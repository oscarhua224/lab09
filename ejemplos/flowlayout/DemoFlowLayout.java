import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DemoFlowLayout {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            MarcoFlowLayout marcoFlowLayout =
                    new MarcoFlowLayout();

            marcoFlowLayout.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE
            );

            marcoFlowLayout.setSize(500, 200);
            marcoFlowLayout.setLocationRelativeTo(null);
            marcoFlowLayout.setVisible(true);
        });
    }
}
