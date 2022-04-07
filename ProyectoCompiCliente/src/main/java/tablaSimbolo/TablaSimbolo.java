package tablaSimbolo;



import reporteHtml.Token;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author andaryus7
 */
public class TablaSimbolo implements Serializable{

    private ArrayList<Metodo> metodos = new ArrayList<>();
    private ArrayList<Variable> variables = new ArrayList<>();
    private ArrayList<Clase> clases = new ArrayList<>();
    private ArrayList<String> comentarios = new ArrayList<>();
       private double score = 0.0;
    
    public TablaSimbolo() {
    }

    /**
     * captura el nombre de la clase analizando
     * @param nombre 
     */
    public void capturarClase(String nombre) {
        if (!"".equals(nombre)) {
            
           this.clases.add(new Clase(nombre));
          
        }else{
            this.clases.add(new Clase("algo"));
        }
        
    }
    
        public void capturaVar(String nombre, String tipo, String funcionP) {
        this.variables.add(new Variable(nombre, tipo, funcionP));
    }

    
    public void capturaScore(String score) {
        try {
            this.score = Double.parseDouble(score);
        } catch (NumberFormatException e) {
            System.out.println("ERROR EN PARSEO DEL SCORE");
            e.printStackTrace();
        }
    }
    
    /**
     * captura el metodo con parametros
     * @param variables
     * @param nombre
     * @param tipo 
     */
    public void capturarMetodo(ArrayList<Variable> variables, String nombre, String tipo) {
        if (!"".equals(nombre) && !"".equals(tipo) && !variables.isEmpty()) {
            ArrayList<Variable> parametros = new ArrayList<>();
            for (Variable variable : variables) {
                parametros.add(variable);
            }
            this.metodos.add(new Metodo(nombre, tipo, parametros.size(), parametros));
            capturaVariable(variables, nombre);
            if (!this.clases.isEmpty()) {
                this.clases.get(this.clases.size() - 1).getFunciones().add(nombre);
            }
        }
    }

    /**
     * captura el metodo sin parametros
     * @param nombre
     * @param tipo
     */
    public void capturarMetodo(String nombre, String tipo) {
        if (!"".equals(nombre) && !"".equals(tipo)) {
            this.metodos.add(new Metodo(nombre, tipo));
            if (!this.clases.isEmpty()) {
                this.clases.get(this.clases.size() - 1).getFunciones().add(nombre);
            }
        }

    }
    
        public void capturarMetodo(String nombre, String tipo, String parametros) {
        try {
            int numPar = Integer.parseInt(parametros);
            this.metodos.add(new Metodo(nombre, tipo, numPar));
        } catch (NumberFormatException e) {
            this.metodos.add(new Metodo(nombre, tipo, 0));
        }
    }
    
    
    /**
     * captura las variabels definidas en los parametros del metodo y los asigna al arreglo global de variables
     * @param variables
     * @param nombre 
     */
    private void capturaVariable(ArrayList<Variable> variables, String nombre) {
        variables.forEach(variable -> {
            variable.setFuncionPadre(nombre);
            this.variables.add(variable);
        });
    }
    
    /**
     * captura la varible al arreglo de variables
     * @param var
     * @param tipo 
     */
    public void capturarVariableIndividual(String var, String tipo) {
        if (!"".equals(var) && !"".equals(tipo)) {
            this.variables.add(new Variable(var, tipo));
        }
    }
    
    
    
      public String recuperarNombreClass(int index, Token token) {
        String nomClase = "";
        if (index < clases.size()) {
            nomClase = clases.get(index).getNombre();
        } else {
            System.out.println("Null pinter Exception xd fila: " + token.getFila() + 1);
        }
        return nomClase;
    }

    public String recuperacionNomVar(int index, Token token) {
        String nomVar = "";
        if (index < variables.size()) {
            nomVar = variables.get(index).getNombre();
        } else {
            System.out.println("Null pinter Exception xd columna: " + token.getColumna() + 1);
        }
        return nomVar;
    }

    public String recuperacionTipoVar(int index, Token token) {
        String nomVar = "";
        if (index < variables.size()) {
            nomVar = variables.get(index).getTipo();
        } else {
            System.out.println("Null pinter Exception xd columna: " + token.getColumna() + 1);
        }
        return nomVar;
    }

