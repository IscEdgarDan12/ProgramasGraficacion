package Graficacion2;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class Lienzo extends JComponent {

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(icono.getIconWidth(), icono.getIconHeight());
    }
    private ImageIcon icono = null;

    public Lienzo(String ficheroImagen) {
        icono = new ImageIcon(ficheroImagen);
    }

    /*Cuando queremos que se rote la foto en radianes*/
    private double rotacion = 0.0;
    /*dibujo de la foto rotandola.*/

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        /*affineTransform realiza el giro, usando como ehe de giro el centro*/
        /*de la foto (width/2, height/2) y el angulo que indica el atributo rotacion*/
        AffineTransform tx = AffineTransform.getRotateInstance(rotacion, icono.getIconWidth() / 2, icono.getIconHeight() / 2);
        
        /*dibujado con la affineTransofrm de rotacion*/
        g2d.drawImage(icono.getImage(), tx, this);
    }
    
    public double getRotacion(){
        return rotacion;
    }
    
    /*se le pasa la rotacion deseada.@param rotacion en radianes*/
    public void setRotacion(double rotacion){
        this.rotacion= rotacion;
    }
}
