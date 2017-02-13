/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.ui;

/**
 *
 * @author apprentice
 */
public class VendingMachineView {

    int insertedAmount;
    public VendingMachineIO io;

    public VendingMachineView(VendingMachineIO io) {
        this.io = io;
    }

    public static class menuItems {

    }
//List Menu Items

    public void insertPayment() {
        insertedAmount = io.readInt("Please insert payment");
    }

    public void listOfItems() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            io.print("Menu");
            io.print("1. Snickers ........ $0.75");
            io.print("2. Twizzlers ....... $0.85");
            io.print("3. Dorritos ........ $1.00");
            io.print("4. Chips Ahoy! ..... $1.25");
            io.print("5. M&M's ........... $0.75");
            insertPayment();

            int userInput = io.readInt("Please make a selection.");
        }

        this.io = new sufficientFunds();
        io.print("Insufficient Funds. Please insert the correct amount.");
        io.print("Please make your selection.");
    }

    public void Change() {

        int Change = 0;

        io.print("Your change is: " + Change);
        io.print("Quarters: " + );
    }

   

}
