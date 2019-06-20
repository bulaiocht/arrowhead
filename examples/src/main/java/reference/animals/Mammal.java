package reference.animals;

public class Mammal extends Animal {

    @Override
    public void consume() {
        System.out.println("I'm consuming fish");
    }

    @Override
    public void reproduce() {
        System.out.println("I'm creating little mammal babies");
    }
}
