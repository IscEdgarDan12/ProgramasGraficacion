package Graficacion2;

import java.awt.*;

public class Fonts extends Frame {

    @Override
    public void paint(Graphics g) {
        setBackground(Color.BLUE);
        setForeground(Color.BLACK);
        Font tr = new Font("TimesRoman", Font.PLAIN, 18);
        Font trb = new Font("TimesRoman", Font.BOLD, 18);
        Font tri = new Font("TimesRoman", Font.ITALIC, 18);
        Font trbi = new Font("TimesRoman", Font.BOLD + Font.ITALIC, 18);
        Font h = new Font("Helvetica", Font.PLAIN, 18);
        Font c = new Font("Courier", Font.PLAIN, 18);
        Font d = new Font("Dialog", Font.PLAIN, 18);
        Font z = new Font("ZapfDingbats", Font.PLAIN, 18);

        g.setFont(tr);
        g.drawString("Hola raton sin cola (times roman plain)", 10, 25);

        g.setFont(trb);
        g.drawString("Hola raton sin cola (times roman Bold)", 10, 50);

        g.setFont(tri);
        g.drawString("Hola raton sin cola (times roman Italic)", 10, 75);

        g.setFont(trbi);
        g.drawString("Hola raton sin cola (times roman Bold & Italic)", 10, 100);

        g.setFont(h);
        g.drawString("Hola raton sin cola (Helvetica plain)", 10, 125);

        g.setFont(c);
        g.drawString("Hola raton sin cola (Courier plain)", 10, 150);

        g.setFont(d);
        g.drawString("Hola raton sin cola (Dialog plain)", 10, 175);

        g.setFont(z);
        g.drawString("Hola raton sin cola (ZapfDingbats plain)", 10, 200);

    }

    public static void main(String[] args) {
        Fonts v = new Fonts();
        v.setSize(375, 300);
        v.setVisible(true);
    }

}
