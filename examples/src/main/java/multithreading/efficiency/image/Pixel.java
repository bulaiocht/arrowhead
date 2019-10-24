package multithreading.efficiency.image;

public class Pixel{
    private int x;
    private int y;
    private int red;
    private int green;
    private int blue;

    public Pixel(int x, int y, int red, int green, int blue) {
        this.x = x;
        this.y = y;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    @Override
    public String toString() {
        return "{x=" + x +
                ", y=" + y +
                ", red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}
