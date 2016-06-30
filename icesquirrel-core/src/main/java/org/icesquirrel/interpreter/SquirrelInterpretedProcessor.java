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

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.iceparser.SquirrelParser;
import org.iceparser.SquirrelParser.ArgsContext;
import org.iceparser.SquirrelParser.ArrayconstructorContext;
import org.iceparser.SquirrelParser.AssignContext;
import org.iceparser.SquirrelParser.AssignlistContext;
import org.iceparser.SquirrelParser.AttributesconstructorContext;
import org.iceparser.SquirrelParser.BreakstatContext;
import org.iceparser.SquirrelParser.ClassdefContext;
import org.iceparser.SquirrelParser.CloneContext;
import org.iceparser.SquirrelParser.ConstdefContext;
import org.iceparser.SquirrelParser.ContinuestatContext;
import org.iceparser.SquirrelParser.DeclareContext;
import org.iceparser.SquirrelParser.DeclarelistContext;
import org.iceparser.SquirrelParser.DefaultcaseContext;
import org.iceparser.SquirrelParser.DelegateContext;
import org.iceparser.SquirrelParser.DeleteContext;
import org.iceparser.SquirrelParser.DowhileloopContext;
import org.iceparser.SquirrelParser.EnumdefContext;
import org.iceparser.SquirrelParser.ExpContext;
import org.iceparser.SquirrelParser.ExplistContext;
import org.iceparser.SquirrelParser.ForeachloopContext;
import org.iceparser.SquirrelParser.ForloopContext;
import org.iceparser.SquirrelParser.FuncargsContext;
import org.iceparser.SquirrelParser.FunctioncallContext;
import org.iceparser.SquirrelParser.FunctiondefContext;
import org.iceparser.SquirrelParser.IfstatContext;
import org.iceparser.SquirrelParser.IncexpContext;
import org.iceparser.SquirrelParser.LocalvarContext;
import org.iceparser.SquirrelParser.LogContext;
import org.iceparser.SquirrelParser.NameAndArgsContext;
import org.iceparser.SquirrelParser.NamedfunctionContext;
import org.iceparser.SquirrelParser.NameonlylistContext;
import org.iceparser.SquirrelParser.NumberContext;
import org.iceparser.SquirrelParser.OperatorAddSubContext;
import org.iceparser.SquirrelParser.OperatorAndContext;
import org.iceparser.SquirrelParser.OperatorBinAndContext;
import org.iceparser.SquirrelParser.OperatorBinOrContext;
import org.iceparser.SquirrelParser.OperatorBinXorContext;
import org.iceparser.SquirrelParser.OperatorComparisonContext;
import org.iceparser.SquirrelParser.OperatorMulDivModContext;
import org.iceparser.SquirrelParser.OperatorOrContext;
import org.iceparser.SquirrelParser.OperatorShiftLeftContext;
import org.iceparser.SquirrelParser.OperatorShiftRightContext;
import org.iceparser.SquirrelParser.OperatorShiftRightUnsignedContext;
import org.iceparser.SquirrelParser.OperatorUnaryContext;
import org.iceparser.SquirrelParser.PrimitiveitemContext;
import org.iceparser.SquirrelParser.ResumeContext;
import org.iceparser.SquirrelParser.RetstatContext;
import org.iceparser.SquirrelParser.StatContext;
import org.iceparser.SquirrelParser.StringContext;
import org.iceparser.SquirrelParser.SwitchcaseContext;
import org.iceparser.SquirrelParser.SwitchstatContext;
import org.iceparser.SquirrelParser.TableconstructorContext;
import org.iceparser.SquirrelParser.TablerowContext;
import org.iceparser.SquirrelParser.TablerowsContext;
import org.iceparser.SquirrelParser.ThrowstatContext;
import org.iceparser.SquirrelParser.TypeofContext;
import org.iceparser.SquirrelParser.VarContext;
import org.iceparser.SquirrelParser.VarOrExpContext;
import org.iceparser.SquirrelParser.VarSuffixContext;
import org.iceparser.SquirrelParser.WhileloopContext;
import org.iceparser.SquirrelParser.YieldContext;
import org.icesquirrel.runtime.AbstractSquirrelClass;
import org.icesquirrel.runtime.AbstractSquirrelFunction;
import org.icesquirrel.runtime.Break;
import org.icesquirrel.runtime.Continue;
import org.icesquirrel.runtime.Key;
import org.icesquirrel.runtime.Return;
import org.icesquirrel.runtime.SquirrelArray;
import org.icesquirrel.runtime.SquirrelCallable;
import org.icesquirrel.runtime.SquirrelException;
import org.icesquirrel.runtime.SquirrelExecution;
import org.icesquirrel.runtime.SquirrelExecutionContext;
import org.icesquirrel.runtime.SquirrelIndexable;
import org.icesquirrel.runtime.SquirrelMath;
import org.icesquirrel.runtime.SquirrelProcessor;
import org.icesquirrel.runtime.SquirrelRuntime;
import org.icesquirrel.runtime.SquirrelRuntimeException;
import org.icesquirrel.runtime.SquirrelTable;
import org.icesquirrel.runtime.SquirrelType;
import org.icesquirrel.runtime.SquirrelUtil;

public class SquirrelInterpretedProcessor extends SquirrelProcessor {

	final static SquirrelArray EMPTY_ARRAY = new SquirrelArray();

	/**
	 * Create an array given an array constructor and return it.
	 * 
	 * @param array
	 *            array constructor
	 * @return array
	 */
	public SquirrelArray createArray(ArrayconstructorContext array) {
		SquirrelRuntime.LOG.fine("Creating array '" + array.getText() + "'");
		return processArray(array, new SquirrelArray());
	}

