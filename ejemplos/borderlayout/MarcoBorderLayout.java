import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MarcoBorderLayout extends JFrame implements ActionListener {
    private final JButton[] botones;

    private static final String[] nombres = {
            "Ocultar Norte",
            "Ocultar Sur",
            "Ocultar Este",
            "Ocultar Oeste",
            "Ocultar Centro"
    };

    private final BorderLayout esquema;

    // botón para restaurar las regiones
    private final JButton botonRestablecer;

    // panel para los cinco botones originales
    private final JPanel panelRegiones;

    public MarcoBorderLayout() {
        super("Demostración de BorderLayout");

        // esquema principal de la ventana
        setLayout(new BorderLayout());

        // Panel que contiene el BorderLayout original
        esquema = new BorderLayout(5, 5);
        panelRegiones = new JPanel(esquema);

        botones = new JButton[nombres.length];

        // Crear los cinco botones originales
        for (int cuenta = 0; cuenta < nombres.length; cuenta++) {

            botones[cuenta] = new JButton(nombres[cuenta]);
            botones[cuenta].addActionListener(this);
        }

        // Distribuir los botones en sus regiones
        panelRegiones.add(botones[0], BorderLayout.NORTH);
        panelRegiones.add(botones[1], BorderLayout.SOUTH);
        panelRegiones.add(botones[2], BorderLayout.EAST);
        panelRegiones.add(botones[3], BorderLayout.WEST);
        panelRegiones.add(botones[4], BorderLayout.CENTER);

        // Agregar el panel de regiones a la ventana
        add(panelRegiones, BorderLayout.CENTER);

        // crear botón de restablecimiento
        botonRestablecer = new JButton("Restablecer regiones");

        // restaurar todos los botones
        botonRestablecer.addActionListener(e -> {

            for (JButton boton : botones) {
                boton.setVisible(true);
            }

            panelRegiones.revalidate();
            panelRegiones.repaint();
        });

        // panel independiente para el botón
        JPanel panelInferior = new JPanel();
        panelInferior.add(botonRestablecer);

        add(panelInferior, BorderLayout.SOUTH);
    }

    // Manejo de eventos original
    @Override
    public void actionPerformed(ActionEvent evento) {

        for (JButton boton : botones) {

            if (evento.getSource() == boton) {
                boton.setVisible(false);
            } else {
                boton.setVisible(true);
            }
        }
        // Actualizar la distribución
        panelRegiones.revalidate();
        panelRegiones.repaint();
    }
}
