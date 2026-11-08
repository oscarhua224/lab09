import javax.swing.*;
import java.awt.FlowLayout;

public class FlowLayoutEjemplo {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("FlowLayout - Oscar Huahuamullo");

        ventana.setSize(450, 250);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        ventana.setLayout(new FlowLayout());

        JButton boton1 = new JButton("Boton 1");
        JButton boton2 = new JButton("Boton 2");
        JButton boton3 = new JButton("Boton 3");
        JButton boton4 = new JButton("Boton 4");
        JButton boton5 = new JButton("Boton 5");

        ventana.add(boton1);
        ventana.add(boton2);
        ventana.add(boton3);
        ventana.add(boton4);
        ventana.add(boton5);

        ventana.setVisible(true);
    }
}
