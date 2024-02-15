package Graficacion2;

import javax.swing.*;

public class JSP extends JFrame{

    JLabel leftLabel = new JLabel();
    JLabel rightLabel = new JLabel();
    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
            new JScrollPane(leftLabel), new JScrollPane(rightLabel));

    public JSP() {
        leftLabel.setIcon(new ImageIcon("/Graficacion2/prueba.png"));
        rightLabel.setIcon(new ImageIcon("/Graficacion2/prueba.jpg"));
        add(splitPane);
    }

    public static void main(String[] args) {
        JSP sp = new JSP();
        sp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sp.setSize(1024, 600);
        sp.setVisible(true);
    }
}
