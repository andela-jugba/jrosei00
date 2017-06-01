/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vendingmachine.dto.Change;
import vendingmachine.dto.Fad;

/**
 *
 * @author apprentice
 */
public class VendingMachineServiceLayerImplTest {
    
    public VendingMachineServiceLayerImplTest() {
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
     * Test of getAllItems method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testGetAllItems() {
        System.out.println("getAllItems");
        VendingMachineServiceLayerImpl instance = new VendingMachineServiceLayerImpl();
        ArrayList<Fad> expResult = null;
        ArrayList<Fad> result = instance.Read();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Write method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testWrite() throws Exception {
        System.out.println("Write");
        ArrayList<Fad> Commemorating = null;
        VendingMachineServiceLayerImpl instance = new VendingMachineServiceLayerImpl();
        instance.Write(Commemorating);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of LeftoverMoney method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testLeftoverMoney() {
        System.out.println("LeftoverMoney");
        ArrayList<Fad> UglyItem = null;
        int Inventory = 0;
        BigDecimal insertedAmount = null;
        VendingMachineServiceLayerImpl instance = new VendingMachineServiceLayerImpl();
        BigDecimal expResult = null;
        BigDecimal result = instance.Change(UglyItem, Inventory, insertedAmount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numberOfCoins method, of class VendingMachineServiceLayerImpl.
     */
    @Test            
    public void testNumberOfCoins() {
        System.out.println("numberOfCoins");
        BigDecimal Change = null;
        VendingMachineServiceLayerImpl instance = new VendingMachineServiceLayerImpl();
        Change expResult = null;
        Change result = instance.changeToCoins(Change);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sufficientFunds method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testSufficientFunds() throws Exception {
        System.out.println("sufficientFunds");
        ArrayList<Fad> UglyItem = null;
        int Inventory = 0;
        BigDecimal insertedAmount = null;
        VendingMachineServiceLayerImpl instance = new VendingMachineServiceLayerImpl();
        instance.sufficientFunds(UglyItem, Inventory, insertedAmount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateInventory method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testUpdateInventory() throws Exception {
        System.out.println("updateInventory");
        ArrayList<Fad> UglyItem = null;
        int Inventory = 0;
        VendingMachineServiceLayerImpl instance = new VendingMachineServiceLayerImpl();
        instance.updateInventory(UglyItem, Inventory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ItemInventory method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testItemInventory() throws NoItemInventoryException {
        System.out.println("ItemInventory");
        ArrayList<Fad> UglyItem = null;
        int Inventory = 0;
        VendingMachineServiceLayerImpl instance = new VendingMachineServiceLayerImpl();
        instance.ItemInventory(UglyItem, Inventory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
