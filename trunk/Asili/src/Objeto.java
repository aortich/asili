
import java.io.IOException;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;


/**
 *
 * @author Fer
 */
public class Objeto extends Sprite {

    private int INC_X, INC_Y;

    public Objeto(String archivo) throws IOException {
        super(Image.createImage(archivo));
    }
}
