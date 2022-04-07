package analisisHtml;
import reporteHtml.Token;
import java.util.ArrayList;

import java_cup.runtime.*;
%%
/*segunda seccion configuracion*/
%class LexicoHtml
%public
%line
%column
%unicode
%cup
%state CADE
%state COMENTARIO

/*delcaracion para los tokens*/
WhiteSpace = [\r|\n|\r\n|\s\t] | [\t\f]
DECIMAL = ([0-9]+[.]([0-9]+))
LETRA = [a-zA-Z|ñ]
HTMLINICIO="<html>"
HTMLFIN="</html>"
H1INICIO="<h1>"
H1CIERRE="</h1>"
H2ABRE="<h2>"
H2CIERRE="</h2>"
TABLAABRE="<table>"
TABLACIERRE="</table>"
TRABRE="<tr>"
TRCIERRE="</tr>"
THABRE="<th>"
THCIERRE="</th>"
TDABRE="<td>"
TDCIERRE="</td>"
SALTO="<br>"
FORABRE="<for"
FORCIERRE="</for>"
PUNTO = "."
DOSPUNTO = ":" 
HASTA="hasta"
ITERADOR = "iterador";
MAYOR=">"
MENOR="<"
POSABERTURA = (({MENOR})({LETRA})+({MAYOR})?)
POSCERRADURA = (({MENOR})({DIVISION})({LETRA})+({MAYOR}))
COMA = ","
PUNTOCOMA = ";"
ENTERO = [0-9]+
DIGONALB = "_"
IDD = ((({LETRA}|{DIGONALB})({LETRA}|{ENTERO}|{DIGONALB})*({LETRA}|{ENTERO}))|{LETRA})
COMODIN="$$"
PARENTESISA ="\("
PARENTESISC ="\)"
IGUAL="="
MENOS = "-"
MAS = "+"
POR = "*"
DIVISION = "/"
COMILLAS= "\""
CORCHETEA= "\["
CORCHETEC= "\]"
INICIO_COMENTARIO_MULTILINEA = "</"
FIN_COMENTARIO_MULTILINEA = "/>"
INTEGER="integer"
STRING="string"

/*comodin %{ para agregar codigo java*/
%{
    private String cadena ="";
    private String auxAnteriror = "";
    private boolean tomarEncuenta = true;

    private Symbol symbol(int type, String lexema) {
        return new Symbol(type, new Token(lexema, yyline + 1, yycolumn + 1));
    }
    private Symbol symbolReservado(String lexema) {
        String aux = lexema.toLowerCase();
        int type;
        switch(aux){
            case "<html>":
                type = sym.HTMLINICIO;
                break;
            case "</html>":
                type = sym.HTMLFIN;
                break;
            case "<h1>":
                type = sym.H1INICIO;
                break;    
            case "</h1>":
                type = sym.H1FIN;
                break;
            case "<h2>":
                type = sym.H2INICIO;
                break;
            case "</h2>":
                type = sym.H2FIN;
                break;
            case "<table>":
                type = sym.TABLAINICIO;
                break;
            case "</table>":
                type = sym.TABLAFIN;
                break;
            case "<tr>":
                type = sym.TRINICIO;
                break;
            case "</tr>":
                type = sym.TRFIN;
                break;
            case "<th>":
                type = sym.THINICIO;
                break;
            case "</th>":
                type = sym.THFIN;
                break;
            case "<td>":
                type = sym.TDINICIO;
                break;
            case "</td>":
                type = sym.TDFIN;
                break;
            case "<br>":
                type = sym.SALTO;
                break;
            case "<for":
                type = sym.FORINICIO;
                break;
            case "</for>":
                type = sym.FORFIN;
                break;
            case "integer":
                type = sym.INTEGER;
                break;
            case "string":
                type = sym.STRING;
                break;
            case "hasta":
                type = sym.HASTA;
                break;
            case "iterador":
                type = sym.ITERADOR;
                break;
            case "result":
                type = sym.RESULT;
                break; 
            case "score":
                type = sym.SCORE;
                break;   
            case "variables":
                if(auxAnteriror.equals("result")){
                    type = sym.VARIABLES;
                }else{
                    type = sym.IDD;
                }
                break;
            case "clases":
                if(auxAnteriror.equals("result")){
                    type = sym.CLASES;
                }else{
                    type = sym.IDD;
                }
                break;
            case "nombre":
                if(auxAnteriror.equals("variables") || auxAnteriror.equals("metodos") || auxAnteriror.equals("clases")){
                    type = sym.NOMBRE;
                }else{
                    type = sym.IDD;
                }
                break;
            case "tipo":
                if(auxAnteriror.equals("variables") || auxAnteriror.equals("metodos")){
                    type = sym.TIPO;
                }else{
                    type = sym.IDD;
                }
                break;
            case "funcion":
                if(auxAnteriror.equals("variables")){
                    type = sym.FUNCION;
                }else{
                    type = sym.IDD;
                }
                break;
            case "metodos":
                if(auxAnteriror.equals("result")){
                    type = sym.METODOS;
                }else{
                    type = sym.IDD;
                }
                break;
            case "comentarios":
                if(auxAnteriror.equals("result")){
                    type = sym.COMENTARIOS;
                }else{
                    type = sym.IDD;
                }
                break;
            case "texto":
                if(auxAnteriror.equals("comentarios")){
                    type = sym.TEXTO;
                }else{
                    type = sym.IDD;
                }
                break;
            case "parametros":
                if(auxAnteriror.equals("metodos")){
                    type = sym.PARAMTETROS;
                }else{
                    type = sym.IDD;
                }
                break;
            default:
                type = sym.IDD;
                break;
        }
        if(tomarEncuenta){
            auxAnteriror = aux;
        }
        return new Symbol(type, new Token(lexema, yyline + 1, yycolumn + 1));
    }
    
%}

