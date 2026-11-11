package ejemplo01_jbutton;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MarcoBoton extends JFrame {

    private final JButton botonJButtonSimple;
    private final JButton botonJButtonElegante;

    // MODIFICACIÓN: nuevos componentes
    private final JButton botonLimpiar;
    private final JLabel etiquetaEstado;

    public MarcoBoton() {
        super("Prueba de botones");
        setLayout(new FlowLayout());

        // Botón simple
        botonJButtonSimple = new JButton("Botón simple");
        add(botonJButtonSimple);

        // Botón elegante con iconos
        // Las imágenes deben estar en resources
        java.net.URL ruta1 = getClass().getResource("/insecto1.gif");
        java.net.URL ruta2 = getClass().getResource("/insecto2.gif");

        Icon insecto1 = ruta1 != null
                ? new ImageIcon(ruta1) : null;
        Icon insecto2 = ruta2 != null
                ? new ImageIcon(ruta2) : null;

        botonJButtonElegante =
                new JButton("Botón elegante", insecto1);

        if (insecto2 != null) {
            botonJButtonElegante.setRolloverIcon(insecto2);
        }

        add(botonJButtonElegante);

        // botón para limpiar
        botonLimpiar = new JButton("Limpiar");
        add(botonLimpiar);

        // etiqueta de estado
        etiquetaEstado = new JLabel("Ningún botón presionado");
        add(etiquetaEstado);

        // Manejador de eventos original
        ManejadorBoton manejador = new ManejadorBoton();

        botonJButtonSimple.addActionListener(manejador);
        botonJButtonElegante.addActionListener(manejador);

        // evento del botón Limpiar
        botonLimpiar.addActionListener(e -> {
            etiquetaEstado.setText("Ningún botón presionado");
        });
    }

    private class ManejadorBoton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {

            String nombreBoton = evento.getActionCommand();

            // actualizar estado
            etiquetaEstado.setText("Último botón: " + nombreBoton);

            JOptionPane.showMessageDialog(
                    MarcoBoton.this,
                    String.format("Usted oprimió: %s", nombreBoton)
            );
        }
    }
}
