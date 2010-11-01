/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

/**
 *
 * @author Alberto Ortiz
 */
public class Instruccion {

    public String tipoEnemigo;
    public int tiempoAparicion;
    public int idleTime;

    public Instruccion(String enemigo, int aparicion, int idle){
        this.tipoEnemigo = enemigo;
        this.tiempoAparicion = aparicion;
        this.idleTime = idle;
    }

    int getTiempoAparicion() {
        return this.tiempoAparicion;
    }

    String getTipoEnemigo() {
      return this.tipoEnemigo;
    }

    int getIdleTime() {
      return this.idleTime;
    }


}
