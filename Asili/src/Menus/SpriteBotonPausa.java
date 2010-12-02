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
 * Sprite del boton de pausa
 * @author Alberto Ortiz
 */
public class SpriteBotonPausa extends Sprite {

    /**
     * EL método constructor que toma una imágen, y toma la posición indicada
     */
    public SpriteBotonPausa(Image imagen) {
        super(imagen);
        setPosition(Asili.ANCHO - this.getWidth(), 0);

    }

    /**
     * Dibuja el sprite
     * @param g - Permite dibujar el objeto actual
     */
    public void dibujar(Graphics g) {
        paint(g);
    }

}
