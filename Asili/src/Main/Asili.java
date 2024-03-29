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
import Objetos.EnemigoTres;
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
    public int nivel, score;
    private boolean disparoDesbloqueado;
    /**
     * El tiempo que debe de esperar el avatar antes de volver a disparar.
     */
    public static final int FIRE_RATE = 250;
    private ControladorEnemigos controladorEnemigos;
    private SpriteBotonContinuar spriteBotonContinuar;
    private SpriteBotonPausa spriteBotonPausa;
    private SpriteBotonSalir spriteBotonSalir;

    private Image balaAvatarUno, enemigoUno, enemigoDos, enemigoTres, enemigoCuatro, bala1, bala2
    , botonPausa, botonContinuar, botonSalir, fondoPausa, muerte, avatarSprite, balaBola;
   // private static final int LIMITE_PROYECTILES = 30;
   //private int contadorBalas;
    /**
     * El encargado de administrar, actualizar y dibujar cada proyectil.
     */
    public static ControladorProyectil controladorProyectiles;
    private Avatar avatar;
    private Spawner spawner;
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
    private boolean pointIsDragged, pausado, inicioNivel, pausaMuerte, avatarTocable;
    private Reloj relojDisparos, relojNivel;
    /**
     *
     * @param EL midlet para que corra en un celular.
     * @throws IOException - Excepción arrojada si no se puede cargar alguna imagen
     */
    public Asili(AppAsili midlet) throws IOException {
        super(true);
        this.pointIsDragged = false;
        this.avatarTocable = false;
        this.inicioNivel = true;
        this.pausaMuerte = false;
        this.score = 0;
        this.spawner = new Spawner(1);
        controladorProyectiles = new ControladorProyectil();
        this.controladorEnemigos = new ControladorEnemigos();
        this.pausado = false;
        this.nivel = 1;
        this.disparoDesbloqueado = true;
        this.setFullScreenMode(true);
        this.midlet = midlet;
        ANCHO = this.getWidth();
        ALTO = this.getHeight();
        balaAvatarUno = Image.createImage("/imagenes/Spritebala.png");
        enemigoUno = Image.createImage("/imagenes/enemigoSprite1.png");
        enemigoDos = Image.createImage("/imagenes/enemigoSprite2.png");
        enemigoTres = Image.createImage("/imagenes/enemigoSprite3.png");
        enemigoCuatro = Image.createImage("/imagenes/enemigoSprite4.png");
        bala1 = Image.createImage("/imagenes/Spritebala2.png");
        bala2 = Image.createImage("/imagenes/Spritebala3.png");
        botonPausa = Image.createImage("/imagenes/pausa.png");
        botonContinuar = Image.createImage("/imagenes/continuar.png");
        botonSalir = Image.createImage("/imagenes/salir.png");
        fondoPausa = Image.createImage("/imagenes/Fondopausa.png");
        muerte = Image.createImage("/imagenes/muerte.png");
        avatarSprite = Image.createImage("/imagenes/avatarSprite.png");
        balaBola = Image.createImage("/imagenes/BalaBola.png");
        this.spriteBotonContinuar = new SpriteBotonContinuar(botonContinuar);
        this.spriteBotonPausa = new SpriteBotonPausa(botonPausa);
            this.spriteBotonSalir = new SpriteBotonSalir(botonSalir);
        this.relojDisparos = new Reloj(0);
        this.relojNivel = new Reloj(0);
        g = this.getGraphics();

        try {
            avatar = new Avatar(0, 3, this.avatarSprite, this.muerte);
            fondo = new Fondo("/imagenes/FondoNivel1.jpg", 2);
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
        if (avatarTocable) {
            if (aX >= (avatar.getX()) && aX <= (avatar.getX() + avatar.getWidth())
                    && aY >= avatar.getY() && aY <= (avatar.getY() + avatar.getHeight())) {
                this.pointIsDragged = true;
            } else if (aX >= (spriteBotonPausa.getX()) && aX <= (spriteBotonPausa.getX() + spriteBotonPausa.getWidth())
                    && aY >= spriteBotonPausa.getY() && aY <= (spriteBotonPausa.getY() + spriteBotonPausa.getHeight())) {
                this.pointIsDragged = false;
                this.pausado = !pausado;
            } else if (aX >= (spriteBotonContinuar.getX()) && aX <= (spriteBotonContinuar.getX() + spriteBotonContinuar.getWidth())
                    && aY >= spriteBotonContinuar.getY() && aY <= (spriteBotonContinuar.getY() + spriteBotonContinuar.getHeight())){
                this.pausado = !pausado;
                //hay que borrar el botón
            }

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
            this.disparoDesbloqueado = false;
            this.relojDisparos.resetReloj();
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
            switch(spawner.getInstruccionActual().getTipoEnemigo()) {
                case 1:
                    this.controladorEnemigos.agregarEnemigo(new EnemigoUno(spawner.getInstruccionActual().getX(), spawner.getInstruccionActual().getY(), 100, 100, spawner.getInstruccionActual().getIdleTime(), enemigoUno, this.balaBola ));
                    break;
                case 2:
                    this.controladorEnemigos.agregarEnemigo(new EnemigoDos(spawner.getInstruccionActual().getX(), spawner.getInstruccionActual().getY(), 100, 100, spawner.getInstruccionActual().getIdleTime(), enemigoDos, this.balaBola));
                    break;
                case 3:
                    this.controladorEnemigos.agregarEnemigo(new EnemigoTres(spawner.getInstruccionActual().getX(), spawner.getInstruccionActual().getY(), 100, 100, spawner.getInstruccionActual().getIdleTime(), enemigoDos, this.balaBola));
                    break;
                case 4:
                    this.controladorEnemigos.agregarEnemigo(new EnemigoDos(spawner.getInstruccionActual().getX(), spawner.getInstruccionActual().getY(), 100, 100, spawner.getInstruccionActual().getIdleTime(), enemigoDos, this.balaBola));
                    break;
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
        if (!pausaMuerte) {
            for (int i = 0; i < controladorProyectiles.getSize() - 1; i++) {
                Proyectil proyectilTemp = controladorProyectiles.proyectilAt(i);
                if (proyectilTemp.perteneceAAvatar()) {
                    for (int j = 0; j < this.controladorEnemigos.getSize() - 1; j++) {
                        Enemigo enemigoTemp = this.controladorEnemigos.enemigoAt(j);
                        if (proyectilTemp.collidesWith(enemigoTemp, true)) {
                            proyectilTemp.detectarColision(true);
                            enemigoTemp.destruir(true);
                            score += enemigoTemp.getValor();
                        }
                    }
                } else {
                    if (proyectilTemp.collidesWith(avatar, true)) {
                        proyectilTemp.detectarColision(true);
                        avatar.destruirAvatar();
                        pausaMuerte = true;
                        this.spawner.vaciarLista();
                        controladorEnemigos.vaciarControlador();
                        controladorProyectiles.vaciarControlador();
                        this.spawner.llenarInstrucciones();
                    }
                }
            }

            for (int i = 0; i < controladorEnemigos.getSize() - 1; i++) {
                Enemigo enemigoTemp = controladorEnemigos.enemigoAt(i);
                if (enemigoTemp.collidesWith(avatar, true)) {
                    avatar.destruirAvatar();
                    pausaMuerte = true;
                    this.spawner.vaciarLista();
                    controladorEnemigos.vaciarControlador();
                    controladorProyectiles.vaciarControlador();
                    this.spawner.llenarInstrucciones();
                }
            }
        }

    }

    public void cambiarNivel() {
        this.nivel++;
        if (this.nivel < 4) {
            try {
                switch(nivel) {
                    case 1:
                        this.fondo = new Fondo("/imagenes/FondoNivel1.jpg", 2);
                        break;
                    case 2:
                        this.fondo = new Fondo("/imagenes/FondoNivel2.jpg", 2);
                        break;
                    case 3:
                        this.fondo = new Fondo("/imagenes/FondoNivel3.jpg", 2);
                        break;
                    default:
                        break;

                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            this.controladorProyectiles.vaciarControlador();
            this.controladorEnemigos.vaciarControlador();
            this.spawner.setNivel(this.nivel);
            this.spawner.llenarInstrucciones();
            this.inicioNivel = true;
        } else {
            midlet.actualizarApp(8);
        }
    }

    public void resetNivel() {
        this.spawner.setNivel(nivel);
        this.spawner.llenarInstrucciones();
        avatarTocable = false;
    }

    /**
     *
     * Llama al método actualizar de cada clase
     */
    public void actualizar() {
        if (!pausado) {
            if (this.inicioNivel == true) {
                relojNivel.incrementar(Animador.RETARDO);
                fondo.actualizar();
                if (relojNivel.getTiempo() > 3000 && this.inicioNivel == true) {
                    this.inicioNivel = false;
                    avatarTocable = true;
                    relojNivel.resetReloj();
                }

            } else if (this.pausaMuerte == true) {
                relojNivel.incrementar(Animador.RETARDO);
                avatar.actualizar();
                if (relojNivel.getTiempo() > 3000) {

                    avatarTocable = true;
                    this.pausaMuerte = false;
                    fondo.resetearFondo();
                    this.resetNivel();
                    avatar.reconstruirAvatar();
                    relojNivel.resetReloj();
                    if(avatar.getVidas() < 1)
                        midlet.actualizarApp(7);
                        
                }

            } else {
                if (this.spawner.juegoTerminado()) {
                    this.cambiarNivel();
                }
                avatarTocable = true;
                controladorEnemigos.actualizar(this.avatar.getX(), this.avatar.getY(), Animador.RETARDO);
                this.spawner.comenzarCuenta();
                avatar.mover();
                spawner.actualizar(Animador.RETARDO);
                fondo.actualizar();
                this.detectarColision();
                this.invocarEnemigo();
                controladorProyectiles.actualizar();
                this.relojDisparos.incrementar(Animador.RETARDO);
                if (this.pointIsDragged) {
                    this.disparar();
                }
                if (this.relojDisparos.getTiempo() >= FIRE_RATE) {
                    this.disparoDesbloqueado = true;
                }
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
        g.drawString("Score: " + this.score, 20, 5, Graphics.LEFT | Graphics.TOP);
        g.drawString("Vidas: " + avatar.getVidas(), 20, 20, Graphics.LEFT | Graphics.TOP);
        g.drawString("Nivel: " + nivel, 20, 35, Graphics.LEFT | Graphics.TOP);
        if (pausado) {
            g.drawImage(fondoPausa, 0, 0, Graphics.LEFT | Graphics.TOP);
            //this.spriteBotonContinuar.dibujar(g);
        }

        if(this.inicioNivel == true) {
            g.drawString("Nivel" + this.nivel, (Asili.ANCHO/2) - 10, (Asili.ALTO/2), Graphics.LEFT | Graphics.TOP);
            if(this.relojNivel.getTiempo() > 1500)
                g.drawString("Comenzar!", (Asili.ANCHO/2) - 20, (Asili.ALTO/2) + 15, Graphics.LEFT | Graphics.TOP);
        }
 
        flushGraphics();
    }

    public void destruir() {
        animador.detener();
        this.spawner = null;
        controladorProyectiles = null;
        this.controladorEnemigos = null;
        this.midlet = null;
        balaAvatarUno = null;
        enemigoUno = null;
        enemigoDos = null;
        bala1 = null;
        bala2 = null;
        botonPausa = null;
        botonContinuar = null;
        botonSalir = null;
        fondoPausa = null;
        muerte = null;
        avatarSprite = null;
        balaBola = null;
        this.spriteBotonContinuar = null;
        this.spriteBotonPausa = null;
        this.spriteBotonSalir = null;
        this.relojDisparos = null;
        this.relojNivel = null;
        g = this.getGraphics();
        fondo = null;
    }
}


