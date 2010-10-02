
import java.io.IOException;
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
public class Enemigo extends Sprite {

    public Enemigo(int ancho, int alto, String archivo) throws IOException {
        super(Image.createImage(archivo),ancho,alto);
    }
}
