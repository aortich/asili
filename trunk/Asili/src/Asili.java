
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;


/**
 *
 * @author Fer
 */
public class Asili extends GameCanvas {

    private Fondo fondo;
    private Avatar avatar;
    private Proyectil proyectil;
    private Enemigo enemigo;
    private boolean pausado=false;
    private Fondo fondoPausa;
 
    public static int ANCHO;        // Ancho y alto de la pantalla del celular
    public static int ALTO;
    private Animador animador;  // Estará avisando a cada rato que se actualice y dibuje queda pendiente la clase
    private Graphics g;
    private AppAsili midlet;

    public Asili (AppAsili midlet) {
        super(true);

        this.midlet = midlet;
        this.setFullScreenMode(true);
        this.ANCHO = this.getWidth();
        this.ALTO = this.getHeight();
        g = this.getGraphics();

        try {
            avatar = new Avatar(5,5,ANCHO,ALTO,"/avatar.jpg");
            fondo = new Fondo("/fondo.jpg", 0, 0);
            fondoPausa = new Fondo("/pausa.png", 0, 0);
            Image img = Image.createImage("/linea.png");   //*********************
            indicador = new Sprite(img, 20, 20);
            int[] secuencia = { 0,0,0,2 };
            indicador.setFrameSequence(secuencia);
            raqueta = new Raqueta(getWidth()/2, getHeight()-10, "/raqueta.jpg");
            mapa = new Mapa();
            mapa.crearMapa();
        } catch (IOException ex) {
            System.out.println("No se pueden cargar los fondos");
        }

        
    }

}
