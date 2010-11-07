/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Objetos;

import Main.Asili;
import javax.microedition.lcdui.Image;

/**
 *
 * @author Alberto Ortiz
 */
public class EnemigoTres extends Enemigo{

    int velocidadH, velocidadV;

    public EnemigoTres(int ancho, int alto, int idleTime, Image imagen) {
        super(ancho, alto, idleTime, imagen);
        int velocidadH = 0;
        int VelocidadV = 2;
        super.setFrame(1);

    }

    public void actualizar(int avatarX) {
        cambiarDireccion(avatarX);
        this.move(this.velocidadH, this.velocidadV);
    }

    public void cambiarDireccion(int avatarX) {
        if(avatarX > this.getX()) {
            super.setFrame(0);
            this.velocidadH = 2;
        } else if(avatarX < this.getX()) {
            super.setFrame(2);
            this.velocidadH = -2;
        }
    }

    public void disparar() {
        Asili.controladorProyectiles.AgregarProyectil(null);
    }

}
