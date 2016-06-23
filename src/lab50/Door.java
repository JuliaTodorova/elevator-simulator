package lab50;

/**
 *
 * @author julkata
 */
public class Door {
    private boolean isOpen;

    public Door() {
        isOpen = false;
    }

    protected void openDoor() {
        this.isOpen = true;
    }

    protected void closeDoor() {
        this.isOpen = false;
    }
    
    protected boolean getState() {
        return isOpen;
    }
 }
