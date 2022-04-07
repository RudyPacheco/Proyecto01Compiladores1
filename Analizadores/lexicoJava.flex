/*primer seccion codigo de usuario*/
//package ;
package com.compiladores1.appserver.analizadores;
import java.util.ArrayList;
import com.compiladores1.appserver.simbolTable.*;
import java_cup.runtime.*;
import com.compiladores1.appserver.errores.Errors;


%%
/*segunda seccion configuracion*/
%class LexicoJava
%public
%line
%column
%unicode
%cup
%state CADE
%state COMENTMULTILINEA
%state COMENTLINEA


WhiteSpace = [\r|\n|\r\n|\s\t] | [\t\f]
INICIOMULTILINEA = "/*"
FINMULTILINEA = "*/"
INICIOLINEA="//"
LETRA = [a-zA-Z|ñ]
DECIMAL = ([0-9]+[.]([0-9]+))
ENTERO = [0-9]+
LLAVEA = "\{"
LLAVEC = "\}"
PARENTESISA ="\("
PARENTESISC ="\)"
PUNTO = "."
COMA = ","
PUNTOCOMA = ";"
DOPUNTO = ":"
COMILLAS= "\""
MENOS = "-"
MAS = "+"
MULTIPLICACION = "*"
DIVISION = "/"
IGUAL="="
NEGATION = "!"
EQUALS=({IGUAL}{IGUAL})
OR="||"
AND="&&"
MENORQ="<"
MAYORQ=">"
MAYOROI=">="
MENOROI="<="
NOTEQUALS="!="
GUIONB = "_"
IMPORT="import"
PRIVATE = "private"
PUBLIC = "public"
PROTECTED = "protected"
FINAL = "final"
CLASS="class"
INT = "int"
BOOLEAN = "boolean"
STRING = "String"
CHAR = "char"
DOUBLE = "double"
IF = "if"
ELSE = "else"
FOR = "for"
WHILE = "while"
DO = "do"
SWITCH = "switch"
BREAK="break"
RETURN = "return"
NEW="new"
DEFAULT = "default"
CASO = "case"
TRUE = "true"
FLASE = "false"
ID = ((({LETRA}|{GUIONB})({LETRA}|{ENTERO}|{GUIONB})*({LETRA}|{ENTERO}))|{LETRA})
CARACTER = "'"[^]"'"


/*comodin %{ para agregar codigo java*/
%{
  
    private Symbol symbol(int type, String lexema) {
        return new Symbol(type, new Token(lexema, yyline + 1, yycolumn + 1));
    }
    private TableSimbol tabla = new TableSimbol();
    private String cadena ="";
    private String comentario="";
    private ArrayList<Errors> errores = new ArrayList<>();
    private boolean isProyecto1 = true;



    public void setErrores(ArrayList errores) {
        this.errores = errores;
    }

    public ArrayList getErrores() {
        return errores;
    }


    public void setTabla(TableSimbol tabla){
        this.tabla = tabla;
    }
    public TableSimbol getTable(){
        return this.tabla;
    }
         public boolean isIsProyecto1() {
        return isProyecto1;
    }

    public void setIsProyecto1(boolean isProyecto1) {
        this.isProyecto1 = isProyecto1;
    }
    
%}

/*accion al finlizar el texto*/
%eof{
   System.out.println("LLegue al final desde flex");
%eof}


