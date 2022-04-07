
package funcionUi;

import java.util.ArrayList;
import tablaSimbolo.Clase;
import tablaSimbolo.Metodo;
import tablaSimbolo.TablaSimbolo;
import tablaSimbolo.Variable;

/**
 *
 * @author andaryus7
 */
public class comparacionProyecto {
 
    
    private TablaSimbolo proyecto1;
    private TablaSimbolo proyecto2;
    private TablaSimbolo tablaSimbolosGeneral = new TablaSimbolo();
    private double valorComentariosRepetidos = 0;
    private double valorClasesRepetidas = 0;
    private double valorMetodoRepetido = 0;
    private double valorVariableRepetida = 0;
    private double Score = 0;

    public comparacionProyecto() {
    }
    
    public comparacionProyecto(TablaSimbolo proyect1, TablaSimbolo proyecto2) {
    }


 

    public void realizarAcciones() {
        RepitenciaComentarios();
        RepitenciaClases();
        RepitenciaMetodos();
        RepitenciaVariable();
        calculoScore();
    }

    /**
     * calcula el score total
     */
    private void calculoScore() {
        if (this.proyecto1.getComentarios().size() > 0 && this.proyecto2.getComentarios().size() > 0) {
            this.Score += (valorComentariosRepetidos / (this.proyecto1.getComentarios().size() + this.proyecto2.getComentarios().size())) * 0.25;
        }
        if (this.proyecto1.getClases().size() > 0 && this.proyecto2.getClases().size() > 0) {
            this.Score += (valorClasesRepetidas / (this.proyecto1.getClases().size() + this.proyecto2.getClases().size())) * 0.25;
        }
        if (this.proyecto1.getVariables().size() > 0 && this.proyecto2.getVariables().size() > 0) {
            this.Score += (valorVariableRepetida / (this.proyecto1.getVariables().size() + this.proyecto2.getVariables().size())) * 0.25;
        }
        if (this.proyecto1.getMetodos().size() > 0 && this.proyecto2.getMetodos().size() > 0) {
            this.Score += (valorMetodoRepetido / (this.proyecto1.getMetodos().size() + this.proyecto2.getMetodos().size())) * 0.25;
        }


    }

//comentarios repetidos
    private void RepitenciaComentarios() {
        if (!proyecto1.getComentarios().isEmpty() && !proyecto2.getComentarios().isEmpty()) {
            proyecto1.getComentarios().stream().filter(comentario -> (proyecto2.getComentarios().contains(comentario))).forEachOrdered(comentario -> {
                if (!this.tablaSimbolosGeneral.getComentarios().contains(comentario)) {
                    agregarRepetidos(comentario);
                }
                valorComentariosRepetidos++;
                this.tablaSimbolosGeneral.getComentarios().add(comentario);
            });
        }
    }


    private void agregarRepetidos(String coment) {
        proyecto2.getComentarios().stream().filter(comentario -> (coment.equals(comentario))).forEachOrdered(_item -> {
            valorComentariosRepetidos++;
        });
    }

//clases repetidas
    private void RepitenciaClases() {
        if (!this.proyecto1.getClases().isEmpty() && !this.proyecto2.getClases().isEmpty()) {
            for (Clase clase : this.proyecto1.getClases()) {
                comparacionClases(clase);
            }
        }
    }

//comparacion de clase
    private void comparacionClases(Clase clase) {
        for (Clase clase1 : this.proyecto2.getClases()) {
            if (clase.getNombre().equals(clase1.getNombre()) && comparacionFuncionesClase(clase, clase1)) {
                if (!classYaAgregada(clase)) {
                    aumentarClasRetip(clase);
                }
                this.valorClasesRepetidas++;
                this.tablaSimbolosGeneral.getClases().add(clase);
                break;
            }
        }
    }

    private boolean classYaAgregada(Clase clase) {
        boolean yaAgregada = false;
        for (Clase clase1 : tablaSimbolosGeneral.getClases()) {
            if (clase.getNombre().equals(clase1.getNombre()) && comparacionFuncionesClase(clase, clase1)) {
                yaAgregada = true;
                break;
            }
        }
        return yaAgregada;
    }


    private void aumentarClasRetip(Clase clase) {
        for (Clase clase1 : proyecto2.getClases()) {
            if (clase.getNombre().equals(clase1.getNombre()) && comparacionFuncionesClase(clase, clase1)) {
                valorClasesRepetidas++;
            }
        }
    }


    private boolean comparacionFuncionesClase(Clase clase, Clase clase1) {
        boolean iguales = true;
        if (clase.getFunciones().size() == clase1.getFunciones().size()) {
            ArrayList<String> funciones = (ArrayList) clase1.getFunciones().clone();
            for (String funcione : clase.getFunciones()) {
                funciones.remove(funcione);
            }
            if (!funciones.isEmpty()) {
                iguales = false;
            }
        } else {
            iguales = false;
        }

        return iguales;
    }