    public String recupearacionFuncionPadreVAr(int index, Token token) {
        String funcionPadre = "";
        if (index < variables.size()) {
            funcionPadre = variables.get(index).getFuncionPadre();
        } else {
            System.out.println("null pointer exelption variables funcionpadre");
        }
        return funcionPadre;
    }

    public String recuperacionNombreMetodo(int index, Token token) {
        String nombre = "";
        if (index < metodos.size()) {
            nombre = metodos.get(index).getNombre();
        } else {
            System.out.println("null pointer exception en metodos nombre");
        }
        return nombre;
    }

    public String recuperacionTipoMetodo(int index, Token token) {
        String nombre = "";
        if (index < metodos.size()) {
            nombre = metodos.get(index).getTipo();
        } else {
            System.out.println("null pointer exception en metodos tipo");
        }
        return nombre;
    }

    public String recuperarTextoComentario(int index, Token token) {
        String texto = "";
        if (index < comentarios.size()) {
            texto = comentarios.get(index);
        } else {
            System.out.println("null pointer exception en metodos tipo");
        }
        return texto;
    }

    public int recuperarParametrosMetodos(int index, Token token) {
        int parametros = 0;
        if (index < metodos.size()) {
            parametros = metodos.get(index).getNumParametros();
        } else {
            System.out.println("null pointer exception en metodos parametros");
        }

        return parametros;
    }
    
    
    
    /**
     * asigna la funcion padre a la variable o varibles ingresadas, de tipo comun
     * @param esGlobal
     * @param numAactulizar 
     */
    public void actualizarVar(boolean esGlobal, int numAactulizar) {
        if (esGlobal && !this.variables.isEmpty() && !this.clases.isEmpty()) {
            int index = this.variables.size() - numAactulizar;
            while (this.variables.size() > index) {
                this.variables.get(index).setFuncionPadre(this.clases.get(this.clases.size() - 1).getNombre());
                index++;
            }
        } else if (!esGlobal && !this.variables.isEmpty() && !this.metodos.isEmpty()) {
            int index = this.variables.size() - numAactulizar;
            while (this.variables.size() > index) {
                this.variables.get(index).setFuncionPadre(this.metodos.get(this.metodos.size() - 1).getNombre());
                index++;
            }
        }
    }

    /**
     * le asigna la funcion padre a la variable o varibles ingresadas asi tambien si son de tipo objeto
     * @param esGlobal
     * @param numAactulizar
     * @param tipo 
     */
    public void actualizarVar(boolean esGlobal, int numAactulizar, String tipo) {
        if (esGlobal && !this.variables.isEmpty() && !this.clases.isEmpty() && tipo != null) {
            int index = this.variables.size() - numAactulizar;
            while (this.variables.size() > index) {
                this.variables.get(index).setTipo(tipo);
                this.variables.get(index).setFuncionPadre(this.clases.get(this.clases.size() - 1).getNombre());
                index++;
            }
        } else if (!esGlobal && !this.variables.isEmpty() && !this.metodos.isEmpty() && tipo != null) {
            int index = this.variables.size() - numAactulizar;
            while (this.variables.size() > index) {
                this.variables.get(index).setTipo(tipo);
                this.variables.get(index).setFuncionPadre(this.metodos.get(this.metodos.size() - 1).getNombre());
                index++;
            }
        }
    }
    
    
    public void capturarComentario(String comentario) {
        this.comentarios.add(comentario);
    }


    public void tosting(){
        System.out.println("Clases Registaradas");
        clases.forEach(clase -> {
            System.out.println(clase.toString());
        });
        System.out.println("Variables Registradas");
        variables.forEach(variable -> {
            System.out.println( variable.toString());
        });
        System.out.println("Metodos Registrados");
        metodos.forEach(metodo -> {
            System.out.println(metodo.toString());
        });
    }

    public ArrayList<Metodo> getMetodos() {
        return metodos;
    }

    public void setMetodos(ArrayList<Metodo> metodos) {
        this.metodos = metodos;
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }

    public ArrayList<Clase> getClases() {
        return clases;
    }

    public void setClases(ArrayList<Clase> clases) {
        this.clases = clases;
    }

    public ArrayList<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<String> comentarios) {
        this.comentarios = comentarios;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    
    
    
}