%%
/* reglas lexicas */
<YYINITIAL> {
{WhiteSpace} 	{/* ignoramos */}
{INICIOMULTILINEA}          {yybegin(COMENTMULTILINEA);} 
{INICIOLINEA}               {yybegin(COMENTLINEA);}
{CARACTER}                  { return symbol(sym.CARACTER,yytext()); }
{DECIMAL}                   { return symbol(sym.DECIMAL,yytext());}
{ENTERO}                    { return symbol(sym.ENTERO,yytext());}
{LLAVEA}                    { return symbol(sym.LLAVEA,yytext());}
{LLAVEC}                    { return symbol(sym.LLAVEC,yytext());}
{PARENTESISA}               { return symbol(sym.PARENTESISA,yytext());}
{PARENTESISC}               { return symbol(sym.PARENTESISC,yytext());}
{PUNTO}                     { return symbol(sym.PUNTO,yytext());}
{COMA}                      { return symbol(sym.COMA,yytext());}
{PUNTOCOMA}                 { return symbol(sym.PUNTOCOMA,yytext());}
{DEFAULT}                   { return symbol(sym.DEFAULT,yytext());}
{DOPUNTO}                   { return symbol(sym.DOPUNTO,yytext());}
{MENOS}                     { return symbol(sym.MENOS,yytext());}
{MAS}                       { return symbol(sym.MAS,yytext());}
{MULTIPLICACION}            { return symbol(sym.MULTIPLICACION,yytext());}
{NEGATION}                  { return symbol(sym.NEGATION,yytext());}
{DIVISION}                  { return symbol(sym.DIVISION,yytext());}
{IGUAL}                     { return symbol(sym.IGUAL,yytext());}
{EQUALS}                    { return symbol(sym.EQUALS,yytext());}
{AND}                       { return symbol(sym.AND,yytext());}
{OR}                        { return symbol(sym.OR,yytext());}
{MENORQ}                    { return symbol(sym.MENORQ,yytext());}
{MAYORQ}                    { return symbol(sym.MAYORQ,yytext());}
{MAYOROI}                   { return symbol(sym.MAYOROI,yytext());}
{MENOROI}                   { return symbol(sym.MENOROI,yytext());}
{CASO}                      { return symbol(sym.CASO,yytext());}
{NOTEQUALS}                 { return symbol(sym.NOTEQUALS,yytext());}
{IMPORT}                    { return symbol(sym.IMPORT,yytext());}
{PRIVATE}                   { return symbol(sym.PRIVATE,yytext());}
{PUBLIC}                    { return symbol(sym.PUBLIC,yytext());}
{PROTECTED}                 { return symbol(sym.PROTECTED,yytext());}
{CLASS}                     { return symbol(sym.CLASS,yytext());}
{INT}                       { return symbol(sym.INT,yytext());}
{BOOLEAN}                   { return symbol(sym.BOOLEAN,yytext());}
{TRUE}                      { return symbol(sym.TRUE,yytext());}
//{CADENA}                    { return symbol(sym.CADENA,yytext());}
{STRING}                    { return symbol(sym.STRING,yytext());}
{CHAR}                      { return symbol(sym.CHAR,yytext());}
{CARACTER}                  { return symbol(sym.CARACTER,yytext());}
{DOUBLE}                    { return symbol(sym.DOUBLE,yytext());}
{IF}                        { return symbol(sym.IF,yytext());}
{ELSE}                      { return symbol(sym.ELSE,yytext());}
{FOR}                       { return symbol(sym.FOR,yytext());}
{WHILE}                     { return symbol(sym.WHILE,yytext());}
{DO}                        { return symbol(sym.DO,yytext());}
{SWITCH}                    { return symbol(sym.SWITCH,yytext());}
{BREAK}                     { return symbol(sym.BREAK,yytext());}
{RETURN}                    { return symbol(sym.RETURN,yytext());}
{NEW}                       { return symbol(sym.NEW,yytext());}
{FLASE}                     { return symbol(sym.FALSE,yytext());}
{FINAL}                     { return symbol(sym.FINAL,yytext());}
{ID}                        { return symbol(sym.ID,yytext());}
{COMILLAS}                  {yybegin(CADE);}

}
<CADE>{
{COMILLAS} { yybegin(YYINITIAL); return symbol(sym.CADENA, cadena);}
[^] {cadena+=yytext();}
}

<COMENTMULTILINEA>{
{FINMULTILINEA} {yybegin(YYINITIAL); this.tabla.getComentarios().add(comentario); comentario = "";}
{MULTIPLICACION}       {;}
(\n)		{;}
{COMILLAS} {;}
[^] {comentario+=yytext();}
}

<COMENTLINEA>{
(\n) {yybegin(YYINITIAL); this.tabla.getComentarios().add(comentario); comentario = "";}
{COMILLAS} {;}
[^] {comentario+=yytext();}
}

[^] {errores.add(new Errors(yytext(),yyline + 1,yycolumn + 1,"No existe en el lenguaje","Lexico","---",isProyecto1));}
