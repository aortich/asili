
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
public class Proyectil extends Sprite {

    public Proyectil(String archivo) throws IOException {
        super(Image.createImage(archivo));
    }

    public void dibujar(Graphics g) {

        super.paint(g);
    }
}