	public Object evaluate(ExpContext expression) {
		try {
			SquirrelExecutionContext ctx = SquirrelExecutionContext.get();
			ctx.setLine(expression.getStart().getLine());
			SquirrelRuntime.LOG.fine(expression.getText());

			ExplistContext explist = expression.explist();
			if (explist != null) {
				Object o = null;
				for (ExpContext exp : explist.exp()) {
					o = evaluate(exp);
				}
				return o;
			}

			List<ExpContext> exps = expression.exp();

			// Nested expressions
			if (exps.size() == 1) {
				final OperatorUnaryContext operatorUnary = expression.operatorUnary();
				if (operatorUnary != null) {
					// : '~' | '-' | '!';
					final String op = expression.getChild(0).getText();
					Object o = evaluate(exps.get(0));
					if (op.equals("!")) {
						return !(SquirrelMath.bool(o));
					} else if (op.equals("-")) {
						return ctx.getRuntime().getClass(o).mul(o, -1);
					} else if (op.equals("~")) {
						return ctx.getRuntime().getClass(o).not(o);
					} else {
						throw new UnsupportedOperationException();
					}

				}

				// : '(' exp ')'
				return evaluate(exps.get(0));
			} else if (exps.size() == 3) {
				// exp '?' exp ':' exp
				return SquirrelMath.bool(evaluate(exps.get(0))) ? evaluate(exps.get(1)) : evaluate(exps.get(2));
			} else if (exps.size() == 2) {
				// : exp 'in' exp
				if (expression.getChild(1).getText().equals("in")) {
					SquirrelTable t = (SquirrelTable) evaluate(exps.get(1));
					return t.containsKey(evaluate(exps.get(0)));
				}

				final OperatorMulDivModContext mulDivMod = expression.operatorMulDivMod();
				if (mulDivMod != null) {
					// : '*' | '/' | '%';
					final String op = expression.getChild(1).getText();
					Object o1 = evaluate(exps.get(0));
					Object o2 = evaluate(exps.get(1));
					if (op.equals("*")) {
						return ctx.getRuntime().getClass(o1).mul(o1, o2);
					} else if (op.equals("/")) {
						return ctx.getRuntime().getClass(o1).div(o1, o2);
					} else if (op.equals("%")) {
						return ctx.getRuntime().getClass(o1).modulo(o1, o2);
					} else {
						throw new UnsupportedOperationException("Unsupport mul/div/mod op " + op);
					}
				}

				final OperatorAddSubContext addSub = expression.operatorAddSub();
				if (addSub != null) {
					// : '*' | '/' | '%';
					final String op = expression.getChild(1).getText();
					Object o1 = evaluate(exps.get(0));
					Object o2 = evaluate(exps.get(1));
					if (op.equals("+")) {
						return ctx.getRuntime().getClass(o1).add(o1, o2);
					} else if (op.equals("-")) {
						return ctx.getRuntime().getClass(o1).sub(o1, o2);
					} else {
						throw new UnsupportedOperationException();
					}
				}

				final OperatorComparisonContext comp = expression.operatorComparison();
				if (comp != null) {
					// : '<' | '>' | '<=' | '>=' | '!=' | '==' | 'instanceof';
					final String op = expression.getChild(1).getText();
					Object o1 = evaluate(exps.get(0));
					Object o2 = evaluate(exps.get(1));
					if (op.equals("<")) {
						return ctx.getRuntime().getClass(o1).lessThan(o1, o2);
					} else if (op.equals(">")) {
						return ctx.getRuntime().getClass(o1).moreThan(o1, o2);
					} else if (op.equals("<=")) {
						return ctx.getRuntime().getClass(o1).lessThanEquals(o1, o2);
					} else if (op.equals(">=")) {
						return ctx.getRuntime().getClass(o1).moreThanEquals(o1, o2);
					} else if (op.equals("!=")) {
						return !Objects.equals(o1, o2);
					} else if (op.equals("==")) {
						return Objects.equals(o1, o2);
					} else if (op.equals("instanceof")) {
						return SquirrelMath.isInstanceOf(o1, o2);
					} else {
						throw new UnsupportedOperationException();
					}
				}

				final OperatorAndContext and = expression.operatorAnd();
				if (and != null) {
					// : '&&';
					Object o1 = evaluate(exps.get(0));
					Object o2 = evaluate(exps.get(1));
					return SquirrelMath.bool(o1) && SquirrelMath.bool(o2);
				}

				final OperatorOrContext or = expression.operatorOr();
				if (or != null) {
					// : '||';
					Object o1 = evaluate(exps.get(0));
					Object o2 = evaluate(exps.get(1));
					return SquirrelMath.bool(o1) || SquirrelMath.bool(o2);
				}

				final OperatorBinAndContext binAnd = expression.operatorBinAnd();
				if (binAnd != null) {
					// : '&';
					Object o1 = evaluate(exps.get(0));
					Object o2 = evaluate(exps.get(1));
					return ctx.getRuntime().getClass(o1).and(o1, o2);
				}

				final OperatorBinXorContext binXor = expression.operatorBinXor();
				if (binXor != null) {
					// : '^';
					Object o1 = evaluate(exps.get(0));
					Object o2 = evaluate(exps.get(1));
					return ctx.getRuntime().getClass(o1).xor(o1, o2);
				}

				final OperatorBinOrContext binOr = expression.operatorBinOr();
				if (binOr != null) {
					// : '|';
					Object o1 = evaluate(exps.get(0));
					Object o2 = evaluate(exps.get(1));
					return ctx.getRuntime().getClass(o1).or(o1, o2);
				}

				final OperatorShiftLeftContext shiftLeft = expression.operatorShiftLeft();
				if (shiftLeft != null) {
					// : '<<';
					Object o1 = evaluate(exps.get(0));
					Object o2 = evaluate(exps.get(1));
					return ctx.getRuntime().getClass(o1).left(o1, o2);
				}

				final OperatorShiftRightContext shiftRight = expression.operatorShiftRight();
				if (shiftRight != null) {
					// : '<<';
					Object o1 = evaluate(exps.get(0));
					Object o2 = evaluate(exps.get(1));
					return ctx.getRuntime().getClass(o1).right(o1, o2);
				}

				final OperatorShiftRightUnsignedContext shiftRightUnsigned = expression.operatorShiftRightUnsigned();
				if (shiftRightUnsigned != null) {
					// : '<<';
					Object o1 = evaluate(exps.get(0));
					Object o2 = evaluate(exps.get(1));
					return ctx.getRuntime().getClass(o1).rightUnsigned(o1, o2);
				}

				// : exp (',' exp )
				evaluate(exps.get(0));
				return evaluate(exps.get(1));
			} else if (!exps.isEmpty()) {
				// : exp (',' exp )
				Object val = null;
				for (ExpContext e : exps) {
					val = evaluate(e);
				}
				return val;
			}

			//
			for (ParseTree tree : expression.children) {
				if (tree instanceof VarContext) {
					return evaluateVar((VarContext) tree);
				} else if (tree instanceof TerminalNode) {
					switch (((TerminalNode) tree).getSymbol().getType()) {
					case SquirrelParser.TRUE:
						return true;
					case SquirrelParser.FALSE:
						return false;
					case SquirrelParser.NULL:
						// TODO a SquirrelNull object?
						return null;
					default:
						throw new UnsupportedOperationException(tree.getText());
					}
				} else if (tree instanceof NumberContext) {
					return createNumber((NumberContext) tree);
				} else if (tree instanceof StringContext) {
					return createString((StringContext) tree);
				} else if (tree instanceof DelegateContext) {
					return processDelegate((DelegateContext) tree);
				} else if (tree instanceof CloneContext) {
					return evaluateClone((CloneContext) tree);
				} else if (tree instanceof DeleteContext) {
					return processDelete((DeleteContext) tree);
				} else if (tree instanceof TypeofContext) {
					return evaluate((TypeofContext) tree);
				} else if (tree instanceof FunctiondefContext) {
					return evaluateFunctionDef((FunctiondefContext) tree);
				} else if (tree instanceof FunctioncallContext) {
					return evaluateFunctionOrInstantiate((FunctioncallContext) tree);
				} else if (tree instanceof AssignContext) {
					return processAssign((AssignContext) tree);
				} else if (tree instanceof AssignlistContext) {
					return processAssignList((AssignlistContext) tree);
				} else if (tree instanceof TableconstructorContext) {
					return createTable((TableconstructorContext) tree);
				} else if (tree instanceof ArrayconstructorContext) {
					return createArray((ArrayconstructorContext) tree);
				} else if (tree instanceof ResumeContext) {
					throw new UnsupportedOperationException();
				} else if (tree instanceof IncexpContext) {
					return evaluate((IncexpContext) tree);
				} else if (tree instanceof LogContext) {
					LogContext logic = (LogContext) tree;
					if (logic.TRUE() != null) {
						return true;
					} else if (logic.FALSE() != null) {
						return false;
					} else if (logic.NULL() != null) {
						return null;
					} else {
						return evaluateVar(logic.var());
					}
				} else if (tree instanceof YieldContext) {
					// YieldContext yield = (YieldContext)tree;
					// Object val = evaluate(yield.exp());
					// throw new Return(val);
					throw new UnsupportedOperationException("Yield not yet supported.");
				}
			}

			throw new UnsupportedOperationException(expression.getText());
		} catch (IllegalArgumentException iae) {
			throw new SquirrelException(iae.getMessage(), iae);
		}
	}

