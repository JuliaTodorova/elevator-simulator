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
public class FloorTest {
    
    public FloorTest() {
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
     * Test of isDownCallButtonLit method, of class Floor.
     */
    @Test
    public void testIsDownCallButtonLit() {
        System.out.println("isDownCallButtonLit");
        Floor instance = new Floor(0);
        assertEquals(false, instance.isDownCallButtonLit());
        instance.callElevatorDown();
        assertEquals(true, instance.isDownCallButtonLit());
    }

    /**
     * Test of isUpCallButtonLit method, of class Floor.
     */
    @Test
    public void testIsUpCallButtonLit() {
        System.out.println("isUpCallButtonLit");
        Floor instance = new Floor(0);
        assertEquals(false, instance.isUpCallButtonLit());
        instance.callElevatorUp();
        assertEquals(true, instance.isUpCallButtonLit());
    }

    /**
     * Test of callElevatorDown method, of class Floor.
     */
    @Test
    public void testCallElevatorDown() {
        System.out.println("callElevatorDown");
        Floor instance = new Floor(0);
        assertEquals(false, instance.isDownCallButtonLit());
        instance.callElevatorDown();
        assertEquals(true, instance.isDownCallButtonLit());
    }

    /**
     * Test of callElevatorUp method, of class Floor.
     */
    @Test
    public void testCallElevatorUp() {
        System.out.println("callElevatorUp");
        Floor instance = new Floor(0);
        assertEquals(false, instance.isUpCallButtonLit());
        instance.callElevatorUp();
        assertEquals(true, instance.isUpCallButtonLit());
    }

    /**
     * Test of elevatorArrive method, of class Floor.
     */
    @Test
    public void testElevatorArrive() {
        System.out.println("elevatorArrive");
        Floor instance = new Floor(2);
        instance.callElevatorUp();
        instance.callElevatorDown();
        instance.elevatorArrive();
        assertEquals(true, instance.getDoorState());
        assertEquals(false, instance.isUpCallButtonLit());
        assertEquals(false, instance.isDownCallButtonLit());
    }

    /**
     * Test of closeDoor method, of class Floor.
     */
    @Test
    public void testCloseDoor() {
        System.out.println("closeDoor");
        Floor instance = new Floor(2);
        instance.closeDoor();
        assertEquals(false, instance.getDoorState());
    }

    /**
     * Test of openDoor method, of class Floor.
     */
    @Test
    public void testOpenDoor() {
        System.out.println("openDoor");
        Floor instance = new Floor(2);
        instance.openDoor();
        assertEquals(true, instance.getDoorState());
    }

    /**
     * Test of getDoorState method, of class Floor.
     */
    @Test
    public void testGetDoorState() {
        System.out.println("getDoorState");
        Floor instance = new Floor(2);
        instance.openDoor();
        assertEquals(true, instance.getDoorState());
        instance.closeDoor();
        assertEquals(false, instance.getDoorState());
    }
}
