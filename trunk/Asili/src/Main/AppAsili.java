package Main;



import Menus.MenuPrincipal;
import Menus.SplashScreenTEC;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

/**
 * @author Fer
 */
public class AppAsili extends MIDlet {

    private Asili asili;
    private SplashScreenTEC splash;
    private MenuPrincipal menuPrincipal;
    public Display display;
     
    public AppAsili() {

        display = Display.getDisplay(this);
        menuPrincipal= new MenuPrincipal (this);
        asili = new Asili (this);
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
            case 1:
                display.setCurrent(asili);
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