%eof{
   System.out.println("LLegue al final desde flex");
%eof}


%%
/* reglas lexicas */
<YYINITIAL> {
{WhiteSpace} 	{/* ignoramos */}
{INICIO_COMENTARIO_MULTILINEA}          {yybegin(COMENTARIO);}
{HTMLINICIO}                               {return symbol(sym.HTMLINICIO,yytext());}
{ENTERO}                                {return symbol(sym.ENTERO,yytext());}
{DECIMAL}                               {return symbol(sym.DECIMAL,yytext());}
{HTMLFIN}                             {return symbol(sym.HTMLFIN,yytext());}
{H1INICIO}                                {return symbol(sym.H1INICIO,yytext());}
{H1CIERRE}                              {return symbol(sym.H1FIN,yytext());}
{H2ABRE}                                {return symbol(sym.H2INICIO,yytext());}
{H2CIERRE}                              {return symbol(sym.H2FIN,yytext());}
{TABLAABRE}                             {return symbol(sym.TABLAINICIO,yytext());}
{TABLACIERRE}                           {return symbol(sym.TABLAFIN,yytext());}
{TRABRE}                                {return symbol(sym.TRINICIO,yytext());}
{TRCIERRE}                              {return symbol(sym.TRFIN,yytext());}
{THABRE}                                {return symbol(sym.THINICIO,yytext());}
{THCIERRE}                              {return symbol(sym.THFIN,yytext());}
{TDABRE}                                {return symbol(sym.TDINICIO,yytext());}
{TDCIERRE}                              {return symbol(sym.TDFIN,yytext());}
{SALTO}                                 {return symbol(sym.SALTO,yytext());}
{FORABRE}                               {return symbol(sym.FORINICIO,yytext());}
{FORCIERRE}                             {return symbol(sym.FORFIN,yytext());}
{PUNTO}                                 {return symbol(sym.PUNTO,yytext());}
{DOSPUNTO}                              {return symbol(sym.DOSPUNTO,yytext());}
{HASTA}                                 {return symbol(sym.HASTA,yytext());}
{MAYOR}                                 {return symbol(sym.MAYOR,yytext());}
{MENOR}                                 {return symbol(sym.MENOR,yytext());}
{POSABERTURA}                           {return symbolReservado(yytext());}
{POSCERRADURA}                          {return symbolReservado(yytext());}
{COMA}                                  {return symbol(sym.COMA,yytext());}
{PUNTOCOMA}                             {return symbol(sym.PUNTOCOMA,yytext());}
{COMODIN}                               {return symbol(sym.COMODIN,yytext());}
{PARENTESISA}                           {return symbol(sym.PARENTESISA,yytext());}
{PARENTESISC}                           {return symbol(sym.PARENTESISC,yytext());}
{IGUAL}                                 {return symbol(sym.IGUAL,yytext());}
{MENOS}                                 {return symbol(sym.MENOS,yytext());}
{MAS}                                   {return symbol(sym.MAS,yytext());}
{POR}                                   {return symbol(sym.POR,yytext());}
{DIVISION}                              {return symbol(sym.DIVISION,yytext());}
{CORCHETEA}                             { tomarEncuenta = false; return symbol(sym.CORCHETEA,yytext());}
{CORCHETEC}                             { tomarEncuenta = true;  return symbol(sym.CORCHETEC,yytext());}
{INTEGER}                               {return symbol(sym.INTEGER,yytext());}
{STRING}                                {return symbol(sym.STRING,yytext());}
{IDD}                                   {return symbolReservado(yytext());}
{COMILLAS}                              {cadena =""; yybegin(CADE);}
}

<CADE>{
{COMILLAS} { yybegin(YYINITIAL); return symbol(sym.CADENA, cadena);}
[^] {cadena+=yytext();}
}

<COMENTARIO>{
{FIN_COMENTARIO_MULTILINEA} {yybegin(YYINITIAL);}
[^] {;}
}


/* error fallback */
[^]                                     {System.out.println("Error simbolo: "+yytext());}
