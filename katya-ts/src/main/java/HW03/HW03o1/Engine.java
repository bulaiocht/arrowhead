package HW03.HW03o1;

public class Engine {
    private boolean isOn;

    public Engine() {
        this.setState(false);
    }

    public void setState(boolean newState) {
        this.isOn = newState;
    }

    public boolean getState() {
        return this.isOn;
    }
}
