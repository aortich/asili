
import javax.microedition.lcdui.Graphics;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alberto Ortiz
 */
public class ControladorProyectil {

    private Proyectil[] proyectiles;
    private int tamano;
    private int objetosGuardados;
    private int factorCrecimiento;
    private int contador;

    public ControladorProyectil() {
        proyectiles = new Proyectil[1];
        this.tamano = 1;
    }

    public ControladorProyectil(int tamano, int factor) {
        this.factorCrecimiento = factor;
        this.tamano = tamano;
    }

    public ControladorProyectil(int tamano) {
        proyectiles = new Proyectil[tamano];
        this.tamano = tamano;
    }

    public Proyectil remove(int index) {
        if (index < 0 || index >= this.tamano) {
            throw new IndexOutOfBoundsException("the index [" + index + "] is not valid for this list with the size [" + this.tamano + "].");
        }
        Proyectil removed = this.proyectiles[index];
        for (int i = index + 1; i < this.tamano; i++) {
            this.proyectiles[i - 1] = this.proyectiles[i];
        }
        this.tamano--;
        return removed;
    }

    public Proyectil get(int index) {
        if (index < 0 || index >= this.tamano) {
            throw new IndexOutOfBoundsException("the index [" + index + "] is not valid for this list with the size [" + this.tamano + "].");
        }
        return this.proyectiles[index];
    }

    public int indexOf(Proyectil elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("ArrayList cannot contain a null element.");
        }
        for (int i = 0; i < this.tamano; i++) {
            Proyectil proyectil = this.proyectiles[i];
            if (proyectil.equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(Proyectil elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("ArrayList cannot contain null.");
        }
        int index = -1;
        for (int i = 0; i < this.tamano; i++) {
            Proyectil proyectil = this.proyectiles[i];
            if (proyectil.equals(elemento)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        for (int i = index + 1; i < this.tamano; i++) {
            this.proyectiles[i - 1] = this.proyectiles[i];
        }
        this.tamano--;
        return true;
    }

    private void increaseCapacity() {
        int currentCapacity = this.proyectiles.length;
        int nuevaCapacidad = currentCapacity + ((currentCapacity * this.factorCrecimiento) / 100);
        if (nuevaCapacidad == currentCapacity) {
            nuevaCapacidad++;
        }
        Proyectil[] newStore = new Proyectil[nuevaCapacidad];
        System.arraycopy(this.proyectiles, 0, newStore, 0, this.tamano);
        this.proyectiles = newStore;
    }

    public void add(Proyectil elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("ArrayList cannot contain null.");
        }
        if (this.tamano >= this.proyectiles.length) {
            increaseCapacity();
        }
        this.proyectiles[this.tamano] = elemento;
        this.tamano++;
    }

    public void add(int index, Proyectil elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("ArrayList cannot contain null.");
        }
        if (index < 0 || index >= this.tamano) {
            throw new IndexOutOfBoundsException("the index [" + index + "] is not valid for this list with the size [" + this.tamano + "].");
        }
        if (this.tamano >= this.proyectiles.length) {
            increaseCapacity();
        }
        // shift all following elements one position to the back:
        for (int i = this.tamano; i > index; i--) {
            this.proyectiles[i] = this.proyectiles[i - 1];
        }
        // insert the given element:
        this.proyectiles[index] = elemento;
        this.tamano++;
    }

    /******************************************
     * Aqui terminan los metodos que hacen a ControladorProyectil un pseudo ArrayList
     *
     * Estos son los métodos para dibujar y actualizar
     * ***************************************
     */

    public void actualizar() {
        this.contador = 0;
        for(this.contador = 0; this.contador <= this.tamano; this.contador++) {
            this.proyectiles[this.contador].actualizar();
            if(this.proyectiles[this.contador].fueraDeLimites == true || this.proyectiles[this.contador].impacto == true) {
                this.remove(this.contador);
            }

        }
    }
    // Que es eso de graphics
    public void dibujar(Graphics g) {
       this.contador = 0;
       for(this.contador = 0; this.contador <= this.tamano; this.contador++) {
           this.proyectiles[this.contador].dibujar(g);
       }
    }
}
