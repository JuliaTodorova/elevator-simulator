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
public class EventSimulatorTest {
    
    public EventSimulatorTest() {
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
     * Test of isDownCallButtonLit method, of class EventSimulator.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIsDownCallButtonLit() {
        System.out.println("isDownCallButtonLit");
        EventSimulator instance = new EventSimulator(2);
        assertEquals(false, instance.isDownCallButtonLit(1));
        instance.callElevatorDown(1);
        assertEquals(true, instance.isDownCallButtonLit(1));
        // raises an error with invalid floor
        int floor = 3;
        instance.isDownCallButtonLit(floor);
    }

    /**
     * Test of isUpCallButtonLit method, of class EventSimulator.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIsUpCallButtonLit() {
        System.out.println("isUpCallButtonLit");
        EventSimulator instance = new EventSimulator(2);
        assertEquals(false, instance.isUpCallButtonLit(1));
        instance.callElevatorUp(1);
        assertEquals(true, instance.isUpCallButtonLit(1));
        // raises an error with invalid floor
        int floor = 3;
        instance.isDownCallButtonLit(floor);
    }

    /**
     * Test of isTargetButtonLit method, of class EventSimulator.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIsTargetButtonLit() {
        EventSimulator instance = new EventSimulator(2);
        assertEquals(false, instance.isTargetButtonLit(1));
        instance.selectFloor(1);
        assertEquals(true, instance.isTargetButtonLit(1));
        // raises an error with invalid floor
        int floor = 3;
        instance.isTargetButtonLit(floor);
    }

    /**
     * Test of isElevatorDoorOpen method, of class EventSimulator.
     */
    @Test
    public void testIsElevatorDoorOpen() {
        System.out.println("isElevatorDoorOpen");
        EventSimulator instance = new EventSimulator(2);
        assertEquals(false, instance.isElevatorDoorOpen());
        instance.tick();
        assertEquals(true, instance.isElevatorDoorOpen());
    }

    /**
     * Test of isFloorDoorOpen method, of class EventSimulator.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIsFloorDoorOpen() {
        System.out.println("isFloorDoorOpen");
        int floor = 0;
        EventSimulator instance = new EventSimulator(2);
        assertEquals(false, instance.isFloorDoorOpen(floor));
        instance.tick();
        assertEquals(true, instance.isFloorDoorOpen(floor));
        // raises an error with invalid floor
        floor = 3;
        instance.isFloorDoorOpen(floor);
    }

    /**
     * Test of getCurrentElevatorFloor method, of class EventSimulator.
     */
    @Test
    public void testGetCurrentElevatorFloor() {
        System.out.println("getCurrentElevatorFloor");
        EventSimulator instance = new EventSimulator(2);
        int expResult = 0;
        int result = instance.getCurrentElevatorFloor();
        assertEquals(expResult, result);
    }

    /**
     * Test of callElevatorDown method, of class EventSimulator.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCallElevatorDown() {
        System.out.println("callElevatorDown");
        int floor = 0;
        EventSimulator instance = new EventSimulator(2);
        instance.callElevatorDown(floor);
        assertEquals(true, instance.isDownCallButtonLit(floor));
        // raises an error with invalid floor
        floor = 3;
        instance.isDownCallButtonLit(floor);
    }

    /**
     * Test of callElevatorUp method, of class EventSimulator.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCallElevatorUp() {
        System.out.println("callElevatorUp");
        int floor = 0;
        EventSimulator instance = new EventSimulator(2);
        instance.callElevatorUp(floor);
        assertEquals(true, instance.isUpCallButtonLit(floor));
        // raises an error with invalid floor
        floor = 3;
        instance.callElevatorUp(floor);
    }

    /**
     * Test of selectFloor method, of class EventSimulator.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSelectFloor() {
        System.out.println("selectFloor");
        int floor = 0;
        EventSimulator instance = new EventSimulator(2);
        instance.tick(); // open the floor door
        instance.selectFloor(floor);
        assertEquals(true, instance.isTargetButtonLit(floor));
        assertEquals(false, instance.isFloorDoorOpen(floor));
        // raises an error with invalid floor
        floor = 3;
        instance.selectFloor(floor);
    }

    /**
     * Test of tick method, of class EventSimulator.
     */
    @Test
    public void testTick() {
        System.out.println("tick");
        EventSimulator instance = new EventSimulator(2);
        instance.tick();
        
        // when elevator has arrived on floor
        assertEquals(true, instance.isFloorDoorOpen(0));
        
        // when elevator has not arrived on floor
        assertEquals(false, instance.isFloorDoorOpen(1));
        
        // it moves the elevator
        instance.callElevatorDown(1);
        instance.tick();
        assertEquals(1, instance.getCurrentElevatorFloor());
    }
    
}
