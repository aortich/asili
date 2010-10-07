

import java.io.IOException;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.*;

/**
 * @author Fer
 */
public class AppAsili extends MIDlet {

    private Asili asili;
    private Alert splash;
    private Image imagen;
    private MenuPrincipal menuPrincipal;
    public Display display;
     
    public AppAsili() {

        try {
            imagen = Image.createImage("/imagenes/logoTec.jpg");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        display = Display.getDisplay(this);
        //asili = new Asili(this);
        menuPrincipal= new MenuPrincipal (this);
        asili = new Asili (this);
        splash= new Alert("ITESM CEM","ITESM CEM",imagen,null);
        splash.setTimeout(5000);
        
        ///Probablemente aquí haya que ponerle un modo de fullscreen
    }
    public void startApp() {

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
