import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MarcoSeleccionMultiple extends JFrame {
    private final JList<String> listaJListColores;
    private final JList<String> listaJListCopia;

    private final JButton botonJButtonCopiar;

    // nuevo botón
    private final JButton botonLimpiar;

    private static final String[] nombresColores = {
            "Negro", "Azul", "Cyan",
            "Gris oscuro", "Gris", "Verde",
            "Gris claro", "Magenta", "Naranja",
            "Rosa", "Rojo", "Blanco", "Amarillo"
    };

    public MarcoSeleccionMultiple() {
        super("Listas de selección múltiple");
        setLayout(new FlowLayout());

        // Crear lista original de colores
        listaJListColores = new JList<>(nombresColores);
        listaJListColores.setVisibleRowCount(5);

        listaJListColores.setSelectionMode(
                ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
        );

        add(new JScrollPane(listaJListColores));

        // Crear botón para copiar
        botonJButtonCopiar = new JButton("Copiar >>>");

        botonJButtonCopiar.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evento) {

                        listaJListCopia.setListData(
                                listaJListColores
                                        .getSelectedValuesList()
                                        .toArray(new String[0])
                        );
                    }
                }
        );

        add(botonJButtonCopiar);

        // Crear lista de destino
        listaJListCopia = new JList<>();
        listaJListCopia.setVisibleRowCount(5);
        listaJListCopia.setFixedCellWidth(100);
        listaJListCopia.setFixedCellHeight(20);

        listaJListCopia.setSelectionMode(
                ListSelectionModel.SINGLE_INTERVAL_SELECTION
        );

        add(new JScrollPane(listaJListCopia));

        // botón para limpiar lista
        botonLimpiar = new JButton("Limpiar lista");

        // evento del nuevo botón
        botonLimpiar.addActionListener(e -> {

            listaJListCopia.setListData(new String[0]);

        });

        add(botonLimpiar);
    }
}
