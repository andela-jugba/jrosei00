/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import vendingmachine.dao.VendingMachineAuditDaoFileImpl;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoImplTest;
import vendingmachine.dto.CoinStack;

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
     * Test of getAllFood method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testGetAllFood() {
    }

    /**
     * Test of saveAllFood method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testSaveAllFood() throws Exception {
    }

    /**
     * Test of Change method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testChange() {
    }

    /**
     * Test of changeToCoins method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testChangeToCoins() {
        
        VendingMachineAuditDaoFileImpl auditDao = new VendingMachineAuditDaoFileImpl();
        VendingMachineDao dao = new VendingMachineDaoImplTest();
        VendingMachineServiceLayerImpl SLImpl = new VendingMachineServiceLayerImpl(dao, auditDao);
        CoinStack cs = SLImpl.changeToCoins(new BigDecimal(0.45));
        assertTrue(cs.getQuarters() == 1
                && cs.getDimes() == 2
                && cs.getNickels() == 0
                && cs.getPennies() == 0);
        
        cs = SLImpl.changeToCoins(new BigDecimal(0.87));
        assertTrue(cs.getQuarters() == 3
                && cs.getDimes() == 1
                && cs.getNickels() == 0
                && cs.getPennies() == 2);
    }

    /**
     * Test of sufficientFunds method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testSufficientFunds() throws Exception {
    }

    /**
     * Test of updateInventory method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testUpdateInventory() throws Exception {
    }

}
