
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
public class Proyectil extends Sprite {

    int dano;
    boolean impacto, fueraDeLimites;
    int velocidadHorizontal;
    int velocidadVertical;

    public Proyectil(int velocidadH, int velocidadV, int x, int y, int dano, int ancho, int alto, String archivo) throws IOException {
        super(Image.createImage(archivo), ancho, alto);
        this.velocidadHorizontal = velocidadH;
        this.impacto = false; this.fueraDeLimites = false;
        this.velocidadVertical = velocidadV;
        super.setPosition(x, y);
        super.setRefPixelPosition(this.getWidth() / 2, this.getHeight());
        this.dano = dano;
    }

    public void dibujar(Graphics g) {

        super.paint(g);
    }

    public void actualizar() {
        super.move(this.velocidadHorizontal, this.velocidadVertical);
        if ((this.getY() + this.getHeight()) > Asili.ALTO || this.getY() - this.getHeight() < Asili.ALTO
                || this.getX() + this.getWidth() > Asili.ANCHO || this.getX() - this.getWidth() < Asili.ANCHO ) {
            fueraDeLimites = true;
        }
    }
}
