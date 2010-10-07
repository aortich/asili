
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;


/**
 *
 * @author Fer
 */
public class MenuPrincipal extends GameCanvas{


    private AppAsili midlet;
    private int ANCHO,ALTO;
    private Graphics g;
    private Fondo fondo;
    private SpriteInicio spriteInicio;
    

    
    public MenuPrincipal(AppAsili midlet) {
        super(true);

        this.midlet = midlet;
        this.setFullScreenMode(true);
        this.ANCHO = this.getWidth();
        this.ALTO = this.getHeight();
        g = this.getGraphics();
       

        try {
            spriteInicio = new SpriteInicio(0, 3);
            fondo = new Fondo("/imagenes/menuPrincipal.jpg", 0);

           
        } catch (IOException ex) {
            System.out.println("No se pueden cargar los fondos");
            ex.printStackTrace();
        }
    

    }
    //comprobación de cajas (Qué opción de seleccionó)
    protected void pointerPressed(int aX, int aY) {
        System.out.println("x:"+aX+"y:"+aY );
        
        }
              
        
    }

