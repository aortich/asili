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
 *
 * @author Fer
 */
public class Proyectil extends Sprite {

    int dano;
    boolean impacto, fueraDeLimites, pertenecenAvatar;
    int velocidadHorizontal;
    int velocidadVertical;

    public Proyectil(int velocidadH, int velocidadV, int x, int y, int dano, int ancho, int alto, boolean pertenencia, Image imagen) {
        super(imagen, ancho, alto);
        this.velocidadHorizontal = velocidadH;
        this.pertenecenAvatar = pertenencia;
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
        this.detectarLimites();
    }

    public boolean perteneceAAvatar(){
        return this.pertenecenAvatar;
    }
    
    public void detectarColision(boolean colision) {
        this.impacto = colision;
    }

    public void detectarLimites(){
        if(this.getX() > Asili.ANCHO || this.getX() < 0 || this.getY() > Asili.ALTO || this.getY() < 0)
            this.fueraDeLimites = true;
    }
}
