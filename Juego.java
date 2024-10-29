import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Juego extends JPanel {
    Zorro zorro = new Zorro(this);
    Monstruo monstruo = new Monstruo(this);
    Fondo fondo = new Fondo(this);
    public boolean juegoFinalizado = false;
    public boolean pierdeVida = false;
    public int vidas = 3;
    public int puntos = 0;
    public int nivel = 1;

    public Juego() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    zorro.keyPressed(e);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        setFocusable(true);
    }

    public void mover() {
        monstruo.mover();
        zorro.mover();
        fondo.mover();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        dibujar(g2);
        dibujarPuntaje(g2);
    }

    public void dibujar(Graphics2D g) {
        fondo.paint(g);
        zorro.paint(g);
        monstruo.paint(g);
        mover();
    }

    public void dibujarPuntaje(Graphics2D g) {
        Font score = new Font("Arial", Font.BOLD, 30);
        g.setFont(score);
        g.setColor(Color.BLACK);
        g.drawString("Puntaje: " + puntos, 900, 30);
        g.drawString("Vidas: " + vidas, 20, 30);
        g.drawString("Nivel: " + nivel, 570, 30);

        if (juegoFinalizado) {
            g.setColor(Color.RED);
            g.drawString("¡HAZ PERDIDOO :C !!!", ((float) getBounds().getCenterX() / 2) + 170, 70);
        }
    }

    public void finJuego() {
        juegoFinalizado = true;
    }

    public void pierdeVida() {
        pierdeVida = true;
    }

    public void resetearPosiciones() {
        zorro.resetearPosicion();
        monstruo.resetearPosicion();
    }
}
