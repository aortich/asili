package Menus;


import Main.Animador;
import Main.AppAsili;
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

    /**
     * El Splash Screen con el logo del TEC
     * @param midlet - EL midlet AppAsili que controla el display
     */
    public SplashScreenTEC(AppAsili midlet) {
        super(true);
        this.midlet = midlet;
        try {
            logoTec = Image.createImage("/imagenes/logoTec.jpg");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        animador = new Animador(this);
    }

    /**
     * El método que dibuja el logo del TEC
     */
    public void dibujar() {
        g.drawImage(logoTec, 0, 0, Graphics.LEFT|Graphics.TOP);
        flushGraphics();
    }

    /**
     * El método que actualiza el Canvas
     */
    public void actualizar() {
        //TODO: Fade-outs  supongo
    }


}
