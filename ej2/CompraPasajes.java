package ej2;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class CompraPasajes {
    private JTextField campoNombre;
    private JTextField campoDni;
    private JTextField campoFecha;
    private JPanel panelDatos;
    private JPanel panelViaje;
    private JComboBox comboOrigen;
    private JComboBox comboDestino;
    private JRadioButton radioPrimerPiso;
    private JRadioButton radioSegundoPiso;
    private JPanel panelAdicionales;
    private JCheckBox checkAudifonos;
    private JCheckBox checkManta;
    private JCheckBox checkRevistas;
    private JList listaServicio;
    private JPanel panelBotones;
    private JButton botonResumen;
    private JButton botonLimpiar;
    private JPanel panelPrincipal;

    public CompraPasajes() {
        String[] ciudades = {
                "Arequipa",
                "Lima",
                "Cuzco",
                "Puno",
                "Tacna",
                "Moquegua"
        };
        comboOrigen.setModel(
                new DefaultComboBoxModel<>(ciudades)
        );
        comboDestino.setModel(
                new DefaultComboBoxModel<>(ciudades)
        );
        comboOrigen.setSelectedItem("Arequipa");
        comboDestino.setSelectedItem("Lima");
        //JRADIO, configuracion de pisos
        ButtonGroup grupoPisos = new ButtonGroup();

        grupoPisos.add(radioPrimerPiso);
        grupoPisos.add(radioSegundoPiso);

        radioPrimerPiso.setSelected(true);
        //JLIST, configuracion de calidad de servicio
        listaServicio.setListData(
                new String[]{"Economico", "Estandar", "VIP"}
        );

        listaServicio.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );
        listaServicio.setSelectedIndex(0);


        botonResumen.addActionListener(e -> {
            mostrarResumen();
        });

        botonLimpiar.addActionListener(e -> {
            limpiarFormulario();
        });

    }

    private void mostrarResumen() {
        String nombre = campoNombre.getText().trim();
        String dni = campoDni.getText().trim();
        String fecha = campoFecha.getText().trim();

        if (nombre.isEmpty() || dni.isEmpty() || fecha.isEmpty()) {
            JOptionPane.showMessageDialog(
                    panelPrincipal, "Complete todos los campos",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        //validar dni
        if (!dni.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "El DNI debe contener exactamente 8 digitos",
                    "DNI invalido",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        DateTimeFormatter formato = DateTimeFormatter
                .ofPattern("dd/MM/uuuu")
                .withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate fechaViaje = LocalDate.parse(fecha, formato);
            if (fechaViaje.isBefore(LocalDate.now())) {
                JOptionPane.showMessageDialog(
                        panelPrincipal,
                        "La fecha no puede ser anterior a hoy",
                        "Fecha invalida",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Ingrese una fecha valida en formato DD/MM/AAAA",
                    "Fecha invalida",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        //obtener datos de viaje
        String origen = (String) comboOrigen.getSelectedItem();
        String destino = (String) comboDestino.getSelectedItem();

        if (origen.equals(destino)) {
            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "El origen y el destino no pueden ser iguales",
                    "Ruta invalida",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        //JRADIO, que piso selecciono usuario
        String piso;

        if (radioPrimerPiso.isSelected()) {
            piso = "Primer piso";
        } else {
            piso = "Segundo piso";
        }
        //JLIST para recuperar la calidad del servicio
        String servicio = (String) listaServicio.getSelectedValue();

        //servicios adicionales
        String adicionales = "";
        if (checkAudifonos.isSelected()) {
            adicionales += "Audifonos, ";
        }
        if (checkManta.isSelected()) {
            adicionales += "Manta, ";
        }
        if (checkRevistas.isSelected()) {
            adicionales += "Revistas, ";
        }
        if (adicionales.isEmpty()) {
            adicionales = "Ninguno";
        } else {
            adicionales = adicionales.substring(
                    0, adicionales.length() - 2
            );
        }

        String resumen =
                "Datos del Pasajero\n" +
                        "Nombre: " + nombre + "\n" +
                        "DNI: " + dni + "\n" +
                        "Fecha: " + fecha + "\n" +
                        "Datos del Viaje\n" +
                        "Origen: " + origen + "\n" +
                        "Destino: " + destino + "\n" +
                        "Piso: " + piso + "\n" +
                        "Servicio: " + servicio + "\n" +
                        "Datos Adicionales\n" +
                        adicionales;
        JOptionPane.showMessageDialog(
                panelPrincipal,
                resumen,
                "Resumen de compra de pasaje",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void limpiarFormulario() {
        //cuadros de texto
        campoDni.setText("");
        campoFecha.setText("");
        campoNombre.setText("");
        //restablecer ciudades
        comboOrigen.setSelectedItem("Arequipa");
        comboDestino.setSelectedItem("Lima");
        //restablecer piso
        radioPrimerPiso.setSelected(true);
        //restablecer servicio
        listaServicio.setSelectedIndex(0);
        //desmarcar servicios adicionales
        checkAudifonos.setSelected(false);
        checkManta.setSelected(false);
        checkRevistas.setSelected(false);
        //regresar el cursor al nombre
        campoDni.requestFocusInWindow();
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(8, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelDatos = new JPanel();
        panelDatos.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1, true, false));
        panelPrincipal.add(panelDatos, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        campoDni = new JTextField();
        campoDni.setText("");
        panelDatos.add(campoDni, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        campoFecha = new JTextField();
        campoFecha.setText("");
        panelDatos.add(campoFecha, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        campoNombre = new JTextField();
        campoNombre.setText("");
        panelDatos.add(campoNombre, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("DNI");
        panelDatos.add(label1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(248, 17), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Fecha");
        panelDatos.add(label2, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Ingrese su nombre completo");
        panelDatos.add(label3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panelViaje = new JPanel();
        panelViaje.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 2, new Insets(0, 0, 0, 0), -1, -1, true, false));
        panelPrincipal.add(panelViaje, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        comboOrigen = new JComboBox();
        comboOrigen.setEditable(false);
        comboOrigen.setEnabled(true);
        comboOrigen.setToolTipText("");
        panelViaje.add(comboOrigen, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboDestino = new JComboBox();
        panelViaje.add(comboDestino, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioPrimerPiso = new JRadioButton();
        radioPrimerPiso.setText("Primer Piso");
        panelViaje.add(radioPrimerPiso, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioSegundoPiso = new JRadioButton();
        radioSegundoPiso.setText("Segundo Piso");
        panelViaje.add(radioSegundoPiso, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        listaServicio = new JList();
        final DefaultListModel defaultListModel1 = new DefaultListModel();
        defaultListModel1.addElement("Economico");
        defaultListModel1.addElement("Estandar");
        defaultListModel1.addElement("VIP");
        listaServicio.setModel(defaultListModel1);
        panelViaje.add(listaServicio, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Origen");
        panelViaje.add(label4, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(260, 17), null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Destino");
        panelViaje.add(label5, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Piso del bus");
        panelViaje.add(label6, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Calidad de Servicio");
        panelViaje.add(label7, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panelAdicionales = new JPanel();
        panelAdicionales.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1, true, false));
        panelPrincipal.add(panelAdicionales, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        checkAudifonos = new JCheckBox();
        checkAudifonos.setText("Audifonos");
        panelAdicionales.add(checkAudifonos, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        checkManta = new JCheckBox();
        checkManta.setText("Manta");
        panelAdicionales.add(checkManta, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        checkRevistas = new JCheckBox();
        checkRevistas.setText("Revistas");
        panelAdicionales.add(checkRevistas, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panelBotones = new JPanel();
        panelBotones.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1, true, false));
        panelPrincipal.add(panelBotones, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        botonResumen = new JButton();
        botonResumen.setText("Resumen");
        panelBotones.add(botonResumen, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonLimpiar = new JButton();
        botonLimpiar.setText("Limpiar");
        panelBotones.add(botonLimpiar, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Datos del Viaje");
        panelPrincipal.add(label8, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("Servicios Adicionales");
        panelPrincipal.add(label9, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("Datos del Pasajero");
        panelPrincipal.add(label10, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelPrincipal;
    }

}
