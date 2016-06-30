grammar Squirrel;

script
	: stat* EOF
	;

block
	: '{' stat* '}'
	;
	
stat
	: STATSEP
    | functioncall
    | breakstat
    | continuestat
    | dowhileloop
    | localvar
    | whileloop
    | ifstat
    | forloop 
    | foreachloop
    | namedfunction
    | throwstat
    | switchstat
    | constdef
    | enumdef
    | classdef
    | retstat
    | block
    | exp (COMMA exp)*
    ;
    
breakstat
	: 'break'
	;
	
continuestat
	: 'continue'
	;
    
switchstat
	: 'switch' '(' exp ')' '{' ( ( switchcase+ defaultcase? ) | defaultcase )'}'
	;
    
throwstat
	: 'throw' exp
	;
    
forloop
	: 'for' '(' ( localvar | assignlist )? STATSEP exp? STATSEP exp? ')' stat
	;
	
foreachloop
	: 'foreach' '(' ( NAME COMMA )? NAME 'in' exp ')' stat
	;
    
dowhileloop
	: 'do' stat 'while' exp
	;
    
whileloop
	:  'while' exp stat
	;
	
ifstat
	: 'if' '(' exp ')' stat STATSEP? ( 'else' stat )?
	;
    
constdef
	: 'const' primitiveitem
	;
    
enumdef
	: 'enum' NAME ASSIGN enumconstructor
	;
    
switchcase
	: 'case' exp ':' stat*
	;

defaultcase
	: 'default' ':' stat+
	;
   
funcname
	: NAME ( '::' NAME)*
	;
	  
classstat
	:	classconstructor | classfunction | classassignlist | staticvar | STATSEP
	;
	
staticvar
	: 'static' declarelist
	;
	
localvar
	: 'local' declarelist
	;
	
retstat
    : 'return' exp? STATSEP?
    ;
    
explist
	: exp (COMMA exp)+
	;

exp
    //: exp (COMMA exp)+
	: '(' explist ')'
	| '(' exp ')'
    | number 
    | string
	| delegate
	| yield
	| delete
	| clone
	| typeof
	| functiondef								
    | functioncall		
    | assignlist
//    | <assoc=right> assign
    | exp 'in' exp						
	| tableconstructor
	| arrayconstructor		
	| resume			
    | incexp		
	| operatorUnary exp								
	| exp operatorMulDivMod exp		
	| exp operatorAddSub exp	
	| exp operatorShiftLeft exp					
	| exp operatorShiftRight exp					
	| exp operatorShiftRightUnsigned exp
	| exp operatorComparison exp	
	| <assoc=right> exp operatorBinAnd exp
	| <assoc=right> exp operatorBinXor exp
	| <assoc=right> exp operatorBinOr exp				
	| exp operatorAnd exp							
	| exp operatorOr exp
    | exp '?' exp ':' exp
    | log	
	;
    
/*
 * Declare
 * 
 * For when assigning a NAME to an expression (e.g. local, static) 
 */
declare
	: NAME ( ASSIGN exp )?
	;
	
declarelist
	: declare ( COMMA declare )+?
	| declare
	;
	
/*
 * Class Assign
 * 
 * For assigning values to instance variables in variables 
 */

classassign
	: attributesconstructor? assign
	;
	
classassignlist
	: classassign (COMMA classassign)* 
	;

/*
 * Assign
 * 
 * For when assigning values to already existing variables, such as in 
 * statements, for loop initializers
 */		
assign
	: var ( ASSIGN | NEW_SLOT ) exp
	;
		
assignlist
	: assign (COMMA assign)*?
	;

/*
 * Expressions
 */
resume
	: 'resume' exp
	;
	
clone
	: 'clone' exp
	;
	
delete
	: 'delete' var
	;
	
yield
	: 'yield' exp
	;
	
vargc
	: 'vargc'
	;
	
vargv
	: 'vargv'
	;
	
delegate
	: 'delegate' exp ':' exp
	;
	
typeof
	: 'typeof' var
	;
	
incexp
	: ( (INC | DEC ) var ) | ( var ( INC | DEC ) )  | ( var INCVAL exp )   | ( var DECVAL exp ) 
	;
	
log
	: TRUE | FALSE | NULL | var 
	;

var
    :  ROOT? (  vargc | vargv | NAME | '(' exp ')' varSuffix ) varSuffix*
    ;

functioncall
    : varOrExp nameAndArgs
    ;

varOrExp
    : var | '(' exp ')'
    ;

nameAndArgs
    : ('.' NAME)? args
    ;

varSuffix
    : nameAndArgs* ('[' exp ']' | '.' NAME)
    ;

