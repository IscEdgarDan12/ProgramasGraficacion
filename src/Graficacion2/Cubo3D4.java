package Graficacion2;

import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.vecmath.Point3d;

public class Cubo3D4 extends JPanel {

    SimpleUniverse universo;

    public Cubo3D4() {
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(config);
        setLayout(new BorderLayout());
        add(canvas3D);
        universo = new SimpleUniverse(canvas3D);
        universo.getViewingPlatform().setNominalViewingTransform();
        BranchGroup escena = crearGrafoEscena();
        escena.compile();
        universo.addBranchGraph(escena);

    }

    public BranchGroup crearGrafoEscena() {
        BranchGroup objetoRaiz = new BranchGroup();
        TransformGroup mouseGrupo = new TransformGroup();
        mouseGrupo.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        mouseGrupo.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objetoRaiz.addChild(mouseGrupo);
        ColorCube cubo = new ColorCube(0.5);
        mouseGrupo.addChild(cubo);
        
        MouseRotate mr = new MouseRotate();
        mr.setTransformGroup(mouseGrupo);
        mr.setSchedulingBounds(new BoundingSphere(new Point3d(),1000));
        objetoRaiz.addChild(mr);
        
        return objetoRaiz;
    }
    
    public static void main(String[] args) {
        System.setProperty("sun.awt.noerasebackground", "true");
        JFrame ventana = new JFrame("Mi cubo 3D rotado");
        Cubo3D4 panel = new Cubo3D4();
        ventana.add(panel);
        ventana.setSize(700,700);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
