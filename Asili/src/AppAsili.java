

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

/**
 * @author Fer
 */
public class AppAsili extends MIDlet {

    private Asili asili;
    
    public AppAsili() {

        asili = new Asili(this);
    }
    public void startApp() {

        Display.getDisplay(this).setCurrent(asili);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
