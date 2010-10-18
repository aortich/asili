public class Reloj
{
    private int tiempo;
    private int limite;

    public Reloj(int limite) {

        this.limite = limite;
        tiempo=0;
    }

    public void incrementar(int lapso) {
        tiempo += lapso;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}

