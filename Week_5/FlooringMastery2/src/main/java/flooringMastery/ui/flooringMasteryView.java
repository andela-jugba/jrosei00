/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.ui;

import flooringMastery.dto.Order;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class flooringMasteryView {

    String date;

    flooringMasteryIO io = new flooringMasteryIOImpl();

    public int printMenuAndGetSelection() {
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print("*  <<Flooring Program>>");
        io.print("* 1. Display Orders");
        io.print("* 2. Add an Order");
        io.print("* 3. Edit an Order");
        io.print("* 4. Remove an Order");
        io.print("* 5. Save Current Work");
        io.print("* 6. Quit");
        io.print("*");
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

        return io.readInt("Please select from the" + " above choices.", 1, 6);
    }

    public Order getNewOrderInfo() {
        String customerName = io.readString("Please enter the customer's name.");
        String state = io.readString("Please enter the state");
        String productType = io.readString("What type of product?");
        String area = io.readString("Please provide the area amount.");
        Order currentOrder = new Order(date);
        currentOrder.setCustomerName(customerName);
        currentOrder.setState(state);
        currentOrder.setProductType(productType);
        currentOrder.setArea(new BigDecimal(area));
        return currentOrder;
    }

    public void displayAddOrderBanner() {
        io.print("=== Add Order ===");
    }

    public void displayAddSuccessBanner() {
        io.readString("Order successfully added.  Please hit enter to continue");
    }

    public void displayRemoveOrderBanner() {
        io.print("=== Remove Order ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Order successfully removed. Please hit enter to continue.");
    }

    public String getDateChoice() {
        return io.readString("Please enter the order date."); //check for LocalDate
    }

    public void displaySearchBanner() {
        io.print("=== Search for Order(s) ===");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command");
    }

    public void displayExitBanner() {
        io.readString("Goodbye");
    }
    
    public String getDateToSearch() {
        String date = io.readString("Please provide a date in the format MM/dd/yyyy.");
        return date;
    }
    
    public void displayOrderList(Map<String, Order> orders) {
        io.print(" === Here is a list of all orders on file ===");
        //something here
        }
    
    public void displayOrdersBanner() {
        io.print("=== Display Orders ===");
    }
}
