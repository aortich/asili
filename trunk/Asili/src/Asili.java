
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
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
    private boolean pausado = false;
    private Fondo fondoPausa;
    public static int ANCHO;        // Ancho y alto de la pantalla del celular
    public static int ALTO;
    private Animador animador;  // Estará avisando a cada rato que se actualice y dibuje queda pendiente la clase
    private Graphics g;
    private AppAsili midlet;
    private boolean pointIsDragged;
    private Vector balas;
    private Reloj reloj;

    public Asili(AppAsili midlet) {
        super(true);
        this.pointIsDragged = false;
        
        this.midlet = midlet;
        this.setFullScreenMode(true);
        this.ANCHO = this.getWidth();
        this.ALTO = this.getHeight();
        g = this.getGraphics();
        balas = new Vector();

        try {
            avatar = new Avatar(0, 3);
            fondo = new Fondo("/imagenes/FondoNivel1.jpg", 2);
            //fondoPausa = new Fondo("/pausa.png", 0, 0); No sabemos ni que pex
        } catch (IOException ex) {
            System.out.println("No se pueden cargar los fondos");
            ex.printStackTrace();
        }

        animador = new Animador(this);
        animador.iniciar();



    }

    protected void pointerPressed(int aX, int aY) {
        if (aX >= (avatar.getX()) && aX <= (avatar.getX() + avatar.getWidth())
                && aY >= avatar.getY() && aY <= (avatar.getY() + avatar.getHeight())) {
            this.pointIsDragged = true;
            // System.out.println(this.pointIsDragged);
            //System.out.println(aX + ", " + avatar.getX());
            //System.out.println(aY + ", " + avatar.getY());
        } else {
            this.pointIsDragged = false;
            //System.out.println(this.pointIsDragged);
            //System.out.println(aX + ", " + avatar.getX());
            //System.out.println(aY + ", " + avatar.getY());
        }
    }

    protected void pointerDragged(int aX, int aY) {
        if (this.pointIsDragged == true) { //Si el puntero esta en el mismo punto que la nave //Empieza a disparar
            avatar.setINCX(aX);
            avatar.setINCY(aY);
            System.out.println(true);
        }

    }

    protected void pointerReleased(int x, int y) {
        this.pointIsDragged = false; //Deja de disparar
    }

    public boolean getPointIsDragged() {
        return this.pointIsDragged;
    }

    public void disparar() {
        if (this.pointIsDragged == true) {
            try {
                balas.addElement(new BalaAvatarNivel1(avatar.getRefPixelX(), avatar.getRefPixelY() + avatar.getHeight() / 2));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void actualizar() {
        avatar.mover();
        fondo.actualizar();
        this.disparar();
        int i = 0;
        if (! balas.isEmpty()) {
            for (Enumeration a = balas.elements(); a.hasMoreElements();) {
                Proyectil proyectilGenerico = (Proyectil) balas.elementAt(i);
                proyectilGenerico.actualizar();
                balas.insertElementAt(proyectilGenerico, i);
                a.nextElement();
                i++;
            }
        }

    }

    public void dibujar() {
        fondo.dibujar(g);
        avatar.dibujar(g);
        int i = 0;
        if (! balas.isEmpty()) {
            for (Enumeration a = balas.elements(); a.hasMoreElements();) {
                Proyectil proyectilGenerico = (Proyectil) balas.elementAt(i);
                proyectilGenerico.dibujar(g);
                balas.insertElementAt(proyectilGenerico, i);
                a.nextElement();
                i++;
            }
        }
        flushGraphics();
    }
}
