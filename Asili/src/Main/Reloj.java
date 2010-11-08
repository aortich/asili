package Main;

/**
 *
 * @author Alberto Ortiz
 */
public class Reloj
{
    private int tiempo;
    private int limite;

    /**
     * Cuenta el tiempo, al acumular retardos
     * @param limite El límite al que puede llegar el reloj
     */
    public Reloj(int limite) {

        this.limite = limite;
        tiempo=0;
    }

    /**
     *
     * @param lapso El tiempo que se agrega al reloj, en milisegundos
     */
    public void incrementar(int lapso) {
        tiempo += lapso;
    }

    /**
     *
     * @return Regresa el tiempo que leva actual, en milisegundos
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     *
     * @param tiempo EL tiempo que se le da al reloj, en milisegundos
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * Reinicia el reloj en cero.
     */
    public void resetReloj() {
        this.tiempo = 0;
    }
}

