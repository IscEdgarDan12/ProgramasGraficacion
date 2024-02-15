/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficacion2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author DanKuzo
 */
public class Mycomponent extends JComponent {

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform tx = new AffineTransform();
        double shiftx = .1;
        double shifty = .3;
        tx.shear(shiftx, shifty);
        g2d.setTransform(tx);
        g2d.drawImage(new ImageIcon("/Graficacion2/Imagen.png").getImage(), tx, this);
    }
}
