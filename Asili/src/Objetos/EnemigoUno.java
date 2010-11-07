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
public class EnemigoUno extends Enemigo {

    public EnemigoUno(int ancho, int alto, int idleTime, Image imagen) {
        super(ancho, alto, idleTime, imagen);
        this.setRefPixelPosition(ancho/2, alto);

    }

    public void actualizar() {
        super.move(1, 2);
    }

    public void apuntar(int avatarX, int avatarY) {
      
    }


}
