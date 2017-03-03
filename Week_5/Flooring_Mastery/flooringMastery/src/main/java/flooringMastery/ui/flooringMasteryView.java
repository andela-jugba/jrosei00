/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.ui;

import java.time.LocalDate;

/**
 *
 * @author apprentice
 */
public class floorMasteryView {

    private floorMasteryIO io;

    public floorMasteryView(floorMasteryIO io) {
        this.io = io;

        io.readString(
                "<< Flooring Program>>\n"
                + "1. Display Orders\n"
                + "2. Add an Order\n"
                + "3. Edit an Order\n"
                + "4. Remove an Order\n"
                + "5. Save Current Work\n"
                + "6. Quit \n"
        );

        int userInput = io.readInt("Please make a number selection.");
    }

    public static displayOrders() {
    
    private LocalDate insertedDate;

    int userInput = io.readDate("Please enter the date.");
    if (insertedDate == orderDate);
    return orderDate ;
    }
    else {
    int userInput = io.readInt("There are no orders on that date.");    
    }
}

public Order addOrder() {

        LocalDate orderDate = io.readLocalDate("Please enter a date");
        String customerName = io.readString("Please enter Customer Name");
        String state = io.readString("Please enter the state abbreviation.");
        Integer product = io.readInteger("Please select a number from the following product list:" + "1. Carpet\n" + "2. Laminate\n" + "3. Tile\n" + "4. Wood");
        order currentOrder = new order(orderDate);
        currentOrder.setcustomerName(customerName);
        currentOrder.setstate(state);
        currentOrder.setproduct(product);
        return currentOrder;
    }

     
//display orders method
//add order method
//edit order method
//remove order method}