	public Object evaluateCallable(SquirrelCallable callable, SquirrelArray arguments) {
		SquirrelExecution stackFrame = SquirrelExecutionContext.get().execution();
		Iterator<Object> argIt = arguments.iterator();
		SquirrelArray varargs = new SquirrelArray();
		for (Map.Entry<Object, Object> en : callable.getSignature().entrySet()) {
			stackFrame.insertLocal(en.getKey(), argIt.hasNext() ? argIt.next() : null);
		}

		// Anything that is left over is a vararg
		while (argIt.hasNext()) {
			varargs.add(argIt.next());
		}

		stackFrame.setVarargs(varargs);

		if (callable instanceof AbstractSquirrelFunction) {
			stackFrame.insertAllLocally(((AbstractSquirrelFunction) callable).getFreeVariables());
		}
		return callable.evaluate(arguments);
	}

	/**
	 * Process a statement.
	 * 
	 * @param statement
	 *            block of statements to process
	 */
	public void processStatement(ParseTree tree) {

		/*
		 * functioncall ;
		 */
		if (tree instanceof RetstatContext) {
			throw new Return(evaluate(((RetstatContext) tree).exp()));
		} else if (tree instanceof ExpContext) {
			// : exp
			evaluate((ExpContext) tree);
		} else if (tree instanceof ConstdefContext) {
			// : constdef
			processConstdef((ConstdefContext) tree);
		} else if (tree instanceof EnumdefContext) {
			// : enumdef
			processEnumdef((EnumdefContext) tree);
		} else if (tree instanceof ClassdefContext) {
			processClassdef((ClassdefContext) tree);
		} else if (tree instanceof IfstatContext) {
			processIfCondition((IfstatContext) tree);
		} else if (tree instanceof WhileloopContext) {
			processWhileLoop((WhileloopContext) tree);
		} else if (tree instanceof ForloopContext) {
			processForLoop((ForloopContext) tree);
		} else if (tree instanceof ForeachloopContext) {
			processForeachLoop((ForeachloopContext) tree);
		} else if (tree instanceof LocalvarContext) {
			processDeclareList(SquirrelExecutionContext.get().execution(), ((LocalvarContext) tree).declarelist());
		} else if (tree instanceof DowhileloopContext) {
			processDoWhileLoop((DowhileloopContext) tree);
		} else if (tree instanceof ExpContext) {
			evaluate((ExpContext) tree);
		} else if (tree instanceof SwitchstatContext) {
			processSwitch((SwitchstatContext) tree);
		}
		// else if (tree instanceof AssignlistContext) {
		// processAssignList((AssignlistContext) tree);
		// }
		else if (tree instanceof BreakstatContext) {
			throw new Break();
		} else if (tree instanceof ContinuestatContext) {
			throw new Continue();
		} else if (tree instanceof ThrowstatContext) {
			ThrowstatContext ts = (ThrowstatContext) tree;
			throw new SquirrelRuntimeException(evaluate(ts.exp()));
		} else if (tree instanceof NamedfunctionContext) {
			NamedfunctionContext nfc = (NamedfunctionContext) tree;
			processNamedFunction(nfc.funcargs(), nfc.stat(), nfc.funcname().NAME(),
					(SquirrelTable) SquirrelExecutionContext.get().execution().getEnvironment());
		} else if (tree instanceof FunctioncallContext) {
			FunctioncallContext fc = (FunctioncallContext) tree;
			evaluateFunctionOrInstantiate(fc);
		} else if (tree instanceof TerminalNode) {
			if (!tree.getText().equals(";") && !tree.getText().equals(",")) {
				throw new UnsupportedOperationException(tree.getText() + " (" + tree.getClass() + ")");
			}
		} else {
			throw new UnsupportedOperationException(tree.getText() + " (" + tree.getClass() + ")");
		}
	}

