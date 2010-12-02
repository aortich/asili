/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Objetos;

import javax.microedition.lcdui.Image;

/**
 * Las balas del enemigo
 * @author Alberto Ortiz
 */
public class BalaEnemigo extends Proyectil {

    public BalaEnemigo(int velocidadH, int velocidadV, int x, int y, int dano, int ancho, int alto, Image imagen) {
        super(velocidadH, velocidadV, x, y, dano, ancho, alto, false, imagen);
        super.setPosition(x, y);
    }

}
