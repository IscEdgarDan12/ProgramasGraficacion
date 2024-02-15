package Graficacion2;

import java.awt.*;
public class PruebaFondos extends Frame{

    @Override
    public void paint(Graphics g) {
        setBackground(Color.yellow);
        setForeground(Color.BLUE);
        Font a = new Font("Chiller", Font.PLAIN, 10);
        Font b = new Font("Showcard Gothic", Font.BOLD, 20);
        Font c = new Font("Colonna MT", Font.ITALIC, 30);
        Font d = new Font("Lucida Console", Font.PLAIN, 40);
        Font e = new Font("Kunstler Script", Font.PLAIN, 50);
        Font f = new Font("Matura MT Script Capitals", Font.PLAIN, 45);
        Font p = new Font("Arial", Font.PLAIN, 35);
        Font h = new Font("MT Extra", Font.PLAIN, 25);
        Font i = new Font("PMingLiU-ExtB", Font.PLAIN, 15);
        Font j = new Font("Bauhaus 93", Font.PLAIN, 10);

        g.setFont(a);
        g.drawString("Hola raton sin cola (times roman plain)", 10, 50);
        g.setFont(b);
        g.drawString("Hola raton sin cola (times roman Bold)", 10, 100);
        g.setFont(c);
        g.drawString("Hola raton sin cola (times roman Italic)", 10, 150);
        g.setFont(d);
        g.drawString("Hola raton sin cola (times roman Bold & Italic)", 10, 200);
        g.setFont(e);
        g.drawString("Hola raton sin cola (Helvetica plain)", 10, 250);
        g.setFont(f);
        g.drawString("Hola raton sin cola (Courier plain)", 10, 300);
        g.setFont(p);
        g.drawString("Hola raton sin cola (Dialog plain)", 10, 350);
        g.setFont(h);
        g.drawString("Hola raton sin cola (ZapfDingbats plain)", 10, 400);
        g.setFont(i);
        g.drawString("Hola raton sin cola (ZapfDingbats plain)", 10, 450);
        g.setFont(j);
        g.drawString("Hola raton sin cola (ZapfDingbats plain)", 10, 500);
    }


    public static void main(String[] args) throws Throwable {
        PruebaFondos v = new PruebaFondos();
        v.setSize(1200, 520);
        v.setVisible(true);

    }

}
