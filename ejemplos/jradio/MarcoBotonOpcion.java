import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class MarcoBotonOpcion extends JFrame {
    private final JTextField campoTexto;

    // Botones originales
    private final JRadioButton simpleJRadioButton;
    private final JRadioButton negritaJRadioButton;
    private final JRadioButton cursivaJRadioButton;
    private final JRadioButton negritaCursivaJRadioButton;

    private final ButtonGroup grupoOpciones;

    // opciones de tamaño
    private final JRadioButton tamano14;
    private final JRadioButton tamano18;
    private final JRadioButton tamano24;
    private final ButtonGroup grupoTamanos;

    public MarcoBotonOpcion() {
        super("Prueba de JRadioButton");
        setLayout(new FlowLayout());

        campoTexto = new JTextField(
                "Observe el cambio en el estilo de letra", 25
        );
        campoTexto.setEditable(false);
        add(campoTexto);

        // Crear botones originales
        simpleJRadioButton = new JRadioButton("Simple", true);
        negritaJRadioButton = new JRadioButton("Negrita", false);
        cursivaJRadioButton = new JRadioButton("Cursiva", false);
        negritaCursivaJRadioButton =
                new JRadioButton("Negrita/Cursiva", false);

        add(simpleJRadioButton);
        add(negritaJRadioButton);
        add(cursivaJRadioButton);
        add(negritaCursivaJRadioButton);

        // Agrupar estilos
        grupoOpciones = new ButtonGroup();
        grupoOpciones.add(simpleJRadioButton);
        grupoOpciones.add(negritaJRadioButton);
        grupoOpciones.add(cursivaJRadioButton);
        grupoOpciones.add(negritaCursivaJRadioButton);

        // botones para tamaños de letra
        tamano14 = new JRadioButton("14 pt", true);
        tamano18 = new JRadioButton("18 pt");
        tamano24 = new JRadioButton("24 pt");

        // segundo grupo independiente
        grupoTamanos = new ButtonGroup();
        grupoTamanos.add(tamano14);
        grupoTamanos.add(tamano18);
        grupoTamanos.add(tamano24);

        add(new JLabel("Tamaño:"));
        add(tamano14);
        add(tamano18);
        add(tamano24);

        // Registrar eventos
        ManejadorBotonOpcion manejador =
                new ManejadorBotonOpcion();

        simpleJRadioButton.addItemListener(manejador);
        negritaJRadioButton.addItemListener(manejador);
        cursivaJRadioButton.addItemListener(manejador);
        negritaCursivaJRadioButton.addItemListener(manejador);

        // eventos de los tamaños
        tamano14.addItemListener(manejador);
        tamano18.addItemListener(manejador);
        tamano24.addItemListener(manejador);

        actualizarFuente();
    }

    // método que combina estilo y tamaño
    private void actualizarFuente() {

        int estilo = Font.PLAIN;

        if (negritaJRadioButton.isSelected()) {
            estilo = Font.BOLD;
        } else if (cursivaJRadioButton.isSelected()) {
            estilo = Font.ITALIC;
        } else if (negritaCursivaJRadioButton.isSelected()) {
            estilo = Font.BOLD | Font.ITALIC;
        }

        int tamano = 14;

        if (tamano18.isSelected()) {
            tamano = 18;
        } else if (tamano24.isSelected()) {
            tamano = 24;
        }

        campoTexto.setFont(new Font("Serif", estilo, tamano));
    }

    private class ManejadorBotonOpcion implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent evento) {

            if (evento.getStateChange() == ItemEvent.SELECTED) {
                actualizarFuente();
            }
        }
    }
}
