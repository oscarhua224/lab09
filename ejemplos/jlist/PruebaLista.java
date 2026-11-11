import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PruebaLista {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MarcoLista marcoLista = new MarcoLista();

            marcoLista.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE
            );

            marcoLista.setSize(450, 250);
            marcoLista.setLocationRelativeTo(null);
            marcoLista.setVisible(true);
        });
    }
}
