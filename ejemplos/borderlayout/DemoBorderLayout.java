import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DemoBorderLayout {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MarcoBorderLayout marco =
                    new MarcoBorderLayout();

            marco.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE
            );

            marco.setSize(500, 350);
            marco.setLocationRelativeTo(null);
            marco.setVisible(true);
        });
    }
}
