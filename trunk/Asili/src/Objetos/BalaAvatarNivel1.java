package Objetos;


import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class BalaAvatarNivel1 extends Proyectil{

    public BalaAvatarNivel1 (int x, int y, Image imagen) throws IOException {
        super(0, 5, x, y, 1, 30, 30, imagen);
        super.setTransform(TRANS_MIRROR_ROT270);
        super.setRefPixelPosition(this.getWidth()/2, this.getHeight());
    }

    public void dibujar(Graphics g) {
        super.paint(g);
    }
    
    public void actualizar() {
        super.actualizar();
    }

}