package Menus;


import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;


public class SpriteTrama extends Sprite{


    public SpriteTrama(int x, int y) throws IOException {
        super (Image.createImage("/imagenes/tramaSprite.png"),360, 50);
        setPosition(0, 250);
        super.setFrame(0);
        //super.setFrameSequence(new int [] {0, 1});

    }

    public void dibujar(Graphics g) {

        super.paint(g);
    }


}
