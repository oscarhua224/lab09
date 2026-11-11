import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PruebaSeleccionMultiple {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MarcoSeleccionMultiple marco =
                    new MarcoSeleccionMultiple();

            marco.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE
            );

            marco.setSize(470, 260);
            marco.setLocationRelativeTo(null);
            marco.setVisible(true);
        });
    }
}
