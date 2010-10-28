package Main;



import Menus.CreditosCanvas;
import Menus.HiSCanvas;
import Menus.InstruccionesCanvas;
import Menus.MenuPrincipal;
import Menus.SplashScreenTEC;
import Menus.TramaCanvas;
import java.io.IOException;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

/**
 * @author Fer
 */
public class AppAsili extends MIDlet {

    private Asili asili;
    private SplashScreenTEC splash;
    private MenuPrincipal menuPrincipal;
    private TramaCanvas tramaCanvas;
    private InstruccionesCanvas instruccionesCanvas;
    private HiSCanvas hiScores;
    private CreditosCanvas creditosCanvas;
    public Display display;
     
    public AppAsili() {

        display = Display.getDisplay(this);
        menuPrincipal= new MenuPrincipal (this);

        
        //crear el juego solo cuando se va a usar
        try {
            asili = new Asili(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            asili = new Asili(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        splash= new SplashScreenTEC(this);
        
       
    }
    public void startApp() {

         display.setCurrent(splash);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
         display.setCurrent(menuPrincipal);


    }

    public void actualizarApp(int opcion) {
        switch(opcion){
            case 0:
                display.setCurrent(menuPrincipal);
                break;
            case 1:
                display.setCurrent(asili);
                break;
            case 2:
                tramaCanvas= new TramaCanvas(this);
                display.setCurrent(tramaCanvas);
                break;
            case 3:
                instruccionesCanvas = new InstruccionesCanvas(this);
                display.setCurrent (instruccionesCanvas);
                break;
            case 4:
                hiScores = new HiSCanvas(this);
                display.setCurrent (hiScores);
                break;
            case 5:
                creditosCanvas = new CreditosCanvas (this);
                display.setCurrent (creditosCanvas);
            
            default:
                break;
        }
    }


    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
