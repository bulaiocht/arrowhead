package homework.lesson4;

public class Wheel {

    private final double SIZE = 15;

    private double size;

    Wheel(){
        this.size = SIZE;
    }

    Wheel(double size){
        if(size < 14 || size > 32){
            throw new IllegalArgumentException("Size has to be from 14 to 32 inch");
        } else
            this.size = size;
    }

    public double getSize(){
        return this.size;
    }

    public void setSize(double size){
        if(size < 14 || size > 32){
            throw new IllegalArgumentException("Size has to be from 14 to 32 inch");
        } else
            this.size = size;
    }

}
