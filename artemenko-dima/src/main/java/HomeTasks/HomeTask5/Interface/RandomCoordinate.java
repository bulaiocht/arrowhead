package HomeTasks.HomeTask5.Interface;

public interface RandomCoordinate {

    double RANDMIN = 1.0;
    double RANDMAX = 100.0;

    default double getRandCoordinate(){
        return Math.random() * (RANDMAX - RANDMIN) + RANDMIN;
    }

}
