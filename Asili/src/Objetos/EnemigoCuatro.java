/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Objetos;

import javax.microedition.lcdui.Image;

/**
 *
 * @author Alberto Ortiz
 */
public class EnemigoCuatro extends Enemigo {

    int tiempo, rate;
    boolean haDisparado;
    Image bala;

    public EnemigoCuatro(int x, int y, int ancho, int alto, int idleTime, Image imagen, Image imagenBala) {
        super(x, y, ancho, alto, idleTime, imagen);
        this.setPosition(x, y);
        int tiempo = 0;
        this.setRefPixelPosition(ancho/2, alto);
        super.valor = 200;
        bala = imagenBala;
    }

}
