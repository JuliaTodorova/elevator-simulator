package lab50;

/**
 *
 * @author julkata
 */
public class EventSimulator implements EventSimulatorInterface {
    ElevatorSystem system;
    
    public EventSimulator(int num_floors) throws IllegalArgumentException {
        if (num_floors < 2) {
            throw new IllegalArgumentException("Number of floors need to be two or more.");
        }
        system = new ElevatorSystem(num_floors);
    }
    @Override
    public boolean isDownCallButtonLit(int floor) throws IllegalArgumentException {
        if (floor < 0 || floor >= system.numberOfFloors()) throw new IllegalArgumentException();
        return system.isDownCallButtonLit(floor);
    }

    @Override
    public boolean isUpCallButtonLit(int floor) throws IllegalArgumentException {
        if (floor < 0 || floor >= system.numberOfFloors()) throw new IllegalArgumentException();
        return system.isUpCallButtonLit(floor);
    }

    @Override
    public boolean isTargetButtonLit(int floor) throws IllegalArgumentException {
        if (floor < 0 || floor >= system.numberOfFloors()) throw new IllegalArgumentException();
        return system.isTargetButtonLit(floor);
    }

    @Override
    public boolean isElevatorDoorOpen() {
        return system.isElevatorDoorOpen();
    }

    @Override
    public boolean isFloorDoorOpen(int floor) throws IllegalArgumentException {
        if (floor < 0 || floor >= system.numberOfFloors()) throw new IllegalArgumentException();
        return system.isFloorDoorOpen(floor);
    }

    @Override
    public int getCurrentElevatorFloor() {
        return system.getCurrentElevatorFloor();
    }

    @Override
    public void callElevatorDown(int floor) throws IllegalArgumentException {
        if (floor < 0 || floor >= system.numberOfFloors()) throw new IllegalArgumentException();
        system.callElevatorDown(floor);
    }

    @Override
    public void callElevatorUp(int floor) throws IllegalArgumentException {
        if (floor < 0 || floor >= system.numberOfFloors()) throw new IllegalArgumentException();
        system.callElevatorUp(floor);
    }

    @Override
    public void selectFloor(int floor) throws IllegalArgumentException {
        if (floor < 0 || floor >= system.numberOfFloors()) throw new IllegalArgumentException();
        system.selectFloor(floor);
    }

    @Override
    public void tick() {
        system.tick();
    }    
}
