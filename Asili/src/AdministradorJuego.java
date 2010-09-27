
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;


/**
 *
 * @author Fer
 */
public class AdministradorJuego extends GameCanvas {

     private Graphics g;
     
     public static int ANCHO;        // Ancho y alto de la pantalla del celular
     public static int ALTO;


    public AdministradorJuego(){
        super(true);
        g = this.getGraphics();
        this.ANCHO = this.getWidth();
        this.ALTO = this.getHeight();
    }

    void actualizar() {

        // Leer el teclado

    }

    void dibujar() {

        // Borra la pantalla
        g.setColor(0x00FF00);
        g.fillRect(0, 0, ANCHO, ALTO);

        // Dibujar  todos los objetos de la aplicación
        fondo.dibujar(g);
        mapa.dibujar(g);

        pelota.dibujar(g);
        raqueta.dibujar(g);

        if ( pausado ) {
            pausa.dibujar(g);
        }
        indicador.setPosition(pelota.getX(), 0);
        indicador.paint(g);

        int m = reloj.getTiempo()/1000 / 60;
        int s = reloj.getTiempo()/1000 % 60;

        g.drawString(m+":"+s, 30, 10, Graphics.LEFT|Graphics.TOP);

        flushGraphics();    // Actualiza los cambios en la memoria de la pantalla
    }

    private void moverAvatar(int teclado) {

    }
    private void verificarChoque() {


    }
    

}