	/**
	 * Process a named function and insert into it the provided table. A key is
	 * returned containing the function name as the key and the function itself
	 * as the value.
	 * 
	 * @param args
	 *            function arguments
	 * @param block
	 *            block of code
	 * @param names
	 *            argument names
	 * @return function
	 */
	public Key processNamedFunction(FuncargsContext args, StatContext block, List<TerminalNode> names, SquirrelTable target) {
		String key = names.get(names.size() - 1).getText();
		for (int i = 0; i < names.size() - 1; i++) {
			target = (SquirrelTable) target.get(names.get(i).getText());
		}

		AbstractSquirrelFunction function = new SquirrelInterpretedFunction(block, args);

		// Free variables
		NameonlylistContext nameonlylist = args.nameonlylist();
		if (nameonlylist != null) {
			for (TerminalNode n : nameonlylist.NAME()) {
				String nkey = n.getText();
				function.getFreeVariables().insert(nkey, SquirrelExecutionContext.get().execution().get(nkey));
			}
		}

		target.insertLocal(key, function);
		return new Key(key, function);
	}

	/**
	 * Process a table constructor, filling in the slots of the provided table
	 * object
	 * 
	 * @param tableContext
	 *            table constructor
	 * @param table
	 *            table object
	 */
	public void processTable(TableconstructorContext tableContext, SquirrelTable table) {
		SquirrelRuntime.LOG.fine("Creating table '" + tableContext.getText() + "'");
		final TablerowsContext tablerows = tableContext.tablerows();
		if (tablerows != null) {
			processTableRows(tablerows, table);
		}
	}

	public Key resolveVar(VarContext var) {
		// // : ROOT? ( NAME | '(' exp ')' varSuffix ) varSuffix*
		SquirrelRuntime.LOG.fine(var.getText());

		SquirrelExecutionContext ctx = SquirrelExecutionContext.get();
		SquirrelExecution exec = ctx.execution();

		Key key = new Key(exec);

		if (var.ROOT() != null) {
			// : ROOT?
			// Start at the root table
			key.setKey(ctx.getRoot());
		}

		List<VarSuffixContext> suffixes = var.varSuffix();
		Iterator<VarSuffixContext> sit = suffixes.iterator();

		/*
		 * There will either be varargc, varargv, a NAME or an expression that
		 * will resolve to to a slot in a table (or an index in an array)
		 */
		TerminalNode name = var.NAME();

		if (var.vargc() != null) {
			key.setKey(null);
			key.setValue(vargc());
			return key;
		} else if (var.vargv() != null) {
			SquirrelArray vargv = vargv();
			if (sit.hasNext()) {
				key.setKey(vargv);
			} else {
				key.setValue(vargv);
				key.setKey(null);
				return key;
			}
		} else if (name != null) {
			// : NAME
			key.setValue(name.getText());
			if (!sit.hasNext()) {
				return key;
			}
		} else {
			// : '(' exp ')' varSuffix
			key.setKey(evaluate(var.exp()));
			resolveVarSuffix(key, sit.next());
		}

		// // : ROOT? ( NAME | '(' exp ')' varSuffix ) varSuffix*
		// The remaining suffixes
		while (sit.hasNext()) {
			resolveVarSuffix(key, sit.next());
		}

		return key;
	}

	private long vargc() {
		SquirrelExecution exec = SquirrelExecutionContext.get().execution();
		return exec.getVarargs() == null ? 0 : exec.getVarargs().size();
	}

	private SquirrelArray vargv() {
		return SquirrelExecutionContext.get().execution().getVarargs();
	}

	/**
	 * Process an array constructor, adding items to the provided array object.
	 * 
	 * @param array
	 *            array constructor
	 * @param arr
	 *            array object
	 * @return array object
	 */
	protected SquirrelArray processArray(ArrayconstructorContext array, SquirrelArray arr) {
		for (ExpContext exp : array.exp()) {
			arr.add(evaluate(exp));
		}
		return arr;
	}

	/**
	 * Create a table containing class attributes. The table will be inserted
	 * into the class attributes {@link AbstractSquirrelClass#getAttributes()}.
	 * 
	 * @param attributesconstructor
	 *            class attributes
	 * @return table
	 */
	protected SquirrelTable createAttributes(AttributesconstructorContext attributesconstructor) {
		SquirrelTable t = new SquirrelTable();
		processTableRows(attributesconstructor.tablerows(), t);
		return t;
	}

	/**
	 * Process a list of variable declarations and push the into the provided
	 * table. The keys will consist of just a NAME, the value of which will be
	 * derived from the expression.
	 * 
	 * @param table
	 *            table
	 * @param declareList
	 *            variables
	 */
	protected void processDeclareList(SquirrelTable table, DeclarelistContext declareList) {
		// : declare (',' declare)*
		SquirrelRuntime.LOG.fine("Declare list: " + declareList.getText());
		for (DeclareContext decl : declareList.declare()) {
			processDeclare(table, decl);
		}
	}

	/**
	 * Get the actual value of a variable. The key will contain the object the
	 * value was contained in (if any).
	 * 
	 * @param var
	 *            variable
	 * @return value
	 */
	protected Object evaluateVar(VarContext var) {
		SquirrelRuntime.LOG.fine("Evaluate var: " + var.getText());
		if (var.getText().equals("a2[i]")) {
			System.out.println("BREAK!");
		}
		Key key = resolveVar(var);
		Object env = key.getKey();
		if (env == null) {
			return key.getValue();
		}
		return get(env, key.getValue());
	}

