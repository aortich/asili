package Menus;


import Main.Animador;
import Main.AppAsili;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

/**
 * El canvas de la trama
 * @author Alberto Ortiz
 */
public class TramaCanvas extends GameCanvas {

    private AppAsili midlet;
    private Graphics g;
    private FondoMenu fondo;
    private Animador animador;

    

    /**
     * El constructor
     * @param midlet - El midlet AppAsili, que controla el display, entre otras cosas.
     */
    public TramaCanvas(AppAsili midlet) {
        super(true);

        this.midlet = midlet;
        this.setFullScreenMode(true);
        g = this.getGraphics();
        try {
            fondo = new FondoMenu("/imagenes/trama.jpg");
        } catch (IOException ex) {
            System.out.println("Error de IO en clase TramaCanvas");
            ex.printStackTrace();
        }


        animador = new Animador(this);
        animador.iniciar();
        
        


    }
   

    /**
     *
     * @param aX - La coordenada X del stylus
     * @param aY - La coordenada Y del stylus
     */
    protected void pointerPressed(int aX, int aY) {
       midlet.actualizarApp(6);
       animador.detener();
        
    }

    /**
     * Dibuja el Canvas
     */
    public void dibujar(){
        fondo.dibujar(g);
        this.flushGraphics();

    }
    /**
     * Actualiza el canvas
     */
    public void actualizar(){

       
    }
}