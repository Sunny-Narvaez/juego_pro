import java.awt.geom.Area;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.util.Random;


public class Monstruo {
    Juego juego1;
    Area cabeza, cuerpo, slime;
    int anchomonstruo = 90;
    int altomonstruo = 90;
    static int x_inicial = 1100;
    static int y_inicial = 415;
    static int x_auxiliar = -5;
    String[] texturas = {"steppicusor.png", "steppicusor2.png"};


    public Monstruo(Juego juego1) {
        this.juego1 = juego1;


    }

    public void mover() {
        if (x_inicial <= -100) {
            juego1.puntos++;
            x_inicial = 1100;
            if (juego1.puntos == 3 || juego1.puntos == 6 || juego1.puntos == 9 || juego1.puntos == 12) {
                x_auxiliar -= 2;
                juego1.nivel++;
            }
        } else {
            if (colision()) {
                if (juego1.vidas == 0) {
                    juego1.finJuego();
                } else {
                    juego1.pierdeVida();
                }
            } else {
                x_inicial += x_auxiliar;
            }
        }
    }

    public void paint(Graphics2D g) {
        Random random = new Random();
        int indiceTextura = random.nextInt(texturas.length);
        String nombreTextura = texturas[indiceTextura];
        ImageIcon moco = new ImageIcon(getClass().getResource(nombreTextura));
        g.drawImage(moco.getImage(), x_inicial, y_inicial, anchomonstruo, altomonstruo, null);
    }
    

    public Area getBounds() {
        Rectangle forma1 = new Rectangle(x_inicial, y_inicial, 40, 40);
        Rectangle forma2 = new Rectangle(x_inicial + 12, y_inicial + 16, 50, 53);
        Area cabeza = new Area(forma1);
        Area cuerpo = new Area(forma2);
        Area slime = new Area(cabeza);
        slime.add(cabeza);
        slime.add(cuerpo);
        return slime;
    }

    public boolean colision() {
        Area areaA = new Area(juego1.zorro.getBounds());
        areaA.intersect(getBounds());
        return !areaA.isEmpty();
    }

    public void resetearPosicion() {
        x_inicial = 1100;
    }
}
