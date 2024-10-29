import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Fondo {
    Juego juego1;
    int anchoFondo = 1000;
    int altoFondo = 600;
    int x1 = 1000;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;

    public Fondo(Juego juego1) {
        this.juego1 = juego1;
    }

    public void mover() {
        x1 -= 2;
        x2 -= 2;
        if (x1 == 0 && x2 == -1000) {
            x1 = 1000;
            x2 = 0;
        }
    }

    public void paint(Graphics2D g) {
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("FondoN.png"));
        g.drawImage(imagenFondo.getImage(), x1, y1, anchoFondo, altoFondo, null);
        g.drawImage(imagenFondo.getImage(), x2, y2, anchoFondo, altoFondo, null);
    }
}
