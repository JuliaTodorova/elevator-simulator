package lab50;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 *
 * @author julkata
 */
public class Elevator {

    int currentFloor;
    int targetFloor;
    String direction;

    protected TargetButton[] tButton;
    protected Door elevatorDoor = new Door();
    protected Chime chime = new Chime();

    protected ConcurrentSkipListMap<Integer, Integer> floorsToService = new ConcurrentSkipListMap<Integer,Integer>();

    public Elevator(int numberOfFloors) {
        direction = "UP";
        currentFloor = 0;
        targetFloor = 0;
        tButton  = new TargetButton[numberOfFloors];

        for(int i = 0; i < tButton.length; i++) {
            tButton[i] = new TargetButton(i);
        }
    }

    protected int getFloor() {
        return currentFloor;
    }

    protected void addFloorToService(int floorId) {
        if(!floorsToService.containsKey(floorId)){
            floorsToService.put(floorId, floorId);
        }
        System.out.println(floorsToService);
    }

    protected int getNextFloorToService() {
        Map.Entry<Integer, Integer> floor = null;
        boolean floorInQueue = floorsToService.containsKey(nextFloor());
        if (floorInQueue) {
            return nextFloor();
        }
        else {
            if(!floorsToService.isEmpty()){
                if (direction.equals("UP")){
                    floor = floorsToService.ceilingEntry(currentFloor);
                }
                else if (direction.equals("DOWN")) {
                    floor = floorsToService.floorEntry(currentFloor);
                }
                if(floor == null) {
                    floor = floorsToService.firstEntry();
                }

                if (floor != null){
                    return floor.getKey();
                }

                return currentFloor;
            }
            return currentFloor;
        }
    }

    private int nextFloor() {
        if(direction.equals("UP")) {
            return currentFloor + 1;
        }
        else if(direction.equals("DOWN")) {
            return currentFloor - 1;
        }
        return currentFloor;
    }

    protected void removeServicedFloor() {
        floorsToService.remove((Object)currentFloor);
    }

    protected boolean getTargetButtonState(int buttonId) {
        return tButton[buttonId].isPressed();
    }

    protected boolean getTargetButtonLightState(int buttonId) {
        return tButton[buttonId].getLightState();
    }

    protected boolean getDoorState() {
        return elevatorDoor.getState();
    }

    protected void openDoor() {
        elevatorDoor.openDoor();
        chime.chimeOn();
        System.out.println("Elevator door openned");
    }

    protected void closeDoor() {
        elevatorDoor.closeDoor();
    }

    public void setTarget(int floorId){
        addFloorToService(floorId);
        targetFloor = getNextFloorToService();
        TargetButton floorButton = tButton[floorId];
        floorButton.setPressed(true);
        closeDoor();
    }

    public void callToFloor(int floorId) {
        addFloorToService(floorId);
        targetFloor = getNextFloorToService();
    }

    public int getTarget(){
        return targetFloor;
    }

    protected void tick(){
        if (getDoorState()) {
            closeDoor();
        }

        targetFloor = getNextFloorToService();

        if (currentFloor < targetFloor){
            direction = "UP";
            currentFloor++;
        } else if (currentFloor > targetFloor) {
            direction = "DOWN";
            currentFloor--;
        }

        if(currentFloor == 0){
            direction = "UP";
        }

        if (hasArrived()) {
            arrive();
            removeServicedFloor();
        }
       System.out.println("CurrentFloor " + currentFloor + " Target Floor " + targetFloor + " Current Direction " + direction);
    }

    protected boolean hasArrived() {
        if(currentFloor == targetFloor) {
            return true;
        }
        return false;
    }

    public void arrive() {
        TargetButton floorButton = tButton[currentFloor];
        floorButton.setPressed(false);
        elevatorDoor.openDoor();
        System.out.println("Arrived! " + currentFloor);
    }
}
