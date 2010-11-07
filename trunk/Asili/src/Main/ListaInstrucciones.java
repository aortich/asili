/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import java.util.Vector;

/**
 *
 * @author Alberto Ortiz
 */
public class ListaInstrucciones {

    Vector lista;
    int lugar;

    public ListaInstrucciones() {
        lista = new Vector();
        lugar = 0;
    }

    public boolean hasNext() {
        return lugar < lista.size();
    }

    public Instruccion siguienteInstruccion() {
        if (hasNext()) {
            lugar++;
            return (Instruccion) lista.elementAt(lugar - 1);
        } else {
            return null;
        }
    }

    public void llenarLista(int nivel) {
        switch (nivel) {

            case 1:
                lista.addElement(new Instruccion(1, 2000, 2000));
                lista.addElement(new Instruccion(1, 2500, 2000));
                lista.addElement(new Instruccion(1, 3000, 1500));
                lista.addElement(new Instruccion(1, 3500, 1500));
                lista.addElement(new Instruccion(1, 4000, 1500));
        }
    }
}
