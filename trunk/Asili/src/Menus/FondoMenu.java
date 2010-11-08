package Menus;


import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *El fondo del menu
 * @author Alberto Ortiz
 */
public class FondoMenu {

    private Image imagen;

    /**
     *
     * @param archivo - El archivo con la ruta hacia la imágen que se va a usar
     * @throws IOException - Excepción de entrada y salida, si existiese un problema con la ruta del archivo.
     */
    public FondoMenu(String archivo) throws IOException {
        imagen = Image.createImage(archivo);
    }

    /**
     *
     * @param g - Usado para dibujar
     */
    public void dibujar(Graphics g) {
        g.drawImage(imagen, 0, 0, Graphics.LEFT|Graphics.TOP);
    }
}
