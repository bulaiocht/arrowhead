package multithreading.efficiency;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ImageRunner {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("examples/src/main/resources/landscape.jpg");
        Path output = Paths.get("examples/src/main/resources/output.png");

        BufferedImage image = ImageIO.read(path.toFile());

        BufferedImage outPutImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
        long currentTimeMillis = System.currentTimeMillis();
//        recolorImage(image, outPutImage, false);
//        recolorImage(image, outPutImage, true);
        long endTimeMillis = System.currentTimeMillis();

        System.out.println((endTimeMillis - currentTimeMillis) + " milliseconds");

        ImageIO.write(outPutImage, "png", output.toFile());

    }

    private static void recolorImage(BufferedImage src, BufferedImage dest, boolean multithreaded) {

        if (!multithreaded) {
            recolorSequentially(src, dest);
        } else {
            recolorMultithreaded(src, dest);
        }

    }



    private static void recolorSequentially(BufferedImage src, BufferedImage dest) {

        int height = src.getHeight();

        int width = src.getWidth();

        recolorSequentially(src, dest, 0, height, width);
    }

    private static void recolorSequentially(BufferedImage src, BufferedImage dest, int startHeight, int endHeight, int width) {

        Set<Integer> heightSet = IntStream
                .range(startHeight, endHeight)
                .boxed()
                .collect(Collectors.toSet());

        List<Coordinate> pixelCoordinates = IntStream
                .range(0, width)
                .boxed()
                .flatMap(x -> heightSet.stream()
                        .map(y -> new Coordinate(x, y)))
                .collect(Collectors.toList());

        List<Pixel> pixels = pixelCoordinates
                .stream()
                .map(coordinate -> {
                    int rgb = src.getRGB(coordinate.getX(), coordinate.getY());

                    int r = ImageConverter.getRed(rgb);
                    int g = ImageConverter.getGreen(rgb);
                    int b = ImageConverter.getBlue(rgb);
                    return new Pixel(coordinate.getX(), coordinate.getY(), r, g, b);
                })
                .collect(Collectors.toList());

        pixels.forEach(pixel -> ImageConverter.recolorPixel(dest, pixel));

    }

    private static void recolorMultithreaded(BufferedImage src, BufferedImage dest) {

        int processors = Runtime.getRuntime().availableProcessors();
        int imgHeight = src.getHeight();
        int imgWidth = src.getWidth();

        List<Thread> threads = new ArrayList<>();

        int threadHeight = imgHeight / processors;
        for (int i = 0; i < processors; i++) {
            int start = threadHeight * i;
            int end = start + threadHeight;
            Thread thread = new Thread(() -> recolorSequentially(src, dest, start, end, imgWidth));
            thread.start();
            threads.add(thread);
        }

        for (final Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
