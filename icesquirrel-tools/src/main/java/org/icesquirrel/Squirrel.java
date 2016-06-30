/** 
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 Emerald Icemoon (emerald.icemoon@gmail.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and 
 * associated documentation files (the "Software"), to deal in the Software without restriction, 
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, 
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is 
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial 
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING 
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package org.icesquirrel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.io.FilenameUtils;
import org.icesquirrel.compiler.SquirrelCompiler;
import org.icesquirrel.interpreter.SquirrelInterpretedScript;

public class Squirrel {
	public final static Logger LOG = Logger.getLogger("SQUIRREL");
	public final static Level DEFAULT_LOG_LEVEL = Level.parse(System.getProperty("squirrel.debug", "INFO"));

	private static ConsoleHandler consoleHandler;
	static {
		consoleHandler = new ConsoleHandler();
		setLogLevel(DEFAULT_LOG_LEVEL);
		for (Handler h : new ArrayList<Handler>(Arrays.asList(LOG.getHandlers()))) {
			LOG.removeHandler(h);
		}
		LOG.addHandler(consoleHandler);
	}

	public enum Mode {
		RUN, INTERPRETED, COMPILE, ON_DEMAND, JIT
	}

	private File output;
	private Mode mode = Mode.ON_DEMAND;
	private ClassLoader classLoader;
	private String namespace;

	public Squirrel() {

	}

	public static void setLogLevel(Level level) {
		consoleHandler.setLevel(level);
		LOG.setLevel(level);
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public File getOutput() {
		return output;
	}

	public void setOutput(File output) {
		this.output = output;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public void init() throws IOException {
		classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader == null) {
			classLoader = Squirrel.class.getClassLoader();
		}

		switch (mode) {
		case RUN:
		case ON_DEMAND:
		case JIT:
			// In RUN, ON_DEMAND or JIT modes, create a class loader for the
			// current
			// output directory
			LOG.info(String.format("Adding %s to the class path.", output));
			URL[] urls = new URL[] { output.toURI().toURL() };
			classLoader = new URLClassLoader(urls, classLoader);
			break;
		default:
			break;
		}
	}

	public void process(File file, String... args) throws Exception {
		LOG.info(String.format("Processing %s in mode", file, mode));

		String className = null;

		switch (mode) {
		case RUN:
		case ON_DEMAND:
		case JIT:
			// In RUN, ON_DEMAND or JIT modes we see if there is a Java class
			// for the script
			className = getClassName(file);
			if (runClass(mode, className, args)) {
				// Ran ok from Java class
				return;
			} else {
				LOG.info("Not a compiled class. Will interpret or compile depending on mode.");
			}
			break;
		case COMPILE:
			className = getClassName(file);
			break;
		default:
			break;
		}

		// Now need to either interpret or compile
		switch (mode) {
		case INTERPRETED:
			SquirrelInterpretedScript.run(file, (Object[]) args);
			break;
		case JIT:
		case ON_DEMAND:
		case COMPILE:
			compile(className, file);
			if (mode != Mode.COMPILE) {
				// Now try loading / running the class again
				runClass(Mode.RUN, className, args);
			}
		default:
			break;
		}
	}

	private void compile(String className, File file) throws Exception {
		SquirrelCompiler compiler = new SquirrelCompiler();
		compiler.setOutput(output);
		compiler.setNamespace(namespace);
		FileInputStream fin = new FileInputStream(file);
		try {
			compiler.compile(fin, FilenameUtils.getBaseName(file.getName()));
		} finally {
			fin.close();
		}
	}

	private boolean runClass(Mode mode, String className, String... args)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
		LOG.info(String.format("Looking up %s in mode", className, mode));
		try {
			Class<?> scriptClass = Class.forName(className, true, classLoader);
			Method m = scriptClass.getMethod("main", String[].class);
			m.invoke(null, (Object[]) args);
			return true;
		} catch (ClassNotFoundException cnfe) {
			if (mode == Mode.RUN) {
				throw cnfe;
			}
		}
		return false;
	}

	private String getClassName(File file) {
		String className;
		String base = FilenameUtils.getBaseName(file.getName());
		className = (namespace == null ? "" : (namespace + ".")) + base;
		return className;
	}

	public static void main(String[] args) throws Exception {
		Options o = new Options();
		o.addOption("?", "help", true, "Display help and exit.");
		o.addOption("n", "namespace", true, "Namespace of generated classes.");
		o.addOption("m", "mode", true, "Mode. One of " + Arrays.asList(Mode.values()));
		o.addOption("o", "output", true, "Output directory for compiled classes. Default is current working directory.");
		o.addOption("l", "level", true, "Log level. One of ALL, CONFIG, FINE, FINER, FINEST, WARN, INFO, SEVERE, OFF");
		CommandLine cli = new GnuParser().parse(o, args);

		Squirrel sq = new Squirrel();

		if (cli.hasOption('?') || cli.getArgList().size() == 0) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp(
					Squirrel.class.getName()
							+ " [-?|--help] [-m <mode>|--mode <mode>] [-o <output directory>|--output <output directory>] [-l <log level>|--log <log level>] <script1.nut> [<script2.nut> ..] [-- <scriptArg1> <scriptArg2> ..]",
					o);
			System.exit(1);
		}

		// Namespace
		if (cli.hasOption('n')) {
			sq.setNamespace(cli.getOptionValue('n'));
		}

		// Mode
		if (cli.hasOption('m')) {
			sq.setMode(Mode.valueOf(cli.getOptionValue('m')));
		}

		// Log level
		if (cli.hasOption('l')) {
			Squirrel.setLogLevel(Level.parse(cli.getOptionValue('l')));
		}

		// Output
		if (cli.hasOption('o')) {
			File dir = new File(cli.getOptionValue('o'));
			sq.setOutput(dir);
		}

		// Process
		List<String> scriptArgList = new ArrayList<>();
		List<String> files = new ArrayList<>();
		boolean scriptArgs = false;
		for (String a : cli.getArgs()) {
			if (a.equals("--") && !scriptArgs) {
				scriptArgs = true;
			} else {
				if (scriptArgs) {
					scriptArgList.add(a);
				} else {
					files.add(a);
				}
			}
		}

		for (String f : files) {
			sq.process(new File(f), scriptArgList.toArray(new String[0]));
		}
	}
}
