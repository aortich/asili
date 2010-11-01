package Main;


import Objetos.Avatar;
import Objetos.BalaAvatarNivel1;
import Objetos.ControladorEnemigos;
import Objetos.ControladorProyectil;
import Objetos.Enemigo;
import Objetos.Fondo;
import Objetos.Proyectil;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;


public class Asili extends GameCanvas {

    private Fondo fondo;
    private boolean disparoDesbloqueado;
    public static final int FIRE_RATE = 250;
    private ControladorEnemigos controladorEnemigos;
    public Image balaAvatarUno;
    private static final int LIMITE_PROYECTILES = 30;
    private int contadorBalas;
    private ControladorProyectil controladorProyectiles;
    private Avatar avatar;
    private Enemigo enemigo;
    private boolean pausado = false;
    private Fondo fondoPausa;
    public static int ANCHO;        // Ancho y alto de la pantalla del celular
    public static int ALTO;
    private Animador animador;  // Estará avisando a cada rato que se actualice y dibuje queda pendiente la clase
    private Graphics g;
    private AppAsili midlet;
    private boolean pointIsDragged, disparando;
    private Reloj reloj;


    public Asili(AppAsili midlet) throws IOException {
        super(true);
        this.pointIsDragged = false;
        this.controladorProyectiles = new ControladorProyectil();
        this.controladorEnemigos = new ControladorEnemigos();
        this.disparando = true;
        this.disparoDesbloqueado = true;
        this.setFullScreenMode(true);
        this.midlet = midlet;
        this.ANCHO = this.getWidth();
        this.ALTO = this.getHeight();
        this.balaAvatarUno = Image.createImage("/imagenes/Spritebala.png");
        this.reloj = new Reloj(0);
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
        } else {
            this.pointIsDragged = false;
        }
    }

    protected void pointerDragged(int aX, int aY) {
        if (this.pointIsDragged) { //Si el puntero esta en el mismo punto que la nave
            avatar.setINCX(aX - avatar.getWidth()/2);
            avatar.setINCY(aY - avatar.getHeight()/2);
        }

    }

    public void disparar() {
        if(this.disparoDesbloqueado) {
            this.controladorProyectiles.AgregarProyectil(new BalaAvatarNivel1(this.avatar.getX() + (avatar.getWidth()/2), this.avatar.getY(), this.balaAvatarUno));
            System.out.println(this.avatar.getX() + "");
            this.disparoDesbloqueado = false;
            this.reloj.resetReloj();
        }
            
    }

    protected void pointerReleased(int x, int y) {
        this.pointIsDragged = false; //Deja de disparar
    }

    public boolean getPointIsDragged() {
        return this.pointIsDragged;
    }

    public void detectarColision() {
        for(int i = 0; i < this.controladorProyectiles.getSize() - 1; i++) {
            Proyectil proyectilTemp = this.controladorProyectiles.proyectilAt(i);
            if(proyectilTemp.perteneceAAvatar()) {
                for(int j = 0; j < this.controladorEnemigos.getSize() -1; j++){
                    Enemigo enemigoTemp = this.controladorEnemigos.enemigoAt(j);
                    if(proyectilTemp.collidesWith(enemigoTemp, true)) {
                        proyectilTemp.detectarColision(true);
                        enemigoTemp.destruir(true);
                    }
                }
            } else {
                if(proyectilTemp.collidesWith(avatar, true)) {
                    proyectilTemp.detectarColision(true);
                    //Terminar Juego
                }
            }
        }
    }

    public void actualizar() {
        avatar.mover();
        fondo.actualizar();
        this.controladorProyectiles.actualizar();
        this.reloj.incrementar(this.animador.RETARDO);
        if(this.pointIsDragged)
            this.disparar();
        if(this.reloj.getTiempo() >= this.FIRE_RATE)
            this.disparoDesbloqueado = true;

    }

    public void dibujar() {
        fondo.dibujar(g);
        avatar.dibujar(g);
        this.controladorProyectiles.dibujar(g);
        flushGraphics();
    }

}
