package Menus;


import Main.Animador;
import Main.AppAsili;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

/**
 *
 * @author Fer
 */
public class MenuPrincipal extends GameCanvas {

    private AppAsili midlet;
    private int ANCHO, ALTO;
    private Graphics g;
    private FondoMenu fondo;
    private SpriteInicio spriteInicio;
    private SpriteTrama spriteTrama;
    private SpriteInstrucciones spriteInstrucciones;
    private SpriteHighscores spriteHighscores;
    private SpriteCreditos spriteCreditos;
    private Animador animador;

    public MenuPrincipal(AppAsili midlet) {
        super(true);

        this.midlet = midlet;
        this.setFullScreenMode(true);
        this.ANCHO = this.getWidth();
        this.ALTO = this.getHeight();
        g = this.getGraphics();
        try {
            spriteInicio = new SpriteInicio(0, 3);
            spriteTrama = new SpriteTrama(0,3);
            spriteInstrucciones = new SpriteInstrucciones(0,3);
            spriteHighscores = new SpriteHighscores (0,3);
            spriteCreditos = new SpriteCreditos (0,3);
            fondo = new FondoMenu("/imagenes/menuPrincipal.jpg");
        } catch (IOException ex) {
            System.out.println("Error de IO");
            ex.printStackTrace();
        }
        animador = new Animador(this);
        animador.iniciar();


    }
    //Comprobación de cajas (Qué opción de seleccionó)

    protected void pointerPressed(int aX, int aY) {
        //Caja de la opción inicio
        if (aX >= (spriteInicio.getX()) && aX <= (spriteInicio.getX() + spriteInicio.getWidth())
                && aY >= spriteInicio.getY() && aY <= (spriteInicio.getY() + spriteInicio.getHeight())) {
            midlet.actualizarApp(1);
        }
        //Caja de la opción trama
        if (aX >= (spriteTrama.getX()) && aX <= (spriteTrama.getX() + spriteTrama.getWidth())
                && aY >= spriteTrama.getY() && aY <= (spriteTrama.getY() + spriteTrama.getHeight())) {
            //Aquí debe de ir la acción a tomar cuando se pique la opción de trama
            midlet.actualizarApp(2);
        }
        //Caja de la opción instrucciones
        if (aX >= (spriteInstrucciones.getX()) && aX <= (spriteInstrucciones.getX() + spriteInstrucciones.getWidth())
                && aY >= spriteInstrucciones.getY() && aY <= (spriteInstrucciones.getY() + spriteInstrucciones.getHeight())) {
            //Aquí debe de ir la acción a tomar cuando se pique la opción de instrucciones
            midlet.actualizarApp(3);
        }
        //Caja de la opción highscores
        if (aX >= (spriteHighscores.getX()) && aX <= (spriteHighscores.getX() + spriteHighscores.getWidth())
                && aY >= spriteHighscores.getY() && aY <= (spriteHighscores.getY() + spriteHighscores.getHeight())) {
                midlet.actualizarApp(4);
            //Aquí debe de ir la acción a tomar cuando se pique la opción de Highscores
        }
        //Caja de la opción creditos
        if (aX >= (spriteCreditos.getX()) && aX <= (spriteCreditos.getX() + spriteCreditos.getWidth())
                && aY >= spriteCreditos.getY() && aY <= (spriteCreditos.getY() + spriteCreditos.getHeight())) {
            midlet.actualizarApp(5);
            System.out.println("Creditos");
        }

    }

    public void dibujar(){
        fondo.dibujar(g);
        spriteInicio.dibujar(g);
        spriteTrama.dibujar(g);
        spriteInstrucciones.dibujar(g);
        spriteHighscores.dibujar(g);
        spriteCreditos.dibujar(g);

    }

    public void actualizar(){
       // fondo.actualizar();
        //spriteInicio.actualizar();
    }
}
