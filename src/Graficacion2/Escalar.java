package Graficacion2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Escalar {

    static JFrame jFrameWindow;

    public static class MyComponent extends JComponent {

        @Override
        protected void paintComponent(Graphics g) {
            try {
                Image image = ImageIO.read(this.getClass().getResource("/Graficacion2/prueba.png"));
                int w = image.getWidth(null);
                int h = image.getHeight(null);
                g.drawImage(image, 0, 0, w, h, null);
                AffineTransform affineTransform = new AffineTransform();
                affineTransform.translate(0, h);
                Double sx = 2.0;
                Double sy = 2.0;
                affineTransform.scale(sx, sy);
                ((Graphics2D) g).drawImage(image, affineTransform, null);
            } catch (IOException ex) {
                Logger.getLogger(Escalar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public static class JFrameWin extends JFrame {

            public JFrameWin() {
                this.setTitle("Escalando Imagen");
                this.setSize(500, 500);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                MyComponent myComponent = new  MyComponent();
                this.add(myComponent);
            }
        }
    }
    public static void main(String[] args) {
        Runnable Imagen2 = new Runnable() {
            
            @Override
            public void run() {
                jFrameWindow = new MyComponent.JFrameWin();
                jFrameWindow.setVisible(true);
            }};
        SwingUtilities.invokeLater(Imagen2);
    }
}
