package Menus;


import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;


/**
 * El sprite que conduce al Canvas de Highscores
 * @author Alberto Ortiz
 */
public class SpriteHighscores extends Sprite{


    /**
     * Metodo constructor que crea una imágen a partir de una ruta, y toma su posición indicada
     * @param x
     * @param y
     * @throws IOException
     */
    public SpriteHighscores(int x, int y) throws IOException {
        super (Image.createImage("/imagenes/highscoresSprite.png"),360, 50);
        setPosition(0, 350);
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
