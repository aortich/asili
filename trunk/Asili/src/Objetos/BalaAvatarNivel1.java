package Objetos;


import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Las balas principales del avatar.
 * @author Alberto Ortiz
 */
public class BalaAvatarNivel1 extends Proyectil{

    /**
     * El constructor de la clase, toma una posición, y pide una imágen.
     * @param x
     * @param y
     * @param imagen - La impagen que usará a bala
     */
    public BalaAvatarNivel1(int x, int y, Image imagen) {
        super(0, -5, x, y, 1, 30, 30,true,imagen);
        super.setPosition(x, y);
        //super.setRefPixelPosition(this.getWidth()/2, this.getHeight());
    }

    /**
     * Dibuja a la bala
     * @param g - Permite dibujar
     */
    public void dibujar(Graphics g) {
        super.paint(g);
    }
    
    /**
     * Actualiza la bala, su posición, y su estado
     */
    public void actualizar() {
        super.actualizar();
    }


}
