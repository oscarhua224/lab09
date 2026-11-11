package ejemplo04_jcombobox;

import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.net.URL;
import javax.swing.*;

public class MarcoCuadroCombinado extends JFrame {
    private final JComboBox<String> imagenesJComboBox;
    private final JLabel etiqueta;

    // etiqueta para mostrar el nombre
    private final JLabel etiquetaNombre;

    // quinta imagen
    private static final String[] nombres = {
            "insecto1.gif",
            "insecto2.gif",
            "insectviaje.gif",
            "insectanim.gif",
            "insecto5.gif"
    };

    private final Icon[] iconos = new Icon[nombres.length];

    public MarcoCuadroCombinado() {
        super("Prueba de JComboBox");
        setLayout(new FlowLayout());

        // Cargar imágenes
        for (int i = 0; i < nombres.length; i++) {
            URL ruta = getClass().getResource("/" + nombres[i]);

            if (ruta != null) {
                iconos[i] = new ImageIcon(ruta);
            } else {
                iconos[i] = null;
            }
        }

        // Crear JComboBox
        imagenesJComboBox = new JComboBox<>(nombres);
        imagenesJComboBox.setMaximumRowCount(3);

        // Etiqueta para mostrar imagen
        etiqueta = new JLabel();
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);

        // etiqueta de nombre
        etiquetaNombre = new JLabel();

        // Mostrar la primera imagen
        actualizarImagen();

        // Manejo de eventos con clase interna anónima
        imagenesJComboBox.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent evento) {

                        if (evento.getStateChange()
                                == ItemEvent.SELECTED) {

                            actualizarImagen();
                        }
                    }
                }
        );

        add(imagenesJComboBox);
        add(etiqueta);

        // mostrar nombre
        add(etiquetaNombre);
    }

    // metodo que actualiza imagen y nombre
    private void actualizarImagen() {

        int indice = imagenesJComboBox.getSelectedIndex();

        if (indice < 0) {
            return;
        }

        Icon imagen = iconos[indice];

        if (imagen != null) {
            etiqueta.setIcon(imagen);
            etiqueta.setText("");
        } else {
            etiqueta.setIcon(null);
            etiqueta.setText("Imagen no encontrada");
        }

        // actualizar nombre
        etiquetaNombre.setText(
                "Imagen seleccionada: " + nombres[indice]
        );
    }
}
