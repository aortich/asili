package Objetos;


import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.Sprite;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alberto Ortiz
 */
public class ControladorProyectil {

    private Vector contenedor;

    public ControladorProyectil() {
        this.contenedor = new Vector();
    }


    public void AgregarProyectil(Proyectil proyectil) {
        this.contenedor.addElement(proyectil);
    }

    public void BorrarProyectil(Proyectil proyectil) {
        this.contenedor.removeElement(proyectil);
    }
    

    public void dibujar(Graphics g) {
        for(int i = 0; i < this.contenedor.size() - 1; i++) {
            Proyectil temporal = (Proyectil) this.contenedor.elementAt(i);
            temporal.dibujar(g);
        }
    }

    public void actualizar() {
        for(int i = 0; i < this.contenedor.size() - 1; i++) {
            Proyectil temporal = (Proyectil) this.contenedor.elementAt(i);
            temporal.actualizar();
            if(temporal.impacto || temporal.fueraDeLimites) {
                this.contenedor.removeElementAt(i);
            }
        }
    }

    public void detectarColisiones(Sprite sprite) {
         for(int i = 0; i < this.contenedor.size() - 1; i++) {
             Proyectil temporal = (Proyectil) this.contenedor.elementAt(i);
             if(temporal.collidesWith(sprite, false))
                temporal.detectarColision(true);
         }
    }

    public String toString() {
        return this.contenedor.size() + "";
    }



}



