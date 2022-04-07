package reporteHtml;

/**
 *
 * @author andaryus7
 */

public class Token {

    private final String lexeme;
    private final int line;
    private final int column;


  
    public Token(String lexema, int linea, int columna) {
        this.lexeme = lexema;
        this.line = linea;
        this.column = columna;

    }
  
    public Token(int fila, int columna) {
        this(null, fila, columna);
    }

    public String getLexema() {
        return lexeme;
    }

    public int getFila() {
        return line;
    }

    public int getColumna() {
        return column;
    }


}
