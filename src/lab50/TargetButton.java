package lab50;

/**
 *
 * @author julkata
 */
public class TargetButton {

    private int targetFloor;
    private boolean pressed;
    private Light light = new Light();

    public TargetButton(int targetFloor) {
        this.targetFloor = targetFloor;
        pressed = false;
    }

    protected void setPressed(boolean pressed) {
        this.pressed = pressed;
        if(pressed) {
            light.turnOn();
        }
        else{
            light.turnOff();
        }
    }

    protected int getTargetButton() {
        return targetFloor;
    }

    protected boolean isPressed() {
        return pressed;
    }

    protected boolean getLightState() {
        return light.getState();
    }
}
