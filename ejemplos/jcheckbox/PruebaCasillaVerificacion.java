import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PruebaCasillaVerificacion {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MarcoCasillaVerificacion marco =
                    new MarcoCasillaVerificacion();

            marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            marco.setSize(420, 160);
            marco.setLocationRelativeTo(null);
            marco.setVisible(true);
        });
    }
}
