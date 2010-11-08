package Objetos;


import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.Sprite;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * El controlador que administra, dibuja y actualiza a los enemigos
 * @author Alberto Ortiz
 */
public class ControladorEnemigos {

    private Vector contenedor;
    private int score;

    /**
     * El metodo constructor que crea un nuevo vector
     */
    public ControladorEnemigos() {
        this.contenedor = new Vector();
        this.score = 0;
    }


    /**
     * Agrega un enemigo a la colección
     * @param enemigo - EL enemigo que se agregará
     */
    public void agregarEnemigo(Enemigo enemigo) {
        this.contenedor.addElement(enemigo);
    }

    /**
     * Regresa el tamaño actual del Vector
     * @return - El tamaño actual del vector
     */
    public int getSize() {
        return this.contenedor.size();
    }

    /**
     * Regresa el enemigo en la posición indicada en el parámetro
     * @param index - La posición del enmeigo
     * @return - EL enemigo en la posición del parámetro
     */
    public Enemigo enemigoAt(int index) {
        return (Enemigo) this.contenedor.elementAt(index);
    }

    /**
     * Borra el enemigo en la posición indicada
     * @param enemigo - El enemigo que se borrará
     */
    public void BorrarEnemigo(Enemigo enemigo) {
        this.contenedor.removeElement(enemigo);
    }


    /**
     * Dibuja a todos los enemigos en el Vector
     * @param g - Permite dibujar
     */
    public void dibujar(Graphics g) {
        for(int i = 0; i < this.contenedor.size() - 1; i++) {
            Enemigo temporal = (Enemigo) this.contenedor.elementAt(i);
            temporal.dibujar(g);
        }
    }

    public void vaciarControlador() {
        this.contenedor.removeAllElements();
    }

    /**
     * Actualiza la posición y estado de todos los enemigos en el Vector
     * @param avatarX - La posición actual de X, para realizar algunas maniobras.
     */
    public void actualizar(int avatarX) {
        for(int i = 0; i < this.contenedor.size() - 1; i++) {
            Enemigo temporal = (Enemigo) this.contenedor.elementAt(i);
            temporal.actualizar(avatarX);
            if(temporal.destruido) {
                this.score = score + temporal.valor;
                this.contenedor.removeElementAt(i);
            }
        }
    }

    public int getScore() {
        return this.score;
    }

    /**
     * Regresa un String con el tamaño, con objetivo de probar si funciona o no el controlador
     * @return - Un string con el tamaño
     */
    public String toString() {
        return this.contenedor.size() + "";
    }

}



