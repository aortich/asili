

import java.io.IOException;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.*;

/**
 * @author Fer
 */
public class AppAsili extends MIDlet {

    private Asili asili;
    private Alert splash;


     
    public AppAsili() {

        asili = new Asili(this);
    }
    public void startApp() {
        splash = new Alert("");

        crearSplash();
        Display.getDisplay(this).setCurrent(asili);
        

    }

    void crearSplash() {
        try {
            Image imagen = Image.createImage("/imagenes/logoTec.jpg");
            splash.setTimeout(Alert.FOREVER);
            splash.setType(AlertType.INFO);
            splash.setImage(imagen);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        
    
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
