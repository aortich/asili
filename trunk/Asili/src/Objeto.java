
import java.io.IOException;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;


/**
 *
 * @author Fer
 */
public class Objeto extends Sprite {

    private int x, y;
    

    public Objeto(int x, int y, String archivo) throws IOException {
        super(Image.createImage(archivo));
        this.x = x;
        this.y = y;
    }
}
