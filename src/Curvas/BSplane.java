package Curvas;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;

class Point {

    public double x;
    public double y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BSplane extends JFrame {

    public static int ORDER = 3;

    public static int WIDTH = 1024;
    public static int HEIGHT = 768;
    static String TITLE = "BSpline Viewer";
    int RESOLUTION = 100;
    int SCALEX = 500;
    int SCALEY = 300;
    int TRANSLATEX = 300;
    int TRANSLATEY = 150;

    private Point[] B;
    private double[] x;
    private int k;

    public BSplane(Point[] B, double[] x, int k) {
        this.B = B;
        this.x = x;
        this.k = k;
    }

    private double N(int i, int k, double t) {
        if (1 == k) {
            if (x[i] <= t && t < x[i + 1]) {
                System.out.println("N{" + i + "," + k + "}(" + t + ") = 1");
                return 1;
            } else {
                System.out.println("N{" + i + "," + k + "}(" + t + ") = 0");
                return 0;
            }
        }

        double a, b;
        a = ((t - x[i]) / (x[i + k - 1] - x[i])) * N(i, k - 1, t);
        if (Double.isNaN(a)) {
            a = 0;
        }
        b = ((x[i + k] - t) / (x[i + k] - x[i + 1])) * N(i + 1, k - 1, t);
        if (Double.isNaN(b)) {
            b = 0;
        }
        System.out.print("N{" + i + "," + k + "}(" + t + ") = ");
        System.out.println(a + b);
        return a + b;
    }

    private Point P(double t) {
        Point sum = new Point();
        for (int i = 0; i < B.length; i++) {
            sum.x += B[i].x * N(i, k, t);
            sum.y += B[i].y * N(i, k, t);
        }
        System.out.print("P(" + t + ") = ");
        System.out.println("(" + sum.x + "," + sum.y + ")");
        return sum;
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        for (int i = 0; i < B.length; i++) {
            g.fillRect((int) (B[i].x * SCALEX + TRANSLATEX) - 2, (int) (B[i].y * SCALEY + TRANSLATEY) - 2, 4, 4);
            System.out.println("Drawing: (" + ((int) (B[i].x * SCALEX + TRANSLATEX) - 2) + "," + ((int) (B[i].y * SCALEY + TRANSLATEY) - 2) + ")");
        }

        Point pnew, pold = null;
        for (int i = 0; i < RESOLUTION; i++) {
            pnew = P((i * x[x.length - 1]) / (double) RESOLUTION);
            if (null != pold) {
                g.drawLine((int) (pold.x * SCALEX + TRANSLATEX),
                        (int) (pold.y * SCALEY + TRANSLATEY),
                        (int) (pnew.x * SCALEX + TRANSLATEX),
                        (int) (pnew.y * SCALEY + TRANSLATEY));
                System.out.println("Drawing: (" + pold.x + "," + pold.y + ") -> (" + pnew.x + "," + pnew.y + ")");
            }
            pold = pnew;
        }
    }

    public static void main(String[] args) {
        int order = ORDER;
        JFrame frame = new JFrame();
        double KNOT[] = {0, 0, 0, 1, 3, 3, 4, 5, 5, 5};
        Point[] points = new Point[4];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 1);
        points[2] = new Point(1, 1);
        points[3] = new Point(1, 0);
        BSplane bs = new BSplane(points, KNOT, order);
        bs.setSize(WIDTH, HEIGHT);
        bs.setTitle(TITLE);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        bs.setVisible(true);
    }
}
