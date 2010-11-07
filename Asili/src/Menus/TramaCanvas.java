package Menus;


import Main.Animador;
import Main.AppAsili;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

public class TramaCanvas extends GameCanvas {

    private AppAsili midlet;
    private Graphics g;
    private FondoMenu fondo;
    private Animador animador;

    

    public TramaCanvas(AppAsili midlet) {
        super(true);

        this.midlet = midlet;
        this.setFullScreenMode(true);
        g = this.getGraphics();
        try {
            fondo = new FondoMenu("/imagenes/trama.jpg");
        } catch (IOException ex) {
            System.out.println("Error de IO en clase TramaCanvas");
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
        this.flushGraphics();

    }
    //probable animación
    public void actualizar(){

       
    }
}