package lab50;

/**
 *
 * @author julkata
*/
public class Light {

    private boolean isOn;

    public Light(){
        isOn = false;
    }

    protected void turnOn() {
        this.isOn = true;
    }

    protected void turnOff() {
        this.isOn = false;
    }

    protected boolean getState() {
        return isOn;
    }
}
