
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

/**
 *
 * @author Fer
 */
public class MenuPrincipal extends GameCanvas {

    private AppAsili midlet;
    private int ANCHO, ALTO;
    private Graphics g;
    private FondoMenu fondo;
    private SpriteInicio spriteInicio;
    private Animador animador;

    public MenuPrincipal(AppAsili midlet) {
        super(true);

        this.midlet = midlet;
        this.setFullScreenMode(true);
        this.ANCHO = this.getWidth();
        this.ALTO = this.getHeight();
        g = this.getGraphics();
        try {
            spriteInicio = new SpriteInicio(0, 3);
            fondo = new FondoMenu();
        } catch (IOException ex) {
            System.out.println("Error de IO");
            ex.printStackTrace();
        }
        animador = new Animador(this);
        animador.iniciar();


    }
    //comprobación de cajas (Qué opción de seleccionó)

    protected void pointerPressed(int aX, int aY) {
        if (aX >= (spriteInicio.getX()) && aX <= (spriteInicio.getX() + spriteInicio.getWidth())
                && aY >= spriteInicio.getY() && aY <= (spriteInicio.getY() + spriteInicio.getHeight())) {
            midlet.actualizarApp(1);
        }


    }

    public void dibujar(){
        fondo.dibujar(g);
        spriteInicio.dibujar(g);
    }

    public void actualizar(){
       // fondo.actualizar();
        //spriteInicio.actualizar();
    }
}
