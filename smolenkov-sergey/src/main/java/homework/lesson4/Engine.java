package homework.lesson4;

public class Engine {

    private boolean hasStartedUp = false;
    private int expense=5;

    public Engine(int expense){
        this.expense = expense;
    }

    public void startEngine(){
        this.hasStartedUp = true;
        System.out.println("The engine is started up");
    }
    public void stopEngine(){
        this.hasStartedUp = false;
    }

    public boolean hasStartedUp(){
        return this.hasStartedUp;
    }

    public void setExpense(int expense){
        this.expense = expense;
    }

    public int getExpense(){
        return this.expense;
    }

}
