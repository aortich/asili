package Objetos;


import Main.Asili;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * El avatar del jugador, es la nave que el controla  a través del stylus
 */
public class Avatar extends Sprite{

    private int INC_X, INC_Y;
    private int contadorPowerUps;
    private boolean escudoActivado;
    private int vidas;
    private int cargaSolar;
    private Image nave, muerte;


    /**
     *
     * @param x - Posición en el eje x del avatar
     * @param y - Posición en el eje y del avatar
     * @throws IOException  - Excepción enviada si ocurre un problema con la ruta especificada
     */
    public Avatar(int x, int y, Image imagen, Image muerte) throws IOException {

        super (imagen,100, 100);
        this.nave = imagen;
        this.muerte = muerte;
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

    /**
     * Dibuja al avatar
     * @param g - Permite dibujar
     */
    public void dibujar(Graphics g) {

        super.paint(g);
    }

    /**
     * Cambia el valor de INC_X pr el dado en el parámetro
     * @param INCX - El nuevo valor de INC_X
     */
    public void setINCX(int INCX) {
        this.INC_X = INCX;
    }

    /**
     * Cambia el valor de INC_Y pr el dado en el parámetro
     * @param INCY el nuevo valor de INC_Y
     */
    public void setINCY(int INCY) {
        this.INC_Y = INCY;
    }

        /**
         * Mueve al avatar de acuerdo a INC_X y a INC_Y. También anima al avatar.
         */
        public void mover() {
        if(INC_X > this.getX()) {
            super.setFrame(3);
        }
        if(INC_X < this.getX()) {
            super.setFrame(1);
        }
        setPosition(INC_X, INC_Y);
    }

        /**
         * Regresa la cantidad de carga solar
         * @return regresa un int con la carga solar
         */
        public int getCargaSolar() {
        return cargaSolar;
    }

    /**
     * Cambia el valor de la carga solar
     * @param cargaSolar El nuevo valor de la carga solar
     */
    public void setCargaSolar(int cargaSolar) {
        this.cargaSolar = cargaSolar;
    }

    /**
     * EL contador de power ups que tiene el jugador
     * @return el número de power ups que se han colectado
     */
    public int getContadorPowerUps() {
        return contadorPowerUps;
    }

    /**
     *
     * @param contadorPowerUps
     */
    public void setContadorPowerUps(int contadorPowerUps) {
        this.contadorPowerUps = contadorPowerUps;
    }

    /**
     * Regresa si el escudo está o no activado
     * @return - El valor del escudo.
     */
    public boolean isEscudoActivado() {
        return escudoActivado;
    }

    /**
     * Cambia el estado del escudo a cualquiera que sea especificado
     * @param escudoActivado El parámetro booleano, que sera el nuevo estado del escudo
     */
    public void setEscudoActivado(boolean escudoActivado) {
        this.escudoActivado = escudoActivado;
    }

    /**
     * El número de vidas del jugador
     * @return Un int con el número de vidas
     */
    public int getVidas() {
        return vidas;
    }

    /**
     * Cambia el número de vidas por uno especificado
     * @param vidas - El nuevo número de vidas
     */
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public void destruirAvatar() {
        this.setImage(muerte, 100, 100);
        int [] arreglo = {0, 0, 1, 1, 2, 2};
        this.setFrameSequence(arreglo);
        this.vidas--;
    }

    public void reconstruirAvatar() {
        this.setImage(nave, 100, 100);
    }


    






}
