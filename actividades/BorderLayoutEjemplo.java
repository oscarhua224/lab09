import javax.swing.*;
import java.awt.BorderLayout;

public class BorderLayoutEjemplo {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Border Layout - Oscar Huahuamullo");

        ventana.setSize(500,350);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        ventana.setLayout(new BorderLayout());

        JButton botonNorte = new JButton("NORTE");
        JButton botonSur = new JButton("SUR");
        JButton botonEste = new JButton("ESTE");
        JButton botonOeste = new JButton("OESTE");
        JButton botonCentro = new JButton("CENTRO");

        ventana.add(botonNorte, BorderLayout.NORTH);
        ventana.add(botonSur, BorderLayout.SOUTH);
        ventana.add(botonEste, BorderLayout.EAST);
        ventana.add(botonOeste, BorderLayout.WEST);
        ventana.add(botonCentro, BorderLayout.CENTER);

        ventana.setVisible(true);
    }
}
