package Menus;


import Main.Animador;
import Main.AppAsili;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

/**
 * El canvas que contiene las instrucciones
 * @author Alberto Ortiz
 */
public class InstruccionesCanvas extends GameCanvas {

    private AppAsili midlet;
    private Graphics g;
    private FondoMenu fondo;
    private Animador animador;



    /**
     * El método constructor
     * @param midlet - El midlet que controla el display actual
     */
    public InstruccionesCanvas(AppAsili midlet) {
        super(true);

        this.midlet = midlet;
        this.setFullScreenMode(true);
        g = this.getGraphics();
        try {
            fondo = new FondoMenu("/imagenes/instrucciones.jpg");
        } catch (IOException ex) {
            System.out.println("Error de IO en clase InstruccionesCanvas");
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
     * EL método que dibuja el Canvas
     */
    public void dibujar(){
        fondo.dibujar(g);
        flushGraphics();

    }
    /**
     * El método que actualiza el Canvas
     */
    public void actualizar(){


    }
}