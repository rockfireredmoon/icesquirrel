// Generated from org/iceparser/Squirrel.g4 by ANTLR 4.3
package org.iceparser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SquirrelParser}.
 */
public interface SquirrelListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SquirrelParser#arglist}.
	 * @param ctx the parse tree
	 */
	void enterArglist(@NotNull SquirrelParser.ArglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#arglist}.
	 * @param ctx the parse tree
	 */
	void exitArglist(@NotNull SquirrelParser.ArglistContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#operatorBinOr}.
	 * @param ctx the parse tree
	 */
	void enterOperatorBinOr(@NotNull SquirrelParser.OperatorBinOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#operatorBinOr}.
	 * @param ctx the parse tree
	 */
	void exitOperatorBinOr(@NotNull SquirrelParser.OperatorBinOrContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(@NotNull SquirrelParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(@NotNull SquirrelParser.AssignContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#arrayconstructor}.
	 * @param ctx the parse tree
	 */
	void enterArrayconstructor(@NotNull SquirrelParser.ArrayconstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#arrayconstructor}.
	 * @param ctx the parse tree
	 */
	void exitArrayconstructor(@NotNull SquirrelParser.ArrayconstructorContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#yield}.
	 * @param ctx the parse tree
	 */
	void enterYield(@NotNull SquirrelParser.YieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#yield}.
	 * @param ctx the parse tree
	 */
	void exitYield(@NotNull SquirrelParser.YieldContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(@NotNull SquirrelParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(@NotNull SquirrelParser.ArgsContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#throwstat}.
	 * @param ctx the parse tree
	 */
	void enterThrowstat(@NotNull SquirrelParser.ThrowstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#throwstat}.
	 * @param ctx the parse tree
	 */
	void exitThrowstat(@NotNull SquirrelParser.ThrowstatContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#classassign}.
	 * @param ctx the parse tree
	 */
	void enterClassassign(@NotNull SquirrelParser.ClassassignContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#classassign}.
	 * @param ctx the parse tree
	 */
	void exitClassassign(@NotNull SquirrelParser.ClassassignContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#tableconstructor}.
	 * @param ctx the parse tree
	 */
	void enterTableconstructor(@NotNull SquirrelParser.TableconstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#tableconstructor}.
	 * @param ctx the parse tree
	 */
	void exitTableconstructor(@NotNull SquirrelParser.TableconstructorContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#classfunction}.
	 * @param ctx the parse tree
	 */
	void enterClassfunction(@NotNull SquirrelParser.ClassfunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#classfunction}.
	 * @param ctx the parse tree
	 */
	void exitClassfunction(@NotNull SquirrelParser.ClassfunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#primitiveitem}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveitem(@NotNull SquirrelParser.PrimitiveitemContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#primitiveitem}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveitem(@NotNull SquirrelParser.PrimitiveitemContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#continuestat}.
	 * @param ctx the parse tree
	 */
	void enterContinuestat(@NotNull SquirrelParser.ContinuestatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#continuestat}.
	 * @param ctx the parse tree
	 */
	void exitContinuestat(@NotNull SquirrelParser.ContinuestatContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#enumdef}.
	 * @param ctx the parse tree
	 */
	void enterEnumdef(@NotNull SquirrelParser.EnumdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#enumdef}.
	 * @param ctx the parse tree
	 */
	void exitEnumdef(@NotNull SquirrelParser.EnumdefContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#varSuffix}.
	 * @param ctx the parse tree
	 */
	void enterVarSuffix(@NotNull SquirrelParser.VarSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#varSuffix}.
	 * @param ctx the parse tree
	 */
	void exitVarSuffix(@NotNull SquirrelParser.VarSuffixContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#staticvar}.
	 * @param ctx the parse tree
	 */
	void enterStaticvar(@NotNull SquirrelParser.StaticvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#staticvar}.
	 * @param ctx the parse tree
	 */
	void exitStaticvar(@NotNull SquirrelParser.StaticvarContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#retstat}.
	 * @param ctx the parse tree
	 */
	void enterRetstat(@NotNull SquirrelParser.RetstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#retstat}.
	 * @param ctx the parse tree
	 */
	void exitRetstat(@NotNull SquirrelParser.RetstatContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#vargv}.
	 * @param ctx the parse tree
	 */
	void enterVargv(@NotNull SquirrelParser.VargvContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#vargv}.
	 * @param ctx the parse tree
	 */
	void exitVargv(@NotNull SquirrelParser.VargvContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#clone}.
	 * @param ctx the parse tree
	 */
	void enterClone(@NotNull SquirrelParser.CloneContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#clone}.
	 * @param ctx the parse tree
	 */
	void exitClone(@NotNull SquirrelParser.CloneContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#typeof}.
	 * @param ctx the parse tree
	 */
	void enterTypeof(@NotNull SquirrelParser.TypeofContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#typeof}.
	 * @param ctx the parse tree
	 */
	void exitTypeof(@NotNull SquirrelParser.TypeofContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#operatorAddSub}.
	 * @param ctx the parse tree
	 */
	void enterOperatorAddSub(@NotNull SquirrelParser.OperatorAddSubContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#operatorAddSub}.
	 * @param ctx the parse tree
	 */
	void exitOperatorAddSub(@NotNull SquirrelParser.OperatorAddSubContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#namedfunction}.
	 * @param ctx the parse tree
	 */
	void enterNamedfunction(@NotNull SquirrelParser.NamedfunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#namedfunction}.
	 * @param ctx the parse tree
	 */
	void exitNamedfunction(@NotNull SquirrelParser.NamedfunctionContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#nameonlylist}.
	 * @param ctx the parse tree
	 */
	void enterNameonlylist(@NotNull SquirrelParser.NameonlylistContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#nameonlylist}.
	 * @param ctx the parse tree
	 */
	void exitNameonlylist(@NotNull SquirrelParser.NameonlylistContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull SquirrelParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull SquirrelParser.NumberContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#operatorAnd}.
	 * @param ctx the parse tree
	 */
	void enterOperatorAnd(@NotNull SquirrelParser.OperatorAndContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#operatorAnd}.
	 * @param ctx the parse tree
	 */
	void exitOperatorAnd(@NotNull SquirrelParser.OperatorAndContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#script}.
	 * @param ctx the parse tree
	 */
	void enterScript(@NotNull SquirrelParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#script}.
	 * @param ctx the parse tree
	 */
	void exitScript(@NotNull SquirrelParser.ScriptContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#foreachloop}.
	 * @param ctx the parse tree
	 */
	void enterForeachloop(@NotNull SquirrelParser.ForeachloopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#foreachloop}.
	 * @param ctx the parse tree
	 */
	void exitForeachloop(@NotNull SquirrelParser.ForeachloopContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#log}.
	 * @param ctx the parse tree
	 */
	void enterLog(@NotNull SquirrelParser.LogContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#log}.
	 * @param ctx the parse tree
	 */
	void exitLog(@NotNull SquirrelParser.LogContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterDeclare(@NotNull SquirrelParser.DeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitDeclare(@NotNull SquirrelParser.DeclareContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(@NotNull SquirrelParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(@NotNull SquirrelParser.ExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#vargc}.
	 * @param ctx the parse tree
	 */
	void enterVargc(@NotNull SquirrelParser.VargcContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#vargc}.
	 * @param ctx the parse tree
	 */
	void exitVargc(@NotNull SquirrelParser.VargcContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#operatorShiftRight}.
	 * @param ctx the parse tree
	 */
	void enterOperatorShiftRight(@NotNull SquirrelParser.OperatorShiftRightContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#operatorShiftRight}.
	 * @param ctx the parse tree
	 */
	void exitOperatorShiftRight(@NotNull SquirrelParser.OperatorShiftRightContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#attributesconstructor}.
	 * @param ctx the parse tree
	 */
	void enterAttributesconstructor(@NotNull SquirrelParser.AttributesconstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#attributesconstructor}.
	 * @param ctx the parse tree
	 */
	void exitAttributesconstructor(@NotNull SquirrelParser.AttributesconstructorContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#nameAndArgs}.
	 * @param ctx the parse tree
	 */
	void enterNameAndArgs(@NotNull SquirrelParser.NameAndArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#nameAndArgs}.
	 * @param ctx the parse tree
	 */
	void exitNameAndArgs(@NotNull SquirrelParser.NameAndArgsContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#classstat}.
	 * @param ctx the parse tree
	 */
	void enterClassstat(@NotNull SquirrelParser.ClassstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#classstat}.
	 * @param ctx the parse tree
	 */
	void exitClassstat(@NotNull SquirrelParser.ClassstatContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#defaultcase}.
	 * @param ctx the parse tree
	 */
	void enterDefaultcase(@NotNull SquirrelParser.DefaultcaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#defaultcase}.
	 * @param ctx the parse tree
	 */
	void exitDefaultcase(@NotNull SquirrelParser.DefaultcaseContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#incexp}.
	 * @param ctx the parse tree
	 */
	void enterIncexp(@NotNull SquirrelParser.IncexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#incexp}.
	 * @param ctx the parse tree
	 */
	void exitIncexp(@NotNull SquirrelParser.IncexpContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#forloop}.
	 * @param ctx the parse tree
	 */
	void enterForloop(@NotNull SquirrelParser.ForloopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#forloop}.
	 * @param ctx the parse tree
	 */
	void exitForloop(@NotNull SquirrelParser.ForloopContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#breakstat}.
	 * @param ctx the parse tree
	 */
	void enterBreakstat(@NotNull SquirrelParser.BreakstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#breakstat}.
	 * @param ctx the parse tree
	 */
	void exitBreakstat(@NotNull SquirrelParser.BreakstatContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#operatorUnary}.
	 * @param ctx the parse tree
	 */
	void enterOperatorUnary(@NotNull SquirrelParser.OperatorUnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#operatorUnary}.
	 * @param ctx the parse tree
	 */
	void exitOperatorUnary(@NotNull SquirrelParser.OperatorUnaryContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#assignlist}.
	 * @param ctx the parse tree
	 */
	void enterAssignlist(@NotNull SquirrelParser.AssignlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#assignlist}.
	 * @param ctx the parse tree
	 */
	void exitAssignlist(@NotNull SquirrelParser.AssignlistContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#classconstructor}.
	 * @param ctx the parse tree
	 */
	void enterClassconstructor(@NotNull SquirrelParser.ClassconstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#classconstructor}.
	 * @param ctx the parse tree
	 */
	void exitClassconstructor(@NotNull SquirrelParser.ClassconstructorContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#enumconstructor}.
	 * @param ctx the parse tree
	 */
	void enterEnumconstructor(@NotNull SquirrelParser.EnumconstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#enumconstructor}.
	 * @param ctx the parse tree
	 */
	void exitEnumconstructor(@NotNull SquirrelParser.EnumconstructorContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#explist}.
	 * @param ctx the parse tree
	 */
	void enterExplist(@NotNull SquirrelParser.ExplistContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#explist}.
	 * @param ctx the parse tree
	 */
	void exitExplist(@NotNull SquirrelParser.ExplistContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#tablerows}.
	 * @param ctx the parse tree
	 */
	void enterTablerows(@NotNull SquirrelParser.TablerowsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#tablerows}.
	 * @param ctx the parse tree
	 */
	void exitTablerows(@NotNull SquirrelParser.TablerowsContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#funcargs}.
	 * @param ctx the parse tree
	 */
	void enterFuncargs(@NotNull SquirrelParser.FuncargsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#funcargs}.
	 * @param ctx the parse tree
	 */
	void exitFuncargs(@NotNull SquirrelParser.FuncargsContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull SquirrelParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull SquirrelParser.VarContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull SquirrelParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull SquirrelParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#operatorBinXor}.
	 * @param ctx the parse tree
	 */
	void enterOperatorBinXor(@NotNull SquirrelParser.OperatorBinXorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#operatorBinXor}.
	 * @param ctx the parse tree
	 */
	void exitOperatorBinXor(@NotNull SquirrelParser.OperatorBinXorContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#delegate}.
	 * @param ctx the parse tree
	 */
	void enterDelegate(@NotNull SquirrelParser.DelegateContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#delegate}.
	 * @param ctx the parse tree
	 */
	void exitDelegate(@NotNull SquirrelParser.DelegateContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void enterFunctioncall(@NotNull SquirrelParser.FunctioncallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void exitFunctioncall(@NotNull SquirrelParser.FunctioncallContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(@NotNull SquirrelParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(@NotNull SquirrelParser.NameContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#delete}.
	 * @param ctx the parse tree
	 */
	void enterDelete(@NotNull SquirrelParser.DeleteContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#delete}.
	 * @param ctx the parse tree
	 */
	void exitDelete(@NotNull SquirrelParser.DeleteContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#ifstat}.
	 * @param ctx the parse tree
	 */
	void enterIfstat(@NotNull SquirrelParser.IfstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#ifstat}.
	 * @param ctx the parse tree
	 */
	void exitIfstat(@NotNull SquirrelParser.IfstatContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#switchcase}.
	 * @param ctx the parse tree
	 */
	void enterSwitchcase(@NotNull SquirrelParser.SwitchcaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#switchcase}.
	 * @param ctx the parse tree
	 */
	void exitSwitchcase(@NotNull SquirrelParser.SwitchcaseContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#classassignlist}.
	 * @param ctx the parse tree
	 */
	void enterClassassignlist(@NotNull SquirrelParser.ClassassignlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#classassignlist}.
	 * @param ctx the parse tree
	 */
	void exitClassassignlist(@NotNull SquirrelParser.ClassassignlistContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#whileloop}.
	 * @param ctx the parse tree
	 */
	void enterWhileloop(@NotNull SquirrelParser.WhileloopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#whileloop}.
	 * @param ctx the parse tree
	 */
	void exitWhileloop(@NotNull SquirrelParser.WhileloopContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#namelist}.
	 * @param ctx the parse tree
	 */
	void enterNamelist(@NotNull SquirrelParser.NamelistContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#namelist}.
	 * @param ctx the parse tree
	 */
	void exitNamelist(@NotNull SquirrelParser.NamelistContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#tablerow}.
	 * @param ctx the parse tree
	 */
	void enterTablerow(@NotNull SquirrelParser.TablerowContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#tablerow}.
	 * @param ctx the parse tree
	 */
	void exitTablerow(@NotNull SquirrelParser.TablerowContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#operatorMulDivMod}.
	 * @param ctx the parse tree
	 */
	void enterOperatorMulDivMod(@NotNull SquirrelParser.OperatorMulDivModContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#operatorMulDivMod}.
	 * @param ctx the parse tree
	 */
	void exitOperatorMulDivMod(@NotNull SquirrelParser.OperatorMulDivModContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#operatorOr}.
	 * @param ctx the parse tree
	 */
	void enterOperatorOr(@NotNull SquirrelParser.OperatorOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#operatorOr}.
	 * @param ctx the parse tree
	 */
	void exitOperatorOr(@NotNull SquirrelParser.OperatorOrContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#functiondef}.
	 * @param ctx the parse tree
	 */
	void enterFunctiondef(@NotNull SquirrelParser.FunctiondefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#functiondef}.
	 * @param ctx the parse tree
	 */
	void exitFunctiondef(@NotNull SquirrelParser.FunctiondefContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#varOrExp}.
	 * @param ctx the parse tree
	 */
	void enterVarOrExp(@NotNull SquirrelParser.VarOrExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#varOrExp}.
	 * @param ctx the parse tree
	 */
	void exitVarOrExp(@NotNull SquirrelParser.VarOrExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(@NotNull SquirrelParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(@NotNull SquirrelParser.StatContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#operatorBinAnd}.
	 * @param ctx the parse tree
	 */
	void enterOperatorBinAnd(@NotNull SquirrelParser.OperatorBinAndContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#operatorBinAnd}.
	 * @param ctx the parse tree
	 */
	void exitOperatorBinAnd(@NotNull SquirrelParser.OperatorBinAndContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#resume}.
	 * @param ctx the parse tree
	 */
	void enterResume(@NotNull SquirrelParser.ResumeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#resume}.
	 * @param ctx the parse tree
	 */
	void exitResume(@NotNull SquirrelParser.ResumeContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#classdef}.
	 * @param ctx the parse tree
	 */
	void enterClassdef(@NotNull SquirrelParser.ClassdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#classdef}.
	 * @param ctx the parse tree
	 */
	void exitClassdef(@NotNull SquirrelParser.ClassdefContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#operatorShiftLeft}.
	 * @param ctx the parse tree
	 */
	void enterOperatorShiftLeft(@NotNull SquirrelParser.OperatorShiftLeftContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#operatorShiftLeft}.
	 * @param ctx the parse tree
	 */
	void exitOperatorShiftLeft(@NotNull SquirrelParser.OperatorShiftLeftContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#switchstat}.
	 * @param ctx the parse tree
	 */
	void enterSwitchstat(@NotNull SquirrelParser.SwitchstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#switchstat}.
	 * @param ctx the parse tree
	 */
	void exitSwitchstat(@NotNull SquirrelParser.SwitchstatContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#operatorComparison}.
	 * @param ctx the parse tree
	 */
	void enterOperatorComparison(@NotNull SquirrelParser.OperatorComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#operatorComparison}.
	 * @param ctx the parse tree
	 */
	void exitOperatorComparison(@NotNull SquirrelParser.OperatorComparisonContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(@NotNull SquirrelParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(@NotNull SquirrelParser.StringContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#operatorShiftRightUnsigned}.
	 * @param ctx the parse tree
	 */
	void enterOperatorShiftRightUnsigned(@NotNull SquirrelParser.OperatorShiftRightUnsignedContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#operatorShiftRightUnsigned}.
	 * @param ctx the parse tree
	 */
	void exitOperatorShiftRightUnsigned(@NotNull SquirrelParser.OperatorShiftRightUnsignedContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#enumlist}.
	 * @param ctx the parse tree
	 */
	void enterEnumlist(@NotNull SquirrelParser.EnumlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#enumlist}.
	 * @param ctx the parse tree
	 */
	void exitEnumlist(@NotNull SquirrelParser.EnumlistContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#localvar}.
	 * @param ctx the parse tree
	 */
	void enterLocalvar(@NotNull SquirrelParser.LocalvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#localvar}.
	 * @param ctx the parse tree
	 */
	void exitLocalvar(@NotNull SquirrelParser.LocalvarContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#funcname}.
	 * @param ctx the parse tree
	 */
	void enterFuncname(@NotNull SquirrelParser.FuncnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#funcname}.
	 * @param ctx the parse tree
	 */
	void exitFuncname(@NotNull SquirrelParser.FuncnameContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#constdef}.
	 * @param ctx the parse tree
	 */
	void enterConstdef(@NotNull SquirrelParser.ConstdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#constdef}.
	 * @param ctx the parse tree
	 */
	void exitConstdef(@NotNull SquirrelParser.ConstdefContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#dowhileloop}.
	 * @param ctx the parse tree
	 */
	void enterDowhileloop(@NotNull SquirrelParser.DowhileloopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#dowhileloop}.
	 * @param ctx the parse tree
	 */
	void exitDowhileloop(@NotNull SquirrelParser.DowhileloopContext ctx);

	/**
	 * Enter a parse tree produced by {@link SquirrelParser#declarelist}.
	 * @param ctx the parse tree
	 */
	void enterDeclarelist(@NotNull SquirrelParser.DeclarelistContext ctx);
	/**
	 * Exit a parse tree produced by {@link SquirrelParser#declarelist}.
	 * @param ctx the parse tree
	 */
	void exitDeclarelist(@NotNull SquirrelParser.DeclarelistContext ctx);
}