package Main;


import Menus.SpriteBotonContinuar;
import Menus.SpriteBotonPausa;
import Menus.SpriteBotonSalir;
import Objetos.Avatar;
import Objetos.BalaAvatarNivel1;
import Objetos.ControladorEnemigos;
import Objetos.ControladorProyectil;
import Objetos.Enemigo;
import Objetos.EnemigoDos;
import Objetos.EnemigoUno;
import Objetos.Fondo;
import Objetos.Proyectil;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;


/**
 * Clase con la lógica principal, se encarga de manejar las colisiones, de mover al avatar, y de disparar, entre otras cosas.
 * @author Alberto Ortiz
 */
public class Asili extends GameCanvas {

    private Fondo fondo;
    /**
     * El nivel actual del juego
     */
    public int nivel;
    private boolean disparoDesbloqueado;
    /**
     * El tiempo que debe de esperar el avatar antes de volver a disparar.
     */
    public static final int FIRE_RATE = 250;
    private ControladorEnemigos controladorEnemigos;
    private SpriteBotonContinuar spriteBotonContinuar;
    private SpriteBotonPausa spriteBotonPausa;
    private SpriteBotonSalir spriteBotonSalir;
    /**
     * Imagen precargada
     */
    /**
     * Imagen precargada
     */
    /**
     * Imagen precargada
     */
    /**
     * Imagen precargada
     */
    /**
     * Imagen precargada
     */
    /**
     * Imagen precargada
     */
    /**
     * Imagen precargada
     */
    /**
     * Imagen precargada
     */
    /**
     * Imagen precargada
     */
    public static Image balaAvatarUno, enemigoUno, enemigoDos, bala1, bala2
    , botonPausa, botonContinuar, botonSalir, fondoPausa;
   // private static final int LIMITE_PROYECTILES = 30;
   //private int contadorBalas;
    /**
     * El encargado de administrar, actualizar y dibujar cada proyectil.
     */
    public static ControladorProyectil controladorProyectiles;
    private Avatar avatar;
    private Spawner spawner;
    private Enemigo enemigo;
    /**
     * El ANCHO actual de la aplicación.
     */
    public static int ANCHO;        // Ancho y alto de la pantalla del celular
    /**
     * El ALTO actual de la aplicación
     */
    public static int ALTO;
    private Animador animador;  // Estará avisando a cada rato que se actualice y dibuje queda pendiente la clase
    private Graphics g;
    private AppAsili midlet;
    private boolean pointIsDragged, pausado;
    private Reloj reloj;


