
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
public class Avatar extends Sprite{

    private int anchoPantalla;
    private int altoPantalla;
    private int INC_X, INC_Y;


    public Avatar(int x, int y, String archivo) throws IOException {

        super ( Image.createImage(archivo));
        //this.x = x;
        //this.y = y;
        setPosition(x, y);

//        this.ancho = ancho;
//        this.alto = alto;
        INC_X = 3;
        INC_Y = 0;
    }
}
