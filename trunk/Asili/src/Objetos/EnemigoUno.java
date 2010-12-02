/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Objetos;

import Main.Asili;
import javax.microedition.lcdui.Image;

/**
 * El enemigo Uno
 * @author Alberto Ortiz
 */
public class EnemigoUno extends Enemigo {

    int tiempo, velH, velV;
    Image bala;
    boolean haDisparado;

    public EnemigoUno(int x, int y, int ancho, int alto, int idleTime, Image imagen, Image imagenBala) {
        super(x, y, ancho, alto, idleTime, imagen);
        this.setPosition(x, y);
        int tiempo = 0;
        this.setRefPixelPosition(ancho/2, alto);
        this.setFrame(4);
        super.valor = 100;
        bala = imagenBala;

    }

    public void actualizar(int avatarX, int avatarY, int retardo) {
        if (this.detectarLimites() && this.tiempo > this.idleTime) {
            this.destruir(true);
        }
        this.apuntar(avatarX, avatarY);
        this.tiempo += retardo;
        super.move(1, 2);
        if(tiempo > idleTime/4) {
            this.disparar();
            this.haDisparado = true;
        }
    }

    public void apuntar(int avatarX, int avatarY) {
      if(avatarX > this.getX())
          this.velH = 4;
      else
          this.velH = -4;

      if(avatarY > this.getY())
          this.velV = 4;
      else
          this.velV = -4;
    }

    public void disparar() {
        if(!haDisparado)
            Asili.controladorProyectiles.AgregarProyectil(new BalaEnemigo(this.velH, this.velV, (this.getX() + ((this.getWidth() / 2))), this.getY(), 1, 30, 30, this.bala));
    }


}
