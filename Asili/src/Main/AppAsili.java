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
        splash= new SplashScreenTEC(this);
        asili = null;
        tramaCanvas = null;
        instruccionesCanvas = null;
        hiScores = null;
        creditosCanvas = null;
        
       
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
            case 1:
                 try {
                    asili = new Asili(this);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                display.setCurrent(asili);

                splash = null;
                tramaCanvas = null;
                menuPrincipal = null;
                instruccionesCanvas = null;
                hiScores = null;
                creditosCanvas = null;
                
                break;
            case 2:
                tramaCanvas= new TramaCanvas(this);
                display.setCurrent(tramaCanvas);

                asili = null;
                splash = null;
                instruccionesCanvas = null;
                hiScores = null;
                menuPrincipal = null;
                creditosCanvas = null;

                break;
            case 3:
                instruccionesCanvas = new InstruccionesCanvas(this);
                display.setCurrent (instruccionesCanvas);

                asili = null;
                splash = null;
                tramaCanvas = null;
                hiScores = null;
                menuPrincipal = null;
                creditosCanvas = null;

                break;
            case 4:
                hiScores = new HiSCanvas(this);
                display.setCurrent (hiScores);

                asili = null;
                splash = null;
                tramaCanvas = null;
                instruccionesCanvas = null;
                menuPrincipal = null;
                creditosCanvas = null;

                break;
            case 5:
                creditosCanvas = new CreditosCanvas (this);
                display.setCurrent (creditosCanvas);

                asili = null;
                splash = null;
                tramaCanvas = null;
                menuPrincipal = null;
                instruccionesCanvas = null;
                hiScores = null;

                break;
            case 6:
                menuPrincipal = new MenuPrincipal(this);
                display.setCurrent(menuPrincipal);

                asili = null;
                splash = null;
                tramaCanvas = null;
                instruccionesCanvas = null;
                hiScores = null;
                creditosCanvas = null;

                break;
            default:
                break;
        }
    }


    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
