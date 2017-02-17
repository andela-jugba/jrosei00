/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoImpl;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.CoinStack;
import vendingmachine.dto.Snack;
import vendingmachine.ui.VendingMachineIO;

/**
 *
 * @author apprentice
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    BigDecimal Payment;
    BigDecimal Cost;
    private VendingMachineDao dao;

    public VendingMachineServiceLayerImpl(VendingMachineDao myDao) {

        this.dao = dao;
    }

    public VendingMachineServiceLayerImpl() {
    }

    public ArrayList< Snack> getAllFood() {
        try {
            VendingMachineDao sn = new VendingMachineDaoImpl();
            ArrayList<Snack> getJunkFood = new ArrayList<>();
            getJunkFood = sn.getAllSnacks();
            return getJunkFood;
        } catch (VendingMachinePersistenceException ex) {
            Logger.getLogger(VendingMachineServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void saveAllFood(ArrayList <Snack> Snacking) throws VendingMachinePersistenceException {
        VendingMachineDao sn = new VendingMachineDaoImpl();
        sn.writeLibrary(Snacking);
        
    }


    //Connects to change file
    @Override
    public BigDecimal Change(ArrayList<Snack> Candy, int candyInList, BigDecimal Payment) {
        Payment= Payment.subtract(Cost);
        return Payment;
    }

    //Find each quantity for each coin
    @Override
    public CoinStack changeToCoins(BigDecimal Change) {

        CoinStack cs = new CoinStack();

        int quarter = 0;
        int dime = 0;
        int nickel = 0;
        int penny = 0;

        BigDecimal quart = new BigDecimal(".25");
        BigDecimal dim = new BigDecimal(".10");
        BigDecimal nick = new BigDecimal(".05");
        BigDecimal pen = new BigDecimal(".01");

        while (Change.compareTo(quart) >= 0) {
            quarter++;
            Change = Change.subtract(quart);
        }
        while (Change.compareTo(dim) >= 0) {
            dime++;
            Change = Change.subtract(dim);
        }
        while (Change.compareTo(nick) >= 0) {
            nickel++;
            Change = Change.subtract(nick);
        }
        while (Change.compareTo(pen) >= 0) {
            penny++;
            Change = Change.subtract(pen);
        }

        cs.setQuarters(quarter);
        cs.setDimes(dime);
        cs.setNickels(nickel);
        cs.setPennies(penny);
        return cs;
    }

    @Override
    public void sufficientFunds(ArrayList<Snack> Candy, int candyInList, BigDecimal Payment) throws InsufficientFundsException {
        Cost = Candy.get(candyInList).getPrice();

        if (Payment.compareTo(Cost) < 0) {

            throw new InsufficientFundsException("Please insert the correct amount.");
        }
    }

    @Override
    public void getInventory(ArrayList<Snack> Candy, int candyInList) {
        int Inventory = Candy.get(candyInList).getInventory();
        Inventory -= Inventory;
        Candy.get(candyInList).setInventory(Inventory);
    }

    
}
