package reference.animals;

public class Fish extends Animal {

    @Override
    public void consume() {
        System.out.println("I'm consuming poops in the water");
    }

    @Override
    public void reproduce() {
        System.out.println("I'm making caviar");
    }
}
