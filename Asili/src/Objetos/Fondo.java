package Objetos;


import Main.Asili;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


/**
 * EL fondo, con scroll automático del juego.
 * @author Alberto Ortiz
 */
public class Fondo {
    private Image imagen;
    private int x, y;
    private int scrollSpeed;

    /**
     * El constructos, que crea la imágen.
     * @param archivo La ruta del archivo que se usará como fondo
     * @param speed La velocidad de scroll del fondo
     * @throws IOException Avisa si existe un problema con la ruta o el archivo
     */
    public Fondo(String archivo, int speed) throws IOException {
        imagen = Image.createImage(archivo);
        this.x = 0;
        this.y = (-imagen.getHeight() + Asili.ALTO);
        this.scrollSpeed = speed;

    }

    /**
     * Dibuja el fondo
     * @param g - Para dibujar
     */
    public void dibujar(Graphics g) {

        g.drawImage(imagen, x, y, Graphics.LEFT|Graphics.TOP);

        if( y > (0)) {
            g.drawImage(imagen, x, y = imagen.getHeight(), Graphics.LEFT|Graphics.TOP);
        }

    }

    /**
     * Mueve el fondo, a la velocidad que marca scrollSpeed
     */
    public void actualizar() {

        this.y = this.y + scrollSpeed;
        if ( this.y>=(0)) { // Si ya se salió completamente la imagen
            //System.out.println(y);
            y=(-imagen.getHeight() + Asili.ALTO);
            //System.out.println(y);
        }
    }

    public void resetearFondo() {
        this.y = (-imagen.getHeight() + Asili.ALTO);
    }
}
