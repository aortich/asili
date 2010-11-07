package Objetos;


import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fer
 */
public class Enemigo extends Sprite {

    boolean destruido;
    int idleTime;
    int tiempoActual;

    public Enemigo(int ancho, int alto, int idleTime, Image imagen) {
        super(imagen,ancho,alto);
        this.destruido = false;
        this.idleTime = idleTime;
        this.tiempoActual = 0;
    }

    public void dibujar(Graphics g) {
        super.paint(g);
    }

    public void actualizar() {
        move(3, -3);
    }

    public void destruir(boolean destruido) {
       System.out.println(this.destruido);
        this.destruido = destruido;
    }

    
}