    /**
     *
     * @param EL midlet para que corra en un celular.
     * @throws IOException - Excepción arrojada si no se puede cargar alguna imagen
     */
    public Asili(AppAsili midlet) throws IOException {
        super(true);
        this.pointIsDragged = false;
        this.spawner = new Spawner(1);
        controladorProyectiles = new ControladorProyectil();
        this.controladorEnemigos = new ControladorEnemigos();
        this.pausado = false;
        this.disparoDesbloqueado = true;
        this.setFullScreenMode(true);
        this.midlet = midlet;
        ANCHO = this.getWidth();
        ALTO = this.getHeight();
        balaAvatarUno = Image.createImage("/imagenes/Spritebala.png");
        enemigoUno = Image.createImage("/imagenes/enemigoSprite1.png");
        enemigoDos = Image.createImage("/imagenes/enemigoSprite2.png");
        bala1 = Image.createImage("/imagenes/Spritebala2.png");
        bala2 = Image.createImage("/imagenes/Spritebala3.png");
        botonPausa = Image.createImage("/imagenes/pausa.png");
        botonContinuar = Image.createImage("/imagenes/continuar.png");
        botonSalir = Image.createImage("/imagenes/salir.png");
        fondoPausa = Image.createImage("/imagenes/Fondopausa.png");
        this.spriteBotonContinuar = new SpriteBotonContinuar();
        this.spriteBotonPausa = new SpriteBotonPausa();
        this.spriteBotonSalir = new SpriteBotonSalir();
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
    
    /**
     *
     * @param aX - Coordenada X del stylus
     * @param aY - Coordenada Y del stylus
     */
    protected void pointerPressed(int aX, int aY) {
        if (aX >= (avatar.getX()) && aX <= (avatar.getX() + avatar.getWidth())
                && aY >= avatar.getY() && aY <= (avatar.getY() + avatar.getHeight())) {
            this.pointIsDragged = true;
        } else if(aX >= (spriteBotonPausa.getX()) && aX <= (spriteBotonPausa.getX() + spriteBotonPausa.getWidth())
                && aY >= spriteBotonPausa.getY() && aY <= (spriteBotonPausa.getY() + spriteBotonPausa.getHeight())) {
            this.pointIsDragged = false;
            this.pausado = !pausado;
        }
    }

    /**
     *
     * @param aX - Coordenada X del stylus
     * @param aY - Coordenada Y del stylus
     */
    protected void pointerDragged(int aX, int aY) {
        if (this.pointIsDragged) { //Si el puntero esta en el mismo punto que la nave
            avatar.setINCX(aX - avatar.getWidth()/2);
            avatar.setINCY(aY - avatar.getHeight()/2);
        }

    }

    /**
     * Agrega proyectiles del avatar al controladorProyectiles
     */
    public void disparar() {
        if(this.disparoDesbloqueado) {
            controladorProyectiles.AgregarProyectil(new BalaAvatarNivel1(this.avatar.getX() + (avatar.getWidth()/2), this.avatar.getY(), this.balaAvatarUno));
            System.out.println(this.avatar.getX() + "");
            this.disparoDesbloqueado = false;
            this.reloj.resetReloj();
        }
            
    }

    /**
     *
     * @param x - Coordenada x del stylus
     * @param y - Coordenada y del stylus
     */
    protected void pointerReleased(int x, int y) {
        this.pointIsDragged = false; //Deja de disparar
    }

    /**
     *
     * @return Regresa si el stylus tocó o no al avatar
     */
    public boolean getPointIsDragged() {
        return this.pointIsDragged;
    }

    /**
     * Agrega un enemigo al controladorEnemigos, lo que provoca su aparición en pantalla
     */
    public void invocarEnemigo() {
        if(spawner.isTime()) {
            switch(spawner.getInstruccionActual().tipoEnemigo) {
                case 1:
                    this.controladorEnemigos.agregarEnemigo(new EnemigoUno(100, 100, spawner.getInstruccionActual().idleTime, enemigoUno ));
                    break;
                case 2:
                    this.controladorEnemigos.agregarEnemigo(new EnemigoDos(100, 100, spawner.getInstruccionActual().idleTime, enemigoDos));
                 default:
                     break;
            }
            spawner.siguienteInstruccion();
        }
    }

    /**
     * Detecta las colisiones necesarias.
     */
    public void detectarColision() {
        for(int i = 0; i < controladorProyectiles.getSize() - 1; i++) {
            Proyectil proyectilTemp = controladorProyectiles.proyectilAt(i);
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

    /**
     *
     * Llama al método actualizar de cada clase
     */
    public void actualizar() {
        if (!pausado) {
            System.out.println(controladorEnemigos);
            controladorEnemigos.actualizar(this.avatar.getX());
            avatar.mover();
            spawner.actualizar(Animador.RETARDO);
            fondo.actualizar();
            this.detectarColision();
            this.invocarEnemigo();
            controladorProyectiles.actualizar();
            this.reloj.incrementar(Animador.RETARDO);
            if (this.pointIsDragged) {
                this.disparar();
            }
            if (this.reloj.getTiempo() >= FIRE_RATE) {
                this.disparoDesbloqueado = true;
            }
        }

    }

    /**
     * Llama al método dibujar de cada clase
     */
    public void dibujar() {
      
        fondo.dibujar(g);
        avatar.dibujar(g);
        this.spriteBotonPausa.dibujar(g);
        controladorProyectiles.dibujar(g);
        this.controladorEnemigos.dibujar(g);
          if(pausado) {
            spriteBotonContinuar.dibujar(g);
            spriteBotonSalir.dibujar(g);
            g.drawImage(fondoPausa, 0, 0, Graphics.LEFT|Graphics.TOP);

        }
        flushGraphics();
    }

}
