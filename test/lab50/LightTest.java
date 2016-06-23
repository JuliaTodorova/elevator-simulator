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
public class LightTest {
    
    public LightTest() {
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
     * Test of turnOn method, of class Light.
     */
    @Test
    public void testTurnOn() {
        System.out.println("turnOn");
        Light instance = new Light();
        instance.turnOn();
        assertEquals(true, instance.getState());
    }

    /**
     * Test of turnOff method, of class Light.
     */
    @Test
    public void testTurnOff() {
        System.out.println("turnOff");
        Light instance = new Light();
        instance.turnOff();
        assertEquals(false, instance.getState());
    }

    /**
     * Test of getState method, of class Light.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Light instance = new Light();
        boolean expResult = false;
        boolean result = instance.getState();
        assertEquals(expResult, result);
    }
}
