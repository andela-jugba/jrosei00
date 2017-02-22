/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.ui;

/**
 *
 * @author apprentice
 */
public class floorMasteryView {

    private floorMasteryIO io;

    public floorMasteryView(floorMasteryIO io) {
        this.io = io;

        io.readString(
                "<< Flooring Program>>
                1. Display Orders
                2. Add an Order
                3. Edit an Order
                4. Remove an Order
                5. Save Current Work
                6. Quit"
                 );
                
                int userInput = io.readInt("Please make a number selection.");
                return userInput;
    }

//display orders method
//add order method
//edit order method
//remove order method
}
