package Analizador;
import java_cup.runtime.Symbol;
%%
%class LexerImg
%type java_cup.runtime.Symbol
%cup
%unicode
%line
%column
%char
%public
D=[0-9]+
esp = [ |\n|\t|\r]+
%state IMAGENES
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
<YYINITIAL> {D}                 {return new Symbol(symImg.NUMERO, yycolumn, yyline, yytext());}
<YYINITIAL> "{"                 {yybegin(IMAGENES);return new Symbol(symImg.LLAVEA, yycolumn, yyline, yytext());}
<IMAGENES> {
    "}"                 {yybegin(YYINITIAL); return new Symbol(symImg.LLAVEC, yycolumn, yyline, yytext());}
    {D}                 {return new Symbol(symImg.NUMERO, yycolumn, yyline, yytext());}
    ","                 {return new Symbol(symImg.COMA, yycolumn, yyline, yytext());}
    {esp}               {/*ignorar*/}
}
{esp}                   {/*ignorar*/}
