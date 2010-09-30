
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;


/**
 *
 * @author Fer
 */
public class AdministradorJuego extends GameCanvas {

    private boolean pointIsDragged;
     private Graphics g;
     private Avatar avatar;
     
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

         /*// Dibujar  todos los objetos de la aplicación
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

        flushGraphics();    // Actualiza los cambios en la memoria de la pantalla*/
    }

    protected void pointDragged(int x, int y) {
        if(x == avatar.getX() && y == avatar.getY()) { //Si el puntero esta en el mismo punto que la nave
            this.pointIsDragged = true; //Empieza a disparar
            avatar.actualizarPosicion(x, y);
        }

    }
    
    protected void pointReleased (int x, int y) {
        this.pointIsDragged = false; //Deja de disparar
    }

    public boolean getPointIsDragged() {
        return this.pointIsDragged;
    }

    /*/Para saber si la nave debe de disparar o no
    protected boolean pointPressed (int x, int y) {
        if (x == avatar.getX() && y == avatar.getY())
            return true;
        else
            return false;
    }
     */

    private void verificarChoque() {


    }
    

}
