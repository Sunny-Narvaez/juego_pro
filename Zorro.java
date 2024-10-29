import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import java.awt.Rectangle;

public class Zorro {
    Juego juego1;

    static boolean saltando = false;
    boolean sube = false;
    boolean baja = false;

    int anchozpersonaje = 168;
    int altopersonaje = 165;
    static int x_inicial = 50;
    static int y_inicial = 380;
    int x_auxiliar = 0;
    int y_auxiliar = 0;

    public Zorro(Juego juego1) {
        this.juego1 = juego1;
    }

    public void mover() {
        if (x_inicial + x_auxiliar > 0 && x_inicial + x_auxiliar < juego1.getWidth() - anchozpersonaje) {
            x_inicial += x_auxiliar;
        }
        if (saltando) {
            if (y_inicial == 380) {
                sube = true;
                y_auxiliar = -5;
                baja = false;
            }
            if (y_inicial == 200) {
                baja = true;
                y_auxiliar = 6;
                sube = false;
            }
            if (sube) {
                y_inicial += y_auxiliar;
            }
            if (baja) {
                y_inicial += y_auxiliar;
                if (y_inicial == 380) {
                    saltando = false;
                }
            }
        }
    }

    public void paint(Graphics2D g) {
        ImageIcon zorro = new ImageIcon(getClass().getResource("zorro_walk.gif"));
        g.drawImage(zorro.getImage(), x_inicial, y_inicial, anchozpersonaje, altopersonaje, null);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            saltando = true;
        }
    }

    public Area getBounds() {
        Rectangle forma1 = new Rectangle(x_inicial, y_inicial, 95, 62);
        return new Area(forma1);
    }

    public void resetearPosicion() {
        x_inicial = 50;
        y_inicial = 380;
        x_auxiliar = 0;
        y_auxiliar = 0;
        saltando = false;
    }
}