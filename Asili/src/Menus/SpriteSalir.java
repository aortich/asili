package Menus;


import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;


/**
 * El sprite que Sale de la aplicación
 * @author Alberto Ortiz
 */
public class SpriteSalir extends Sprite{


    /**
     * El método constructor, que toma la ruta de la imágen, para crear una, y toma una posición inicial
     * @param x
     * @param y
     * @throws IOException
     */
    public SpriteSalir(int x, int y) throws IOException {
        super (Image.createImage("/imagenes/salirSprite.png"),360, 50);
        setPosition(0, 590);
        super.setFrame(0);
        //super.setFrameSequence(new int [] {0, 1});

    }

    /**
     *Dibuja el sprite
     * @param g - Permite dibujar
     */
    public void dibujar(Graphics g) {

        super.paint(g);
    }


}
