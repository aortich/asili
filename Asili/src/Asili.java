
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;


/**
 *
 * @author Fer
 */
public class Asili extends GameCanvas {

    private Fondo fondo;
    private Avatar avatar;
    private Proyectil proyectil;
    private Enemigo enemigo;
    private boolean pausado=false;
    private Fondo fondoPausa;
 
    public static int ANCHO;        // Ancho y alto de la pantalla del celular
    public static int ALTO;
    private Animador animador;  // Estará avisando a cada rato que se actualice y dibuje queda pendiente la clase
    private Graphics g;
    private AppAsili midlet;
    private boolean pointIsDragged;

    public Asili (AppAsili midlet) {
        super(true);
        this.pointIsDragged = false;
        this.midlet = midlet;
        this.setFullScreenMode(true);
        this.ANCHO = this.getWidth();
        this.ALTO = this.getHeight();
        g = this.getGraphics();

        try {
            avatar = new Avatar(0, 3);
            fondo = new Fondo("/fondo.jpg", 1);
            //fondoPausa = new Fondo("/pausa.png", 0, 0); No sabemos ni que pex
        } catch (IOException ex) {
            System.out.println("No se pueden cargar los fondos");
        }

        
    }

        protected void pointDragged(int x, int y) {
        if(x == avatar.getX() && y == avatar.getY()) { //Si el puntero esta en el mismo punto que la nave
            this.pointIsDragged = true; //Empieza a disparar
            avatar.setINCX(x);
            avatar.setINCY(y);
        }

    }

    protected void pointReleased (int x, int y) {
        this.pointIsDragged = false; //Deja de disparar
    }

    public boolean getPointIsDragged() {
        return this.pointIsDragged;
    }


    public void actualizar() {
        avatar.mover();

    }

    public void dibujar() {
        fondo.dibujar(g);
        avatar.dibujar(g);
    }

}
