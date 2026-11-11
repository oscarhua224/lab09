import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class MarcoLista extends JFrame {

    private final JList<String> listaJListColores;

    // Colores originales
    private static final String[] nombresColores = {
            "Negro", "Azul", "Cyan",
            "Gris oscuro", "Gris", "Verde",
            "Gris claro", "Magenta",
            "Naranja", "Rosa", "Rojo",
            "Blanco", "Amarillo"
    };

    private static final Color[] colores = {
            Color.BLACK, Color.BLUE, Color.CYAN,
            Color.DARK_GRAY, Color.GRAY, Color.GREEN,
            Color.LIGHT_GRAY, Color.MAGENTA,
            Color.ORANGE, Color.PINK, Color.RED,
            Color.WHITE, Color.YELLOW
    };

    // nuevos componentes
    private final JButton botonRestablecer;
    private final JLabel etiquetaColor;
    private final Color colorOriginal;

    public MarcoLista() {
        super("Prueba de JList");
        setLayout(new FlowLayout());

        // guardar el color original
        colorOriginal = getContentPane().getBackground();

        // Crear JList
        listaJListColores = new JList<>(nombresColores);
        listaJListColores.setVisibleRowCount(5);

        // Permitir seleccionar un solo color
        listaJListColores.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        // Agregar lista con barra de desplazamiento
        add(new JScrollPane(listaJListColores));

        // etiqueta informativa
        etiquetaColor = new JLabel("Color seleccionado: Ninguno");
        add(etiquetaColor);

        // botón para restablecer
        botonRestablecer = new JButton("Restablecer color");
        add(botonRestablecer);

        // Evento de selección
        listaJListColores.addListSelectionListener(
                new ListSelectionListener() {

                    @Override
                    public void valueChanged(ListSelectionEvent evento) {

                        if (!evento.getValueIsAdjusting()) {

                            int indice =
                                    listaJListColores.getSelectedIndex();

                            if (indice != -1) {

                                // Cambiar fondo
                                getContentPane().setBackground(
                                        colores[indice]
                                );

                                // MODIFICACIÓN: mostrar nombre
                                etiquetaColor.setText(
                                        "Color seleccionado: "
                                                + nombresColores[indice]
                                );
                            }
                        }
                    }
                }
        );

        // evento del botón
        botonRestablecer.addActionListener(e -> {

            // Restaurar color de fondo
            getContentPane().setBackground(colorOriginal);

            // Limpiar selección
            listaJListColores.clearSelection();

            // Restaurar etiqueta
            etiquetaColor.setText(
                    "Color seleccionado: Ninguno"
            );
        });
    }
}
