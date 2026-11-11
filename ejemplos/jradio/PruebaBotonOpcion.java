import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PruebaBotonOpcion {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MarcoBotonOpcion marco = new MarcoBotonOpcion();

            marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            marco.setSize(450, 220);
            marco.setLocationRelativeTo(null);
            marco.setVisible(true);
        });
    }
}