	private Object get(Object env, Object key) {
		if (env instanceof AbstractSquirrelFunction) {
			/*
			 * If the environment is a function, call it to get the table or
			 * array
			 */

			// New execution
			SquirrelExecutionContext.get().newExecution(env, 1);
			try {
				// TODO will we get args here?
				env = evaluateCallable((AbstractSquirrelFunction) env, new SquirrelArray());
			} finally {
				SquirrelExecutionContext.get().popExecution();
			}
		}
		if (env instanceof SquirrelTable) {
			try {
				return ((SquirrelTable) env).getOrFail(key);
			} catch (IllegalArgumentException iae) {
			}
		} else if (env instanceof SquirrelIndexable) {
			if (key instanceof Number) {
				return ((SquirrelIndexable) env).get(((Number) key).intValue());
			}
		}

		// Must be a function
		AbstractSquirrelClass clazz = SquirrelExecutionContext.get().getRuntime().getClass(env);
		return clazz == null ? null : clazz.getOrFail(key);

	}

	private void resolveVarSuffix(Key environment, VarSuffixContext varSuffix) {
		SquirrelRuntime.LOG.fine(varSuffix.getText());

		// : nameAndArgs* ('[' exp ']' | '.' NAME)
		List<NameAndArgsContext> nargs = varSuffix.nameAndArgs();

		// If there are any arguments, the will evaluate the key from a (chain
		// of) function calls
		Object var = environment.getValue() == null ? environment.getKey() : get(environment.getKey(), environment.getValue());
		for (NameAndArgsContext n : nargs) {
			// : nameAndArgs*
			environment.setKey(evaluateNameAndArgs(environment.getKey(), var, n));
		}

		environment.setKey(var);

		// The environment will be either a table or an array, so next we
		// process
		// the index express or dot name
		// : ('[' exp ']' | '.' NAME)
		TerminalNode name = varSuffix.NAME();
		if (name != null) {
			// : '.' NAME
			environment.setValue(name.getText());
		} else {
			// : ('[' exp ']' | '.' NAME)
			environment.setValue(evaluate(varSuffix.exp()));
		}

	}

	private Object evaluateNameAndArgs(Object env, Object var, NameAndArgsContext n) {
		SquirrelRuntime.LOG.fine(n.getText());

		// : ('.' NAME)? args
		TerminalNode name = n.NAME();

		if (name != null) {
			// : ('.' NAME)?
			env = var;
			var = ((SquirrelTable) var).get(name.getText());
		}

		ArgsContext args = n.args();
		// : '(' ( exp (COMMA exp)* )? ')'
		SquirrelArray argList = new SquirrelArray();
		for (ExpContext e : args.exp()) {
			argList.add(evaluate(e));
		}

		// New execution
		if (var instanceof AbstractSquirrelFunction) {
			AbstractSquirrelFunction func = (AbstractSquirrelFunction) var;
			if (env instanceof SquirrelExecution) {
				env = ((SquirrelExecution) env).getEnvironment();
			}
			SquirrelExecutionContext.get().newExecution(env, n.getStart().getLine());
			try {
				return evaluateCallable(func, argList);
			} finally {
				SquirrelExecutionContext.get().popExecution();
			}
		} else if (var instanceof AbstractSquirrelClass) {
			return ((AbstractSquirrelClass) var).construct(argList);
		} else if (var == null) {
			return null;
		} else {
			throw new UnsupportedOperationException(
					String.format("Cannot evaluate %s as a function or a constructor.", n.getText()));
		}
	}

	/**
	 * Clone the result of an expression if it is a table, array or class
	 * instance.
	 * 
	 * @param clone
	 *            clone
	 * @return
	 */
	private Object evaluateClone(CloneContext cloneExp) {
		try {
			ExpContext exp = cloneExp.exp();
			Object o = evaluate(exp);
			if (o instanceof SquirrelType) {
				return ((SquirrelType<?>) o).clone();
			} else if (o instanceof Number || o instanceof String) {
				// Immutable anyway
				return o;
			}
		} catch (CloneNotSupportedException e) {
		}
		throw new SquirrelException("Clone not supported.");
	}

	/**
	 * Evaluate the type of an object
	 * 
	 * @param incexp
	 *            increment expression
	 */
	private Object evaluate(TypeofContext typeof) {
		// : 'typeof' var
		SquirrelRuntime.LOG.info(String.format("Typeof: %s", typeof.getText()));
		final Object exp = evaluateVar(typeof.var());
		AbstractSquirrelClass clazz = SquirrelExecutionContext.get().getRuntime().getClass(exp);
		return clazz == null ? null : clazz.typeof(exp);
	}

	/**
	 * Evaluate an increment expression
	 * 
	 * @param incexp
	 *            increment expression
	 */
	private Object evaluate(IncexpContext incexp) {
		// : ( ('++' | '--' ) var ) | ( var ( '++' | '--' ) ) | ( var '+=' exp )
		// | ( var '-=' exp )
		final ExpContext exp = incexp.exp();
		TerminalNode inc = incexp.INC();
		TerminalNode dec = incexp.DEC();
		TerminalNode decval = incexp.DECVAL();
		TerminalNode incval = incexp.INCVAL();
		TerminalNode op = null;
		int n = 1;
		if (exp != null) {
			n = ((Number) evaluate(exp)).intValue();
		}
		if (dec != null || decval != null) {
			n *= -1;
			op = dec == null ? decval : dec;
		} else {
			op = inc == null ? incval : inc;
		}
		VarContext varc = incexp.var();
		Key var = resolveVar(varc);
		Object val = get((SquirrelTable) var.getKey(), var.getValue());
		Object newVal = SquirrelExecutionContext.get().getRuntime().getClass(val).add(val, n);
		((SquirrelTable) var.getKey()).put(var.getValue(), newVal);
		return op.getSourceInterval().startsBeforeDisjoint(varc.getSourceInterval()) ? val : newVal;
	}

