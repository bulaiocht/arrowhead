package reference.animals;

public class AnimalRunner {

    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.consume();
        animal.reproduce();

        Animal animal1 = new Mammal();
        animal1.reproduce();
        animal1.consume();

        Animal animal2 = new Fish();
        animal2.consume();
        animal2.reproduce();

    }

}
