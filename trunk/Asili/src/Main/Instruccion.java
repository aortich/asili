/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

/**
 *La clase instrucción, usada para administrar instrucciones
 * @author Alberto Ortiz
 */
public class Instruccion {

    /**
     * El tipo de Enemigo
     */
    public int tipoEnemigo;
    /**
     * El tiempo en milisegundos en el que aparece el Enemigo
     */
    public int tiempoAparicion;
    /**
     * EL tiempo que el enemigo puede permanecer en pantalla, antes de desaparecer
     */
    public int idleTime;

    /**
     *
     * @param enemigo - El tipo de enemigo
     * @param aparicion - El tiempo que tarda en aparecer un nuevo enemigo, en milisegundos
     * @param idle - EL tiempo en el que se queda un enemigo, antes de desaparecer.
     */
    public Instruccion(int enemigo, int aparicion, int idle){
        this.tipoEnemigo = enemigo;
        this.tiempoAparicion = aparicion;
        this.idleTime = idle;
    }

    int getTiempoAparicion() {
        return this.tiempoAparicion;
    }

    int getTipoEnemigo() {
      return this.tipoEnemigo;
    }

    int getIdleTime() {
      return this.idleTime;
    }


}
