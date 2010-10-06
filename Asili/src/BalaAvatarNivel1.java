
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class BalaAvatarNivel1 extends Proyectil{

    public BalaAvatarNivel1 (int x, int y) throws IOException {
        super(0, 5, x, y, 1, 30, 30, "/imagenes/Spritebala.png");
        super.setTransform(TRANS_MIRROR_ROT270);
        super.setRefPixelPosition(this.getWidth()/2, this.getHeight());
    }
    /*
    public void actualizar(int x, int y) {
        super.move(0, 5);
        if ((this.getX() + this.getHeight()) > Asili.ALTO) {
            super.impacto = true;
        }
    }
     *
     */

    

}