    private void RepitenciaMetodos() {
        if (!this.proyecto1.getMetodos().isEmpty() && !this.proyecto2.getMetodos().isEmpty()) {
            for (int i = 0; i < this.proyecto1.getMetodos().size(); i++) {
                Metodo metodo = this.proyecto1.getMetodos().get(i);
                comprobarMetodo(metodo);
            }

        }
    }
    


//comparacion metodos
    private void comprobarMetodo(Metodo metodo) {
        for (int i = 0; i < this.proyecto2.getMetodos().size(); i++) {
            Metodo metodo1 = this.proyecto2.getMetodos().get(i);
            if (metodo.getNombre().equals(metodo1.getNombre()) && comporbacionParametros(metodo, metodo1)) {
                if (!metodYaAgregado(metodo)) {
                    aumentarRepitMetodo(metodo);
                }
                valorMetodoRepetido++;
                this.tablaSimbolosGeneral.getMetodos().add(metodo);
                break;
            }
        }

    }


    private void aumentarRepitMetodo(Metodo metodo) {
        for (int i = 0; i < this.proyecto2.getMetodos().size(); i++) {
            Metodo metodo1 = this.proyecto2.getMetodos().get(i);
            if (metodo.getNombre().equals(metodo1.getNombre()) && comporbacionParametros(metodo, metodo1)) {
                valorMetodoRepetido++;
            }
        }
    }


    private boolean metodYaAgregado(Metodo metodo) {
        boolean yaAgregado = false;
        for (Metodo metodo1 : tablaSimbolosGeneral.getMetodos()) {
            if (metodo.getNombre().equals(metodo1.getNombre()) && comporbacionParametros(metodo, metodo1)) {
                yaAgregado = true;
                break;
            }
        }
        return yaAgregado;
    }

//comparacion de parametros
    private boolean comporbacionParametros(Metodo metodo, Metodo metodo1) {
        boolean iguales = true;
        if (metodo.getNumParametros() == metodo1.getNumParametros()) {
            if (metodo.getNumParametros() != 0) {
                noVerrific(metodo1.getVariables());
                for (Variable variable : metodo.getVariables()) {
                    for (Variable variable1 : metodo1.getVariables()) {
                        if (varEsIgual(variable, variable1) && !variable1.isYaVerificada()) {
                            variable1.setYaVerificada(true);
                            variable.setYaVerificada(true);
                            break;
                        }
                    }
                    if (!variable.isYaVerificada()) {
                        iguales = false;
                        break;
                    }
                }

            }
        } else {
            iguales = false;
        }
        return iguales;
    }
    
    
    
    
    
    private void noVerrific(ArrayList<Variable> variables){
        for (Variable variable : variables) {
            variable.setYaVerificada(false);
        }
    }


    private void RepitenciaVariable() {
        if (!this.proyecto1.getVariables().isEmpty() && !this.proyecto2.getVariables().isEmpty()) {
            for (Variable variable : proyecto1.getVariables()) {
                comprovarVariable(variable);
            }
        }
    }

//comparacion variable
    private void comprovarVariable(Variable variable) {
        for (Variable variable1 : proyecto2.getVariables()) {
            if (varEsIgual(variable, variable1)) {
                if (!varYaAgreada(variable)) {
                    aumentarVarRepit(variable, true);
                } else {
                    aumentarVarRepit(variable, false);
                }
                valorVariableRepetida++;
                this.tablaSimbolosGeneral.getVariables().add(variable);
                break;
            }
        }
    }


    private void aumentarVarRepit(Variable variable, boolean aumetarContador) {
        for (Variable variable1 : proyecto2.getVariables()) {
            if (varEsIgual(variable, variable1)) {
                if (aumetarContador) {
                    valorVariableRepetida++;
                }
                variable.funcionPadre(variable1.getFuncionPadre());
            }
        }
    }


    private boolean varYaAgreada(Variable variable) {
        boolean yaAgregada = false;
        for (Variable variable1 : tablaSimbolosGeneral.getVariables()) {
            if (varEsIgual(variable, variable1)) {
                yaAgregada = true;
                break;
            }
        }
        return yaAgregada;
    }

    private boolean varEsIgual(Variable variable, Variable variable1) {
        return variable.getNombre().equals(variable1.getNombre()) && variable.getTipo().equals(variable1.getTipo());
    }

    public TablaSimbolo getProyecto() {
        return tablaSimbolosGeneral;
    }

    public void setProyecto(TablaSimbolo proyecto) {
        this.tablaSimbolosGeneral = proyecto;
    }

    public TablaSimbolo getProyect1() {
        return proyecto1;
    }

    public void setProyect1(TablaSimbolo proyect1) {
        this.proyecto1 = proyect1;
    }

    public TablaSimbolo getProyecto2() {
        return proyecto2;
    }

    public void setProyecto2(TablaSimbolo proyecto2) {
        this.proyecto2 = proyecto2;
    }

    public double getCantidadComentRepit() {
        return valorComentariosRepetidos;
    }

    public void setCantidadComentRepit(int cantidadComentRepit) {
        this.valorComentariosRepetidos = cantidadComentRepit;
    }

    public double getCantidadClasesRepit() {
        return valorClasesRepetidas;
    }

    public void setCantidadClasesRepit(int cantidadClasesRepit) {
        this.valorClasesRepetidas = cantidadClasesRepit;
    }

    public double getCantidadMetodRepit() {
        return valorMetodoRepetido;
    }

    public void setCantidadMetodRepit(int cantidadMetodRepit) {
        this.valorMetodoRepetido = cantidadMetodRepit;
    }

    public double getCantidadVariableRepit() {
        return valorVariableRepetida;
    }

    public void setCantidadVariableRepit(int cantidadVariableRepit) {
        this.valorVariableRepetida = cantidadVariableRepit;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double Score) {
        this.Score = Score;
    }
    
}
