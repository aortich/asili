package Menus;


import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;


/**
 * El sprite que conduce al Canvas de Instrucciones
 * @author Alberto Ortiz
 */
public class SpriteInstrucciones extends Sprite{


    /**
     * Metodo constructor que crea una imágen a partir de una ruta, y toma su posición indicada
     * @param x
     * @param y
     * @throws IOException
     */
    public SpriteInstrucciones(int x, int y) throws IOException {
        super (Image.createImage("/imagenes/instruccionesSprite.png"),360, 50);
        setPosition(0, 300);
        super.setFrame(0);
        //super.setFrameSequence(new int [] {0, 1});

    }

    /**
     * Pinta el sprite
     * @param g - Permite dibujar
     */
    public void dibujar(Graphics g) {

        super.paint(g);
    }


}
