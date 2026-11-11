package ejemplo02_jcheckbox;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class MarcoCasillaVerificacion extends JFrame {
    private final JTextField campoTexto;
    private final JCheckBox negritaJCheckBox;
    private final JCheckBox cursivaJCheckBox;

    // nueva casilla para cambiar el color
    private final JCheckBox rojoJCheckBox;

    public MarcoCasillaVerificacion() {
        super("Prueba de JCheckBox");
        setLayout(new FlowLayout());

        // Campo de texto
        campoTexto = new JTextField(
                "Observe cómo cambia el estilo de letra", 25
        );

        campoTexto.setFont(new Font("Serif", Font.PLAIN, 14));
        add(campoTexto);

        // Casillas originales
        negritaJCheckBox = new JCheckBox("Negrita");
        cursivaJCheckBox = new JCheckBox("Cursiva");

        add(negritaJCheckBox);
        add(cursivaJCheckBox);

        // tercera casilla
        rojoJCheckBox = new JCheckBox("Texto rojo");
        add(rojoJCheckBox);

        // Registrar manejador de eventos
        ManejadorCheckBox manejador = new ManejadorCheckBox();

        negritaJCheckBox.addItemListener(manejador);
        cursivaJCheckBox.addItemListener(manejador);

        // registrar el nuevo JCheckBox
        rojoJCheckBox.addItemListener(manejador);
    }

    private class ManejadorCheckBox implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent evento) {
            Font tipoLetra;

            // Determinar el estilo de letra
            if (negritaJCheckBox.isSelected()
                    && cursivaJCheckBox.isSelected()) {

                tipoLetra = new Font(
                        "Serif", Font.BOLD | Font.ITALIC, 14
                );

            } else if (negritaJCheckBox.isSelected()) {
                tipoLetra = new Font("Serif", Font.BOLD, 14);

            } else if (cursivaJCheckBox.isSelected()) {
                tipoLetra = new Font("Serif", Font.ITALIC, 14);

            } else {
                tipoLetra = new Font("Serif", Font.PLAIN, 14);
            }

            campoTexto.setFont(tipoLetra);

            // cambiar el color del texto
            if (rojoJCheckBox.isSelected()) {
                campoTexto.setForeground(Color.RED);
            } else {
                campoTexto.setForeground(Color.BLACK);
            }
        }
    }
}
