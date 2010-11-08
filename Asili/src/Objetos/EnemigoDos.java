/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Objetos;

import Main.Asili;
import javax.microedition.lcdui.Image;

/**
 * El Enemigo dos
 * @author Alberto Ortiz
 */
public class EnemigoDos extends Enemigo{

    int velocidadH, velocidadV;

    /**
     *
     * @param ancho El ancho del sprite
     * @param alto El alto del sprite
     * @param idleTime EL tiempo que el enemigo deberia de estar en el escenario, en milisegundos
     * @param imagen EL spritesheet del enemigo
     */
    public EnemigoDos(int ancho, int alto, int idleTime, Image imagen) {
        super(ancho, alto, idleTime, imagen);
        velocidadH = 0;
        velocidadV = 1;
        super.setFrame(1);
        this.setRefPixelPosition(ancho/2, alto);

    }

    public void actualizar(int avatarX) {
        cambiarDireccion(avatarX);
        this.move(this.velocidadH, this.velocidadV);
    }

    /**
     * Cambia la direccion del enemigo, dependiendo de la posicion del avatar, que se´envía como parmetro
     * @param avatarX - la posicion actual del avatar, enviada como parámetro.
     */
    public void cambiarDireccion(int avatarX) {
        if(avatarX > this.getX()) {
            super.setFrame(0);
            this.velocidadH = 2;
        } else if(avatarX < this.getX()) {
            super.setFrame(2);
            this.velocidadH = -2;
        } else if(avatarX == this.getX()) {
            this.velocidadH = 0;
        }
    }

    /**
     * Método que agrega proyectiles al arreglo
     */
    public void disparar() {
        Asili.controladorProyectiles.AgregarProyectil(null);
    }

}
