package lab50;

/**
 *
 * @author julkata
 */
public class ElevatorSystem {
    private Elevator elevator;
    private Floor[] floors;

    public ElevatorSystem(int numberOfFloors) {
         elevator = new Elevator(numberOfFloors);
         floors = new Floor[numberOfFloors];
         for(int i = 0; i < numberOfFloors; i++) {
             floors[i] = new Floor(i + 1);
         }
    }

    public int numberOfFloors(){
        return floors.length;
    }

    public boolean isDownCallButtonLit(int floorId) {
        Floor floor = floors[floorId];
        return floor.isDownCallButtonLit();
    }

    public boolean isUpCallButtonLit(int floorId) {
        Floor floor = floors[floorId];
        return floor.isUpCallButtonLit();
    }

    public boolean isTargetButtonLit(int floorId) {
        return elevator.getTargetButtonState(floorId);
    }

    public boolean isElevatorDoorOpen(){
        return elevator.getDoorState();
    }

    public boolean isFloorDoorOpen(int floorId) {
        Floor floor = floors[floorId];
        return floor.getDoorState();
    }

    public int getCurrentElevatorFloor() {
        return elevator.getFloor();
    }

    public void callElevatorDown(int floorId) {
        Floor floor = floors[floorId];
        floor.callElevatorDown();
        elevator.callToFloor(floorId);
    }

    public void callElevatorUp(int floorId) {
        Floor floor = floors[floorId];
        floor.callElevatorUp();
        elevator.callToFloor(floorId);
    }

    public void selectFloor(int floorId) {
        elevator.setTarget(floorId);
        Floor floor = floors[elevator.currentFloor];
        floor.closeDoor();
    }

    protected void tick() {
        Floor floor = floors[elevator.currentFloor];

        if (floor.getDoorState()) {
            floor.closeDoor();
        }

        elevator.tick();

        if(elevator.hasArrived()){
           floor = floors[elevator.currentFloor];
           floor.elevatorArrive();
        }
    }
}
