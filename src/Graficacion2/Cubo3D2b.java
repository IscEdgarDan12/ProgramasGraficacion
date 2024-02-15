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
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.vecmath.Vector3f;

public class Cubo3D2b extends JPanel {

    public Cubo3D2b() {
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(config);
        setLayout(new BorderLayout());
        add(canvas3D);

        SimpleUniverse universo = new SimpleUniverse(canvas3D);

        Vector3f posicionVista = new Vector3f();
        posicionVista.z = 3f;
        posicionVista.x = 0f;
        posicionVista.y = 0f;

        //traslacion
        Transform3D transformVista = new Transform3D();
        transformVista.setTranslation(posicionVista);

        //rotacion
        Transform3D rotacion = new Transform3D();
        rotacion.rotX(Math.toRadians(-45));
        rotacion.mul(transformVista);

        universo.getViewingPlatform().getViewPlatformTransform().setTransform(rotacion);
        universo.getViewingPlatform().getViewPlatformTransform().setTransform(transformVista);

        BranchGroup escena = crearGrafoEscena();
        escena.compile();
        universo.addBranchGraph(escena);

    }

    public BranchGroup crearGrafoEscena() {
        BranchGroup objetoRaiz = new BranchGroup();
        TransformGroup objetoGiro = new TransformGroup();
        objetoGiro.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objetoRaiz.addChild(objetoGiro);
        ColorCube cubo2 = new ColorCube(0.3f);
        objetoGiro.addChild(cubo2);

        Alpha rotacionAlpha = new Alpha(-1, 2000);
        RotationInterpolator rotation = new RotationInterpolator(rotacionAlpha, objetoGiro);
        rotation.setSchedulingBounds(new BoundingSphere());
        objetoRaiz.addChild(rotation);
        return objetoRaiz;
    }

    public static void main(String[] args) {
        System.setProperty("sun.awt.noerasebackground", "true");
        JFrame ventana = new JFrame("Mi cubo 3D rotado solo");
        Cubo3D4 panel = new Cubo3D4();
        ventana.add(panel);
        ventana.setSize(100, 700);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
