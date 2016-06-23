package lab50;

/**
 *
 * @author julkata
 */
public class Floor {

    private int floorId;

    private CallButton cButtonUp;
    private CallButton cButtonDown;

    private Door floorDoor = new Door();

    public Floor(int floorId){
        this.floorId = floorId;
        cButtonUp = new CallButton();
        cButtonDown = new CallButton();
    }

    public boolean isDownCallButtonLit() {
        return cButtonDown.getLightState();
    }

    public boolean isUpCallButtonLit() {
        return cButtonUp.getLightState();
    }

    public void callElevatorDown() {
        cButtonDown.press();
    }

    public void callElevatorUp() {
        cButtonUp.press();
    }

    protected void elevatorArrive() {
        cButtonUp.release();
        cButtonDown.release();
        floorDoor.openDoor();
    }

    protected void closeDoor() {
        floorDoor.closeDoor();
    }

    protected void openDoor() {
        floorDoor.openDoor();
    }

    protected boolean getDoorState() {
        return floorDoor.getState();
    }
}
