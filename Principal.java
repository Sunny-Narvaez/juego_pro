import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Principal {

    public static int reiniciaJuego = -1;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,
                "INSTRUCCIONES: El juego consiste en saltar todos los obstaculos y hacer el mayor puntaje posible. \nAhora, ¿estás listo? :D");

        System.out.println("Intentando cargar Juego...");
        Juego juego1 = new Juego();
        System.out.println("Juego cargado correctamente.");

        JFrame ventana = new JFrame("ZorroJuego");
        ventana.add(juego1);
        ventana.setSize(1100, 600);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            if (juego1.juegoFinalizado) {
                reiniciaJuego = JOptionPane.showConfirmDialog(null, "Haz perdido, ¿Quieres jugar de nuevo?",
                        "Haz Perdido", JOptionPane.YES_NO_OPTION);
                if (reiniciaJuego == 0) {
                    reiniciaValores(juego1);
                } else if (reiniciaJuego == 1) {
                    System.exit(0);
                }
            } else {
                juego1.repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                if (juego1.pierdeVida) {
                    JOptionPane.showMessageDialog(null, "CUIDADO!!! ");
                    juego1.pierdeVida = false;
                    juego1.vidas--;
                    juego1.resetearPosiciones();
                }
            }
        }
    }

    public static void reiniciaValores(Juego juego1) {
        juego1.juegoFinalizado = false;
        juego1.monstruo.resetearPosicion();
        juego1.puntos = 0;
        juego1.nivel = 1;
        juego1.vidas = 3;
        reiniciaJuego = -1;
        juego1.zorro.resetearPosicion();
    }

}