	/**
	 * Evaluate a function definition. The function is not placed in any table,
	 * it is just returned.
	 * 
	 * @param functionDef
	 *            function definition
	 */
	private Object evaluateFunctionDef(FunctiondefContext functionDef) {
		// : 'function' funcargs block
		return new SquirrelInterpretedFunction(functionDef.stat(), functionDef.funcargs());
	}

	/**
	 * Evaluate a function or instantiate a new object from the class. This is
	 * the actual invokation of the function.
	 * 
	 * @param function
	 *            function
	 * @return value
	 */
	private Object evaluateFunctionOrInstantiate(FunctioncallContext functionCall) {
		// : varOrExp nameAndArgs
		SquirrelRuntime.LOG.fine(functionCall.getText());

		// : varOrExp nameAndArgs

		SquirrelExecutionContext ctx = SquirrelExecutionContext.get();
		ctx.setLine(functionCall.getStart().getLine());

		// We know we are executing a function, so either the expression or the
		// variable must resolve to a function or a table containing the
		// function
		// : var | '(' exp ')'
		VarOrExpContext varOrExp = functionCall.varOrExp();
		VarContext var = varOrExp.var();
		Object env;
		Object func;
		if (var != null) {
			Key key = resolveVar(var);
			env = key.getKey();
			func = get(env, key.getValue());
			// func = evaluate(key);
		} else {
			// Resolve an actual function or table containing function from an
			// expression
			func = evaluate(varOrExp.exp());
			throw new UnsupportedOperationException();
		}

		// The environment will point to either a function directly, or to
		// an object containing the function
		return evaluateNameAndArgs(env, func, functionCall.nameAndArgs());
	}

	/**
	 * Process all of a tables rows, pushing the new slots onto the table at the
	 * top of the stack when this was called.
	 * 
	 * @param table
	 *            table
	 */
	private void processTableRows(TablerowsContext tableRows, SquirrelTable table) {
		for (TablerowContext exp : tableRows.tablerow()) {
			processTableRow(exp, table);
		}
	}

	/**
	 * Process a single table row, pushing the new slot onto the table at the
	 * top of the stack when this was called.
	 * 
	 * @param row
	 *            table row
	 */
	private void processTableRow(TablerowContext row, SquirrelTable table) {
		// : '[' exp ']' ASSIGN explist | NAME ASSIGN explist | namedfunction
		SquirrelRuntime.LOG.fine("Table row: " + row.getText());

		final NamedfunctionContext namedfunction = row.namedfunction();
		if (namedfunction != null) {
			// : namedfunction
			processNamedFunction(namedfunction.funcargs(), namedfunction.stat(), namedfunction.funcname().NAME(), table);
		} else {
			final List<ExpContext> exps = row.exp();
			if (exps.size() == 2) {
				// : '[' exp ']' '=' exp
				table.insertLocal(evaluate(exps.get(0)), evaluate(exps.get(1)));
			} else if (exps.size() == 1) {
				// : NAME = 'exp'
				table.insertLocal(row.NAME().getText(), evaluate(exps.get(0)));
			} else {
				throw new UnsupportedOperationException();
			}
		}
	}

	/**
	 * Process a const declaration and insert it into the const table.
	 * 
	 * @param constDef
	 *            const declaration
	 */
	private void processConstdef(ConstdefContext constDef) {
		// : 'const' primitiveitem
		SquirrelExecutionContext.get().getRuntime().getConstTable().insert(createPrimitiveItem(constDef.primitiveitem()));
	}

	/**
	 * Process a enum declaration and insert it into the const table.
	 * 
	 * @param enumDef
	 *            enum declaration
	 */
	private void processEnumdef(EnumdefContext constDef) {
		// : 'enum' enumconstructor
		SquirrelTable table = new SquirrelTable();
		TerminalNode name = constDef.NAME();
		for (PrimitiveitemContext prim : constDef.enumconstructor().enumlist().primitiveitem()) {
			table.insert(createPrimitiveItem(prim));
		}
		SquirrelExecutionContext.get().getRuntime().getConstTable().insertLocal(name.getText(), table);
	}

	/**
	 * Process an if condition.
	 * 
	 * @param ifStatement
	 *            if
	 */
	private void processIfCondition(IfstatContext ifStatement) {
		// : 'if' '(' exp ')' block ( 'else' block )?
		SquirrelRuntime.LOG.fine("If '" + ifStatement.getText() + "'");
		final Object evaluate = evaluate(ifStatement.exp());
		boolean val = SquirrelMath.bool(evaluate);
		final List<StatContext> block = ifStatement.stat();
		if (val) {
			// If
			processStatement(block.get(0));
		} else if (block.size() > 1) {
			// Else (if it exists)
			processStatement(block.get(1));
		}
	}

	/**
	 * Process a while loop.
	 * 
	 * @param while
	 *            loop
	 */
	private void processWhileLoop(WhileloopContext whileLoop) {
		// : 'while' exp block
		while (SquirrelMath.bool(evaluate(whileLoop.exp()))) {
			try {
				processStatement(whileLoop.stat());
			} catch (Break be) {
				break;
			} catch (Continue ce) {
				continue;
			}
		}
	}

