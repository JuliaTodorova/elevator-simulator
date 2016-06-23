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
public class CallButtonTest {
    
    public CallButtonTest() {
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
     * Test of press method, of class CallButton.
     */
    @Test
    public void testPress() {
        System.out.println("press");
        CallButton instance = new CallButton();
        instance.press();
        assertEquals(true, instance.isPressed());
        assertEquals(true, instance.getLightState());
    }

    /**
     * Test of release method, of class CallButton.
     */
    @Test
    public void testRelease() {
        System.out.println("release");
        CallButton instance = new CallButton();
        instance.release();
        assertEquals(false, instance.isPressed());
        assertEquals(false, instance.getLightState());
    }

    /**
     * Test of isPressed method, of class CallButton.
     */
    @Test
    public void testIsPressed() {
        System.out.println("isPressed");
        CallButton instance = new CallButton();

        // by default it is false
        assertEquals(false, instance.isPressed());

        // when button is pressed it is true
        instance.press();
        assertEquals(true, instance.isPressed());
    }

    /**
     * Test of getLightState method, of class CallButton.
     */
    @Test
    public void testGetLightState() {
        System.out.println("getLightState");
        CallButton instance = new CallButton();
        
        // by default it is false
        assertEquals(false, instance.getLightState());

        // when button is pressed it is true
        instance.press();
        assertEquals(true, instance.getLightState());
    }
    
}
