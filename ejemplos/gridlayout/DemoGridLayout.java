import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DemoGridLayout {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MarcoGridLayout marco = new MarcoGridLayout();

            marco.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE
            );

            marco.setSize(650, 250);
            marco.setLocationRelativeTo(null);
            marco.setVisible(true);
        });
    }
}