args
    : '(' ( exp (COMMA exp)* )? ')'
    ;
    
namedfunction
	: 'function' funcname funcargs  stat
	;
    
classfunction
	: attributesconstructor? 'function' NAME funcargs stat
	;
    
functiondef
    : 'function' funcargs  stat
    ;

nameonlylist
    : NAME (COMMA NAME)*
    ;
    
name
	: NAME (ASSIGN exp)?
	;
	
namelist
    : name (COMMA name)*
    ;

arglist
    : namelist (COMMA VARARGS)? | VARARGS
    ;
    
funcargs
    : '(' arglist? ')' (':(' nameonlylist ')')? 
    ;
    
classdef
	: 'class' var attributesconstructor? ( 'extends' var )? '{' classstat* '}'
	;
	
classconstructor
	: attributesconstructor? 'constructor' funcargs stat
	;
	
arrayconstructor
    : '[' (exp (COMMA exp)*)? ']'
    ;
    
attributesconstructor
	: '</' tablerows? '/>'
	;
	
tableconstructor
    : '{' tablerows? '}'
    ;

enumconstructor
    : '{' enumlist? '}'
    ;
    
enumlist
    : primitiveitem (COMMA? primitiveitem)* COMMA?
	;
	
primitiveitem
	: NAME ASSIGN ( string | number )
	;

tablerows
    : tablerow (COMMA? tablerow)* COMMA?
    ;

tablerow
    : '[' exp ']' ASSIGN exp | NAME ASSIGN exp | namedfunction
    ;

operatorOr 
	: '||';

operatorAnd 
	: '&&';
	
operatorBinXor
	: '^' ;
	
operatorBinAnd
	: '&' ;

operatorBinOr
	: '|' ;

operatorShiftLeft
	: '<<' ;

operatorShiftRight
	: '>>' ;

operatorShiftRightUnsigned
	: '>>>' ;

operatorComparison 
	: '<' | '>' | '<=' | '>=' | '!=' | '==' | 'instanceof';

operatorAddSub
	: '+' | '-';

operatorMulDivMod
	: '*' | '/' | '%';

operatorUnary
    : '~' | '-' | '!';

number
    : OCTAL | INT | HEX | FLOAT | CHAR
    ;

string
    : NORMALSTRING | VERBATIMSTRING
    ;

// LEXER
TRUE
	: 'true'
	;
	
FALSE
	: 'false'
	;
	
NULL
	: 'null'
	;

ROOT
	: '::'
	;
	
NAME
    : ( [a-zA-Z] | '_' )+ ( [a-zA-Z0-9] | '_' )* 
    ;

NORMALSTRING
    : '"' ( EscapeSequence | ~('\\'|'"') )* '"' 
    ;

VERBATIMSTRING 
	: '@"' ( ~["] | '""')* '"' ;

OCTAL
	: '0' Digit+
	;	

INT
    : Digit+
    ;

HEX
    : '0' [xX] HexDigit+
    ;

FLOAT
    : Digit+ '.' Digit* ExponentPart?
    | '.' Digit+ ExponentPart?
    | Digit+ ExponentPart
    ;

CHAR 
	: '\'' Character '\''
	;

COMMA
	: ','
	;
	
ASSIGN
	: '='
	;
	
NEW_SLOT
	: '<-'
	;
	
VARARGS
	: '...'
	;
	
STATSEP
	: ';'
	;
	
INC
	: '++'
	;
	
DEC
	: '--'
	;
	
INCVAL
	: '+='
	;
	
DECVAL
	: '-='
	;
	
fragment 
Character 
	: ~['\\] 
	;

fragment
ExponentPart
    : [eE] [+-]? Digit+
    ;

fragment
HexExponentPart
    : [pP] [+-]? Digit+
    ;

fragment
EscapeSequence
    : '\\' [abfnrtvz"'\\]
    | '\\' '\r'? '\n'
    | DecimalEscape
    | HexEscape
    ;
    
fragment
DecimalEscape
    : '\\' Digit
    | '\\' Digit Digit
    | '\\' [0-2] Digit Digit
    ;
    
fragment
HexEscape
    : '\\' 'x' HexDigit HexDigit
    ;

fragment
Digit
    : [0-9]
    ;

fragment
HexDigit
    : [0-9a-fA-F]
    ;
     
COMMENT : '/*' .*? '*/' -> skip ;

LINE_COMMENT : '//' ~[\r\n]* -> skip ;
    
WS  
    : [ \t\u000C\r\n]+ -> skip
    ;

SHEBANG
    : '#' '!' ~('\n'|'\r')* -> channel(HIDDEN)
    ;
