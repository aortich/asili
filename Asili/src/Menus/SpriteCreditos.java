package Menus;


import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;


/**
 * El sprite que conduce al Canvas de Creditos
 * @author Alberto Ortiz
 */
public class SpriteCreditos extends Sprite{


    /**
     * El método constructor, que toma la ruta de la imágen, para crear una, y toma una posición inicial
     * @param x
     * @param y
     * @throws IOException
     */
    public SpriteCreditos(int x, int y) throws IOException {
        super (Image.createImage("/imagenes/creditosSprite.png"),360, 50);
        setPosition(0, 400);
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
