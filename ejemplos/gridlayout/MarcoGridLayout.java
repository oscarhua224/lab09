import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class MarcoGridLayout extends JFrame implements ActionListener {
    private final JButton[] botones;

    private static final String[] nombres = {
            "uno", "dos", "tres",
            "cuatro", "cinco", "seis"
    };

    private final Container contenedor;

    // Esquemas originales
    private final GridLayout cuadricula1;
    private final GridLayout cuadricula2;

    // tercer esquema
    private final GridLayout cuadricula3;

    // variable para controlar tres esquemas
    private int esquemaActual = 0;

    public MarcoGridLayout() {
        super("Demostración de GridLayout");

        // Esquemas originales
        cuadricula1 = new GridLayout(2, 3, 5, 5);
        cuadricula2 = new GridLayout(3, 2);

        //nueva distribución de 1 x 6
        cuadricula3 = new GridLayout(1, 6, 5, 5);

        contenedor = getContentPane();

        // Establecer distribución inicial
        setLayout(cuadricula1);

        botones = new JButton[nombres.length];

        // Crear los seis botones
        for (int cuenta = 0; cuenta < nombres.length; cuenta++) {

            botones[cuenta] = new JButton(nombres[cuenta]);

            // Registrar ActionListener
            botones[cuenta].addActionListener(this);

            // Agregar botones al JFrame
            add(botones[cuenta]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        // avanzar al siguiente esquema
        esquemaActual = (esquemaActual + 1) % 3;

        // seleccionar entre tres distribuciones
        switch (esquemaActual) {

            case 0:
                contenedor.setLayout(cuadricula1);
                break;

            case 1:
                contenedor.setLayout(cuadricula2);
                break;

            case 2:
                contenedor.setLayout(cuadricula3);
                break;
        }

        // Actualizar distribución
        contenedor.revalidate();
        contenedor.repaint();
    }
}
