package Menus;


import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;


public class SpriteInstrucciones extends Sprite{


    public SpriteInstrucciones(int x, int y) throws IOException {
        super (Image.createImage("/imagenes/instruccionesSprite.png"),360, 50);
        setPosition(0, 300);
        super.setFrame(0);
        //super.setFrameSequence(new int [] {0, 1});

    }

    public void dibujar(Graphics g) {

        super.paint(g);
    }


}
