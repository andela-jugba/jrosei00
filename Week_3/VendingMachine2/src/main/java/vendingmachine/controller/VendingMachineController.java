/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Change;
import vendingmachine.dto.Fad;
import vendingmachine.service.InsufficientFundsException;
import vendingmachine.service.NoItemInventoryException;
import vendingmachine.service.VendingMachineServiceLayer;
import vendingmachine.ui.VendingMachineView;

/**
 *
 * @author apprentice
 */
public class VendingMachineController {
    
    VendingMachineView view;
    VendingMachineServiceLayer service;
    
    public VendingMachineController (VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }
    
    public void run() throws VendingMachinePersistenceException {
        
        BigDecimal price;
        int item;
        boolean statement = false;
        
        ArrayList < Fad > items = new ArrayList<>();
        
        items = service.Read();
        item = view.menuItems(items);
        price = view.insertMoney();
        
        try {
            service.sufficientFunds (items, item, price);
        } catch (InsufficientFundsException e) {
            
        }       
        
        try {
            service.ItemInventory(items, item);
        } catch (NoItemInventoryException e) {
            statement = true;
            System.out.println("Unfortauntely we are out of this product. Please choose another.");
        }
        
        if (statement == false) {
            service.updateInventory(items, item);
            
            BigDecimal change = service.Change(items, item, price);
            Change coins = service.changeToCoins(change);
            view.leftoverMoney(coins, change);
                             
        }
    }
}
