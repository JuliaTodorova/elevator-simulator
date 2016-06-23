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
public class DoorTest {
    
    public DoorTest() {
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
     * Test of openDoor method, of class Door.
     */
    @Test
    public void testOpenDoor() {
        System.out.println("openDoor");
        Door instance = new Door();
        instance.openDoor();
        assertEquals(true, instance.getState());
    }

    /**
     * Test of closeDoor method, of class Door.
     */
    @Test
    public void testCloseDoor() {
        System.out.println("closeDoor");
        Door instance = new Door();
        instance.closeDoor();
        assertEquals(false, instance.getState());
    }

    /**
     * Test of getState method, of class Door.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Door instance = new Door();
        boolean expResult = false;
        boolean result = instance.getState();
        assertEquals(expResult, result);
    }
    
}
