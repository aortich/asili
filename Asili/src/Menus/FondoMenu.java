package Menus;


import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alberto Ortiz
 */
public class FondoMenu {

    private Image imagen;

    public FondoMenu(String archivo) throws IOException {
        imagen = Image.createImage(archivo);
    }

    public void dibujar(Graphics g) {
        g.drawImage(imagen, 0, 0, Graphics.LEFT|Graphics.TOP);
    }
}
