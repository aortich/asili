/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import java.util.Vector;

/**
 *Lista con instrucciones
 * @author Alberto Ortiz
 */
public class ListaInstrucciones {

    Vector lista;
    int lugar;

    /**
     *  El constructor que crea un vector para contener las instrucciones
     */
    public ListaInstrucciones() {
        lista = new Vector();
        lugar = 0;
    }

    /**
     *
     * @return Regresa si la lista tiene un item próximo o no.
     */
    public boolean hasNext() {
        return lugar < lista.size();
    }

    /**
     *
     * @return Devuelve la sigiuiente instrucción. Si no hay siguiente instrucción, regresa null
     */
    public Instruccion siguienteInstruccion() {
        if (hasNext()) {
            lugar++;
            return (Instruccion) lista.elementAt(lugar - 1);
        } else {
            return null;
        }
    }

    /**
     *
     * @param nivel Llena la lista de acuerdo al nivel actual
     */
    public void llenarLista(int nivel) {
        switch (nivel) {

            case 1:
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 2000, 2000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 2500, 2000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 3000, 1500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 3500, 1500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 4000, 1500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 4500, 2000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 5000, 2000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 6000, 1500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 6500, 1500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 7000, 1500));
                break;
            case 2:
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 2000, 1000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 2200, 1000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 2400, 500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 2500, 1500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 2600, 1500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 3000, 1000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 3100, 1000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 3200, 500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 3500, 500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 4200, 1500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 4300, 1000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 4500, 1000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 4700, 500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 4800, 500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 4900, 1500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 5000, 1000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 5200, 1000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 5600, 500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 5800, 1500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 6000, 1500));

                break;

            case 3:
                 lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 2000, 1000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 2200, 1000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 2400, 500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 2500, 1500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 2600, 1500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 3000, 1000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 3100, 1000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 3200, 500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 3500, 500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 4200, 1500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 4300, 1000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 4500, 1000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 4700, 500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 4800, 500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 4900, 1500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 5000, 1000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 1, 5200, 1000));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 5600, 500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 5800, 1500));
                lista.addElement(new Instruccion(Asili.ANCHO + 30, Asili.ALTO + 30, 2, 6000, 1500));

                break;
        }
    }

    public void vaciarLista() {
        this.lista.removeAllElements();
    }
}
