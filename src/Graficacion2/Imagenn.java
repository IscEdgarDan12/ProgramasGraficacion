package Graficacion2;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class Imagenn {

    public static void main(String[] args) {
        try {
            InputStream input = new FileInputStream("prueba.jpg");
            ImageInputStream image = ImageIO.createImageInputStream(input);
            BufferedImage imagenL = ImageIO.read(image);

            int alto = imagenL.getHeight();
            int ancho = imagenL.getWidth();

            System.out.println("alto " + alto + " ancho " + ancho);
            for (int i = 0; i < imagenL.getHeight(); i++) {
                for (int j = 0; j < imagenL.getWidth(); j++) {
                    int srcPixel = imagenL.getRGB(i, j);
                    Color c = new Color(srcPixel);
                    int valrR = c.getRed();
                    int valrG = c.getGreen();
                    int valrB = c.getBlue();
                    System.out.println("R "+valrR+" G "+valrG+ " B"+valrB);
                }
                System.out.println();
            }
        } catch (Exception e) {
        }
    }

}
