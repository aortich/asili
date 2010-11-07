package Menus;


import Main.Animador;
import Main.AppAsili;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

public class InstruccionesCanvas extends GameCanvas {

    private AppAsili midlet;
    private Graphics g;
    private FondoMenu fondo;
    private Animador animador;



    public InstruccionesCanvas(AppAsili midlet) {
        super(true);

        this.midlet = midlet;
        this.setFullScreenMode(true);
        g = this.getGraphics();
        try {
            fondo = new FondoMenu("/imagenes/instrucciones.jpg");
        } catch (IOException ex) {
            System.out.println("Error de IO en clase InstruccionesCanvas");
            ex.printStackTrace();
        }


        animador = new Animador(this);
        animador.iniciar();




    }


    protected void pointerPressed(int aX, int aY) {
       midlet.actualizarApp(6);
       animador.detener();

    }

    public void dibujar(){
        fondo.dibujar(g);
        flushGraphics();

    }
    //probable animación
    public void actualizar(){


    }
}