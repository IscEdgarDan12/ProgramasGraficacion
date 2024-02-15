package Graficacion2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Principall {

    private Lienzo l;

    public static void main(String[] args) {
        new Principall();
    }

    public Principall() {
        JFrame v = new JFrame("Girar Imagen Alv");
        l = new Lienzo("/Graficacion2/prueba.png");
        v.getContentPane().add(l);
        JPanel botonesRotacion = new JPanel(new FlowLayout());
        JButton botonSentidoHorario = new JButton("++ >");
        JButton botonSentidoAntiHorario = new JButton("< --");
        botonesRotacion.add(botonSentidoAntiHorario);
        botonesRotacion.add(botonSentidoHorario);
        v.getContentPane().add(botonesRotacion, BorderLayout.SOUTH);

        // las acciones de los botones
        botonSentidoAntiHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setRotacion(l.getRotacion() - 0.1);
                l.repaint();
            }
        });
        botonSentidoHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setRotacion(l.getRotacion() + 0.1);
                l.repaint();
            }
        });
        v.pack();
        v.setVisible(true);
        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
