package Objetos;


import Main.Asili;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


public class Fondo {
    private Image imagen;
    private int x, y;
    private int scrollSpeed;

    public Fondo (String archivo, int speed) throws IOException {
        imagen = Image.createImage(archivo);
        this.x = 0;
        this.y = (-imagen.getHeight() + Asili.ALTO);
        this.scrollSpeed = speed;

    }

    public void dibujar(Graphics g) {

        g.drawImage(imagen, x, y, Graphics.LEFT|Graphics.TOP);

        if( y > (0)) {
            g.drawImage(imagen, x, y = imagen.getHeight(), Graphics.LEFT|Graphics.TOP);
        }

    }

        public void actualizar() {

        this.y = this.y + scrollSpeed;
        if ( this.y>=(0)) { // Si ya se salió completamente la imagen
            //System.out.println(y);
            y=(-imagen.getHeight() + Asili.ALTO);
            //System.out.println(y);
        }
    }
}
