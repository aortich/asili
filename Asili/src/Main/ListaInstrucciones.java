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
                lista.addElement(new Instruccion(2, 2000, 2000));
                lista.addElement(new Instruccion(2, 2500, 2000));
                lista.addElement(new Instruccion(2, 3000, 1500));
                lista.addElement(new Instruccion(2, 3500, 1500));
                lista.addElement(new Instruccion(2, 4000, 1500));
        }
    }
}
