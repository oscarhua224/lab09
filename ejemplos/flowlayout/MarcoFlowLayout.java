import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class MarcoFlowLayout extends JFrame {
    private final JButton botonJButtonIzquierda;
    private final JButton botonJButtonCentro;
    private final JButton botonJButtonDerecha;

    private final FlowLayout esquema;
    private final Container contenedor;

    // nuevo botón y variable de control
    private final JButton botonCambiarEspaciado;
    private boolean espaciadoAmpliado = false;

    public MarcoFlowLayout() {
        super("Demostración de FlowLayout");

        esquema = new FlowLayout();
        contenedor = getContentPane();
        setLayout(esquema);

        // Botón Izquierda
        botonJButtonIzquierda = new JButton("Izquierda");
        add(botonJButtonIzquierda);

        botonJButtonIzquierda.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evento) {

                        esquema.setAlignment(FlowLayout.LEFT);
                        contenedor.revalidate();
                        contenedor.repaint();
                    }
                }
        );

        // Botón Centro
        botonJButtonCentro = new JButton("Centro");
        add(botonJButtonCentro);

        botonJButtonCentro.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evento) {

                        esquema.setAlignment(FlowLayout.CENTER);
                        contenedor.revalidate();
                        contenedor.repaint();
                    }
                }
        );

        // Botón Derecha
        botonJButtonDerecha = new JButton("Derecha");
        add(botonJButtonDerecha);

        botonJButtonDerecha.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evento) {

                        esquema.setAlignment(FlowLayout.RIGHT);
                        contenedor.revalidate();
                        contenedor.repaint();
                    }
                }
        );

        // nuevo botón
        botonCambiarEspaciado = new JButton("Cambiar espaciado");
        add(botonCambiarEspaciado);

        // evento del cuarto botón
        botonCambiarEspaciado.addActionListener(e -> {
            if (!espaciadoAmpliado) {

                esquema.setHgap(20);
                esquema.setVgap(20);

                espaciadoAmpliado = true;

            } else {

                esquema.setHgap(5);
                esquema.setVgap(5);

                espaciadoAmpliado = false;
            }
            // Actualizar la distribución
            contenedor.revalidate();
            contenedor.repaint();
        });
    }
}
