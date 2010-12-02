/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Audio;

import java.io.IOException;
import java.io.InputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;

/**
 *
 * @author Alberto Ortiz
 */
public class AdministradorSonidos {

    private Player p;
    private boolean reproduciendo;

    public AdministradorSonidos() {
        reproduciendo = false;
    }

    public void Reproducir(String archivo) {
        try {
            if (p != null) {
                p.stop();
                p.deallocate();
                p = null;
                reproduciendo = false;
            }
            InputStream input = getClass().getResourceAsStream(archivo);
            Player p = Manager.createPlayer(input, "audio/sp-midi");
            p.realize();
            p.prefetch();
            p.start();
            reproduciendo = true;



        } catch (MediaException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }



    }

    public void parar() {
        try {
            p.stop();
        } catch(MediaException ex) {
            ex.printStackTrace();
        }
        p.deallocate();
        p = null;
        reproduciendo = false;
    }

    public boolean estaReproduciendo() {
        return reproduciendo;
    }
}
