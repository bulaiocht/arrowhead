package multithreading.efficiency.image;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class ImageConverter {

    private static final int MASK = 0xFF;

    public static int getAlpha(int argb) {
        return (argb & (MASK << 24)) >> 24;
    }

    static int getRed(int argb) {
        return (argb & (MASK << 16)) >> 16;
    }

    static int getGreen(int argb) {
        return (argb & (MASK << 8)) >> 8;
    }

    static int getBlue(int argb) {
        return argb & MASK;
    }

    private static int toARGB(int a, int r, int g, int b) {
        int argb = 0;
        argb |= a << 24;
        argb |= r << 16;
        argb |= g << 8;
        argb |= b;
        return argb;
    }

    private static boolean isShadeOfGray(int red, int green, int blue) {
        return Math.abs(red - green) < 30 && Math.abs(red - blue) < 30 && Math.abs(green - blue) < 30;
    }

    public static void recolorPixel(BufferedImage out, Pixel pixel){

        int red = pixel.getRed();
        int green = pixel.getGreen();
        int blue = pixel.getBlue();

        int newA;

        if (isShadeOfGray(red, green, blue)) {
            newA = 255;
        } else {
            newA = 0;
        }

        int argb = toARGB(newA, red, green, blue);
        setColor(out, pixel.getX(), pixel.getY(), argb);

    }

    private static void setColor(BufferedImage image, int x, int y, int argb) {
        WritableRaster raster = image.getRaster();
        ColorModel colorModel = image.getColorModel();
        Object dataElements = colorModel.getDataElements(argb, null);
        raster.setDataElements(x, y, dataElements);
    }


}
