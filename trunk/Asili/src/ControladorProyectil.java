
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

    public void BorrarProyectil(Proyectil proyectil) {
        this.contenedor.removeElement(proyectil);
    }

    public void ResetEnumerador(){
        this.enumerador = this.contenedor.elements();
    }

    
    /******************************************
     * Aqui terminan los metodos que hacen a ControladorProyectil un pseudo ArrayList
     *
     * Estos son los métodos para dibujar y actualizar
     * ***************************************
     */

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



}



