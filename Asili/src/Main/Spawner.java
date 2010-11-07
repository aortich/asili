/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;


/**
 *
 * @author Alberto Ortiz
 */
public class Spawner {

    private int tiempoActual;
    private int nivelActual;
    private Instruccion instruccion;
    private ListaInstrucciones listaInstrucciones;
    private boolean esTiempo;
    private boolean juegoTerminado;

    public Spawner(int nivel) {
        tiempoActual = 0;
        nivelActual = nivel;
        listaInstrucciones = new ListaInstrucciones();
        listaInstrucciones.llenarLista(nivelActual);
        instruccion = listaInstrucciones.siguienteInstruccion();
        esTiempo = false;
        juegoTerminado = false;
    }

    public void actualizar(int tiempo) {
        tiempoActual += tiempo;
        if(tiempoActual >= instruccion.getTiempoAparicion() )
            esTiempo = true;
    }

    public void resetTiempo() {
        tiempoActual = 0;
        esTiempo = false;
    }

    public void setNivel(int nivel) {
        this.nivelActual = nivel;
    }

    public void setTiempo(int newTiempo) {
        tiempoActual = newTiempo;
        esTiempo = true;
    }

    public boolean isTime(){
        return esTiempo;
    }

    public boolean juegoTerminado() {
        return juegoTerminado;
    }

    public Instruccion getInstruccionActual() {
        return instruccion;
    }


    public void siguienteInstruccion() {
        instruccion = listaInstrucciones.siguienteInstruccion();
        resetTiempo();
        if(instruccion == null) {
            juegoTerminado = true;
        }
    }

}
