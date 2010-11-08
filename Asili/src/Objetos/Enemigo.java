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
 * Los enemigos del juego, que disparan y destruyen al avatar
 * @author Fer
 */
public class Enemigo extends Sprite {

    boolean destruido;
    int idleTime;
    int tiempoActual;

    /**
     *
     * @param ancho El ancho del sprite
     * @param alto El alto del sprite
     * @param idleTime El tiempo que el enemigo deberia de estar en el escenario
     * @param imagen El spritesheet del enemigo
     */
    public Enemigo(int ancho, int alto, int idleTime, Image imagen) {
        super(imagen,ancho,alto);
        this.destruido = false;
        this.idleTime = idleTime;
        this.tiempoActual = 0;
    }

    /**
     * Dibuja al enemigo
     * @param g - Permite dibujar
     */
    public void dibujar(Graphics g) {
        super.paint(g);
    }

    /**
     * Actualiza la posición del enemigo
     * @param avatarX - Para obtener la posición del avatar
     */
    public void actualizar(int avatarX) {
        move(3, -3);
    }

    /**
     * Cambia el estado del enemigo, para después ser destruido
     * @param destruido - EL estado futuro del enemigo
     */
    public void destruir(boolean destruido) {
       System.out.println(this.destruido);
        this.destruido = destruido;
    }

    
}
