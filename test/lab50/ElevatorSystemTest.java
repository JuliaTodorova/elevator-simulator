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
public class ElevatorSystemTest {
    
    public ElevatorSystemTest() {
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
     * Test of numberOfFloors method, of class ElevatorSystem.
     */
    @Test
    public void testNumberOfFloors() {
        System.out.println("numberOfFloors");
        ElevatorSystem instance = new ElevatorSystem(10);
        assertEquals(10, instance.numberOfFloors());
    }

    /**
     * Test of isDownCallButtonLit method, of class ElevatorSystem.
     */
    @Test
    public void testIsDownCallButtonLit() {
        System.out.println("isDownCallButtonLit");
        ElevatorSystem instance = new ElevatorSystem(10);
        assertEquals(false, instance.isDownCallButtonLit(5));
        instance.callElevatorDown(5);
        assertEquals(true, instance.isDownCallButtonLit(5));
    }

    /**
     * Test of isUpCallButtonLit method, of class ElevatorSystem.
     */
    @Test
    public void testIsUpCallButtonLit() {
        System.out.println("isUpCallButtonLit");
        ElevatorSystem instance = new ElevatorSystem(10);
        assertEquals(false, instance.isUpCallButtonLit(5));
        instance.callElevatorUp(5);
        assertEquals(true, instance.isUpCallButtonLit(5));
    }

    /**
     * Test of isTargetButtonLit method, of class ElevatorSystem.
     */
    @Test
    public void testIsTargetButtonLit() {
        System.out.println("isTargetButtonLit");
        ElevatorSystem instance = new ElevatorSystem(10);
        assertEquals(false, instance.isTargetButtonLit(5));
        instance.selectFloor(5);
        assertEquals(true, instance.isTargetButtonLit(5));
    }

    /**
     * Test of isElevatorDoorOpen method, of class ElevatorSystem.
     */
    @Test
    public void testIsElevatorDoorOpen() {
        System.out.println("isElevatorDoorOpen");
        ElevatorSystem instance = new ElevatorSystem(10);
        assertEquals(false, instance.isElevatorDoorOpen());
        instance.tick();
        assertEquals(true, instance.isElevatorDoorOpen());
    }

    /**
     * Test of isFloorDoorOpen method, of class ElevatorSystem.
     */
    @Test
    public void testIsFloorDoorOpen() {
        System.out.println("isFloorDoorOpen");
        ElevatorSystem instance = new ElevatorSystem(10);        
        assertEquals(false, instance.isFloorDoorOpen(0));
        instance.tick();
        assertEquals(true, instance.isFloorDoorOpen(0));
    }

    /**
     * Test of getCurrentElevatorFloor method, of class ElevatorSystem.
     */
    @Test
    public void testGetCurrentElevatorFloor() {
        System.out.println("getCurrentElevatorFloor");
        ElevatorSystem instance = new ElevatorSystem(10);
        assertEquals(0, instance.getCurrentElevatorFloor());
    }

    /**
     * Test of callElevatorDown method, of class ElevatorSystem.
     */
    @Test
    public void testCallElevatorDown() {
        System.out.println("callElevatorDown");
        int floorId = 5;
        ElevatorSystem instance = new ElevatorSystem(10);
        instance.callElevatorDown(floorId);
        assertEquals(true, instance.isDownCallButtonLit(floorId));
    }

    /**
     * Test of callElevatorUp method, of class ElevatorSystem.
     */
    @Test
    public void testCallElevatorUp() {
        System.out.println("callElevatorUp");
        int floorId = 5;
        ElevatorSystem instance = new ElevatorSystem(10);
        instance.callElevatorUp(floorId);
        assertEquals(true, instance.isUpCallButtonLit(floorId));
    }

    /**
     * Test of selectFloor method, of class ElevatorSystem.
     */
    @Test
    public void testSelectFloor() {
        System.out.println("selectFloor");
        int floorId = 5;
        ElevatorSystem instance = new ElevatorSystem(10);
        instance.tick(); // open the floor door
        instance.selectFloor(floorId);
        assertEquals(true, instance.isTargetButtonLit(floorId));
        assertEquals(false, instance.isFloorDoorOpen(floorId));
    }

    /**
     * Test of tick method, of class ElevatorSystem.
     */
    @Test
    public void testTick() {
        System.out.println("tick");
        ElevatorSystem instance = new ElevatorSystem(10);
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
