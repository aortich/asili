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
public class ControladorEnemigos {

    private Vector contenedor;

    public ControladorEnemigos() {
        this.contenedor = new Vector();
    }


    public void AgregarEnemigo(Enemigo enemigo) {
        this.contenedor.addElement(enemigo);
    }

    public void BorrarProyectil(Enemigo enemigo) {
        this.contenedor.removeElement(enemigo);
    }


    public void dibujar(Graphics g) {
        for(int i = 0; i < this.contenedor.size() - 1; i++) {
            Enemigo temporal = (Enemigo) this.contenedor.elementAt(i);
            temporal.dibujar(g);
        }
    }

    public void actualizar() {
        for(int i = 0; i < this.contenedor.size() - 1; i++) {
            Enemigo temporal = (Enemigo) this.contenedor.elementAt(i);
            temporal.actualizar();
            if(temporal.destruido) {
                this.contenedor.removeElementAt(i);
            }
        }
    }

    public void detectarColisiones(Sprite sprite) {
        for(int i = 0; i < this.contenedor.size() - 1; i++) {
            Enemigo temporal = (Enemigo) this.contenedor.elementAt(i);
            if(temporal.collidesWith(sprite, false)){
                temporal.destruir(true);

            }
        }
    }

    public String toString() {
        return this.contenedor.size() + "";
    }



}



