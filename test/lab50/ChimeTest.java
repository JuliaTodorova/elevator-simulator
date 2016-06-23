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
public class ChimeTest {
    
    public ChimeTest() {
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
     * Test of chimeOn method, of class Chime.
     */
    @Test
    public void testChimeOn() {
        System.out.println("chimeOn");
        Chime instance = new Chime();
        boolean expResult = true;
        boolean result = instance.chimeOn();
        assertEquals(expResult, result);
    }
    
}
