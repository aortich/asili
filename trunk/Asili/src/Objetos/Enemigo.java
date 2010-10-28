package Objetos;


import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fer
 */
public class Enemigo extends Sprite {

    boolean destruido;

    public Enemigo(int ancho, int alto, String archivo, int [] secuencia) throws IOException {
        super(Image.createImage(archivo),ancho,alto);
        super.setFrameSequence(secuencia);
        super.setFrame(2);
    }

    public void dibujar(Graphics g) {
        super.paint(g);
    }

    public void actualizar() {
        super.move(1, 1);
    }

    public void destruir(boolean destruido) {
       this.destruido = destruido;
    }

    
}