	/**
	 * Process a foreach loop.
	 * 
	 * @param forEach
	 *            loop
	 */
	private void processForeachLoop(ForeachloopContext forLoop) {
		List<TerminalNode> names = forLoop.NAME();
		String valueName = names.size() == 2 ? names.get(1).getText() : names.get(0).getText();
		String indexName = names.size() == 2 ? names.get(0).getText() : null;
		Object obj = evaluate(forLoop.exp());

		/*
		 * New execution for the loop. Also delegate to the current execution as
		 * local variables can come from outside the scope of the loop
		 */
		SquirrelTable currentStackFrame = SquirrelExecutionContext.get().execution();
		SquirrelExecution exec = SquirrelExecutionContext.get()
				.newExecution(SquirrelExecutionContext.get().execution().getEnvironment(), forLoop.getStart().getLine());
		exec.addDelegate(currentStackFrame);

		try {
			if (obj instanceof SquirrelTable) {
				for (Map.Entry<Object, Object> en : ((SquirrelTable) obj).entrySet()) {
					if (indexName != null) {
						exec.insertLocal(indexName, en.getKey());
					}
					exec.insertLocal(valueName, en.getValue());
					try {
						processStatement(forLoop.stat());
					} catch (Break be) {
						break;
					} catch (Continue ce) {
						continue;
					}
				}
			} else if (obj instanceof SquirrelIndexable) {
				// Iterate over a table
				int idx = 0;
				for (Object en : (SquirrelIndexable) obj) {
					if (indexName != null) {
						exec.insertLocal(indexName, idx++);
					}
					exec.insertLocal(valueName, (Object) en);
					try {
						processStatement(forLoop.stat());
					} catch (Break be) {
						break;
					} catch (Continue ce) {
						continue;
					}
				}
			} else if (obj instanceof String) {
				int idx = 0;
				for (char c : ((String) obj).toCharArray()) {
					if (indexName != null) {
						exec.insertLocal(indexName, idx++);
					}
					exec.insertLocal(valueName, c);
					try {
						processStatement(forLoop.stat());
					} catch (Break be) {
						break;
					} catch (Continue ce) {
						continue;
					}
				}
			} else {
				throw new SquirrelException(String.format("Cannot iterate over a %s", obj));
			}
		} finally {
			SquirrelExecutionContext.get().popExecution();
		}

	}

	/**
	 * Process a for loop.
	 * 
	 * @param forLoop
	 *            loop
	 */
	private void processForLoop(ForloopContext forLoop) {
		// : 'for' '(' ( localvar | assignlist ) ';' exp? ';' exp ')' block

		// First either declare new variables or assign values to exist ones
		LocalvarContext lvc = forLoop.localvar();
		if (lvc != null) {
			// Create a new table for the scope of the loop, delegating to the
			// current environment
			SquirrelExecution execution = SquirrelExecutionContext.get().execution();
			SquirrelExecution newExecution = SquirrelExecutionContext.get().newExecution(execution.getEnvironment(),
					forLoop.getStart().getLine());
			newExecution.addDelegate(execution);
			processDeclareList(newExecution, lvc.declarelist());
		} else {
			AssignlistContext ass = forLoop.assignlist();
			if (ass != null) {
				processAssignList(ass);
			}
		}

		// Find the condition expression and the adjust expression
		List<ExpContext> exps = forLoop.exp();
		ExpContext condition = null;
		ExpContext loop = null;
		if (exps.size() > 0) {
			final List<TerminalNode> seps = forLoop.STATSEP();
			TerminalNode s1 = seps.get(1);
			if (exps.size() == 1) {
				ExpContext e1 = exps.get(0);
				if (e1.getSourceInterval().startsBeforeNonDisjoint(s1.getSourceInterval())) {
					condition = e1;
				} else {
					loop = e1;
				}
			} else {
				condition = exps.get(0);
				loop = exps.get(1);
			}
		}

		//
		while (condition == null || SquirrelMath.bool(evaluate(condition))) {
			try {
				processStatement(forLoop.stat());
			} catch (Break be) {
				break;
			} catch (Continue c) {
				continue;
			}
			if (loop != null) {
				evaluate(loop);
			}
		}

		if (lvc != null) {
			SquirrelExecutionContext.get().popExecution();
		}
	}

	/**
	 * Process a switch statement.
	 * 
	 * @param switchStat
	 *            switch statement
	 */
	private void processSwitch(SwitchstatContext switchStat) {
		// : 'switch' '(' exp ')' '{' ( ( switchcase+ defaultcase? ) |
		// defaultcase )'}'
		Object val = evaluate(switchStat.exp());
		try {
			for (SwitchcaseContext cs : switchStat.switchcase()) {
				// : 'case' exp ':' stat*
				Object caseVal = evaluate(cs.exp());
				if (Objects.equals(val, caseVal)) {
					processStatements(cs.stat());
				}
			}

			DefaultcaseContext defaultCase = switchStat.defaultcase();
			if (defaultCase != null) {
				processStatements(defaultCase.stat());
			}
		} catch (Break be) {
			//
		}
	}

	/**
	 * Process a do while loop.
	 * 
	 * @param doWhileLoop
	 *            loop
	 */
	private void processDoWhileLoop(DowhileloopContext doWhileLoop) {
		// : 'while' exp block
		do {
			try {
				processStatement(doWhileLoop.stat());
			} catch (Break be) {
				break;
			} catch (Continue c) {
				continue;
			}
		} while (SquirrelMath.bool(evaluate(doWhileLoop.exp())));
	}

	/**
	 * Process the delegate expression
	 * 
	 * @param delegate
	 */
	private Object processDelegate(DelegateContext delegate) {
		// : 'delegate' exp ':' exp
		SquirrelTable parent = (SquirrelTable) evaluate(delegate.exp(0));
		SquirrelTable child = (SquirrelTable) evaluate(delegate.exp(1));
		child.addDelegate(parent);
		return child;
	}

	/**
	 * Process an assign list, pushing to values into the appropriate table. The
	 * keys must already exist in their respective targets. Also returns the
	 * last value assigned.
	 * 
	 * @param assign
	 *            list
	 *
	 */
	private Object processAssignList(AssignlistContext assignList) {
		// : assign (',' assign)*
		Object val = null;
		for (AssignContext ac : assignList.assign()) {
			val = processAssign(ac);
		}
		return val;
	}

