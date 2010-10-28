package Main;


import Menus.CreditosCanvas;
import Menus.HiSCanvas;
import Menus.InstruccionesCanvas;
import Menus.MenuPrincipal;
import Menus.SplashScreenTEC;
import Menus.TramaCanvas;
import Objetos.Enemigo;


/***********************************************************************
 ***********************************************************************
 * IMPORTANTE:
 * Preguntar todo referente a Threads.
 *
 *
 * *********************************************************************
 * ********************************************************************
 */
public class Animador implements Runnable {

    private Asili asili;
    private MenuPrincipal menu;
    private SplashScreenTEC splash;
    private TramaCanvas trama;
    private InstruccionesCanvas instrucciones;
    private HiSCanvas hScores;
    private CreditosCanvas creditos;
    private Enemigo enemigo;
    private boolean corriendo;
    private Thread thread;
    private static final int FPS = 50;
    public static final int RETARDO = 1000 / FPS;
    int caso;

    public Animador(Asili juego) {
        this.menu = null;
        this.splash = null;
        this.asili = juego;
        this.caso = 1;
        this.trama = null;
        this.enemigo = null;
        this.instrucciones = null;
        this.hScores = null;
        this.creditos = null;
    }

    public Animador(MenuPrincipal menu) {
        this.menu = menu;
        this.splash = null;
        this.asili = null;
        this.caso = 2;
        this.trama = null;
        this.enemigo = null;
        this.instrucciones = null;
        this.hScores = null;
        this.creditos = null;
    }

    public Animador(SplashScreenTEC splash) {
        this.menu = null;
        this.splash = splash;
        this.asili = null;
        this.caso = 3;
        this.trama = null;
        this.enemigo = null;
        this.instrucciones = null;
        this.hScores = null;
        this.creditos = null;
    }
    public Animador(TramaCanvas trama) {
        this.menu = null;
        this.splash = null;
        this.asili = null;
        this.caso = 4;
        this.trama = trama;
        this.enemigo = null;
        this.instrucciones = null;
        this.hScores = null;
        this.creditos = null;
    }
    public Animador(Enemigo enemigo) {
        this.menu = null;
        this.splash = null;
        this.asili = null;
        this.caso = 4;
        this.trama = null;
        this.enemigo = enemigo;
        this.instrucciones = null;
        this.hScores = null;
        this.creditos = null;
    }

    public Animador(InstruccionesCanvas instrucciones) {
        this.menu = null;
        this.splash = null;
        this.asili = null;
        this.caso = 5;
        this.trama = null;
        this.enemigo = null;
        this.instrucciones = instrucciones;
        this.hScores = null;
        this.creditos = null;
    }

    public Animador(HiSCanvas hScores) {
        this.menu = null;
        this.splash = null;
        this.asili = null;
        this.caso = 6;
        this.trama = null;
        this.enemigo = null;
        this.instrucciones = null;
        this.hScores = hScores;
        this.creditos = null;
    }

    public Animador(CreditosCanvas creditos) {
        this.menu = null;
        this.splash = null;
        this.asili = null;
        this.caso = 7;
        this.trama = null;
        this.enemigo = null;
        this.instrucciones = null;
        this.hScores = hScores;
        this.creditos = creditos;

    }

    public void iniciar() {

        thread = new Thread(this);
        thread.start();     // Llama al método run()
    }

    public void run() {

        corriendo = true;

        while (corriendo) {

            long ini = System.currentTimeMillis();
            // Indicarle al juego que actualice a todos los objetos (posicion)
            this.actualizar();
            // Actualice la pantalla (dibuje todos los objetos)
            this.dibujar();
            long fin = System.currentTimeMillis();

            try {
                if (RETARDO - (fin - ini) >= 0) // Para evitar valores negativos
                {
                    Thread.sleep(RETARDO - (fin - ini));
                }
            } catch (InterruptedException ex) {
            }
        }
    }
    public void detener(){
        corriendo = false;
    }

    public void actualizar() {
        switch (this.caso) {
            case 1:
                asili.actualizar();
                break;

            case 2:
                menu.actualizar();
                break;

            case 3:
                splash.actualizar();
                break;
            case 4:
                trama.actualizar();
                break;
            case 5:
                instrucciones.actualizar();
                break;
            case 6:
                hScores.actualizar();
                break;
            case 7:
                creditos.actualizar();
                break;


            default:
                break;
        }

    }

    public void dibujar() {
        switch (this.caso) {
            case 1:
                asili.dibujar();
                break;

            case 2:
                menu.dibujar();
                break;

            case 3:
                splash.dibujar();
                break;

            case 4:
                trama.dibujar();
                break;
            case 5:
                instrucciones.dibujar();
                break;
            case 6:
                hScores.dibujar();
                break;
            case 7:
                creditos.dibujar();
                break;

            default:
                break;
        }


    }

    public void terminar() {
        corriendo = false;

    }
}
