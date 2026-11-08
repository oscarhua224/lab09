package actividad;

import javax.swing.*;
import java.awt.GridLayout;

public class GridLayoutEjemplo {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("GridLayout - Oscar Huahuamullo");

        ventana.setSize(500, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        ventana.setLayout(new GridLayout(3, 3, 5, 5));

        JButton boton1 = new JButton("Boton 1");
        JButton boton2 = new JButton("Boton 2");
        JButton boton3 = new JButton("Boton 3");
        JButton boton4 = new JButton("Boton 4");
        JButton boton5 = new JButton("Boton 5");
        JButton boton6 = new JButton("Boton 6");
        JButton boton7 = new JButton("Boton 7");
        JButton boton8 = new JButton("Boton 8");
        JButton boton9 = new JButton("Boton 9");

        ventana.add(boton1);
        ventana.add(boton2);
        ventana.add(boton3);
        ventana.add(boton4);
        ventana.add(boton5);
        ventana.add(boton6);
        ventana.add(boton7);
        ventana.add(boton8);
        ventana.add(boton9);

        ventana.setVisible(true);
    }
}
