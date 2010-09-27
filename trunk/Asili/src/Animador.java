/***********************************************************************
 ***********************************************************************
 * IMPORTANTE:
 * Preguntar todo referente a Threads.
 *
 *
 * *********************************************************************
 * ********************************************************************
 */

/**
 *
 * @author Fer
 */
public class Animador implements Runnable {

    private Asili asili;        // Juego debería ser una interface
    private boolean corriendo;
    private Thread thread;
    private static final int FPS = 50;
    public static final int RETARDO = 1000 / FPS;

    public Animador(Asili juego) {

        this.asili = juego;
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
            asili.actualizar();
            // Actualice la pantalla (dibuje todos los objetos)
            asili.dibujar();
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

    public void terminar() {
        corriendo = false;
    }
}
