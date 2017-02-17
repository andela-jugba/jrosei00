/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.CoinStack;
import vendingmachine.dto.Snack;

/**
 *
 * @author apprentice
 */
public interface VendingMachineServiceLayer {

    public ArrayList< Snack> getAllFood();

    public void sufficientFunds(ArrayList<Snack> Candy, int candyInList, BigDecimal Payment) throws InsufficientFundsException;

    public void updateInventory(ArrayList<Snack> Candy, int candyInList) throws VendingMachinePersistenceException;

    public BigDecimal Change(ArrayList<Snack> Candy, int candyInList, BigDecimal Payment);

    public CoinStack changeToCoins(BigDecimal Change);
}
