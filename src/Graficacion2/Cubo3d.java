package Graficacion2;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.swing.*;
import java.awt.*;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;

public class Cubo3d extends JPanel {

    public Cubo3d() {
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D  = new Canvas3D(config);
        setLayout(new BorderLayout());
        add(canvas3D);
        
        SimpleUniverse universo = new SimpleUniverse(canvas3D);
        universo.getViewingPlatform().setNominalViewingTransform();
        
        BranchGroup escena = crearGrafoEscena();
        escena.compile();
        universo.addBranchGraph(escena);
        
        
    }
    public BranchGroup crearGrafoEscena(){
        BranchGroup objetoRaiz= new BranchGroup();
        objetoRaiz.addChild(new ColorCube(0.5));
        return objetoRaiz;
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Cubo 3D");
        Cubo3d panel = new Cubo3d();
        ventana.add(panel);
        ventana.setSize(500,500);
        ventana.setVisible(true);
    }
}
