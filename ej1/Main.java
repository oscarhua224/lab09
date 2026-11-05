import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame(
                    "Sistema de compra de pasajes"
            );
            CompraPasajes formulario = new CompraPasajes();

            ventana.setContentPane(
                    formulario.getPanelPrincipal()
            );
            ventana.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE
            );

            ventana.pack();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}
