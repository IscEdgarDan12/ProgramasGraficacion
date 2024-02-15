package Graficacion2;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import javax.media.j3d.Alpha;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cubo3D2 extends JPanel {

    public Cubo3D2() {
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(config);
        setLayout(new BorderLayout());
        add(canvas3D);
        SimpleUniverse universo = new SimpleUniverse(canvas3D);
        universo.getViewingPlatform().setNominalViewingTransform();
        BranchGroup escena = crearGrafoEscena();
        escena.compile();
        universo.addBranchGraph(escena);
    }

    public static BranchGroup crearGrafoEscena() {
        BranchGroup objetoRaiz = new BranchGroup();
        TransformGroup objetoGiro = new TransformGroup();
        objetoGiro.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objetoRaiz.addChild(objetoGiro);
        ColorCube cubo = new ColorCube(0.5f);
        objetoGiro.addChild(cubo);

        Alpha rotacionAlpha = new Alpha(-1, 5000);
        RotationInterpolator rotation = new RotationInterpolator(rotacionAlpha, objetoGiro);
        rotation.setSchedulingBounds(new BoundingSphere());
        objetoRaiz.addChild(rotation);
        return objetoRaiz;
    }

    public static void main(String[] args) {
        System.setProperty("sun.awt.noerasebackground", "true");
        JFrame ventana = new JFrame("Giro Cubo 3D");
        Cubo3D2 panel = new Cubo3D2();
        ventana.add(panel);
        ventana.setSize(500, 500);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
