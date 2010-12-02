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
public class EnemigoTres extends Enemigo {

    boolean haDisparado;
    Image bala;

    public EnemigoTres(int x, int y, int ancho, int alto, int idleTime, Image imagen, Image imagenBala) {
        super(x, y, ancho, alto, idleTime, imagen);
        this.setPosition(x, y);
        this.bala = imagenBala;
        this.haDisparado = false;
    }

    public void actualizar() {

    }

}
