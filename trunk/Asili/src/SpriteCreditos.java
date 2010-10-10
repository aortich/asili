
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;


public class SpriteCreditos extends Sprite{


    public SpriteCreditos(int x, int y) throws IOException {
        super (Image.createImage("/imagenes/creditosSprite.png"),360, 50);
        setPosition(0, 400);
        super.setFrame(0);
        //super.setFrameSequence(new int [] {0, 1});

    }

    public void dibujar(Graphics g) {

        super.paint(g);
    }


}
