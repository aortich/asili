/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

/**
 *
 * @author Alberto Ortiz
 */
public class EnemigoSpawner {
    private Reloj sincroReloj;
    public Instruccion instruccionActual, instruccionSiguiente;
    public boolean horaDeInvocar;

    public int getTiempo() {
        return sincroReloj.getTiempo();
    }

    public void actualizar(int tiempo) {
       sincroReloj.incrementar(tiempo);
    }


    public boolean horaDeInvocar() {
        if(this.instruccionActual.tiempoAparicion <= this.sincroReloj.getTiempo())
            return true;
        else
            return false;
    }

    public Instruccion enviarInstrucion() {
        return this.instruccionActual;
    }


    





}
