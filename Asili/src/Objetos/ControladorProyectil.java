package Objetos;


import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.Sprite;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * El controlador que administra, dibuja y actualiza a los proyectiles
 * @author Alberto Ortiz
 */
public class ControladorProyectil {

    private Vector contenedor;

    /**
     * El metodo constructor que crea un nuevo vector
     */
    public ControladorProyectil() {
        this.contenedor = new Vector();
    }

    /**
     * Regresa el tamaño actual del Vector
     * @return - El tamaño actual del vector
     */
    public int getSize(){
        return this.contenedor.size();
    }

    /**
     * Regresa el proyectil dada una posición
     * @param index - El lugar del proyectil que se desea obtener
     * @return - El proyectil en el lugar especificado por el parámetro
     */
    public Proyectil proyectilAt(int index){
        return (Proyectil)this.contenedor.elementAt(index);
    }

    public void vaciarControlador() {
        this.contenedor.removeAllElements();
    }


    /**
     * Agrega un proyectil al Vector
     * @param proyectil - El proyectil que se ha de agregar
     */
    public void AgregarProyectil(Proyectil proyectil) {
        this.contenedor.addElement(proyectil);
    }

    /**
     * Borra el proyectil indicado
     * @param proyectil - EL proyectil que se borrará
     */
    public void BorrarProyectil(Proyectil proyectil) {
        this.contenedor.removeElement(proyectil);
    }
    

    /**
     * Dibuja todos los proyectiles que estan dentro del Vector
     * @param g - Permite dibujar
     */
    public void dibujar(Graphics g) {
        for(int i = 0; i < this.contenedor.size() - 1; i++) {
            Proyectil temporal = (Proyectil) this.contenedor.elementAt(i);
            temporal.dibujar(g);
        }
    }

    /**
     * Actualiza la posición y estado de todos los proyectiles en el Vector
     */
    public void actualizar() {
        for(int i = 0; i < this.contenedor.size() - 1; i++) {
            Proyectil temporal = (Proyectil) this.contenedor.elementAt(i);
            temporal.actualizar();
            if(temporal.impacto || temporal.fueraDeLimites) {
                this.contenedor.removeElementAt(i);
            }
        }
    }


    /**
     * Regresa un String con la información del tamaño, con objetivos de prueba
     * @return - Un hilo con el tamaño del Vector
     */
    public String toString() {
        return this.contenedor.size() + "";
    }



}



