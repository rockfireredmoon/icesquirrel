// Generated from org/iceparser/Squirrel.g4 by ANTLR 4.3
package org.iceparser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SquirrelParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__63=1, T__62=2, T__61=3, T__60=4, T__59=5, T__58=6, T__57=7, T__56=8, 
		T__55=9, T__54=10, T__53=11, T__52=12, T__51=13, T__50=14, T__49=15, T__48=16, 
		T__47=17, T__46=18, T__45=19, T__44=20, T__43=21, T__42=22, T__41=23, 
		T__40=24, T__39=25, T__38=26, T__37=27, T__36=28, T__35=29, T__34=30, 
		T__33=31, T__32=32, T__31=33, T__30=34, T__29=35, T__28=36, T__27=37, 
		T__26=38, T__25=39, T__24=40, T__23=41, T__22=42, T__21=43, T__20=44, 
		T__19=45, T__18=46, T__17=47, T__16=48, T__15=49, T__14=50, T__13=51, 
		T__12=52, T__11=53, T__10=54, T__9=55, T__8=56, T__7=57, T__6=58, T__5=59, 
		T__4=60, T__3=61, T__2=62, T__1=63, T__0=64, TRUE=65, FALSE=66, NULL=67, 
		ROOT=68, NAME=69, NORMALSTRING=70, VERBATIMSTRING=71, OCTAL=72, INT=73, 
		HEX=74, FLOAT=75, CHAR=76, COMMA=77, ASSIGN=78, NEW_SLOT=79, VARARGS=80, 
		STATSEP=81, INC=82, DEC=83, INCVAL=84, DECVAL=85, COMMENT=86, LINE_COMMENT=87, 
		WS=88, SHEBANG=89;
	public static final String[] tokenNames = {
		"<INVALID>", "'default'", "'clone'", "'foreach'", "'!='", "'while'", "'{'", 
		"'>>'", "'&&'", "'^'", "'for'", "'delegate'", "'delete'", "'constructor'", 
		"'do'", "'('", "'typeof'", "'const'", "'>='", "'<'", "'>>>'", "']'", "'~'", 
		"'vargc'", "'static'", "'function'", "'+'", "'/'", "'continue'", "'return'", 
		"'class'", "'||'", "'instanceof'", "'<<'", "'extends'", "'}'", "'if'", 
		"'?'", "'enum'", "'<='", "'break'", "'resume'", "'local'", "'&'", "'yield'", 
		"'switch'", "'*'", "':('", "'.'", "'</'", "'case'", "'throw'", "':'", 
		"'['", "'=='", "'|'", "'>'", "'!'", "'%'", "'else'", "'in'", "')'", "'/>'", 
		"'vargv'", "'-'", "'true'", "'false'", "'null'", "'::'", "NAME", "NORMALSTRING", 
		"VERBATIMSTRING", "OCTAL", "INT", "HEX", "FLOAT", "CHAR", "','", "'='", 
		"'<-'", "'...'", "';'", "'++'", "'--'", "'+='", "'-='", "COMMENT", "LINE_COMMENT", 
		"WS", "SHEBANG"
	};
	public static final int
		RULE_script = 0, RULE_block = 1, RULE_stat = 2, RULE_breakstat = 3, RULE_continuestat = 4, 
		RULE_switchstat = 5, RULE_throwstat = 6, RULE_forloop = 7, RULE_foreachloop = 8, 
		RULE_dowhileloop = 9, RULE_whileloop = 10, RULE_ifstat = 11, RULE_constdef = 12, 
		RULE_enumdef = 13, RULE_switchcase = 14, RULE_defaultcase = 15, RULE_funcname = 16, 
		RULE_classstat = 17, RULE_staticvar = 18, RULE_localvar = 19, RULE_retstat = 20, 
		RULE_explist = 21, RULE_exp = 22, RULE_declare = 23, RULE_declarelist = 24, 
		RULE_classassign = 25, RULE_classassignlist = 26, RULE_assign = 27, RULE_assignlist = 28, 
		RULE_resume = 29, RULE_clone = 30, RULE_delete = 31, RULE_yield = 32, 
		RULE_vargc = 33, RULE_vargv = 34, RULE_delegate = 35, RULE_typeof = 36, 
		RULE_incexp = 37, RULE_log = 38, RULE_var = 39, RULE_functioncall = 40, 
		RULE_varOrExp = 41, RULE_nameAndArgs = 42, RULE_varSuffix = 43, RULE_args = 44, 
		RULE_namedfunction = 45, RULE_classfunction = 46, RULE_functiondef = 47, 
		RULE_nameonlylist = 48, RULE_name = 49, RULE_namelist = 50, RULE_arglist = 51, 
		RULE_funcargs = 52, RULE_classdef = 53, RULE_classconstructor = 54, RULE_arrayconstructor = 55, 
		RULE_attributesconstructor = 56, RULE_tableconstructor = 57, RULE_enumconstructor = 58, 
		RULE_enumlist = 59, RULE_primitiveitem = 60, RULE_tablerows = 61, RULE_tablerow = 62, 
		RULE_operatorOr = 63, RULE_operatorAnd = 64, RULE_operatorBinXor = 65, 
		RULE_operatorBinAnd = 66, RULE_operatorBinOr = 67, RULE_operatorShiftLeft = 68, 
		RULE_operatorShiftRight = 69, RULE_operatorShiftRightUnsigned = 70, RULE_operatorComparison = 71, 
		RULE_operatorAddSub = 72, RULE_operatorMulDivMod = 73, RULE_operatorUnary = 74, 
		RULE_number = 75, RULE_string = 76;
	public static final String[] ruleNames = {
		"script", "block", "stat", "breakstat", "continuestat", "switchstat", 
		"throwstat", "forloop", "foreachloop", "dowhileloop", "whileloop", "ifstat", 
		"constdef", "enumdef", "switchcase", "defaultcase", "funcname", "classstat", 
		"staticvar", "localvar", "retstat", "explist", "exp", "declare", "declarelist", 
		"classassign", "classassignlist", "assign", "assignlist", "resume", "clone", 
		"delete", "yield", "vargc", "vargv", "delegate", "typeof", "incexp", "log", 
		"var", "functioncall", "varOrExp", "nameAndArgs", "varSuffix", "args", 
		"namedfunction", "classfunction", "functiondef", "nameonlylist", "name", 
		"namelist", "arglist", "funcargs", "classdef", "classconstructor", "arrayconstructor", 
		"attributesconstructor", "tableconstructor", "enumconstructor", "enumlist", 
		"primitiveitem", "tablerows", "tablerow", "operatorOr", "operatorAnd", 
		"operatorBinXor", "operatorBinAnd", "operatorBinOr", "operatorShiftLeft", 
		"operatorShiftRight", "operatorShiftRightUnsigned", "operatorComparison", 
		"operatorAddSub", "operatorMulDivMod", "operatorUnary", "number", "string"
	};

	@Override
	public String getGrammarFileName() { return "Squirrel.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SquirrelParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ScriptContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SquirrelParser.EOF, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitScript(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_script);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__62) | (1L << T__61) | (1L << T__59) | (1L << T__58) | (1L << T__54) | (1L << T__53) | (1L << T__52) | (1L << T__50) | (1L << T__49) | (1L << T__48) | (1L << T__47) | (1L << T__42) | (1L << T__41) | (1L << T__39) | (1L << T__36) | (1L << T__35) | (1L << T__34) | (1L << T__28) | (1L << T__26) | (1L << T__24) | (1L << T__23) | (1L << T__22) | (1L << T__20) | (1L << T__19) | (1L << T__13) | (1L << T__11) | (1L << T__7) | (1L << T__1))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__0 - 64)) | (1L << (TRUE - 64)) | (1L << (FALSE - 64)) | (1L << (NULL - 64)) | (1L << (ROOT - 64)) | (1L << (NAME - 64)) | (1L << (NORMALSTRING - 64)) | (1L << (VERBATIMSTRING - 64)) | (1L << (OCTAL - 64)) | (1L << (INT - 64)) | (1L << (HEX - 64)) | (1L << (FLOAT - 64)) | (1L << (CHAR - 64)) | (1L << (STATSEP - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)))) != 0)) {
				{
				{
				setState(154); stat();
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(160); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(T__58);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__62) | (1L << T__61) | (1L << T__59) | (1L << T__58) | (1L << T__54) | (1L << T__53) | (1L << T__52) | (1L << T__50) | (1L << T__49) | (1L << T__48) | (1L << T__47) | (1L << T__42) | (1L << T__41) | (1L << T__39) | (1L << T__36) | (1L << T__35) | (1L << T__34) | (1L << T__28) | (1L << T__26) | (1L << T__24) | (1L << T__23) | (1L << T__22) | (1L << T__20) | (1L << T__19) | (1L << T__13) | (1L << T__11) | (1L << T__7) | (1L << T__1))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__0 - 64)) | (1L << (TRUE - 64)) | (1L << (FALSE - 64)) | (1L << (NULL - 64)) | (1L << (ROOT - 64)) | (1L << (NAME - 64)) | (1L << (NORMALSTRING - 64)) | (1L << (VERBATIMSTRING - 64)) | (1L << (OCTAL - 64)) | (1L << (INT - 64)) | (1L << (HEX - 64)) | (1L << (FLOAT - 64)) | (1L << (CHAR - 64)) | (1L << (STATSEP - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)))) != 0)) {
				{
				{
				setState(163); stat();
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(169); match(T__29);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public ConstdefContext constdef() {
			return getRuleContext(ConstdefContext.class,0);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public NamedfunctionContext namedfunction() {
			return getRuleContext(NamedfunctionContext.class,0);
		}
		public LocalvarContext localvar() {
			return getRuleContext(LocalvarContext.class,0);
		}
		public BreakstatContext breakstat() {
			return getRuleContext(BreakstatContext.class,0);
		}
		public IfstatContext ifstat() {
			return getRuleContext(IfstatContext.class,0);
		}
		public ForloopContext forloop() {
			return getRuleContext(ForloopContext.class,0);
		}
		public ThrowstatContext throwstat() {
			return getRuleContext(ThrowstatContext.class,0);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SwitchstatContext switchstat() {
			return getRuleContext(SwitchstatContext.class,0);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SquirrelParser.COMMA, i);
		}
		public WhileloopContext whileloop() {
			return getRuleContext(WhileloopContext.class,0);
		}
		public ForeachloopContext foreachloop() {
			return getRuleContext(ForeachloopContext.class,0);
		}
		public EnumdefContext enumdef() {
			return getRuleContext(EnumdefContext.class,0);
		}
		public ClassdefContext classdef() {
			return getRuleContext(ClassdefContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(SquirrelParser.COMMA); }
		public ContinuestatContext continuestat() {
			return getRuleContext(ContinuestatContext.class,0);
		}
		public TerminalNode STATSEP() { return getToken(SquirrelParser.STATSEP, 0); }
		public FunctioncallContext functioncall() {
			return getRuleContext(FunctioncallContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public DowhileloopContext dowhileloop() {
			return getRuleContext(DowhileloopContext.class,0);
		}
		public RetstatContext retstat() {
			return getRuleContext(RetstatContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		try {
			int _alt;
			setState(197);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(171); match(STATSEP);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172); functioncall();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(173); breakstat();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(174); continuestat();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(175); dowhileloop();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(176); localvar();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(177); whileloop();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(178); ifstat();
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(179); forloop();
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(180); foreachloop();
				}
				break;

			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(181); namedfunction();
				}
				break;

			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(182); throwstat();
				}
				break;

			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(183); switchstat();
				}
				break;

			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(184); constdef();
				}
				break;

			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(185); enumdef();
				}
				break;

			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(186); classdef();
				}
				break;

			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(187); retstat();
				}
				break;

			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(188); block();
				}
				break;

			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(189); exp(0);
				setState(194);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(190); match(COMMA);
						setState(191); exp(0);
						}
						} 
					}
					setState(196);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BreakstatContext extends ParserRuleContext {
		public BreakstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakstat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterBreakstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitBreakstat(this);
		}
	}

	public final BreakstatContext breakstat() throws RecognitionException {
		BreakstatContext _localctx = new BreakstatContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_breakstat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199); match(T__24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContinuestatContext extends ParserRuleContext {
		public ContinuestatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continuestat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterContinuestat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitContinuestat(this);
		}
	}

	public final ContinuestatContext continuestat() throws RecognitionException {
		ContinuestatContext _localctx = new ContinuestatContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_continuestat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201); match(T__36);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchstatContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public SwitchcaseContext switchcase(int i) {
			return getRuleContext(SwitchcaseContext.class,i);
		}
		public List<SwitchcaseContext> switchcase() {
			return getRuleContexts(SwitchcaseContext.class);
		}
		public DefaultcaseContext defaultcase() {
			return getRuleContext(DefaultcaseContext.class,0);
		}
		public SwitchstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchstat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterSwitchstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitSwitchstat(this);
		}
	}

	public final SwitchstatContext switchstat() throws RecognitionException {
		SwitchstatContext _localctx = new SwitchstatContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_switchstat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203); match(T__19);
			setState(204); match(T__49);
			setState(205); exp(0);
			setState(206); match(T__3);
			setState(207); match(T__58);
			setState(217);
			switch (_input.LA(1)) {
			case T__14:
				{
				{
				setState(209); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(208); switchcase();
					}
					}
					setState(211); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__14 );
				setState(214);
				_la = _input.LA(1);
				if (_la==T__63) {
					{
					setState(213); defaultcase();
					}
				}

				}
				}
				break;
			case T__63:
				{
				setState(216); defaultcase();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(219); match(T__29);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThrowstatContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ThrowstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwstat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterThrowstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitThrowstat(this);
		}
	}

	public final ThrowstatContext throwstat() throws RecognitionException {
		ThrowstatContext _localctx = new ThrowstatContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_throwstat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221); match(T__13);
			setState(222); exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForloopContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode STATSEP(int i) {
			return getToken(SquirrelParser.STATSEP, i);
		}
		public LocalvarContext localvar() {
			return getRuleContext(LocalvarContext.class,0);
		}
		public AssignlistContext assignlist() {
			return getRuleContext(AssignlistContext.class,0);
		}
		public List<TerminalNode> STATSEP() { return getTokens(SquirrelParser.STATSEP); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ForloopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forloop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterForloop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitForloop(this);
		}
	}

	public final ForloopContext forloop() throws RecognitionException {
		ForloopContext _localctx = new ForloopContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_forloop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224); match(T__54);
			setState(225); match(T__49);
			setState(228);
			switch (_input.LA(1)) {
			case T__22:
				{
				setState(226); localvar();
				}
				break;
			case T__49:
			case T__41:
			case T__1:
			case ROOT:
			case NAME:
				{
				setState(227); assignlist();
				}
				break;
			case STATSEP:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(230); match(STATSEP);
			setState(232);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__62) | (1L << T__58) | (1L << T__53) | (1L << T__52) | (1L << T__49) | (1L << T__48) | (1L << T__42) | (1L << T__41) | (1L << T__39) | (1L << T__23) | (1L << T__20) | (1L << T__11) | (1L << T__7) | (1L << T__1))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__0 - 64)) | (1L << (TRUE - 64)) | (1L << (FALSE - 64)) | (1L << (NULL - 64)) | (1L << (ROOT - 64)) | (1L << (NAME - 64)) | (1L << (NORMALSTRING - 64)) | (1L << (VERBATIMSTRING - 64)) | (1L << (OCTAL - 64)) | (1L << (INT - 64)) | (1L << (HEX - 64)) | (1L << (FLOAT - 64)) | (1L << (CHAR - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)))) != 0)) {
				{
				setState(231); exp(0);
				}
			}

			setState(234); match(STATSEP);
			setState(236);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__62) | (1L << T__58) | (1L << T__53) | (1L << T__52) | (1L << T__49) | (1L << T__48) | (1L << T__42) | (1L << T__41) | (1L << T__39) | (1L << T__23) | (1L << T__20) | (1L << T__11) | (1L << T__7) | (1L << T__1))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__0 - 64)) | (1L << (TRUE - 64)) | (1L << (FALSE - 64)) | (1L << (NULL - 64)) | (1L << (ROOT - 64)) | (1L << (NAME - 64)) | (1L << (NORMALSTRING - 64)) | (1L << (VERBATIMSTRING - 64)) | (1L << (OCTAL - 64)) | (1L << (INT - 64)) | (1L << (HEX - 64)) | (1L << (FLOAT - 64)) | (1L << (CHAR - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)))) != 0)) {
				{
				setState(235); exp(0);
				}
			}

			setState(238); match(T__3);
			setState(239); stat();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForeachloopContext extends ParserRuleContext {
		public TerminalNode NAME(int i) {
			return getToken(SquirrelParser.NAME, i);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<TerminalNode> NAME() { return getTokens(SquirrelParser.NAME); }
		public TerminalNode COMMA() { return getToken(SquirrelParser.COMMA, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ForeachloopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreachloop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterForeachloop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitForeachloop(this);
		}
	}

	public final ForeachloopContext foreachloop() throws RecognitionException {
		ForeachloopContext _localctx = new ForeachloopContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_foreachloop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241); match(T__61);
			setState(242); match(T__49);
			setState(245);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(243); match(NAME);
				setState(244); match(COMMA);
				}
				break;
			}
			setState(247); match(NAME);
			setState(248); match(T__4);
			setState(249); exp(0);
			setState(250); match(T__3);
			setState(251); stat();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DowhileloopContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public DowhileloopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dowhileloop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterDowhileloop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitDowhileloop(this);
		}
	}

	public final DowhileloopContext dowhileloop() throws RecognitionException {
		DowhileloopContext _localctx = new DowhileloopContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dowhileloop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253); match(T__50);
			setState(254); stat();
			setState(255); match(T__59);
			setState(256); exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileloopContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public WhileloopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileloop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterWhileloop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitWhileloop(this);
		}
	}

	public final WhileloopContext whileloop() throws RecognitionException {
		WhileloopContext _localctx = new WhileloopContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_whileloop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258); match(T__59);
			setState(259); exp(0);
			setState(260); stat();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfstatContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode STATSEP() { return getToken(SquirrelParser.STATSEP, 0); }
		public IfstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterIfstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitIfstat(this);
		}
	}

	public final IfstatContext ifstat() throws RecognitionException {
		IfstatContext _localctx = new IfstatContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifstat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262); match(T__28);
			setState(263); match(T__49);
			setState(264); exp(0);
			setState(265); match(T__3);
			setState(266); stat();
			setState(268);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(267); match(STATSEP);
				}
				break;
			}
			setState(272);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(270); match(T__5);
				setState(271); stat();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstdefContext extends ParserRuleContext {
		public PrimitiveitemContext primitiveitem() {
			return getRuleContext(PrimitiveitemContext.class,0);
		}
		public ConstdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterConstdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitConstdef(this);
		}
	}

	public final ConstdefContext constdef() throws RecognitionException {
		ConstdefContext _localctx = new ConstdefContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_constdef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274); match(T__47);
			setState(275); primitiveitem();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumdefContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(SquirrelParser.ASSIGN, 0); }
		public TerminalNode NAME() { return getToken(SquirrelParser.NAME, 0); }
		public EnumconstructorContext enumconstructor() {
			return getRuleContext(EnumconstructorContext.class,0);
		}
		public EnumdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterEnumdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitEnumdef(this);
		}
	}

	public final EnumdefContext enumdef() throws RecognitionException {
		EnumdefContext _localctx = new EnumdefContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_enumdef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277); match(T__26);
			setState(278); match(NAME);
			setState(279); match(ASSIGN);
			setState(280); enumconstructor();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SwitchcaseContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public SwitchcaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchcase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterSwitchcase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitSwitchcase(this);
		}
	}

	public final SwitchcaseContext switchcase() throws RecognitionException {
		SwitchcaseContext _localctx = new SwitchcaseContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_switchcase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282); match(T__14);
			setState(283); exp(0);
			setState(284); match(T__12);
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__62) | (1L << T__61) | (1L << T__59) | (1L << T__58) | (1L << T__54) | (1L << T__53) | (1L << T__52) | (1L << T__50) | (1L << T__49) | (1L << T__48) | (1L << T__47) | (1L << T__42) | (1L << T__41) | (1L << T__39) | (1L << T__36) | (1L << T__35) | (1L << T__34) | (1L << T__28) | (1L << T__26) | (1L << T__24) | (1L << T__23) | (1L << T__22) | (1L << T__20) | (1L << T__19) | (1L << T__13) | (1L << T__11) | (1L << T__7) | (1L << T__1))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__0 - 64)) | (1L << (TRUE - 64)) | (1L << (FALSE - 64)) | (1L << (NULL - 64)) | (1L << (ROOT - 64)) | (1L << (NAME - 64)) | (1L << (NORMALSTRING - 64)) | (1L << (VERBATIMSTRING - 64)) | (1L << (OCTAL - 64)) | (1L << (INT - 64)) | (1L << (HEX - 64)) | (1L << (FLOAT - 64)) | (1L << (CHAR - 64)) | (1L << (STATSEP - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)))) != 0)) {
				{
				{
				setState(285); stat();
				}
				}
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefaultcaseContext extends ParserRuleContext {
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public DefaultcaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultcase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterDefaultcase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitDefaultcase(this);
		}
	}

	public final DefaultcaseContext defaultcase() throws RecognitionException {
		DefaultcaseContext _localctx = new DefaultcaseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_defaultcase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291); match(T__63);
			setState(292); match(T__12);
			setState(294); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(293); stat();
				}
				}
				setState(296); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__62) | (1L << T__61) | (1L << T__59) | (1L << T__58) | (1L << T__54) | (1L << T__53) | (1L << T__52) | (1L << T__50) | (1L << T__49) | (1L << T__48) | (1L << T__47) | (1L << T__42) | (1L << T__41) | (1L << T__39) | (1L << T__36) | (1L << T__35) | (1L << T__34) | (1L << T__28) | (1L << T__26) | (1L << T__24) | (1L << T__23) | (1L << T__22) | (1L << T__20) | (1L << T__19) | (1L << T__13) | (1L << T__11) | (1L << T__7) | (1L << T__1))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__0 - 64)) | (1L << (TRUE - 64)) | (1L << (FALSE - 64)) | (1L << (NULL - 64)) | (1L << (ROOT - 64)) | (1L << (NAME - 64)) | (1L << (NORMALSTRING - 64)) | (1L << (VERBATIMSTRING - 64)) | (1L << (OCTAL - 64)) | (1L << (INT - 64)) | (1L << (HEX - 64)) | (1L << (FLOAT - 64)) | (1L << (CHAR - 64)) | (1L << (STATSEP - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncnameContext extends ParserRuleContext {
		public TerminalNode NAME(int i) {
			return getToken(SquirrelParser.NAME, i);
		}
		public List<TerminalNode> NAME() { return getTokens(SquirrelParser.NAME); }
		public FuncnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterFuncname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitFuncname(this);
		}
	}

	public final FuncnameContext funcname() throws RecognitionException {
		FuncnameContext _localctx = new FuncnameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_funcname);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298); match(NAME);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ROOT) {
				{
				{
				setState(299); match(ROOT);
				setState(300); match(NAME);
				}
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassstatContext extends ParserRuleContext {
		public ClassfunctionContext classfunction() {
			return getRuleContext(ClassfunctionContext.class,0);
		}
		public TerminalNode STATSEP() { return getToken(SquirrelParser.STATSEP, 0); }
		public ClassconstructorContext classconstructor() {
			return getRuleContext(ClassconstructorContext.class,0);
		}
		public StaticvarContext staticvar() {
			return getRuleContext(StaticvarContext.class,0);
		}
		public ClassassignlistContext classassignlist() {
			return getRuleContext(ClassassignlistContext.class,0);
		}
		public ClassstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classstat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterClassstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitClassstat(this);
		}
	}

	public final ClassstatContext classstat() throws RecognitionException {
		ClassstatContext _localctx = new ClassstatContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_classstat);
		try {
			setState(311);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(306); classconstructor();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(307); classfunction();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(308); classassignlist();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(309); staticvar();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(310); match(STATSEP);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StaticvarContext extends ParserRuleContext {
		public DeclarelistContext declarelist() {
			return getRuleContext(DeclarelistContext.class,0);
		}
		public StaticvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticvar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterStaticvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitStaticvar(this);
		}
	}

	public final StaticvarContext staticvar() throws RecognitionException {
		StaticvarContext _localctx = new StaticvarContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_staticvar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313); match(T__40);
			setState(314); declarelist();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalvarContext extends ParserRuleContext {
		public DeclarelistContext declarelist() {
			return getRuleContext(DeclarelistContext.class,0);
		}
		public LocalvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localvar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterLocalvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitLocalvar(this);
		}
	}

	public final LocalvarContext localvar() throws RecognitionException {
		LocalvarContext _localctx = new LocalvarContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_localvar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316); match(T__22);
			setState(317); declarelist();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RetstatContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode STATSEP() { return getToken(SquirrelParser.STATSEP, 0); }
		public RetstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retstat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterRetstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitRetstat(this);
		}
	}

	public final RetstatContext retstat() throws RecognitionException {
		RetstatContext _localctx = new RetstatContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_retstat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319); match(T__35);
			setState(321);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(320); exp(0);
				}
				break;
			}
			setState(324);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(323); match(STATSEP);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExplistContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SquirrelParser.COMMA); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SquirrelParser.COMMA, i);
		}
		public ExplistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterExplist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitExplist(this);
		}
	}

	public final ExplistContext explist() throws RecognitionException {
		ExplistContext _localctx = new ExplistContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_explist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326); exp(0);
			setState(329); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(327); match(COMMA);
				setState(328); exp(0);
				}
				}
				setState(331); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public OperatorBinOrContext operatorBinOr() {
			return getRuleContext(OperatorBinOrContext.class,0);
		}
		public CloneContext clone() {
			return getRuleContext(CloneContext.class,0);
		}
		public OperatorAndContext operatorAnd() {
			return getRuleContext(OperatorAndContext.class,0);
		}
		public OperatorBinAndContext operatorBinAnd() {
			return getRuleContext(OperatorBinAndContext.class,0);
		}
		public ResumeContext resume() {
			return getRuleContext(ResumeContext.class,0);
		}
		public OperatorMulDivModContext operatorMulDivMod() {
			return getRuleContext(OperatorMulDivModContext.class,0);
		}
		public OperatorAddSubContext operatorAddSub() {
			return getRuleContext(OperatorAddSubContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public OperatorOrContext operatorOr() {
			return getRuleContext(OperatorOrContext.class,0);
		}
		public ExplistContext explist() {
			return getRuleContext(ExplistContext.class,0);
		}
		public LogContext log() {
			return getRuleContext(LogContext.class,0);
		}
		public TableconstructorContext tableconstructor() {
			return getRuleContext(TableconstructorContext.class,0);
		}
		public OperatorComparisonContext operatorComparison() {
			return getRuleContext(OperatorComparisonContext.class,0);
		}
		public OperatorUnaryContext operatorUnary() {
			return getRuleContext(OperatorUnaryContext.class,0);
		}
		public FunctiondefContext functiondef() {
			return getRuleContext(FunctiondefContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public AssignlistContext assignlist() {
			return getRuleContext(AssignlistContext.class,0);
		}
		public OperatorShiftRightUnsignedContext operatorShiftRightUnsigned() {
			return getRuleContext(OperatorShiftRightUnsignedContext.class,0);
		}
		public DeleteContext delete() {
			return getRuleContext(DeleteContext.class,0);
		}
		public TypeofContext typeof() {
			return getRuleContext(TypeofContext.class,0);
		}
		public IncexpContext incexp() {
			return getRuleContext(IncexpContext.class,0);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public OperatorShiftLeftContext operatorShiftLeft() {
			return getRuleContext(OperatorShiftLeftContext.class,0);
		}
		public OperatorShiftRightContext operatorShiftRight() {
			return getRuleContext(OperatorShiftRightContext.class,0);
		}
		public YieldContext yield() {
			return getRuleContext(YieldContext.class,0);
		}
		public DelegateContext delegate() {
			return getRuleContext(DelegateContext.class,0);
		}
		public OperatorBinXorContext operatorBinXor() {
			return getRuleContext(OperatorBinXorContext.class,0);
		}
		public ArrayconstructorContext arrayconstructor() {
			return getRuleContext(ArrayconstructorContext.class,0);
		}
		public FunctioncallContext functioncall() {
			return getRuleContext(FunctioncallContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitExp(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_exp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(334); operatorUnary();
				setState(335); exp(14);
				}
				break;

			case 2:
				{
				setState(337); match(T__49);
				setState(338); explist();
				setState(339); match(T__3);
				}
				break;

			case 3:
				{
				setState(341); match(T__49);
				setState(342); exp(0);
				setState(343); match(T__3);
				}
				break;

			case 4:
				{
				setState(345); number();
				}
				break;

			case 5:
				{
				setState(346); string();
				}
				break;

			case 6:
				{
				setState(347); delegate();
				}
				break;

			case 7:
				{
				setState(348); yield();
				}
				break;

			case 8:
				{
				setState(349); delete();
				}
				break;

			case 9:
				{
				setState(350); clone();
				}
				break;

			case 10:
				{
				setState(351); typeof();
				}
				break;

			case 11:
				{
				setState(352); functiondef();
				}
				break;

			case 12:
				{
				setState(353); functioncall();
				}
				break;

			case 13:
				{
				setState(354); assignlist();
				}
				break;

			case 14:
				{
				setState(355); tableconstructor();
				}
				break;

			case 15:
				{
				setState(356); arrayconstructor();
				}
				break;

			case 16:
				{
				setState(357); resume();
				}
				break;

			case 17:
				{
				setState(358); incexp();
				}
				break;

			case 18:
				{
				setState(359); log();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(417);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(415);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(362);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(363); match(T__4);
						setState(364); exp(20);
						}
						break;

					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(365);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(366); operatorMulDivMod();
						setState(367); exp(14);
						}
						break;

					case 3:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(369);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(370); operatorAddSub();
						setState(371); exp(13);
						}
						break;

					case 4:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(373);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(374); operatorShiftLeft();
						setState(375); exp(12);
						}
						break;

					case 5:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(377);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(378); operatorShiftRight();
						setState(379); exp(11);
						}
						break;

					case 6:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(381);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(382); operatorShiftRightUnsigned();
						setState(383); exp(10);
						}
						break;

					case 7:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(385);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(386); operatorComparison();
						setState(387); exp(9);
						}
						break;

					case 8:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(389);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(390); operatorBinAnd();
						setState(391); exp(7);
						}
						break;

					case 9:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(393);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(394); operatorBinXor();
						setState(395); exp(6);
						}
						break;

					case 10:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(397);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(398); operatorBinOr();
						setState(399); exp(5);
						}
						break;

					case 11:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(401);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(402); operatorAnd();
						setState(403); exp(5);
						}
						break;

					case 12:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(405);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(406); operatorOr();
						setState(407); exp(4);
						}
						break;

					case 13:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(409);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(410); match(T__27);
						setState(411); exp(0);
						setState(412); match(T__12);
						setState(413); exp(3);
						}
						break;
					}
					} 
				}
				setState(419);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DeclareContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SquirrelParser.ASSIGN, 0); }
		public TerminalNode NAME() { return getToken(SquirrelParser.NAME, 0); }
		public DeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitDeclare(this);
		}
	}

	public final DeclareContext declare() throws RecognitionException {
		DeclareContext _localctx = new DeclareContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_declare);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420); match(NAME);
			setState(423);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(421); match(ASSIGN);
				setState(422); exp(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarelistContext extends ParserRuleContext {
		public List<DeclareContext> declare() {
			return getRuleContexts(DeclareContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SquirrelParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SquirrelParser.COMMA, i);
		}
		public DeclareContext declare(int i) {
			return getRuleContext(DeclareContext.class,i);
		}
		public DeclarelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarelist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterDeclarelist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitDeclarelist(this);
		}
	}

	public final DeclarelistContext declarelist() throws RecognitionException {
		DeclarelistContext _localctx = new DeclarelistContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_declarelist);
		try {
			int _alt;
			setState(433);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(425); declare();
				setState(428); 
				_errHandler.sync(this);
				_alt = 1+1;
				do {
					switch (_alt) {
					case 1+1:
						{
						{
						setState(426); match(COMMA);
						setState(427); declare();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(430); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(432); declare();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassassignContext extends ParserRuleContext {
		public AttributesconstructorContext attributesconstructor() {
			return getRuleContext(AttributesconstructorContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public ClassassignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classassign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterClassassign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitClassassign(this);
		}
	}

	public final ClassassignContext classassign() throws RecognitionException {
		ClassassignContext _localctx = new ClassassignContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_classassign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(435); attributesconstructor();
				}
			}

			setState(438); assign();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassassignlistContext extends ParserRuleContext {
		public List<ClassassignContext> classassign() {
			return getRuleContexts(ClassassignContext.class);
		}
		public ClassassignContext classassign(int i) {
			return getRuleContext(ClassassignContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SquirrelParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SquirrelParser.COMMA, i);
		}
		public ClassassignlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classassignlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterClassassignlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitClassassignlist(this);
		}
	}

	public final ClassassignlistContext classassignlist() throws RecognitionException {
		ClassassignlistContext _localctx = new ClassassignlistContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_classassignlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440); classassign();
			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(441); match(COMMA);
				setState(442); classassign();
				}
				}
				setState(447);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SquirrelParser.ASSIGN, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode NEW_SLOT() { return getToken(SquirrelParser.NEW_SLOT, 0); }
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448); var();
			setState(449);
			_la = _input.LA(1);
			if ( !(_la==ASSIGN || _la==NEW_SLOT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(450); exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignlistContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SquirrelParser.COMMA); }
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SquirrelParser.COMMA, i);
		}
		public AssignlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterAssignlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitAssignlist(this);
		}
	}

	public final AssignlistContext assignlist() throws RecognitionException {
		AssignlistContext _localctx = new AssignlistContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_assignlist);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(452); assign();
			setState(457);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(453); match(COMMA);
					setState(454); assign();
					}
					} 
				}
				setState(459);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResumeContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ResumeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resume; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterResume(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitResume(this);
		}
	}

	public final ResumeContext resume() throws RecognitionException {
		ResumeContext _localctx = new ResumeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_resume);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460); match(T__23);
			setState(461); exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CloneContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public CloneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clone; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterClone(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitClone(this);
		}
	}

	public final CloneContext clone() throws RecognitionException {
		CloneContext _localctx = new CloneContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_clone);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463); match(T__62);
			setState(464); exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeleteContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public DeleteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterDelete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitDelete(this);
		}
	}

	public final DeleteContext delete() throws RecognitionException {
		DeleteContext _localctx = new DeleteContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_delete);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466); match(T__52);
			setState(467); var();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class YieldContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public YieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yield; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterYield(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitYield(this);
		}
	}

	public final YieldContext yield() throws RecognitionException {
		YieldContext _localctx = new YieldContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_yield);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469); match(T__20);
			setState(470); exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VargcContext extends ParserRuleContext {
		public VargcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vargc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterVargc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitVargc(this);
		}
	}

	public final VargcContext vargc() throws RecognitionException {
		VargcContext _localctx = new VargcContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_vargc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472); match(T__41);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VargvContext extends ParserRuleContext {
		public VargvContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vargv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterVargv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitVargv(this);
		}
	}

	public final VargvContext vargv() throws RecognitionException {
		VargvContext _localctx = new VargvContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_vargv);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474); match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DelegateContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public DelegateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delegate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterDelegate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitDelegate(this);
		}
	}

	public final DelegateContext delegate() throws RecognitionException {
		DelegateContext _localctx = new DelegateContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_delegate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476); match(T__53);
			setState(477); exp(0);
			setState(478); match(T__12);
			setState(479); exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeofContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TypeofContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeof; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterTypeof(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitTypeof(this);
		}
	}

	public final TypeofContext typeof() throws RecognitionException {
		TypeofContext _localctx = new TypeofContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_typeof);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(481); match(T__48);
			setState(482); var();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IncexpContext extends ParserRuleContext {
		public TerminalNode DEC() { return getToken(SquirrelParser.DEC, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode INC() { return getToken(SquirrelParser.INC, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode DECVAL() { return getToken(SquirrelParser.DECVAL, 0); }
		public TerminalNode INCVAL() { return getToken(SquirrelParser.INCVAL, 0); }
		public IncexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterIncexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitIncexp(this);
		}
	}

	public final IncexpContext incexp() throws RecognitionException {
		IncexpContext _localctx = new IncexpContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_incexp);
		int _la;
		try {
			setState(497);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(484);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(485); var();
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(486); var();
				setState(487);
				_la = _input.LA(1);
				if ( !(_la==INC || _la==DEC) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(489); var();
				setState(490); match(INCVAL);
				setState(491); exp(0);
				}
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(493); var();
				setState(494); match(DECVAL);
				setState(495); exp(0);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(SquirrelParser.NULL, 0); }
		public TerminalNode FALSE() { return getToken(SquirrelParser.FALSE, 0); }
		public TerminalNode TRUE() { return getToken(SquirrelParser.TRUE, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public LogContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_log; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterLog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitLog(this);
		}
	}

	public final LogContext log() throws RecognitionException {
		LogContext _localctx = new LogContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_log);
		try {
			setState(503);
			switch (_input.LA(1)) {
			case TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(499); match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(500); match(FALSE);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(501); match(NULL);
				}
				break;
			case T__49:
			case T__41:
			case T__1:
			case ROOT:
			case NAME:
				enterOuterAlt(_localctx, 4);
				{
				setState(502); var();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public VargvContext vargv() {
			return getRuleContext(VargvContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode NAME() { return getToken(SquirrelParser.NAME, 0); }
		public VargcContext vargc() {
			return getRuleContext(VargcContext.class,0);
		}
		public TerminalNode ROOT() { return getToken(SquirrelParser.ROOT, 0); }
		public List<VarSuffixContext> varSuffix() {
			return getRuleContexts(VarSuffixContext.class);
		}
		public VarSuffixContext varSuffix(int i) {
			return getRuleContext(VarSuffixContext.class,i);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_var);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			_la = _input.LA(1);
			if (_la==ROOT) {
				{
				setState(505); match(ROOT);
				}
			}

			setState(516);
			switch (_input.LA(1)) {
			case T__41:
				{
				setState(508); vargc();
				}
				break;
			case T__1:
				{
				setState(509); vargv();
				}
				break;
			case NAME:
				{
				setState(510); match(NAME);
				}
				break;
			case T__49:
				{
				setState(511); match(T__49);
				setState(512); exp(0);
				setState(513); match(T__3);
				setState(514); varSuffix();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(521);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(518); varSuffix();
					}
					} 
				}
				setState(523);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctioncallContext extends ParserRuleContext {
		public VarOrExpContext varOrExp() {
			return getRuleContext(VarOrExpContext.class,0);
		}
		public NameAndArgsContext nameAndArgs() {
			return getRuleContext(NameAndArgsContext.class,0);
		}
		public FunctioncallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functioncall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterFunctioncall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitFunctioncall(this);
		}
	}

	public final FunctioncallContext functioncall() throws RecognitionException {
		FunctioncallContext _localctx = new FunctioncallContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_functioncall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524); varOrExp();
			setState(525); nameAndArgs();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarOrExpContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VarOrExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varOrExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterVarOrExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitVarOrExp(this);
		}
	}

	public final VarOrExpContext varOrExp() throws RecognitionException {
		VarOrExpContext _localctx = new VarOrExpContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_varOrExp);
		try {
			setState(532);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(527); var();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(528); match(T__49);
				setState(529); exp(0);
				setState(530); match(T__3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameAndArgsContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(SquirrelParser.NAME, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public NameAndArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameAndArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterNameAndArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitNameAndArgs(this);
		}
	}

	public final NameAndArgsContext nameAndArgs() throws RecognitionException {
		NameAndArgsContext _localctx = new NameAndArgsContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_nameAndArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(534); match(T__16);
				setState(535); match(NAME);
				}
			}

			setState(538); args();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarSuffixContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode NAME() { return getToken(SquirrelParser.NAME, 0); }
		public NameAndArgsContext nameAndArgs(int i) {
			return getRuleContext(NameAndArgsContext.class,i);
		}
		public List<NameAndArgsContext> nameAndArgs() {
			return getRuleContexts(NameAndArgsContext.class);
		}
		public VarSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varSuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterVarSuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitVarSuffix(this);
		}
	}

	public final VarSuffixContext varSuffix() throws RecognitionException {
		VarSuffixContext _localctx = new VarSuffixContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_varSuffix);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(540); nameAndArgs();
					}
					} 
				}
				setState(545);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			setState(552);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(546); match(T__11);
				setState(547); exp(0);
				setState(548); match(T__43);
				}
				break;
			case T__16:
				{
				setState(550); match(T__16);
				setState(551); match(NAME);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SquirrelParser.COMMA); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SquirrelParser.COMMA, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554); match(T__49);
			setState(563);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__62) | (1L << T__58) | (1L << T__53) | (1L << T__52) | (1L << T__49) | (1L << T__48) | (1L << T__42) | (1L << T__41) | (1L << T__39) | (1L << T__23) | (1L << T__20) | (1L << T__11) | (1L << T__7) | (1L << T__1))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__0 - 64)) | (1L << (TRUE - 64)) | (1L << (FALSE - 64)) | (1L << (NULL - 64)) | (1L << (ROOT - 64)) | (1L << (NAME - 64)) | (1L << (NORMALSTRING - 64)) | (1L << (VERBATIMSTRING - 64)) | (1L << (OCTAL - 64)) | (1L << (INT - 64)) | (1L << (HEX - 64)) | (1L << (FLOAT - 64)) | (1L << (CHAR - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)))) != 0)) {
				{
				setState(555); exp(0);
				setState(560);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(556); match(COMMA);
					setState(557); exp(0);
					}
					}
					setState(562);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(565); match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamedfunctionContext extends ParserRuleContext {
		public FuncnameContext funcname() {
			return getRuleContext(FuncnameContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public FuncargsContext funcargs() {
			return getRuleContext(FuncargsContext.class,0);
		}
		public NamedfunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedfunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterNamedfunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitNamedfunction(this);
		}
	}

	public final NamedfunctionContext namedfunction() throws RecognitionException {
		NamedfunctionContext _localctx = new NamedfunctionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_namedfunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567); match(T__39);
			setState(568); funcname();
			setState(569); funcargs();
			setState(570); stat();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassfunctionContext extends ParserRuleContext {
		public AttributesconstructorContext attributesconstructor() {
			return getRuleContext(AttributesconstructorContext.class,0);
		}
		public TerminalNode NAME() { return getToken(SquirrelParser.NAME, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public FuncargsContext funcargs() {
			return getRuleContext(FuncargsContext.class,0);
		}
		public ClassfunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classfunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterClassfunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitClassfunction(this);
		}
	}

	public final ClassfunctionContext classfunction() throws RecognitionException {
		ClassfunctionContext _localctx = new ClassfunctionContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_classfunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(573);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(572); attributesconstructor();
				}
			}

			setState(575); match(T__39);
			setState(576); match(NAME);
			setState(577); funcargs();
			setState(578); stat();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctiondefContext extends ParserRuleContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public FuncargsContext funcargs() {
			return getRuleContext(FuncargsContext.class,0);
		}
		public FunctiondefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functiondef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterFunctiondef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitFunctiondef(this);
		}
	}

	public final FunctiondefContext functiondef() throws RecognitionException {
		FunctiondefContext _localctx = new FunctiondefContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_functiondef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(580); match(T__39);
			setState(581); funcargs();
			setState(582); stat();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameonlylistContext extends ParserRuleContext {
		public TerminalNode NAME(int i) {
			return getToken(SquirrelParser.NAME, i);
		}
		public List<TerminalNode> NAME() { return getTokens(SquirrelParser.NAME); }
		public List<TerminalNode> COMMA() { return getTokens(SquirrelParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SquirrelParser.COMMA, i);
		}
		public NameonlylistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameonlylist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterNameonlylist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitNameonlylist(this);
		}
	}

	public final NameonlylistContext nameonlylist() throws RecognitionException {
		NameonlylistContext _localctx = new NameonlylistContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_nameonlylist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584); match(NAME);
			setState(589);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(585); match(COMMA);
				setState(586); match(NAME);
				}
				}
				setState(591);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SquirrelParser.ASSIGN, 0); }
		public TerminalNode NAME() { return getToken(SquirrelParser.NAME, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(592); match(NAME);
			setState(595);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(593); match(ASSIGN);
				setState(594); exp(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamelistContext extends ParserRuleContext {
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SquirrelParser.COMMA); }
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SquirrelParser.COMMA, i);
		}
		public NamelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namelist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterNamelist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitNamelist(this);
		}
	}

	public final NamelistContext namelist() throws RecognitionException {
		NamelistContext _localctx = new NamelistContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_namelist);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(597); name();
			setState(602);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(598); match(COMMA);
					setState(599); name();
					}
					} 
				}
				setState(604);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArglistContext extends ParserRuleContext {
		public TerminalNode VARARGS() { return getToken(SquirrelParser.VARARGS, 0); }
		public TerminalNode COMMA() { return getToken(SquirrelParser.COMMA, 0); }
		public NamelistContext namelist() {
			return getRuleContext(NamelistContext.class,0);
		}
		public ArglistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arglist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterArglist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitArglist(this);
		}
	}

	public final ArglistContext arglist() throws RecognitionException {
		ArglistContext _localctx = new ArglistContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_arglist);
		int _la;
		try {
			setState(611);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(605); namelist();
				setState(608);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(606); match(COMMA);
					setState(607); match(VARARGS);
					}
				}

				}
				break;
			case VARARGS:
				enterOuterAlt(_localctx, 2);
				{
				setState(610); match(VARARGS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncargsContext extends ParserRuleContext {
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public NameonlylistContext nameonlylist() {
			return getRuleContext(NameonlylistContext.class,0);
		}
		public FuncargsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcargs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterFuncargs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitFuncargs(this);
		}
	}

	public final FuncargsContext funcargs() throws RecognitionException {
		FuncargsContext _localctx = new FuncargsContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_funcargs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(613); match(T__49);
			setState(615);
			_la = _input.LA(1);
			if (_la==NAME || _la==VARARGS) {
				{
				setState(614); arglist();
				}
			}

			setState(617); match(T__3);
			setState(622);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(618); match(T__17);
				setState(619); nameonlylist();
				setState(620); match(T__3);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassdefContext extends ParserRuleContext {
		public AttributesconstructorContext attributesconstructor() {
			return getRuleContext(AttributesconstructorContext.class,0);
		}
		public List<ClassstatContext> classstat() {
			return getRuleContexts(ClassstatContext.class);
		}
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public ClassstatContext classstat(int i) {
			return getRuleContext(ClassstatContext.class,i);
		}
		public ClassdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterClassdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitClassdef(this);
		}
	}

	public final ClassdefContext classdef() throws RecognitionException {
		ClassdefContext _localctx = new ClassdefContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_classdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624); match(T__34);
			setState(625); var();
			setState(627);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(626); attributesconstructor();
				}
			}

			setState(631);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(629); match(T__30);
				setState(630); var();
				}
			}

			setState(633); match(T__58);
			setState(637);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__51) | (1L << T__49) | (1L << T__41) | (1L << T__40) | (1L << T__39) | (1L << T__15) | (1L << T__1))) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (ROOT - 68)) | (1L << (NAME - 68)) | (1L << (STATSEP - 68)))) != 0)) {
				{
				{
				setState(634); classstat();
				}
				}
				setState(639);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(640); match(T__29);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassconstructorContext extends ParserRuleContext {
		public AttributesconstructorContext attributesconstructor() {
			return getRuleContext(AttributesconstructorContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public FuncargsContext funcargs() {
			return getRuleContext(FuncargsContext.class,0);
		}
		public ClassconstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classconstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterClassconstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitClassconstructor(this);
		}
	}

	public final ClassconstructorContext classconstructor() throws RecognitionException {
		ClassconstructorContext _localctx = new ClassconstructorContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_classconstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(643);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(642); attributesconstructor();
				}
			}

			setState(645); match(T__51);
			setState(646); funcargs();
			setState(647); stat();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayconstructorContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(SquirrelParser.COMMA); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SquirrelParser.COMMA, i);
		}
		public ArrayconstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayconstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterArrayconstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitArrayconstructor(this);
		}
	}

	public final ArrayconstructorContext arrayconstructor() throws RecognitionException {
		ArrayconstructorContext _localctx = new ArrayconstructorContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_arrayconstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649); match(T__11);
			setState(658);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__62) | (1L << T__58) | (1L << T__53) | (1L << T__52) | (1L << T__49) | (1L << T__48) | (1L << T__42) | (1L << T__41) | (1L << T__39) | (1L << T__23) | (1L << T__20) | (1L << T__11) | (1L << T__7) | (1L << T__1))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__0 - 64)) | (1L << (TRUE - 64)) | (1L << (FALSE - 64)) | (1L << (NULL - 64)) | (1L << (ROOT - 64)) | (1L << (NAME - 64)) | (1L << (NORMALSTRING - 64)) | (1L << (VERBATIMSTRING - 64)) | (1L << (OCTAL - 64)) | (1L << (INT - 64)) | (1L << (HEX - 64)) | (1L << (FLOAT - 64)) | (1L << (CHAR - 64)) | (1L << (INC - 64)) | (1L << (DEC - 64)))) != 0)) {
				{
				setState(650); exp(0);
				setState(655);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(651); match(COMMA);
					setState(652); exp(0);
					}
					}
					setState(657);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(660); match(T__43);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributesconstructorContext extends ParserRuleContext {
		public TablerowsContext tablerows() {
			return getRuleContext(TablerowsContext.class,0);
		}
		public AttributesconstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributesconstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterAttributesconstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitAttributesconstructor(this);
		}
	}

	public final AttributesconstructorContext attributesconstructor() throws RecognitionException {
		AttributesconstructorContext _localctx = new AttributesconstructorContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_attributesconstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(662); match(T__15);
			setState(664);
			_la = _input.LA(1);
			if (((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & ((1L << (T__39 - 25)) | (1L << (T__11 - 25)) | (1L << (NAME - 25)))) != 0)) {
				{
				setState(663); tablerows();
				}
			}

			setState(666); match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableconstructorContext extends ParserRuleContext {
		public TablerowsContext tablerows() {
			return getRuleContext(TablerowsContext.class,0);
		}
		public TableconstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableconstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterTableconstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitTableconstructor(this);
		}
	}

	public final TableconstructorContext tableconstructor() throws RecognitionException {
		TableconstructorContext _localctx = new TableconstructorContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_tableconstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(668); match(T__58);
			setState(670);
			_la = _input.LA(1);
			if (((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & ((1L << (T__39 - 25)) | (1L << (T__11 - 25)) | (1L << (NAME - 25)))) != 0)) {
				{
				setState(669); tablerows();
				}
			}

			setState(672); match(T__29);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumconstructorContext extends ParserRuleContext {
		public EnumlistContext enumlist() {
			return getRuleContext(EnumlistContext.class,0);
		}
		public EnumconstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumconstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterEnumconstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitEnumconstructor(this);
		}
	}

	public final EnumconstructorContext enumconstructor() throws RecognitionException {
		EnumconstructorContext _localctx = new EnumconstructorContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_enumconstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(674); match(T__58);
			setState(676);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(675); enumlist();
				}
			}

			setState(678); match(T__29);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumlistContext extends ParserRuleContext {
		public PrimitiveitemContext primitiveitem(int i) {
			return getRuleContext(PrimitiveitemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SquirrelParser.COMMA); }
		public List<PrimitiveitemContext> primitiveitem() {
			return getRuleContexts(PrimitiveitemContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SquirrelParser.COMMA, i);
		}
		public EnumlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterEnumlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitEnumlist(this);
		}
	}

	public final EnumlistContext enumlist() throws RecognitionException {
		EnumlistContext _localctx = new EnumlistContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_enumlist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(680); primitiveitem();
			setState(687);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(682);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(681); match(COMMA);
						}
					}

					setState(684); primitiveitem();
					}
					} 
				}
				setState(689);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			}
			setState(691);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(690); match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveitemContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(SquirrelParser.ASSIGN, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode NAME() { return getToken(SquirrelParser.NAME, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public PrimitiveitemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveitem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterPrimitiveitem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitPrimitiveitem(this);
		}
	}

	public final PrimitiveitemContext primitiveitem() throws RecognitionException {
		PrimitiveitemContext _localctx = new PrimitiveitemContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_primitiveitem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(693); match(NAME);
			setState(694); match(ASSIGN);
			setState(697);
			switch (_input.LA(1)) {
			case NORMALSTRING:
			case VERBATIMSTRING:
				{
				setState(695); string();
				}
				break;
			case OCTAL:
			case INT:
			case HEX:
			case FLOAT:
			case CHAR:
				{
				setState(696); number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablerowsContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(SquirrelParser.COMMA); }
		public TablerowContext tablerow(int i) {
			return getRuleContext(TablerowContext.class,i);
		}
		public List<TablerowContext> tablerow() {
			return getRuleContexts(TablerowContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(SquirrelParser.COMMA, i);
		}
		public TablerowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablerows; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterTablerows(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitTablerows(this);
		}
	}

	public final TablerowsContext tablerows() throws RecognitionException {
		TablerowsContext _localctx = new TablerowsContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_tablerows);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(699); tablerow();
			setState(706);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(701);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(700); match(COMMA);
						}
					}

					setState(703); tablerow();
					}
					} 
				}
				setState(708);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			}
			setState(710);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(709); match(COMMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablerowContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode ASSIGN() { return getToken(SquirrelParser.ASSIGN, 0); }
		public NamedfunctionContext namedfunction() {
			return getRuleContext(NamedfunctionContext.class,0);
		}
		public TerminalNode NAME() { return getToken(SquirrelParser.NAME, 0); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TablerowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablerow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterTablerow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitTablerow(this);
		}
	}

	public final TablerowContext tablerow() throws RecognitionException {
		TablerowContext _localctx = new TablerowContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_tablerow);
		try {
			setState(722);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(712); match(T__11);
				setState(713); exp(0);
				setState(714); match(T__43);
				setState(715); match(ASSIGN);
				setState(716); exp(0);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(718); match(NAME);
				setState(719); match(ASSIGN);
				setState(720); exp(0);
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 3);
				{
				setState(721); namedfunction();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorOrContext extends ParserRuleContext {
		public OperatorOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorOr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterOperatorOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitOperatorOr(this);
		}
	}

	public final OperatorOrContext operatorOr() throws RecognitionException {
		OperatorOrContext _localctx = new OperatorOrContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_operatorOr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(724); match(T__33);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorAndContext extends ParserRuleContext {
		public OperatorAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorAnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterOperatorAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitOperatorAnd(this);
		}
	}

	public final OperatorAndContext operatorAnd() throws RecognitionException {
		OperatorAndContext _localctx = new OperatorAndContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_operatorAnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(726); match(T__56);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorBinXorContext extends ParserRuleContext {
		public OperatorBinXorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorBinXor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterOperatorBinXor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitOperatorBinXor(this);
		}
	}

	public final OperatorBinXorContext operatorBinXor() throws RecognitionException {
		OperatorBinXorContext _localctx = new OperatorBinXorContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_operatorBinXor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(728); match(T__55);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorBinAndContext extends ParserRuleContext {
		public OperatorBinAndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorBinAnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterOperatorBinAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitOperatorBinAnd(this);
		}
	}

	public final OperatorBinAndContext operatorBinAnd() throws RecognitionException {
		OperatorBinAndContext _localctx = new OperatorBinAndContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_operatorBinAnd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730); match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorBinOrContext extends ParserRuleContext {
		public OperatorBinOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorBinOr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterOperatorBinOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitOperatorBinOr(this);
		}
	}

	public final OperatorBinOrContext operatorBinOr() throws RecognitionException {
		OperatorBinOrContext _localctx = new OperatorBinOrContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_operatorBinOr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(732); match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorShiftLeftContext extends ParserRuleContext {
		public OperatorShiftLeftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorShiftLeft; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterOperatorShiftLeft(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitOperatorShiftLeft(this);
		}
	}

	public final OperatorShiftLeftContext operatorShiftLeft() throws RecognitionException {
		OperatorShiftLeftContext _localctx = new OperatorShiftLeftContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_operatorShiftLeft);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(734); match(T__31);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorShiftRightContext extends ParserRuleContext {
		public OperatorShiftRightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorShiftRight; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterOperatorShiftRight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitOperatorShiftRight(this);
		}
	}

	public final OperatorShiftRightContext operatorShiftRight() throws RecognitionException {
		OperatorShiftRightContext _localctx = new OperatorShiftRightContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_operatorShiftRight);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(736); match(T__57);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorShiftRightUnsignedContext extends ParserRuleContext {
		public OperatorShiftRightUnsignedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorShiftRightUnsigned; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterOperatorShiftRightUnsigned(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitOperatorShiftRightUnsigned(this);
		}
	}

	public final OperatorShiftRightUnsignedContext operatorShiftRightUnsigned() throws RecognitionException {
		OperatorShiftRightUnsignedContext _localctx = new OperatorShiftRightUnsignedContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_operatorShiftRightUnsigned);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(738); match(T__44);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorComparisonContext extends ParserRuleContext {
		public OperatorComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorComparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterOperatorComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitOperatorComparison(this);
		}
	}

	public final OperatorComparisonContext operatorComparison() throws RecognitionException {
		OperatorComparisonContext _localctx = new OperatorComparisonContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_operatorComparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(740);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__60) | (1L << T__46) | (1L << T__45) | (1L << T__32) | (1L << T__25) | (1L << T__10) | (1L << T__8))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorAddSubContext extends ParserRuleContext {
		public OperatorAddSubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorAddSub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterOperatorAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitOperatorAddSub(this);
		}
	}

	public final OperatorAddSubContext operatorAddSub() throws RecognitionException {
		OperatorAddSubContext _localctx = new OperatorAddSubContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_operatorAddSub);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(742);
			_la = _input.LA(1);
			if ( !(_la==T__38 || _la==T__0) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorMulDivModContext extends ParserRuleContext {
		public OperatorMulDivModContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorMulDivMod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterOperatorMulDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitOperatorMulDivMod(this);
		}
	}

	public final OperatorMulDivModContext operatorMulDivMod() throws RecognitionException {
		OperatorMulDivModContext _localctx = new OperatorMulDivModContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_operatorMulDivMod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(744);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__18) | (1L << T__6))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorUnaryContext extends ParserRuleContext {
		public OperatorUnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorUnary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterOperatorUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitOperatorUnary(this);
		}
	}

	public final OperatorUnaryContext operatorUnary() throws RecognitionException {
		OperatorUnaryContext _localctx = new OperatorUnaryContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_operatorUnary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(746);
			_la = _input.LA(1);
			if ( !(((((_la - 22)) & ~0x3f) == 0 && ((1L << (_la - 22)) & ((1L << (T__42 - 22)) | (1L << (T__7 - 22)) | (1L << (T__0 - 22)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode HEX() { return getToken(SquirrelParser.HEX, 0); }
		public TerminalNode CHAR() { return getToken(SquirrelParser.CHAR, 0); }
		public TerminalNode INT() { return getToken(SquirrelParser.INT, 0); }
		public TerminalNode OCTAL() { return getToken(SquirrelParser.OCTAL, 0); }
		public TerminalNode FLOAT() { return getToken(SquirrelParser.FLOAT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(748);
			_la = _input.LA(1);
			if ( !(((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (OCTAL - 72)) | (1L << (INT - 72)) | (1L << (HEX - 72)) | (1L << (FLOAT - 72)) | (1L << (CHAR - 72)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public TerminalNode NORMALSTRING() { return getToken(SquirrelParser.NORMALSTRING, 0); }
		public TerminalNode VERBATIMSTRING() { return getToken(SquirrelParser.VERBATIMSTRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SquirrelListener ) ((SquirrelListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(750);
			_la = _input.LA(1);
			if ( !(_la==NORMALSTRING || _la==VERBATIMSTRING) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 22: return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 19);

		case 1: return precpred(_ctx, 13);

		case 2: return precpred(_ctx, 12);

		case 3: return precpred(_ctx, 11);

		case 4: return precpred(_ctx, 10);

		case 5: return precpred(_ctx, 9);

		case 6: return precpred(_ctx, 8);

		case 7: return precpred(_ctx, 7);

		case 8: return precpred(_ctx, 6);

		case 9: return precpred(_ctx, 5);

		case 10: return precpred(_ctx, 4);

		case 11: return precpred(_ctx, 3);

		case 12: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3[\u02f3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\7\2\u009e\n\2\f\2\16\2\u00a1\13"+
		"\2\3\2\3\2\3\3\3\3\7\3\u00a7\n\3\f\3\16\3\u00aa\13\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\7\4\u00c3\n\4\f\4\16\4\u00c6\13\4\5\4\u00c8\n\4\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\6\7\u00d4\n\7\r\7\16\7\u00d5\3\7\5\7\u00d9\n\7"+
		"\3\7\5\7\u00dc\n\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\5\t\u00e7\n\t\3"+
		"\t\3\t\5\t\u00eb\n\t\3\t\3\t\5\t\u00ef\n\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\5\n\u00f8\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u010f\n\r\3\r\3\r\5\r\u0113\n\r"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u0121"+
		"\n\20\f\20\16\20\u0124\13\20\3\21\3\21\3\21\6\21\u0129\n\21\r\21\16\21"+
		"\u012a\3\22\3\22\3\22\7\22\u0130\n\22\f\22\16\22\u0133\13\22\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u013a\n\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26"+
		"\5\26\u0144\n\26\3\26\5\26\u0147\n\26\3\27\3\27\3\27\6\27\u014c\n\27\r"+
		"\27\16\27\u014d\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\5\30\u016b\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\7\30\u01a2\n\30\f\30\16\30\u01a5\13\30\3\31\3\31\3\31\5\31"+
		"\u01aa\n\31\3\32\3\32\3\32\6\32\u01af\n\32\r\32\16\32\u01b0\3\32\5\32"+
		"\u01b4\n\32\3\33\5\33\u01b7\n\33\3\33\3\33\3\34\3\34\3\34\7\34\u01be\n"+
		"\34\f\34\16\34\u01c1\13\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\7\36\u01ca"+
		"\n\36\f\36\16\36\u01cd\13\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\""+
		"\3\"\3#\3#\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\5\'\u01f4\n\'\3(\3(\3(\3(\5(\u01fa\n(\3)\5)\u01fd"+
		"\n)\3)\3)\3)\3)\3)\3)\3)\3)\5)\u0207\n)\3)\7)\u020a\n)\f)\16)\u020d\13"+
		")\3*\3*\3*\3+\3+\3+\3+\3+\5+\u0217\n+\3,\3,\5,\u021b\n,\3,\3,\3-\7-\u0220"+
		"\n-\f-\16-\u0223\13-\3-\3-\3-\3-\3-\3-\5-\u022b\n-\3.\3.\3.\3.\7.\u0231"+
		"\n.\f.\16.\u0234\13.\5.\u0236\n.\3.\3.\3/\3/\3/\3/\3/\3\60\5\60\u0240"+
		"\n\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\7\62"+
		"\u024e\n\62\f\62\16\62\u0251\13\62\3\63\3\63\3\63\5\63\u0256\n\63\3\64"+
		"\3\64\3\64\7\64\u025b\n\64\f\64\16\64\u025e\13\64\3\65\3\65\3\65\5\65"+
		"\u0263\n\65\3\65\5\65\u0266\n\65\3\66\3\66\5\66\u026a\n\66\3\66\3\66\3"+
		"\66\3\66\3\66\5\66\u0271\n\66\3\67\3\67\3\67\5\67\u0276\n\67\3\67\3\67"+
		"\5\67\u027a\n\67\3\67\3\67\7\67\u027e\n\67\f\67\16\67\u0281\13\67\3\67"+
		"\3\67\38\58\u0286\n8\38\38\38\38\39\39\39\39\79\u0290\n9\f9\169\u0293"+
		"\139\59\u0295\n9\39\39\3:\3:\5:\u029b\n:\3:\3:\3;\3;\5;\u02a1\n;\3;\3"+
		";\3<\3<\5<\u02a7\n<\3<\3<\3=\3=\5=\u02ad\n=\3=\7=\u02b0\n=\f=\16=\u02b3"+
		"\13=\3=\5=\u02b6\n=\3>\3>\3>\3>\5>\u02bc\n>\3?\3?\5?\u02c0\n?\3?\7?\u02c3"+
		"\n?\f?\16?\u02c6\13?\3?\5?\u02c9\n?\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\5@\u02d5"+
		"\n@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K"+
		"\3L\3L\3M\3M\3N\3N\3N\4\u01b0\u01cb\3.O\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098"+
		"\u009a\2\n\3\2PQ\3\2TU\b\2\6\6\24\25\"\"))88::\4\2\34\34BB\5\2\35\35\60"+
		"\60<<\5\2\30\30;;BB\3\2JN\3\2HI\u031d\2\u009f\3\2\2\2\4\u00a4\3\2\2\2"+
		"\6\u00c7\3\2\2\2\b\u00c9\3\2\2\2\n\u00cb\3\2\2\2\f\u00cd\3\2\2\2\16\u00df"+
		"\3\2\2\2\20\u00e2\3\2\2\2\22\u00f3\3\2\2\2\24\u00ff\3\2\2\2\26\u0104\3"+
		"\2\2\2\30\u0108\3\2\2\2\32\u0114\3\2\2\2\34\u0117\3\2\2\2\36\u011c\3\2"+
		"\2\2 \u0125\3\2\2\2\"\u012c\3\2\2\2$\u0139\3\2\2\2&\u013b\3\2\2\2(\u013e"+
		"\3\2\2\2*\u0141\3\2\2\2,\u0148\3\2\2\2.\u016a\3\2\2\2\60\u01a6\3\2\2\2"+
		"\62\u01b3\3\2\2\2\64\u01b6\3\2\2\2\66\u01ba\3\2\2\28\u01c2\3\2\2\2:\u01c6"+
		"\3\2\2\2<\u01ce\3\2\2\2>\u01d1\3\2\2\2@\u01d4\3\2\2\2B\u01d7\3\2\2\2D"+
		"\u01da\3\2\2\2F\u01dc\3\2\2\2H\u01de\3\2\2\2J\u01e3\3\2\2\2L\u01f3\3\2"+
		"\2\2N\u01f9\3\2\2\2P\u01fc\3\2\2\2R\u020e\3\2\2\2T\u0216\3\2\2\2V\u021a"+
		"\3\2\2\2X\u0221\3\2\2\2Z\u022c\3\2\2\2\\\u0239\3\2\2\2^\u023f\3\2\2\2"+
		"`\u0246\3\2\2\2b\u024a\3\2\2\2d\u0252\3\2\2\2f\u0257\3\2\2\2h\u0265\3"+
		"\2\2\2j\u0267\3\2\2\2l\u0272\3\2\2\2n\u0285\3\2\2\2p\u028b\3\2\2\2r\u0298"+
		"\3\2\2\2t\u029e\3\2\2\2v\u02a4\3\2\2\2x\u02aa\3\2\2\2z\u02b7\3\2\2\2|"+
		"\u02bd\3\2\2\2~\u02d4\3\2\2\2\u0080\u02d6\3\2\2\2\u0082\u02d8\3\2\2\2"+
		"\u0084\u02da\3\2\2\2\u0086\u02dc\3\2\2\2\u0088\u02de\3\2\2\2\u008a\u02e0"+
		"\3\2\2\2\u008c\u02e2\3\2\2\2\u008e\u02e4\3\2\2\2\u0090\u02e6\3\2\2\2\u0092"+
		"\u02e8\3\2\2\2\u0094\u02ea\3\2\2\2\u0096\u02ec\3\2\2\2\u0098\u02ee\3\2"+
		"\2\2\u009a\u02f0\3\2\2\2\u009c\u009e\5\6\4\2\u009d\u009c\3\2\2\2\u009e"+
		"\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2"+
		"\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\7\2\2\3\u00a3\3\3\2\2\2\u00a4\u00a8"+
		"\7\b\2\2\u00a5\u00a7\5\6\4\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8\3\2"+
		"\2\2\u00ab\u00ac\7%\2\2\u00ac\5\3\2\2\2\u00ad\u00c8\7S\2\2\u00ae\u00c8"+
		"\5R*\2\u00af\u00c8\5\b\5\2\u00b0\u00c8\5\n\6\2\u00b1\u00c8\5\24\13\2\u00b2"+
		"\u00c8\5(\25\2\u00b3\u00c8\5\26\f\2\u00b4\u00c8\5\30\r\2\u00b5\u00c8\5"+
		"\20\t\2\u00b6\u00c8\5\22\n\2\u00b7\u00c8\5\\/\2\u00b8\u00c8\5\16\b\2\u00b9"+
		"\u00c8\5\f\7\2\u00ba\u00c8\5\32\16\2\u00bb\u00c8\5\34\17\2\u00bc\u00c8"+
		"\5l\67\2\u00bd\u00c8\5*\26\2\u00be\u00c8\5\4\3\2\u00bf\u00c4\5.\30\2\u00c0"+
		"\u00c1\7O\2\2\u00c1\u00c3\5.\30\2\u00c2\u00c0\3\2\2\2\u00c3\u00c6\3\2"+
		"\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c7\u00ad\3\2\2\2\u00c7\u00ae\3\2\2\2\u00c7\u00af\3\2"+
		"\2\2\u00c7\u00b0\3\2\2\2\u00c7\u00b1\3\2\2\2\u00c7\u00b2\3\2\2\2\u00c7"+
		"\u00b3\3\2\2\2\u00c7\u00b4\3\2\2\2\u00c7\u00b5\3\2\2\2\u00c7\u00b6\3\2"+
		"\2\2\u00c7\u00b7\3\2\2\2\u00c7\u00b8\3\2\2\2\u00c7\u00b9\3\2\2\2\u00c7"+
		"\u00ba\3\2\2\2\u00c7\u00bb\3\2\2\2\u00c7\u00bc\3\2\2\2\u00c7\u00bd\3\2"+
		"\2\2\u00c7\u00be\3\2\2\2\u00c7\u00bf\3\2\2\2\u00c8\7\3\2\2\2\u00c9\u00ca"+
		"\7*\2\2\u00ca\t\3\2\2\2\u00cb\u00cc\7\36\2\2\u00cc\13\3\2\2\2\u00cd\u00ce"+
		"\7/\2\2\u00ce\u00cf\7\21\2\2\u00cf\u00d0\5.\30\2\u00d0\u00d1\7?\2\2\u00d1"+
		"\u00db\7\b\2\2\u00d2\u00d4\5\36\20\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3"+
		"\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7"+
		"\u00d9\5 \21\2\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00dc\3\2"+
		"\2\2\u00da\u00dc\5 \21\2\u00db\u00d3\3\2\2\2\u00db\u00da\3\2\2\2\u00dc"+
		"\u00dd\3\2\2\2\u00dd\u00de\7%\2\2\u00de\r\3\2\2\2\u00df\u00e0\7\65\2\2"+
		"\u00e0\u00e1\5.\30\2\u00e1\17\3\2\2\2\u00e2\u00e3\7\f\2\2\u00e3\u00e6"+
		"\7\21\2\2\u00e4\u00e7\5(\25\2\u00e5\u00e7\5:\36\2\u00e6\u00e4\3\2\2\2"+
		"\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea"+
		"\7S\2\2\u00e9\u00eb\5.\30\2\u00ea\u00e9\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00ee\7S\2\2\u00ed\u00ef\5.\30\2\u00ee\u00ed\3\2"+
		"\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\7?\2\2\u00f1"+
		"\u00f2\5\6\4\2\u00f2\21\3\2\2\2\u00f3\u00f4\7\5\2\2\u00f4\u00f7\7\21\2"+
		"\2\u00f5\u00f6\7G\2\2\u00f6\u00f8\7O\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8"+
		"\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\7G\2\2\u00fa\u00fb\7>\2\2\u00fb"+
		"\u00fc\5.\30\2\u00fc\u00fd\7?\2\2\u00fd\u00fe\5\6\4\2\u00fe\23\3\2\2\2"+
		"\u00ff\u0100\7\20\2\2\u0100\u0101\5\6\4\2\u0101\u0102\7\7\2\2\u0102\u0103"+
		"\5.\30\2\u0103\25\3\2\2\2\u0104\u0105\7\7\2\2\u0105\u0106\5.\30\2\u0106"+
		"\u0107\5\6\4\2\u0107\27\3\2\2\2\u0108\u0109\7&\2\2\u0109\u010a\7\21\2"+
		"\2\u010a\u010b\5.\30\2\u010b\u010c\7?\2\2\u010c\u010e\5\6\4\2\u010d\u010f"+
		"\7S\2\2\u010e\u010d\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0112\3\2\2\2\u0110"+
		"\u0111\7=\2\2\u0111\u0113\5\6\4\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2"+
		"\2\2\u0113\31\3\2\2\2\u0114\u0115\7\23\2\2\u0115\u0116\5z>\2\u0116\33"+
		"\3\2\2\2\u0117\u0118\7(\2\2\u0118\u0119\7G\2\2\u0119\u011a\7P\2\2\u011a"+
		"\u011b\5v<\2\u011b\35\3\2\2\2\u011c\u011d\7\64\2\2\u011d\u011e\5.\30\2"+
		"\u011e\u0122\7\66\2\2\u011f\u0121\5\6\4\2\u0120\u011f\3\2\2\2\u0121\u0124"+
		"\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\37\3\2\2\2\u0124"+
		"\u0122\3\2\2\2\u0125\u0126\7\3\2\2\u0126\u0128\7\66\2\2\u0127\u0129\5"+
		"\6\4\2\u0128\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u0128\3\2\2\2\u012a"+
		"\u012b\3\2\2\2\u012b!\3\2\2\2\u012c\u0131\7G\2\2\u012d\u012e\7F\2\2\u012e"+
		"\u0130\7G\2\2\u012f\u012d\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2"+
		"\2\2\u0131\u0132\3\2\2\2\u0132#\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u013a"+
		"\5n8\2\u0135\u013a\5^\60\2\u0136\u013a\5\66\34\2\u0137\u013a\5&\24\2\u0138"+
		"\u013a\7S\2\2\u0139\u0134\3\2\2\2\u0139\u0135\3\2\2\2\u0139\u0136\3\2"+
		"\2\2\u0139\u0137\3\2\2\2\u0139\u0138\3\2\2\2\u013a%\3\2\2\2\u013b\u013c"+
		"\7\32\2\2\u013c\u013d\5\62\32\2\u013d\'\3\2\2\2\u013e\u013f\7,\2\2\u013f"+
		"\u0140\5\62\32\2\u0140)\3\2\2\2\u0141\u0143\7\37\2\2\u0142\u0144\5.\30"+
		"\2\u0143\u0142\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0146\3\2\2\2\u0145\u0147"+
		"\7S\2\2\u0146\u0145\3\2\2\2\u0146\u0147\3\2\2\2\u0147+\3\2\2\2\u0148\u014b"+
		"\5.\30\2\u0149\u014a\7O\2\2\u014a\u014c\5.\30\2\u014b\u0149\3\2\2\2\u014c"+
		"\u014d\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e-\3\2\2\2"+
		"\u014f\u0150\b\30\1\2\u0150\u0151\5\u0096L\2\u0151\u0152\5.\30\20\u0152"+
		"\u016b\3\2\2\2\u0153\u0154\7\21\2\2\u0154\u0155\5,\27\2\u0155\u0156\7"+
		"?\2\2\u0156\u016b\3\2\2\2\u0157\u0158\7\21\2\2\u0158\u0159\5.\30\2\u0159"+
		"\u015a\7?\2\2\u015a\u016b\3\2\2\2\u015b\u016b\5\u0098M\2\u015c\u016b\5"+
		"\u009aN\2\u015d\u016b\5H%\2\u015e\u016b\5B\"\2\u015f\u016b\5@!\2\u0160"+
		"\u016b\5> \2\u0161\u016b\5J&\2\u0162\u016b\5`\61\2\u0163\u016b\5R*\2\u0164"+
		"\u016b\5:\36\2\u0165\u016b\5t;\2\u0166\u016b\5p9\2\u0167\u016b\5<\37\2"+
		"\u0168\u016b\5L\'\2\u0169\u016b\5N(\2\u016a\u014f\3\2\2\2\u016a\u0153"+
		"\3\2\2\2\u016a\u0157\3\2\2\2\u016a\u015b\3\2\2\2\u016a\u015c\3\2\2\2\u016a"+
		"\u015d\3\2\2\2\u016a\u015e\3\2\2\2\u016a\u015f\3\2\2\2\u016a\u0160\3\2"+
		"\2\2\u016a\u0161\3\2\2\2\u016a\u0162\3\2\2\2\u016a\u0163\3\2\2\2\u016a"+
		"\u0164\3\2\2\2\u016a\u0165\3\2\2\2\u016a\u0166\3\2\2\2\u016a\u0167\3\2"+
		"\2\2\u016a\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016b\u01a3\3\2\2\2\u016c"+
		"\u016d\f\25\2\2\u016d\u016e\7>\2\2\u016e\u01a2\5.\30\26\u016f\u0170\f"+
		"\17\2\2\u0170\u0171\5\u0094K\2\u0171\u0172\5.\30\20\u0172\u01a2\3\2\2"+
		"\2\u0173\u0174\f\16\2\2\u0174\u0175\5\u0092J\2\u0175\u0176\5.\30\17\u0176"+
		"\u01a2\3\2\2\2\u0177\u0178\f\r\2\2\u0178\u0179\5\u008aF\2\u0179\u017a"+
		"\5.\30\16\u017a\u01a2\3\2\2\2\u017b\u017c\f\f\2\2\u017c\u017d\5\u008c"+
		"G\2\u017d\u017e\5.\30\r\u017e\u01a2\3\2\2\2\u017f\u0180\f\13\2\2\u0180"+
		"\u0181\5\u008eH\2\u0181\u0182\5.\30\f\u0182\u01a2\3\2\2\2\u0183\u0184"+
		"\f\n\2\2\u0184\u0185\5\u0090I\2\u0185\u0186\5.\30\13\u0186\u01a2\3\2\2"+
		"\2\u0187\u0188\f\t\2\2\u0188\u0189\5\u0086D\2\u0189\u018a\5.\30\t\u018a"+
		"\u01a2\3\2\2\2\u018b\u018c\f\b\2\2\u018c\u018d\5\u0084C\2\u018d\u018e"+
		"\5.\30\b\u018e\u01a2\3\2\2\2\u018f\u0190\f\7\2\2\u0190\u0191\5\u0088E"+
		"\2\u0191\u0192\5.\30\7\u0192\u01a2\3\2\2\2\u0193\u0194\f\6\2\2\u0194\u0195"+
		"\5\u0082B\2\u0195\u0196\5.\30\7\u0196\u01a2\3\2\2\2\u0197\u0198\f\5\2"+
		"\2\u0198\u0199\5\u0080A\2\u0199\u019a\5.\30\6\u019a\u01a2\3\2\2\2\u019b"+
		"\u019c\f\4\2\2\u019c\u019d\7\'\2\2\u019d\u019e\5.\30\2\u019e\u019f\7\66"+
		"\2\2\u019f\u01a0\5.\30\5\u01a0\u01a2\3\2\2\2\u01a1\u016c\3\2\2\2\u01a1"+
		"\u016f\3\2\2\2\u01a1\u0173\3\2\2\2\u01a1\u0177\3\2\2\2\u01a1\u017b\3\2"+
		"\2\2\u01a1\u017f\3\2\2\2\u01a1\u0183\3\2\2\2\u01a1\u0187\3\2\2\2\u01a1"+
		"\u018b\3\2\2\2\u01a1\u018f\3\2\2\2\u01a1\u0193\3\2\2\2\u01a1\u0197\3\2"+
		"\2\2\u01a1\u019b\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3"+
		"\u01a4\3\2\2\2\u01a4/\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u01a9\7G\2\2\u01a7"+
		"\u01a8\7P\2\2\u01a8\u01aa\5.\30\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2"+
		"\2\2\u01aa\61\3\2\2\2\u01ab\u01ae\5\60\31\2\u01ac\u01ad\7O\2\2\u01ad\u01af"+
		"\5\60\31\2\u01ae\u01ac\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\3\2\2\2"+
		"\u01b0\u01ae\3\2\2\2\u01b1\u01b4\3\2\2\2\u01b2\u01b4\5\60\31\2\u01b3\u01ab"+
		"\3\2\2\2\u01b3\u01b2\3\2\2\2\u01b4\63\3\2\2\2\u01b5\u01b7\5r:\2\u01b6"+
		"\u01b5\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\58"+
		"\35\2\u01b9\65\3\2\2\2\u01ba\u01bf\5\64\33\2\u01bb\u01bc\7O\2\2\u01bc"+
		"\u01be\5\64\33\2\u01bd\u01bb\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd\3"+
		"\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\67\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2"+
		"\u01c3\5P)\2\u01c3\u01c4\t\2\2\2\u01c4\u01c5\5.\30\2\u01c59\3\2\2\2\u01c6"+
		"\u01cb\58\35\2\u01c7\u01c8\7O\2\2\u01c8\u01ca\58\35\2\u01c9\u01c7\3\2"+
		"\2\2\u01ca\u01cd\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cc"+
		";\3\2\2\2\u01cd\u01cb\3\2\2\2\u01ce\u01cf\7+\2\2\u01cf\u01d0\5.\30\2\u01d0"+
		"=\3\2\2\2\u01d1\u01d2\7\4\2\2\u01d2\u01d3\5.\30\2\u01d3?\3\2\2\2\u01d4"+
		"\u01d5\7\16\2\2\u01d5\u01d6\5P)\2\u01d6A\3\2\2\2\u01d7\u01d8\7.\2\2\u01d8"+
		"\u01d9\5.\30\2\u01d9C\3\2\2\2\u01da\u01db\7\31\2\2\u01dbE\3\2\2\2\u01dc"+
		"\u01dd\7A\2\2\u01ddG\3\2\2\2\u01de\u01df\7\r\2\2\u01df\u01e0\5.\30\2\u01e0"+
		"\u01e1\7\66\2\2\u01e1\u01e2\5.\30\2\u01e2I\3\2\2\2\u01e3\u01e4\7\22\2"+
		"\2\u01e4\u01e5\5P)\2\u01e5K\3\2\2\2\u01e6\u01e7\t\3\2\2\u01e7\u01f4\5"+
		"P)\2\u01e8\u01e9\5P)\2\u01e9\u01ea\t\3\2\2\u01ea\u01f4\3\2\2\2\u01eb\u01ec"+
		"\5P)\2\u01ec\u01ed\7V\2\2\u01ed\u01ee\5.\30\2\u01ee\u01f4\3\2\2\2\u01ef"+
		"\u01f0\5P)\2\u01f0\u01f1\7W\2\2\u01f1\u01f2\5.\30\2\u01f2\u01f4\3\2\2"+
		"\2\u01f3\u01e6\3\2\2\2\u01f3\u01e8\3\2\2\2\u01f3\u01eb\3\2\2\2\u01f3\u01ef"+
		"\3\2\2\2\u01f4M\3\2\2\2\u01f5\u01fa\7C\2\2\u01f6\u01fa\7D\2\2\u01f7\u01fa"+
		"\7E\2\2\u01f8\u01fa\5P)\2\u01f9\u01f5\3\2\2\2\u01f9\u01f6\3\2\2\2\u01f9"+
		"\u01f7\3\2\2\2\u01f9\u01f8\3\2\2\2\u01faO\3\2\2\2\u01fb\u01fd\7F\2\2\u01fc"+
		"\u01fb\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u0206\3\2\2\2\u01fe\u0207\5D"+
		"#\2\u01ff\u0207\5F$\2\u0200\u0207\7G\2\2\u0201\u0202\7\21\2\2\u0202\u0203"+
		"\5.\30\2\u0203\u0204\7?\2\2\u0204\u0205\5X-\2\u0205\u0207\3\2\2\2\u0206"+
		"\u01fe\3\2\2\2\u0206\u01ff\3\2\2\2\u0206\u0200\3\2\2\2\u0206\u0201\3\2"+
		"\2\2\u0207\u020b\3\2\2\2\u0208\u020a\5X-\2\u0209\u0208\3\2\2\2\u020a\u020d"+
		"\3\2\2\2\u020b\u0209\3\2\2\2\u020b\u020c\3\2\2\2\u020cQ\3\2\2\2\u020d"+
		"\u020b\3\2\2\2\u020e\u020f\5T+\2\u020f\u0210\5V,\2\u0210S\3\2\2\2\u0211"+
		"\u0217\5P)\2\u0212\u0213\7\21\2\2\u0213\u0214\5.\30\2\u0214\u0215\7?\2"+
		"\2\u0215\u0217\3\2\2\2\u0216\u0211\3\2\2\2\u0216\u0212\3\2\2\2\u0217U"+
		"\3\2\2\2\u0218\u0219\7\62\2\2\u0219\u021b\7G\2\2\u021a\u0218\3\2\2\2\u021a"+
		"\u021b\3\2\2\2\u021b\u021c\3\2\2\2\u021c\u021d\5Z.\2\u021dW\3\2\2\2\u021e"+
		"\u0220\5V,\2\u021f\u021e\3\2\2\2\u0220\u0223\3\2\2\2\u0221\u021f\3\2\2"+
		"\2\u0221\u0222\3\2\2\2\u0222\u022a\3\2\2\2\u0223\u0221\3\2\2\2\u0224\u0225"+
		"\7\67\2\2\u0225\u0226\5.\30\2\u0226\u0227\7\27\2\2\u0227\u022b\3\2\2\2"+
		"\u0228\u0229\7\62\2\2\u0229\u022b\7G\2\2\u022a\u0224\3\2\2\2\u022a\u0228"+
		"\3\2\2\2\u022bY\3\2\2\2\u022c\u0235\7\21\2\2\u022d\u0232\5.\30\2\u022e"+
		"\u022f\7O\2\2\u022f\u0231\5.\30\2\u0230\u022e\3\2\2\2\u0231\u0234\3\2"+
		"\2\2\u0232\u0230\3\2\2\2\u0232\u0233\3\2\2\2\u0233\u0236\3\2\2\2\u0234"+
		"\u0232\3\2\2\2\u0235\u022d\3\2\2\2\u0235\u0236\3\2\2\2\u0236\u0237\3\2"+
		"\2\2\u0237\u0238\7?\2\2\u0238[\3\2\2\2\u0239\u023a\7\33\2\2\u023a\u023b"+
		"\5\"\22\2\u023b\u023c\5j\66\2\u023c\u023d\5\6\4\2\u023d]\3\2\2\2\u023e"+
		"\u0240\5r:\2\u023f\u023e\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0241\3\2\2"+
		"\2\u0241\u0242\7\33\2\2\u0242\u0243\7G\2\2\u0243\u0244\5j\66\2\u0244\u0245"+
		"\5\6\4\2\u0245_\3\2\2\2\u0246\u0247\7\33\2\2\u0247\u0248\5j\66\2\u0248"+
		"\u0249\5\6\4\2\u0249a\3\2\2\2\u024a\u024f\7G\2\2\u024b\u024c\7O\2\2\u024c"+
		"\u024e\7G\2\2\u024d\u024b\3\2\2\2\u024e\u0251\3\2\2\2\u024f\u024d\3\2"+
		"\2\2\u024f\u0250\3\2\2\2\u0250c\3\2\2\2\u0251\u024f\3\2\2\2\u0252\u0255"+
		"\7G\2\2\u0253\u0254\7P\2\2\u0254\u0256\5.\30\2\u0255\u0253\3\2\2\2\u0255"+
		"\u0256\3\2\2\2\u0256e\3\2\2\2\u0257\u025c\5d\63\2\u0258\u0259\7O\2\2\u0259"+
		"\u025b\5d\63\2\u025a\u0258\3\2\2\2\u025b\u025e\3\2\2\2\u025c\u025a\3\2"+
		"\2\2\u025c\u025d\3\2\2\2\u025dg\3\2\2\2\u025e\u025c\3\2\2\2\u025f\u0262"+
		"\5f\64\2\u0260\u0261\7O\2\2\u0261\u0263\7R\2\2\u0262\u0260\3\2\2\2\u0262"+
		"\u0263\3\2\2\2\u0263\u0266\3\2\2\2\u0264\u0266\7R\2\2\u0265\u025f\3\2"+
		"\2\2\u0265\u0264\3\2\2\2\u0266i\3\2\2\2\u0267\u0269\7\21\2\2\u0268\u026a"+
		"\5h\65\2\u0269\u0268\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u026b\3\2\2\2\u026b"+
		"\u0270\7?\2\2\u026c\u026d\7\61\2\2\u026d\u026e\5b\62\2\u026e\u026f\7?"+
		"\2\2\u026f\u0271\3\2\2\2\u0270\u026c\3\2\2\2\u0270\u0271\3\2\2\2\u0271"+
		"k\3\2\2\2\u0272\u0273\7 \2\2\u0273\u0275\5P)\2\u0274\u0276\5r:\2\u0275"+
		"\u0274\3\2\2\2\u0275\u0276\3\2\2\2\u0276\u0279\3\2\2\2\u0277\u0278\7$"+
		"\2\2\u0278\u027a\5P)\2\u0279\u0277\3\2\2\2\u0279\u027a\3\2\2\2\u027a\u027b"+
		"\3\2\2\2\u027b\u027f\7\b\2\2\u027c\u027e\5$\23\2\u027d\u027c\3\2\2\2\u027e"+
		"\u0281\3\2\2\2\u027f\u027d\3\2\2\2\u027f\u0280\3\2\2\2\u0280\u0282\3\2"+
		"\2\2\u0281\u027f\3\2\2\2\u0282\u0283\7%\2\2\u0283m\3\2\2\2\u0284\u0286"+
		"\5r:\2\u0285\u0284\3\2\2\2\u0285\u0286\3\2\2\2\u0286\u0287\3\2\2\2\u0287"+
		"\u0288\7\17\2\2\u0288\u0289\5j\66\2\u0289\u028a\5\6\4\2\u028ao\3\2\2\2"+
		"\u028b\u0294\7\67\2\2\u028c\u0291\5.\30\2\u028d\u028e\7O\2\2\u028e\u0290"+
		"\5.\30\2\u028f\u028d\3\2\2\2\u0290\u0293\3\2\2\2\u0291\u028f\3\2\2\2\u0291"+
		"\u0292\3\2\2\2\u0292\u0295\3\2\2\2\u0293\u0291\3\2\2\2\u0294\u028c\3\2"+
		"\2\2\u0294\u0295\3\2\2\2\u0295\u0296\3\2\2\2\u0296\u0297\7\27\2\2\u0297"+
		"q\3\2\2\2\u0298\u029a\7\63\2\2\u0299\u029b\5|?\2\u029a\u0299\3\2\2\2\u029a"+
		"\u029b\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u029d\7@\2\2\u029ds\3\2\2\2\u029e"+
		"\u02a0\7\b\2\2\u029f\u02a1\5|?\2\u02a0\u029f\3\2\2\2\u02a0\u02a1\3\2\2"+
		"\2\u02a1\u02a2\3\2\2\2\u02a2\u02a3\7%\2\2\u02a3u\3\2\2\2\u02a4\u02a6\7"+
		"\b\2\2\u02a5\u02a7\5x=\2\u02a6\u02a5\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7"+
		"\u02a8\3\2\2\2\u02a8\u02a9\7%\2\2\u02a9w\3\2\2\2\u02aa\u02b1\5z>\2\u02ab"+
		"\u02ad\7O\2\2\u02ac\u02ab\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad\u02ae\3\2"+
		"\2\2\u02ae\u02b0\5z>\2\u02af\u02ac\3\2\2\2\u02b0\u02b3\3\2\2\2\u02b1\u02af"+
		"\3\2\2\2\u02b1\u02b2\3\2\2\2\u02b2\u02b5\3\2\2\2\u02b3\u02b1\3\2\2\2\u02b4"+
		"\u02b6\7O\2\2\u02b5\u02b4\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6y\3\2\2\2\u02b7"+
		"\u02b8\7G\2\2\u02b8\u02bb\7P\2\2\u02b9\u02bc\5\u009aN\2\u02ba\u02bc\5"+
		"\u0098M\2\u02bb\u02b9\3\2\2\2\u02bb\u02ba\3\2\2\2\u02bc{\3\2\2\2\u02bd"+
		"\u02c4\5~@\2\u02be\u02c0\7O\2\2\u02bf\u02be\3\2\2\2\u02bf\u02c0\3\2\2"+
		"\2\u02c0\u02c1\3\2\2\2\u02c1\u02c3\5~@\2\u02c2\u02bf\3\2\2\2\u02c3\u02c6"+
		"\3\2\2\2\u02c4\u02c2\3\2\2\2\u02c4\u02c5\3\2\2\2\u02c5\u02c8\3\2\2\2\u02c6"+
		"\u02c4\3\2\2\2\u02c7\u02c9\7O\2\2\u02c8\u02c7\3\2\2\2\u02c8\u02c9\3\2"+
		"\2\2\u02c9}\3\2\2\2\u02ca\u02cb\7\67\2\2\u02cb\u02cc\5.\30\2\u02cc\u02cd"+
		"\7\27\2\2\u02cd\u02ce\7P\2\2\u02ce\u02cf\5.\30\2\u02cf\u02d5\3\2\2\2\u02d0"+
		"\u02d1\7G\2\2\u02d1\u02d2\7P\2\2\u02d2\u02d5\5.\30\2\u02d3\u02d5\5\\/"+
		"\2\u02d4\u02ca\3\2\2\2\u02d4\u02d0\3\2\2\2\u02d4\u02d3\3\2\2\2\u02d5\177"+
		"\3\2\2\2\u02d6\u02d7\7!\2\2\u02d7\u0081\3\2\2\2\u02d8\u02d9\7\n\2\2\u02d9"+
		"\u0083\3\2\2\2\u02da\u02db\7\13\2\2\u02db\u0085\3\2\2\2\u02dc\u02dd\7"+
		"-\2\2\u02dd\u0087\3\2\2\2\u02de\u02df\79\2\2\u02df\u0089\3\2\2\2\u02e0"+
		"\u02e1\7#\2\2\u02e1\u008b\3\2\2\2\u02e2\u02e3\7\t\2\2\u02e3\u008d\3\2"+
		"\2\2\u02e4\u02e5\7\26\2\2\u02e5\u008f\3\2\2\2\u02e6\u02e7\t\4\2\2\u02e7"+
		"\u0091\3\2\2\2\u02e8\u02e9\t\5\2\2\u02e9\u0093\3\2\2\2\u02ea\u02eb\t\6"+
		"\2\2\u02eb\u0095\3\2\2\2\u02ec\u02ed\t\7\2\2\u02ed\u0097\3\2\2\2\u02ee"+
		"\u02ef\t\b\2\2\u02ef\u0099\3\2\2\2\u02f0\u02f1\t\t\2\2\u02f1\u009b\3\2"+
		"\2\2C\u009f\u00a8\u00c4\u00c7\u00d5\u00d8\u00db\u00e6\u00ea\u00ee\u00f7"+
		"\u010e\u0112\u0122\u012a\u0131\u0139\u0143\u0146\u014d\u016a\u01a1\u01a3"+
		"\u01a9\u01b0\u01b3\u01b6\u01bf\u01cb\u01f3\u01f9\u01fc\u0206\u020b\u0216"+
		"\u021a\u0221\u022a\u0232\u0235\u023f\u024f\u0255\u025c\u0262\u0265\u0269"+
		"\u0270\u0275\u0279\u027f\u0285\u0291\u0294\u029a\u02a0\u02a6\u02ac\u02b1"+
		"\u02b5\u02bb\u02bf\u02c4\u02c8\u02d4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}