import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PruebaCuadroCombinado {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MarcoCuadroCombinado marco =
                    new MarcoCuadroCombinado();

            marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            marco.setSize(450, 300);
            marco.setLocationRelativeTo(null);
            marco.setVisible(true);
        });
    }
}
