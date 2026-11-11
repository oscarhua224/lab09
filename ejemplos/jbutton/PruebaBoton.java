import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PruebaBoton {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MarcoBoton marcoBoton = new MarcoBoton();

            marcoBoton.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE
            );

            marcoBoton.setSize(420, 170);
            marcoBoton.setLocationRelativeTo(null);
            marcoBoton.setVisible(true);
        });
    }
}
