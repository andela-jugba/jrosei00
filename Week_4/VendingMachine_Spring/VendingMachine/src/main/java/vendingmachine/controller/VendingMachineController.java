/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.CoinStack;
import vendingmachine.dto.Snack;
import vendingmachine.service.InsufficientFundsException;
import vendingmachine.service.VendingMachineServiceLayer;
import vendingmachine.service.noItemInventoryException;
import vendingmachine.ui.VendingMachineView;

/**
 *
 * @author apprentice
 */
public class VendingMachineController {

    VendingMachineServiceLayer vmsl;
    VendingMachineView vmv;

    public VendingMachineController(VendingMachineServiceLayer vmsl, VendingMachineView vmv) {
        this.vmsl = vmsl;
        this.vmv = vmv;
        
    }

    public void run() throws VendingMachinePersistenceException {

        BigDecimal Money;
        int Item;
        boolean statement = false;

        ArrayList<Snack> Foods = new ArrayList<>();

        Foods = vmsl.getAllFood();

        Item = vmv.listOfItems(Foods);

        Money = vmv.insertPayment();

        try {
            vmsl.sufficientFunds(Foods, Item, Money);//in try catch
        } catch (InsufficientFundsException ex) {
            //Logger.getLogger(VendingMachineController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            vmsl.ItemInventory(Foods, Item);
        } catch (noItemInventoryException exe) {
            statement = true;
        }
    
        if (statement == false) {
        vmsl.updateInventory(Foods, Item);

        BigDecimal ch = vmsl.Change(Foods, Item, Money);

        CoinStack cs = vmsl.changeToCoins(ch);

        vmv.Change(cs, ch);

        }
    }

}
