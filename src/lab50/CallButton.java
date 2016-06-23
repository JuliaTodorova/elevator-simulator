package lab50;

/**
 *
 * @author julkata
 */
public class CallButton {

    private boolean isPressed;
    private Light light = new Light();

    public CallButton(){
        isPressed = false;
    }

    protected void press() {
        this.isPressed = true;
        light.turnOn();
    }

    protected void release() {
        this.isPressed = false;
        light.turnOff();
    }

    protected boolean isPressed() {
        return isPressed;
    }
    
    protected boolean getLightState() {
        return light.getState();
    }
}
