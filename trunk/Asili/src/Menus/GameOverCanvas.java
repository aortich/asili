package Menus;




import Main.Animador;
import Main.AppAsili;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;


/**
 *Canvas de Game Over
 * @author Fernando Moreno
 */
public class GameOverCanvas extends GameCanvas {


    private AppAsili midlet;
    private Graphics g;
    private FondoMenu fondo;
    private Animador animador;

    /**
     *
     * @param midlet - El midlet AppAsili que controla el display
     */
    public GameOverCanvas(AppAsili midlet) {
        super(true);


        this.midlet = midlet;
        this.setFullScreenMode(true);
        g = this.getGraphics();
        try {
            fondo = new FondoMenu("/imagenes/gameOver.jpg");
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
       midlet.actualizarApp(6);
       animador.detener();


    }


    /**
     * El método que dibuja el Game Over en la pantalla
     */
    public void dibujar(){
        fondo.dibujar(g);
        this.flushGraphics();


    }

    /**
     * EL método actualizar
     */
    public void actualizar() {


    }
}