
import java.io.IOException;
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
public class Avatar extends Objeto{

    private int anchoPantalla;
    private int altoPantalla;
    private int INC_X, INC_Y;
    private int contadorPowerUps;
    private boolean escudoActivado;
    private int vidas;
    private int cargaSolar;
    private AdministradorJuego administrador;


    public Avatar(int x, int y, String archivo) throws IOException {

        super (x, y, archivo);
        setPosition(super.x, super.y);
        contadorPowerUps = 0;
        escudoActivado = false;
        vidas = 3;
        cargaSolar = 10;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void disparar() {
        if(administrador.getPointIsDragged() == true) {
            //Dispara
        }
    }






}
