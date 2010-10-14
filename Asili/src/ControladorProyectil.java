
import java.util.Enumeration;
import java.util.Vector;
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

    private Vector contenedor;
    private int tamano;
    private int factorCrecimiento;
    private int contador;
    private int numeroDeObjetos;
    private Enumeration enumerador;

    public ControladorProyectil() {
        this.contenedor = new Vector();
        this.tamano = 1;
        this.factorCrecimiento = 50;
        this.numeroDeObjetos = 0;
        this.contador = 0;
        this.enumerador = this.contenedor.elements();
    }


    public void AgregarProyectil(Proyectil proyectil) {
        this.contenedor.addElement(proyectil);
    }

    public void BorrarProyectil() {
        
    }

    }



    /******************************************
     * Aqui terminan los metodos que hacen a ControladorProyectil un pseudo ArrayList
     *
     * Estos son los métodos para dibujar y actualizar
     * ***************************************
     */
    public void actualizar() {
        if (!this.isEmpty()) {
            this.contador = 0;
            for (this.contador = 0; this.contador < this.numeroDeObjetos; this.contador++) {
                this.proyectiles[this.contador].actualizar();
                if (this.proyectiles[this.contador].fueraDeLimites == true || this.proyectiles[this.contador].impacto == true) {
                    this.remove(this.contador);
                }

            }
        }
    }

    public void dibujar(Graphics g) {
        if (!this.isEmpty()) {
            this.contador = 0;
            for (this.contador = 0; this.contador < this.numeroDeObjetos; this.contador++) {
                this.proyectiles[this.contador].dibujar(g);
            }
        }
    }

