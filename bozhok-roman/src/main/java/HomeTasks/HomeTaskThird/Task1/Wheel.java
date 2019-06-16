package HomeTasks.HomeTaskThird.Task1;

public class Wheel {
    private boolean brokenWheel ;

    public Wheel (boolean brokenWheel){
        this.brokenWheel=brokenWheel;

    }
    public void changeWheel (){
        this.brokenWheel = false;
    }
    public void brokenWheel (){
        this.brokenWheel=true;
    }
}
