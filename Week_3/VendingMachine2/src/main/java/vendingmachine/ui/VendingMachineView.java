/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.ui;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dto.Change;
import vendingmachine.dto.Fad;

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

    public BigDecimal insertMoney() {

        String insertedAmountString = io.readString("Please insert amount.");
        BigDecimal insertedAmount = new BigDecimal(insertedAmountString);
        return insertedAmount;
    }

    public int menuItems(List< Fad> Style) {

        io.print(" === Menu === ");
        io.print("1  |" + Style.get(0).getItem() + " ----------" + Style.get(0).getPrice());
        io.print("2  |" + Style.get(1).getItem() + " ----------" + Style.get(1).getPrice());
        io.print("3  |" + Style.get(2).getItem() + " ----------" + Style.get(2).getPrice());
        io.print("4  |" + Style.get(3).getItem() + " ----------" + Style.get(3).getPrice());
        io.print("5  |" + Style.get(4).getItem() + " ----------" + Style.get(4).getPrice());
        io.print("6  |" + Style.get(5).getItem() + " ----------" + Style.get(5).getPrice());

        int Selection = io.readInt("Please insert amount.");
        Selection -= 1;
        return Selection;
    }

    public int LeftoverMoney(Change coins, BigDecimal change) {

        io.print("Your change is " + change);
        io.print("Quarters: " + coins.getQuarter());
        io.print("Dimes: " + coins.getDime());
        io.print("Nickels: " + coins.getNickel());
        io.print("Pennies: " + coins.getPenny());
        io.print("");
        return 0;

    }
}