	/**
	 * Process a single assign, pushing a value into the appropriate table.
	 *
	 * @param assign
	 *            assignment
	 * @return value
	 */
	private Object processAssign(AssignContext assign) {
		// : var ( ASSIGN | NEW_SLOT ) exp
		SquirrelRuntime.LOG.fine(assign.getText());

		// Resolve the variable and evaluate the expression
		Key key = resolveVar(assign.var());
		ExpContext exp = assign.exp();
		final Object val = evaluate(exp);

		if (key.getKey() instanceof SquirrelIndexable) {
			SquirrelIndexable arr = (SquirrelIndexable) key.getKey();
			if (assign.NEW_SLOT() != null) {
				// TODO is this valid?
				throw new UnsupportedOperationException();
			} else {
				arr.set(((Long) key.getValue()).intValue(), val);
			}
		} else if (key.getKey() instanceof SquirrelTable) {
			SquirrelTable table = (SquirrelTable) key.getKey();

			// If the key doesn't already exist as a local then it is a key for
			// the environment
			// if (table instanceof SquirrelExecution &&
			// !table.containsKeyLocally(key.getValue())) {
			// table = (SquirrelTable) ((SquirrelExecution)
			// table).getEnvironment();
			// }

			// This will NOT be a 'local xx=yy'
			// It will be either
			//
			// 1. A new slot assignment, this can only be to the environment
			// 2. An existing local assignment
			// 3. An existing environment assignment
			if (assign.NEW_SLOT() != null) {
				if (table instanceof SquirrelExecution) {
					table = (SquirrelTable) ((SquirrelExecution) table).getEnvironment();
				}
				table.insert(key.getValue(), val);
			} else {
				if (table instanceof SquirrelExecution && ((SquirrelExecution) table).isLocal(key.getValue())) {
					// Existing local assignment
					table.insertLocal(key.getValue(), val);
				} else {
					// Existing environment assignment
					if (table instanceof SquirrelExecution) {
						table = (SquirrelTable) ((SquirrelExecution) table).getEnvironment();
					}
					table.put(key.getValue(), val);
				}
			}
		} else {
			throw new UnsupportedOperationException(key.getKey().getClass() + " is of unknown class");
		}
		return val;
	}

	/**
	 * Process a single declaration and push it in to the provided table. The
	 * keys will consist of just a NAME, the value of which will be derived from
	 * the expression.
	 * 
	 * @param table
	 *            the table to assign the variables to
	 * @param declare
	 *            the declaration
	 *
	 */
	private void processDeclare(SquirrelTable table, DeclareContext declare) {
		// : NAME ( ASSIGN exp )?
		SquirrelRuntime.LOG.fine("Declare: " + declare.getText());
		String key = declare.NAME().getText();
		ExpContext exp = declare.exp();
		Object val = null;
		if (exp != null) {
			val = evaluate(exp);
		}
		table.insertLocal(key, val);
	}

	/**
	 * Process the class declaration and insert into it's parent table.
	 * 
	 * @param classDef
	 *            class declaration
	 */
	private void processClassdef(ClassdefContext classDef) {
		// : 'class' var attributesconstructor? ( 'extends' var )? '{'
		// classstat* '}'
		List<VarContext> var = classDef.var();
		Key className = resolveVar(var.get(0));

		if (className.getKey() instanceof SquirrelExecution) {
			// TODO need to check qualified class names
			className.setKey(((SquirrelExecution) className.getKey()).getEnvironment());
		}

		// Superclass
		AbstractSquirrelClass superClass = null;
		if (var.size() > 1) {
			superClass = (AbstractSquirrelClass) evaluateVar(var.get(1));
		}
		SquirrelInterpretedClass clazz = new SquirrelInterpretedClass(classDef, superClass);

		// Attributes
		AttributesconstructorContext attr = classDef.attributesconstructor();
		(((SquirrelTable) className.getKey()).getClassDeclaration()).getAttributes().insertLocal(className.getValue(),
				attr == null ? null : createAttributes(attr));

		((SquirrelTable) className.getKey()).insertLocal(className.getValue(), clazz);
	}

	/**
	 * Create a primitive item. This consists of a name and primtive value. Used
	 * for enum and const.
	 * 
	 * @param primitive
	 *            item
	 * @return name and value pair
	 */
	private Key createPrimitiveItem(PrimitiveitemContext primitiveitem) {
		Object val = null;
		StringContext string = primitiveitem.string();
		if (string != null) {
			val = createString(string);
		} else {
			val = createNumber(primitiveitem.number());
		}
		return new Key(primitiveitem.NAME().getText(), val);
	}

	/**
	 * Create a table object given the constructor
	 * 
	 * @param tableContext
	 *            table constructor
	 * @return table object
	 */
	private SquirrelTable createTable(TableconstructorContext tableContext) {
		SquirrelTable table = new SquirrelTable();
		// table.addDelegate(table.getClassDeclaration());
		// table.addDelegate(SquirrelExecutionContext.get().getRuntime().getBuiltInFunctions());
		processTable(tableContext, table);
		return table;
	}

	/**
	 * Create a number, this will either be {@link Long} or a {@link Double}.
	 * 
	 * @param stringContext
	 *            string
	 * @return string
	 */
	private Object createNumber(NumberContext numberContext) {
		// : OCTAL | INT | HEX | FLOAT | CHAR
		TerminalNode number = numberContext.INT();
		if (number != null) {
			return Long.parseLong(number.getText());
		}
		number = numberContext.FLOAT();
		if (number != null) {
			return Double.parseDouble(number.getText());
		}
		number = numberContext.OCTAL();
		if (number != null) {
			return Long.parseLong(number.getText().substring(1), 8);
		}
		number = numberContext.HEX();
		if (number != null) {
			return Long.parseLong(number.getText().substring(2), 16);
		}
		number = numberContext.CHAR();
		if (number != null) {
			return Long.valueOf((int) (number.getText().charAt(1)));
		}

		throw new UnsupportedOperationException();
	}

	/**
	 * Create a string, from either a normal string or a verbatim string. The
	 * result is the same in both cases, a native string
	 * 
	 * @param stringContext
	 *            string
	 * @return string
	 */
	private String createString(StringContext stringContext) {
		TerminalNode normal = stringContext.NORMALSTRING();
		if (normal == null) {
			return SquirrelUtil.unquote(stringContext.VERBATIMSTRING().getText().substring(1).replace("\"\"", "\""));
		}
		return SquirrelUtil.unescapeString(SquirrelUtil.unquote(normal.getText()));
	}

	/**
	 * Process 'delete' keyword
	 * 
	 * @param delete
	 *            delete
	 */
	private Object processDelete(DeleteContext delete) {
		Key key = resolveVar(delete.var());
		SquirrelTable env = (SquirrelTable) key.getKey();
		return env.remove(key.getValue());

	}

}
