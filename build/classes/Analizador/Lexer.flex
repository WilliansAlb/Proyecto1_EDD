package Analizador;
import java_cup.runtime.Symbol;
%%
%class Lexer
%type java_cup.runtime.Symbol
%cup
%unicode
%line
%column
%char
%public
L=[a-zA-Z]+
H=#([a-fA-F0-9]{6}|[a-fA-F0-9]{3})
D=[0-9]+
esp = [ \n\t\r]+
%state PARAMETROS
%state IMAGENES
%state USUARIOS
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
/* palabras reservadas */
<YYINITIAL> "("                 {yybegin(PARAMETROS);return new Symbol(sym.PARENTESISA, yycolumn, yyline, yytext());}
<YYINITIAL> {D}                 {return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());}
<YYINITIAL> "{"                 {yybegin(IMAGENES);return new Symbol(sym.LLAVEA, yycolumn, yyline, yytext());}
<YYINITIAL> {L}({L}|{D})*       {return new Symbol(sym.NOMBRE, yycolumn, yyline, yytext());}
<YYINITIAL> ":"                 {yybegin(USUARIOS);return new Symbol(sym.DOSP, yycolumn, yyline, yytext());}

<PARAMETROS> {
    ")"                 {yybegin(YYINITIAL); return new Symbol(sym.PARENTESISC, yycolumn, yyline, yytext());}
    {D}                 {return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());}
    ","                 {return new Symbol(sym.COMA, yycolumn, yyline, yytext());}
    {H}                 {return new Symbol(sym.HEXA, yycolumn, yyline, yytext());}
    ";"                 {return new Symbol(sym.PUNTOC, yycolumn, yyline, yytext());}
    {esp}               {/*ignorar*/}
}
<IMAGENES> {
    "}"                 {yybegin(YYINITIAL); return new Symbol(sym.LLAVEC, yycolumn, yyline, yytext());}
    {D}                 {return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());}
    ","                 {return new Symbol(sym.COMA, yycolumn, yyline, yytext());}
    {esp}               {/*ignorar*/}
}
<USUARIOS> {
    ";"                 {yybegin(YYINITIAL); return new Symbol(sym.PUNTOC, yycolumn, yyline, yytext());}
    {D}                 {return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());}
    ","                 {return new Symbol(sym.COMA, yycolumn, yyline, yytext());}
    {esp}               {/*ignorar*/}
}
{esp}                   {/*ignorar*/}