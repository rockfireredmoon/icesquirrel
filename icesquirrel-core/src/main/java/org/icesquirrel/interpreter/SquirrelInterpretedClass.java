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
package org.icesquirrel.interpreter;

import java.util.Arrays;

import org.iceparser.SquirrelParser.AssignContext;
import org.iceparser.SquirrelParser.AttributesconstructorContext;
import org.iceparser.SquirrelParser.ClassassignContext;
import org.iceparser.SquirrelParser.ClassassignlistContext;
import org.iceparser.SquirrelParser.ClassconstructorContext;
import org.iceparser.SquirrelParser.ClassdefContext;
import org.iceparser.SquirrelParser.ClassfunctionContext;
import org.iceparser.SquirrelParser.ClassstatContext;
import org.iceparser.SquirrelParser.StaticvarContext;
import org.icesquirrel.runtime.AbstractSquirrelClass;
import org.icesquirrel.runtime.AbstractSquirrelFunction;
import org.icesquirrel.runtime.JavaSquirrelClass;
import org.icesquirrel.runtime.Key;
import org.icesquirrel.runtime.SquirrelArray;
import org.icesquirrel.runtime.SquirrelException;
import org.icesquirrel.runtime.SquirrelExecutionContext;
import org.icesquirrel.runtime.SquirrelObject;

public class SquirrelInterpretedClass extends JavaSquirrelClass<SquirrelInterpretedClass> {
	final static String CONSTRUCTOR = "constructor";

	public SquirrelInterpretedClass(ClassdefContext classDef, AbstractSquirrelClass superclass) {
		super(SquirrelInterpretedClass.class);

		setSuperClass(superclass);

		// If there is a super class, copy all of it's members
		if (superclass != null) {
			insertAllLocally(superclass);
		}

		addDelegate(getClassDeclaration());

		final SquirrelExecutionContext ctx = SquirrelExecutionContext.get();
		final SquirrelInterpretedProcessor processor = (SquirrelInterpretedProcessor) ctx.getProcessor();

		AttributesconstructorContext attr;
		ClassconstructorContext constructor = null;

		// Store the constructor for later execution when the class is
		// instantiated
		for (ClassstatContext stat : classDef.classstat()) {
			// : classconstructor | classfunction | attributesconstructor |
			// classassignlist | staticvar | STATSEP

			// Constructor
			ClassconstructorContext con = stat.classconstructor();
			if (con != null) {
				if (constructor == null) {
					attr = con.attributesconstructor();
					getAttributes().insert(CONSTRUCTOR, attr == null ? null : processor.createAttributes(attr));
					constructor = con;
				} else {
					throw new SquirrelException("Only one constructor allowed.");
				}
			}

			// Functions
			ClassfunctionContext cfc = stat.classfunction();
			if (cfc != null) {
				Key funcKey = processor.processNamedFunction(cfc.funcargs(), cfc.stat(), Arrays.asList(cfc.NAME()), this);
				attr = cfc.attributesconstructor();
				getAttributes().insertLocal(funcKey.getKey(), attr == null ? null : processor.createAttributes(attr));
			}

			// Static variables
			StaticvarContext svc = stat.staticvar();
			if (svc != null) {
				processor.processDeclareList(this, svc.declarelist());
			}

			/*
			 * Instance variables. The values themselves processed on
			 * instantiation, but the class attributes are processed now
			 */
			ClassassignlistContext cal = stat.classassignlist();
			if (cal != null) {
				for (ClassassignContext cac : cal.classassign()) {
					AssignContext ass = cac.assign();
					Key key = processor.resolveVar(ass.var());
					attr = cac.attributesconstructor();
					getAttributes().insertLocal(key.getValue(), attr == null ? null : processor.createAttributes(attr));
					insertLocal(key.getValue(), processor.evaluate(ass.exp()));
				}
			}
		}

		if (constructor == null && (superclass == null || !superclass.containsKey(CONSTRUCTOR))) {
			insertLocal(CONSTRUCTOR, null);
		} else if (constructor != null) {
			insertLocal(CONSTRUCTOR, new SquirrelInterpretedFunction(constructor.stat(), constructor.funcargs()));
		}
	}

	@Override
	public Object construct(SquirrelArray array) {
		SquirrelExecutionContext ctx = SquirrelExecutionContext.get();
		final SquirrelObject obj = new SquirrelObject(this, array) {
			@Override
			public Object getObject() {
				return SquirrelInterpretedClass.this;
			}
		};

		// Copy all of the members into the instance
		obj.insertAllLocally(this);

		// A new execution for constructing
		ctx.newExecution(obj, 1);
		try {

			// Run the constructor
			AbstractSquirrelFunction conf = (AbstractSquirrelFunction) get(CONSTRUCTOR);
			if (conf != null) {
				((SquirrelInterpretedProcessor) ctx.getProcessor()).evaluateCallable(conf, array);
			}
		} finally {
			ctx.popExecution();
		}

		return obj;
	}

}
