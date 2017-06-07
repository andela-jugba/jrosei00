/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

import flooringMastery.dto.Order;
import java.time.LocalDate;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class orderDaoImplTest {

    orderDaoImpl orderDaoTest = new orderDaoImpl();
    Order order;

    public orderDaoImplTest() {
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
     * Test of addOrder method, of class orderDaoImpl.
     */
    @Test
    public void testAddOrder() throws Exception {
        Order plastic = new Order();
        plastic.setDate(LocalDate.now());
        plastic.setCustomerName("John Smith");
        plastic.setState("MN");
        plastic.setProductType("plastic");

        Order returnOrder = orderDaoTest.addOrder(LocalDate.now(), plastic);
        
        assertEquals(plastic, returnOrder);
    }

    /*
     * Test of getAllOrders method, of class orderDaoImpl.
    */
    /*
    @Test
    public void testGetAllOrders() {
        System.out.println("getAllOrders");
        orderDaoImpl instance = new orderDaoImpl();
        HashMap<LocalDate, String> expResult = null;
        HashMap<LocalDate, String> result = instance.getAllOrders();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /*
     * Test of getOrder method, of class orderDaoImpl.
     */
    /*
    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
        LocalDate date = null;
        orderDaoImpl instance = new orderDaoImpl();
        Order expResult = null;
        Order result = instance.getOrder(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /*
     * Test of removeOrder method, of class orderDaoImpl.
     */
    
    @Test
    public void testRemoveOrder() {
        orderDaoTest.removeOrder(LocalDate.now());
        assertNotNull(orderDaoTest.removeOrder(order.getDate(), order.getOrderNumber));
    }


}
