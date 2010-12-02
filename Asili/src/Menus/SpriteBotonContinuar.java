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
 *EL Sprite del boton de continuar
 * @author Alberto Ortiz
 */
public class SpriteBotonContinuar extends Sprite {

    /**
     * El constructor, que toma la imágen y toma la posición indicada
     */
    public SpriteBotonContinuar(Image imagen) {
        super(imagen);
        setPosition(Asili.ANCHO/2, (Asili.ALTO/2));
    }

    /**
     * Dibuja el sprite
     * @param g - Permite dibujar
     */
    public void dibujar(Graphics g) {
        paint(g);
    }

}
