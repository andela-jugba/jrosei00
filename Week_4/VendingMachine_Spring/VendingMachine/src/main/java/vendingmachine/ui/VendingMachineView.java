/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.ui;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dto.CoinStack;
import vendingmachine.dto.Snack;

/**
 *
 * @author apprentice
 */
public class VendingMachineView {

    public VendingMachineIO io;

    public VendingMachineView() {

    }

    public VendingMachineView(VendingMachineIO io) {
        this.io = io;
    }

    public static class menuItems {

    }

    public BigDecimal insertPayment() {

        String insertedAmount;

        insertedAmount = io.readString("Please insert payment");
        BigDecimal X = new BigDecimal(insertedAmount); //need to set scale
        return X;
    }

    public int listOfItems(List<Snack> Candy) {

        io.print("Menu");
        io.print("1. " + Candy.get(0).getName() + ".........." + Candy.get(0).getPrice());
        io.print("2. " + Candy.get(1).getName() + ".........." + Candy.get(1).getPrice());
        io.print("3. " + Candy.get(2).getName() + ".........." + Candy.get(2).getPrice());
        io.print("4. " + Candy.get(3).getName() + ".........." + Candy.get(3).getPrice());
        io.print("5. " + Candy.get(4).getName() + ".........." + Candy.get(4).getPrice());

        int userInput = io.readInt("Please make a number selection.");
        userInput -= 1;
        return userInput;
    }

    public void Change(CoinStack cs, BigDecimal ch)  {


        io.print("Your change is: " + ch);
        io.print("Quarters: " + cs.getQuarters());
        io.print("Dimes: " + cs.getDimes());
        io.print("Nickels: " + cs.getNickels());
        io.print("Pennies: " + cs.getPennies());
    }

}
