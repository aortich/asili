package Menus;


import Main.Animador;
import Main.AppAsili;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

/**
 *EL Canvas con las puntaciones más altas
 * @author Alberto Ortiz
 */
public class HiSCanvas extends GameCanvas {

    private AppAsili midlet;
    private Graphics g;
    private FondoMenu fondo;
    private Animador animador;



    /**
     *
     * @param midlet - El midlet AppAsili que controla el display
     */
    public HiSCanvas(AppAsili midlet) {
        super(true);

        this.midlet = midlet;
        this.setFullScreenMode(true);
        g = this.getGraphics();
        try {
            fondo = new FondoMenu("/imagenes/highscores.jpg");
        } catch (IOException ex) {
            System.out.println("Error de IO en clase HiSCanvas");
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
       midlet.actualizarApp(0);
       animador.detener();

    }

    /**
     * EL método que dibuja el Canvas
     */
    public void dibujar(){
        fondo.dibujar(g);
        this.flushGraphics();

    }
    //probable animación


    /**
     * El método que actualiza el canvas.
     */
    public void actualizar() {
        
    }
}