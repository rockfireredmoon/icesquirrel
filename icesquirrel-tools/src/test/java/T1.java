import org.icesquirrel.interpreter.SquirrelInterpretedProcessor;
import org.icesquirrel.runtime.AbstractSquirrelClass;
import org.icesquirrel.runtime.AbstractSquirrelFunction;
import org.icesquirrel.runtime.SquirrelArray;
import org.icesquirrel.runtime.SquirrelExecution;
import org.icesquirrel.runtime.SquirrelExecutionContext;
import org.icesquirrel.runtime.SquirrelRuntime;
import org.icesquirrel.runtime.SquirrelTable;

// The top level java class is the 'script'
public class T1 extends SquirrelTable {

	T1() {
	}

	void run() {
		SquirrelExecutionContext ctx = SquirrelExecutionContext.get();
		SquirrelExecution exec = ctx.execution();
		ctx.getRoot().insert("A", "67");
		ctx.getRoot().insert("B", new SquirrelTable("C", "341", "D", "890"));
		ctx.getRoot().insert("C", "999");

		exec.insert("A", "1");
		exec.insert("B", new SquirrelTable());
		((SquirrelTable) exec.get("B")).insert("C", 520l);
		((SquirrelTable) exec.get("B")).insert("D", 520l);

		Object temp1 = exec.get("C");
		AbstractSquirrelClass tempClass1 = ctx.getRuntime().getClass(temp1);
		Object temp2 = "\n";
		((AbstractSquirrelFunction) ctx.getRuntime().getBuiltInFunctions().get("print")).evaluate(new SquirrelArray(tempClass1.add(
				temp1, temp2)));

	}

	public static void main(String[] args) {
		T1 t1 = new T1();
		SquirrelExecutionContext squirrelExecutionContext = SquirrelExecutionContext.get();
		SquirrelRuntime runtime = SquirrelRuntime.getDefaultRuntime();
		SquirrelInterpretedProcessor processor = new SquirrelInterpretedProcessor();
		squirrelExecutionContext.start(t1, runtime, processor);
		try {
			squirrelExecutionContext.newExecution(t1, 1, "T1");
			try {
				t1.run();
			} finally {
				squirrelExecutionContext.popExecution();
			}
		} finally {
			squirrelExecutionContext.stop();
		}
	}
}
