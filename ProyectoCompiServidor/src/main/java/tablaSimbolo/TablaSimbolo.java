package tablaSimbolo;



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

    public TablaSimbolo() {
    }


    public void capturarClase(String nombre) {
        if (!"".equals(nombre)) {
            
           this.clases.add(new Clase(nombre));
          
        }else{
            this.clases.add(new Clase("algo"));
        }
        
    }
    

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


    public void capturarMetodo(String nombre, String tipo) {
        if (!"".equals(nombre) && !"".equals(tipo)) {
            this.metodos.add(new Metodo(nombre, tipo));
            if (!this.clases.isEmpty()) {
                this.clases.get(this.clases.size() - 1).getFunciones().add(nombre);
            }
        }

    }
    

    private void capturaVariable(ArrayList<Variable> variables, String nombre) {
        variables.forEach(variable -> {
            variable.setFuncionPadre(nombre);
            this.variables.add(variable);
        });
    }
    

    public void capturarVariableIndividual(String var, String tipo) {
        if (!"".equals(var) && !"".equals(tipo)) {
            this.variables.add(new Variable(var, tipo));
        }
    }
    

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

}
