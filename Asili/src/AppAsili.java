

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

     
    public AppAsili() {

        try {
            imagen = Image.createImage("/imagenes/logoTec.jpg");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
        asili = new Asili(this);
        splash= new Alert("ITESM CEM","ITESM CEM",imagen,null);
        splash.setTimeout(5000);
        
        ///Probablemente aquí haya que ponerle un modo de fullscreen
    }
    public void startApp() {

         Display.getDisplay(this).setCurrent(splash);
         try {
             Thread.sleep(5000);
         }
         catch (InterruptedException ex) {
             ex.printStackTrace();          }
        Display.getDisplay(this).setCurrent(asili);

        

    }


    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
