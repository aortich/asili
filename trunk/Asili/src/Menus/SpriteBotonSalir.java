/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Menus;

import Main.Asili;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

/**
 * EL sprite del boton de salir
 * @author Alberto Ortiz
 */
public class SpriteBotonSalir extends Sprite {

    /**
     * El constructor que toma una imágen, y toma la posición indicada
     */
    public SpriteBotonSalir(Image imagen) {
        super(imagen);
        setPosition(this.getWidth(), (Asili.ANCHO/2) + this.getHeight());
    }
    
    /**
     * Dibuja el Sprite
     * @param g - Permite dibujar
     */
    public void dibujar(Graphics g) {
        paint(g);
    }


}
