/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Objetos;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.Sprite;

/**
 *
 * @author Alberto Ortiz
 */
public class ControladorPowerUps {

    private Vector contenedor;

    public ControladorPowerUps() {
        this.contenedor = new Vector();
    }

    public void vaciarControlador() {
        this.contenedor.removeAllElements();
    }

    public int getSize() {
        return this.contenedor.size();
    }

    public void BorrarPowerup(PowerUp powerup) {
        this.contenedor.removeElement(powerup);
    }

    public void AgregarPowerUp(PowerUp powerup) {
        this.contenedor.addElement(powerup);
    }

    public PowerUp PowerUpAt(int index) {
        return (PowerUp) this.contenedor.elementAt(index);
    }

    public void dibujar(Graphics g) {
        for (int i = 0; i < this.contenedor.size() - 1; i++) {
            PowerUp temporal = (PowerUp) this.contenedor.elementAt(i);
            temporal.dibujar(g);
        }
    }

    public void actualizar(int tiempo) {
        for (int i = 0; i < this.contenedor.size() - 1; i++) {
            PowerUp temporal = (PowerUp) this.contenedor.elementAt(i);
            temporal.actualizar(tiempo);
            if (temporal.destruido) {
                this.contenedor.removeElementAt(i);
            }
        }
    }
}
