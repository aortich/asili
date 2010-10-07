
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
    
    public MenuPrincipal(AppAsili midlet) {
        super(true);

        this.midlet = midlet;
        this.setFullScreenMode(true);
        this.ANCHO = this.getWidth();
        this.ALTO = this.getHeight();
        g = this.getGraphics();
       

        try {

            fondo = new Fondo("/imagenes/menuPrincipal.jpg", 0);
           
        } catch (IOException ex) {
            System.out.println("No se pueden cargar los fondos");
            ex.printStackTrace();
        }
    

    }
    //comprobación de cajas (Qué opción de selaccionó)
    protected void pointerReleased(int x, int y) {

        //inicio
        if (y>378 && y<434){
            
        }
        //trama
        else if(y >318  && y < 378){

        }
        else if(y > 261 && y <318)
        {

        }
        else if(y > 204 && y < 261)
        {

        }
        if (y>150 && y<204){

        }
    }

}
