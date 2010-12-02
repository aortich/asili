/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Objetos;

import Main.Asili;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author Alberto Ortiz
 */
public class PowerUp extends Sprite {
    
    Image estadoBala;
    Image estadoEscudo;
    Image estadoBomba;
    boolean estaEnBala, estaEnEscudo, destruido;
    int tiempo, x, y;

    public PowerUp (Image estadoBala, Image estadoEscudo, Image estadoBomba, int x, int y) {
        super(estadoBala);
        this.setPosition(x, y);
        this.estaEnBala = true;
        this.estaEnEscudo = false;
        this.estadoBala = estadoBala;
        this.estadoEscudo = estadoEscudo;
        this.estadoBomba = estadoBomba;
        this.tiempo = 0;
        this.x = 1; this.y = 1;

    }
    
    public void actualizar(int tiempo) {
        this.tiempo = this.tiempo + tiempo;
        if(this.tiempo == 300){
            this.cambiarEstado();
            this.tiempo = 0;
        }
        
        this.move(x, y);


    }

    public void cambiarEstado() {
        if(this.estaEnBala) {
            this.setImage(estadoEscudo, 100, 100);
            this.estaEnBala = false;
            this.estaEnEscudo = true;
        }

        if(this.estaEnEscudo) {
            this.setImage(estadoBala, 100, 100);
            this.estaEnBala = true;
            this.estaEnEscudo = false;
        }

    }

    public void dibujar(Graphics g){
        this.paint(g);
    }
    
    public void destruir(boolean destruir) {
        this.destruido = destruir;
    }

    public void detectarLimites() {
        if(this.getX() > Asili.ANCHO || this.getY() > Asili.ALTO)
            this.destruir(true);
    }

}
