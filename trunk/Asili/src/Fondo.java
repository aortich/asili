
import java.io.IOException;
import javax.microedition.lcdui.Image;


public class Fondo {
    private Image imagen;
    private int x, y;
    private int scrollSpeed;

    public Fondo (String archivo, int speed) throws IOException {
        imagen = Image.createImage(archivo);
        this.x = 0;
        this.y = 0;
        this.scrollSpeed = speed;

    }

    public void dibujar(Graphics g) {

        super.paint(g);
    }

        public void actualizar() {

        this.y = y - scrollSpeed;
        if ( this.y<=-imagen.getHeight()) { // Si ya se salió completamente la imagen
            y=0;    // Repetir
        }
    }
}
