import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            JFrame ventana = new JFrame(
                    "Registro de estudiantes"
            );

            RegistroEstudiantes formulario =
                    new RegistroEstudiantes();

            ventana.setContentPane(
                    formulario.getPanelPrincipal()
            );
            ventana.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE
            );
            ventana.pack();
            ventana.setSize(500, 300);
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}
