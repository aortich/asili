
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
public class Avatar extends Sprite{

    private int anchoPantalla;
    private int altoPantalla;
    private int INC_X, INC_Y;
    private int contadorPowerUps;
    private boolean escudoActivado;
    private int vidas;
    private int cargaSolar;
    private AdministradorJuego administrador;


    public Avatar(int ancho, int alto, int x, int y, String archivo) throws IOException {

        super (Image.createImage(archivo),ancho,alto);
        setPosition(x, y);
        contadorPowerUps = 0;
        escudoActivado = false;
        vidas = 3;
        cargaSolar = 10;
    }

    public void dibujar(Graphics g) {

        super.paint(g);
    }

    public void actualizarPosicion(int x, int y) {
        setPosition(x, y);
    }

    public void disparar() {
        if(administrador.getPointIsDragged() == true) {
            //Dispara
        }
    }






}
