/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab50;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author julkata
 */
public class ElevatorTest {
    
    public ElevatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFloor method, of class Elevator.
     */
    @Test
    public void testGetFloor() {
        System.out.println("getFloor");
        Elevator instance = new Elevator(8);
        assertEquals(0, instance.getFloor());
        instance.callToFloor(1);
        instance.tick();
        assertEquals(1, instance.getFloor());
    }

    /**
     * Test of getTargetButtonState method, of class Elevator.
     */
    @Test
    public void testGetTargetButtonState() {
        System.out.println("getTargetButtonState");
        int buttonId = 1;
        Elevator instance = new Elevator(2);
        assertEquals(false, instance.getTargetButtonState(buttonId));
        instance.setTarget(buttonId);
        assertEquals(true, instance.getTargetButtonState(buttonId));
    }

    /**
     * Test of getTargetButtonLightState method, of class Elevator.
     */
    @Test
    public void testGetTargetButtonLightState() {
        System.out.println("getTargetButtonLightState");
        int buttonId = 1;
        Elevator instance = new Elevator(2);
        assertEquals(false, instance.getTargetButtonLightState(buttonId));
        instance.setTarget(buttonId);
        assertEquals(true, instance.getTargetButtonLightState(buttonId));
    }

    /**
     * Test of getDoorState method, of class Elevator.
     */
    @Test
    public void testGetDoorState() {
        System.out.println("getDoorState");
        Elevator instance = new Elevator(2);
        assertEquals(false, instance.getDoorState());
        instance.openDoor();
        assertEquals(true, instance.getDoorState());
    }

    /**
     * Test of openDoor method, of class Elevator.
     */
    @Test
    public void testOpenDoor() {
        System.out.println("openDoor");
        Elevator instance = new Elevator(2);
        assertEquals(false, instance.getDoorState());
        instance.openDoor();
        assertEquals(true, instance.getDoorState());
    }

    /**
     * Test of closeDoor method, of class Elevator.
     */
    @Test
    public void testCloseDoor() {
        System.out.println("closeDoor");
        Elevator instance = new Elevator(2);
        instance.closeDoor();
        assertEquals(false, instance.getDoorState());
    }

    /**
     * Test of setTarget method, of class Elevator.
     */
    @Test
    public void testSetTarget() {
        System.out.println("setTarget");
        int floorId = 1;
        Elevator instance = new Elevator(2);
        instance.openDoor();
        instance.setTarget(floorId);
        assertEquals(true, instance.getTargetButtonState(floorId));
        assertEquals(false, instance.getDoorState());

    }

    /**
     * Test of callToFloor method, of class Elevator.
     */
    @Test
    public void testCallToFloor() {
        System.out.println("callToFloor");
        int floorId = 1;
        Elevator instance = new Elevator(2);
        instance.callToFloor(floorId);
        assertEquals(floorId, instance.getTarget());
    }

    /**
     * Test of getTarget method, of class Elevator.
     */
    @Test
    public void testGetTarget() {
        System.out.println("getTarget");
        Elevator instance = new Elevator(2);
        instance.callToFloor(1);
        assertEquals(1, instance.getTarget());
    }

    /**
     * Test of tick method, of class Elevator.
     */
    @Test
    public void testTick() {
        System.out.println("tick");
        Elevator instance = new Elevator(2);
        // When current is < target
        instance.setTarget(1);
        instance.tick();
        assertEquals(1, instance.getFloor());
        // When current is > target
        instance.setTarget(0);
        instance.tick();
        assertEquals(0, instance.getFloor());
        // When arrived
        assertEquals(false, instance.getTargetButtonState(0));
        assertEquals(true, instance.getDoorState());
    }

    /**
     * Test of hasArrived method, of class Elevator.
     */
    @Test
    public void testHasArrived() {
        System.out.println("hasArrived");
        Elevator instance = new Elevator(2);
        assertEquals(true, instance.hasArrived());
        instance.setTarget(1);
        assertEquals(false, instance.hasArrived());
    }

    /**
     * Test of arrive method, of class Elevator.
     */
    @Test
    public void testArrive() {
        System.out.println("arrive");
        Elevator instance = new Elevator(2);
        instance.arrive();
        assertEquals(false, instance.getTargetButtonState(0));
        assertEquals(true, instance.getDoorState());
    }
    
   /**
     * Test of arrive method, of class Elevator.
     */
    @Test
    public void addFloorToService() {
        System.out.println("floor added");
        Elevator instance = new Elevator(2);
        int floorId = 1;
        instance.addFloorToService(floorId);
        assertEquals(floorId, instance.getNextFloorToService());
    }
        
   /**
     * Test of arrive method, of class Elevator.
     */
    @Test
    public void getNextFloorToService() {
        System.out.println("got next floor");
        Elevator instance = new Elevator(3);
        // if no floor to service
        assertEquals(0, instance.getNextFloorToService());

        // when there is a floor to service
        int next = 1;
        int nextNext = 2;
        instance.addFloorToService(nextNext);
        instance.addFloorToService(next);
        assertEquals(next, instance.getNextFloorToService());
        
        // when current floor is in the list
        instance.tick();
        assertEquals(nextNext, instance.getNextFloorToService());

    } 
}
