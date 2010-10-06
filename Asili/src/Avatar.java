
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
 */
public class Avatar extends Sprite{

    private int anchoPantalla;
    private int altoPantalla;
    private int INC_X, INC_Y;
    private int contadorPowerUps;
    private boolean escudoActivado;
    private int vidas;
    private int cargaSolar;
    private Asili asili;


    public Avatar(int x, int y) throws IOException {

        super (Image.createImage("/imagenes/avatarSprite.png"),100, 100);
        super.defineReferencePixel(this.getWidth()/2, this.getHeight()/2);
        setPosition(x, y);
        
        super.setFrame(2);
        super.setFrameSequence(new int [] {0, 1, 2, 3, 4});
        contadorPowerUps = 0;
        escudoActivado = false;
        vidas = 3;
        cargaSolar = 10;
        this.INC_X = 0;
        this.INC_Y = 0;
    }

    public void dibujar(Graphics g) {

        super.paint(g);
    }

    public void setINCX(int INCX) {
        this.INC_X = INCX;
    }

        public void setINCY(int INCY) {
        this.INC_Y = INCY;
    }

    public void mover() {
        if(INC_X > this.getX()) {
            super.setFrame(3);
        }
        if(INC_X < this.getX()) {
            super.setFrame(1);
        }
        setPosition(INC_X, INC_Y);
    }

    public int getCargaSolar() {
        return cargaSolar;
    }

    public void setCargaSolar(int cargaSolar) {
        this.cargaSolar = cargaSolar;
    }

    public int getContadorPowerUps() {
        return contadorPowerUps;
    }

    public void setContadorPowerUps(int contadorPowerUps) {
        this.contadorPowerUps = contadorPowerUps;
    }

    public boolean isEscudoActivado() {
        return escudoActivado;
    }

    public void setEscudoActivado(boolean escudoActivado) {
        this.escudoActivado = escudoActivado;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    /*
    public void disparar() {
        if(asili.getPointIsDragged() == true) {
            //Dispara
        }
    }*/

    






}
