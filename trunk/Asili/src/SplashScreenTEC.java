
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alberto Ortiz
 */
public class SplashScreenTEC extends GameCanvas {
    private AppAsili midlet;
    private Image logoTec;
    private Graphics g;
    private Animador animador;

    public SplashScreenTEC (AppAsili midlet) {
        super(true);
        this.midlet = midlet;
        try {
            logoTec = Image.createImage("/imagenes/logoTec.jpg");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        animador = new Animador(this);
    }

    public void dibujar() {
        g.drawImage(logoTec, 0, 0, Graphics.LEFT|Graphics.TOP);
    }

    public void actualizar() {
        //TODO: Fade-outs  supongo
    }


}
