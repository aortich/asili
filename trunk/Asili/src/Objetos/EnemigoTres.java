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
public class EnemigoTres extends Enemigo {

    boolean haDisparado, estadoDerecha;
    Image bala;
    int vuelta, velH, velV, velBalaV, velBalaH;

    public EnemigoTres(int x, int y, int ancho, int alto, int idleTime, Image imagen, Image imagenBala) {
        super(x, y, ancho, alto, idleTime, imagen);
        this.setPosition(x, y);
        this.bala = imagenBala;
        estadoDerecha = true;
        this.velBalaV = 0;
        this.velBalaH = 0;
        this.velH = 4;
        this.velV = 3;
        this.setFrame(3);
        this.haDisparado = false;
    }

    public void actualizar(int avatarX, int avatarY, int retardo) {
        this.apuntar(avatarX, avatarY);
        this.tiempoActual += retardo;
        this.vuelta += retardo;
        if(this.vuelta > 250) {
            if(estadoDerecha) {
                velH = -4;
                estadoDerecha = !estadoDerecha;
                this.setFrame(0);
            } else {
                velH = 4;
                estadoDerecha = !estadoDerecha;
                this.setFrame(2);
            }
        }
        if(tiempoActual > this.idleTime) {
            this.disparar();
            boolean haDisparado = true;
        }
    }

    public void apuntar(int avatarX, int avatarY) {
        if (avatarX > this.getX()) {
            this.velH = 4;
        } else {
            this.velH = -4;
        }

        if (avatarY > this.getY()) {
            this.velV = 4;
        } else {
            this.velV = -4;
        }
    }


    public void disparar() {
         if(!haDisparado)
            Asili.controladorProyectiles.AgregarProyectil(new BalaEnemigo(this.velH, this.velV, (this.getX() + ((this.getWidth() / 2))), this.getY(), 1, 30, 30, this.bala));
    }

}
