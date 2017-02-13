/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vendingmachine.dto.Snack;

/**
 *
 * @author apprentice
 */
public class VendingMachineDaoImplTest {
    
    public VendingMachineDaoImplTest() {
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
     * Test of getAllSnacks method, of class VendingMachineDaoImpl.
     */
    @Test
    public void testGetAllSnacks() throws Exception {
        System.out.println("getAllSnacks");
        VendingMachineDaoImpl instance = new VendingMachineDaoImpl();
        List<Snack> expResult = null;
        List<Snack> result = instance.getAllSnacks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
