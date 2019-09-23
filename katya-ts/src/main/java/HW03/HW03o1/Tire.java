package HW03.HW03o1;

public class Tire {

    private boolean isFlat;

    public Tire() {
        this.setState(false);
    }

    // Set the tire state (flat = true or okay = false)
    public void setState(boolean newState) {
        this.isFlat = newState;
    }

    public boolean getState() {
        return this.isFlat;
    }
}
