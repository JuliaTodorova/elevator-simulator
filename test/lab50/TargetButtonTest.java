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
public class TargetButtonTest {
    
    public TargetButtonTest() {
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
     * Test of setPressed method, of class TargetButton.
     */
    @Test
    public void testSetPressed() {
        System.out.println("setPressed");
        boolean pressed = true;
        TargetButton instance = new TargetButton(8);
        instance.setPressed(pressed);
    }

    /**
     * Test of getTargetButton method, of class TargetButton.
     */
    @Test
    public void testGetTargetButton() {
        System.out.println("getTargetButton");
        TargetButton instance = new TargetButton(7);
        assertEquals(7, instance.getTargetButton());
    }

    /**
     * Test of isPressed method, of class TargetButton.
     */
    @Test
    public void testIsPressed() {
        System.out.println("isPressed");
        TargetButton instance = new TargetButton(8);
        assertEquals(false, instance.isPressed());
    }

    /**
     * Test of getLightState method, of class TargetButton.
     */
    @Test
    public void testGetLightState() {
        System.out.println("getLightState");
        TargetButton instance = new TargetButton(8);
        // by default it is false
        assertEquals(false, instance.getLightState());

        // when button is pressed it is true
        instance.setPressed(true);
        assertEquals(true, instance.getLightState());
    }
    
}
