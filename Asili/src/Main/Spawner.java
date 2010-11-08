/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;


/**
 * Da la instrucción actual, y la hora para invocar a los enemigos
 * @author Alberto Ortiz
 */
public class Spawner {

    private int tiempoActual;
    private int nivelActual;
    private Instruccion instruccion;
    private ListaInstrucciones listaInstrucciones;
    private boolean esTiempo;
    private boolean nivelTerminado, comenzarCuenta;

    /**
     *
     * @param nivel - El nivel actual, para llenar la lista de acuerdo al nivel
     */
    public Spawner(int nivel) {
        tiempoActual = 0;
        nivelActual = nivel;
        listaInstrucciones = new ListaInstrucciones();
        listaInstrucciones.llenarLista(nivelActual);
        instruccion = listaInstrucciones.siguienteInstruccion();
        esTiempo = false;
        nivelTerminado = false;
        comenzarCuenta = false;
    }

    public void vaciarLista() {
        this.listaInstrucciones.vaciarLista();
    }

    /**
     *
     * @param tiempo EL tiempo que se agrega, en milisegundos
     */
    public void actualizar(int tiempo) {
        if (this.comenzarCuenta) {
            tiempoActual += tiempo;
            if (tiempoActual >= instruccion.getTiempoAparicion()) {
                esTiempo = true;
            }
        }
    }

    /**
     * Regresa el tiempo a cero
     */
    public void resetTiempo() {
        tiempoActual = 0;
        esTiempo = false;
    }

    /**
     *
     * @param nivel Modifica el nivel actual
     */
    public void setNivel(int nivel) {
        this.nivelActual = nivel;
    }

    /**
     *
     * @param newTiempo Cambia el tiempo transcurrido por uno nuevo
     */
    public void setTiempo(int newTiempo) {
        tiempoActual = newTiempo;
        esTiempo = true;
    }

    /**
     *
     * @return - regresa si ya es hora de invocar
     */
    public boolean isTime(){
        return esTiempo;
    }

    /**
     *
     * @return regresa si el juego ya termino
     */
    public boolean juegoTerminado() {
        return nivelTerminado;
    }

    /**
     *
     * @return regresa la instrucción actual
     */
    public Instruccion getInstruccionActual() {
        return instruccion;
    }

    public void comenzarCuenta() {
        this.comenzarCuenta = true;
    }

    public void detenerCuenta() {
        this.comenzarCuenta = false;
    }

    public void llenarInstrucciones() {
        this.listaInstrucciones.llenarLista(nivelActual);
    }


    /**
     * Pasa a la siguiente instrucción. SI la siguiente instrucción es null, el juego termina
     */
    public void siguienteInstruccion() {
        instruccion = listaInstrucciones.siguienteInstruccion();
        resetTiempo();
        if(!listaInstrucciones.hasNext()) {
            nivelTerminado = true;
        }
    }

}
