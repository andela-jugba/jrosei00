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

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView io) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void VendingMachineController (VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }
    
    public void run() throws VendingMachinePersistenceException {
        
        BigDecimal Price;
        int Item;
        boolean statement = false;
        
        ArrayList < Fad > Items = new ArrayList<>();
        
        Items = service.Read();
        Item = view.menuItems(Items);
        Price = view.insertMoney();
        
        try {
            service.sufficientFunds (Items, Item, Price);
        } catch (InsufficientFundsException e) {
            
        }
        
        try {
            service.sufficientFunds (Items, Item, Price);
        } catch (InsufficientFundsException e) {
            
        }
        
        try {
            service.ItemInventory(Items, Item);
        } catch (NoItemInventoryException e) {
            statement = true;
        }
        
        if (statement == false) {
            service.updateInventory(Items, Item);
            
            BigDecimal change = service.Change(Items, Item, Price);
            Change coins = service.changeToCoins(change);
            view.LeftoverMoney(coins, change);
                    
             
        }
    }
}
