
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
    private static final int LIMITE_PROYECTILES = 30;
    private int contadorBalas;
    private ControladorProyectil controladorProyectiles;
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
    private boolean pointIsDragged, disparando;

    public Asili(AppAsili midlet) {
        super(true);
        this.pointIsDragged = false;
        this.controladorProyectiles = new ControladorProyectil();
        this.disparando = true;
        this.setFullScreenMode(true);
        this.midlet = midlet;
        this.ANCHO = this.getWidth();
        this.ALTO = this.getHeight();
        g = this.getGraphics();

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
        System.out.println("( " + aX + ", " + aY + ")");
        if (aX >= (avatar.getX()) && aX <= (avatar.getX() + avatar.getWidth())
                && aY >= avatar.getY() && aY <= (avatar.getY() + avatar.getHeight())) {
            this.pointIsDragged = true;
            try {
                this.disparar();
            } catch (IOException ex) {
                    ex.printStackTrace();
            }
        } else {
            this.pointIsDragged = false;
        }
    }

    protected void pointerDragged(int aX, int aY) {
        if (this.pointIsDragged == true) { //Si el puntero esta en el mismo punto que la nave //Empieza a disparar
            avatar.setINCX(aX - avatar.getWidth()/2);
            avatar.setINCY(aY - avatar.getHeight()/2);
        }

    }

    public void disparar() throws IOException{
        if(this.contadorBalas < this.LIMITE_PROYECTILES) {
            this.controladorProyectiles.add(new BalaAvatarNivel1(this.avatar.getRefPixelX(), this.avatar.getY()));
            System.out.println(this.controladorProyectiles);
        }
    }

    protected void pointerReleased(int x, int y) {
        this.pointIsDragged = false; //Deja de disparar
        this.disparando = false;
    }

    public boolean getPointIsDragged() {
        return this.pointIsDragged;
    }

    public void actualizar() {
        avatar.mover();
        fondo.actualizar();
        this.controladorProyectiles.actualizar();

    }

    public void dibujar() {
        fondo.dibujar(g);
        avatar.dibujar(g);
        this.controladorProyectiles.dibujar(g);
        flushGraphics();
    }
}
