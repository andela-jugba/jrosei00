/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.controller;

import flooringMastery.dao.flooringMasteryPersistenceException;
import flooringMastery.dao.orderDao;
import flooringMastery.dao.orderDaoImpl;
import flooringMastery.dto.Order;
import flooringMastery.ui.flooringMasteryIO;
import flooringMastery.ui.flooringMasteryIOImpl;
import flooringMastery.ui.flooringMasteryView;
import java.time.LocalDate;

/**
 *
 * @author apprentice
 */
public class flooringMasteryController {

    private flooringMasteryIO io = new flooringMasteryIOImpl();
    flooringMasteryView view = new flooringMasteryView();
    orderDao dao = new orderDaoImpl();

    public void run() throws flooringMasteryPersistenceException {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
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

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                   getOrderByDate();
                    break;
                case 2:
                    addOrder();
                    break;
                case 3:
                    editOrder();
                    break;
                case 4:
                    removeOrder();
                    break;
                case 5:
                    save();
                    break;
                case 6:
                    quit();
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addOrder() throws flooringMasteryPersistenceException {
        view.displayAddOrderBanner();
        Order newOrder = view.getNewOrderInfo();
        dao.addOrder(newOrder.getDate(), newOrder);
        view.displayAddSuccessBanner();
    }

    private void removeOrder() {
        view.displayRemoveOrderBanner();
        String date = view.getDateChoice();
        dao.removeOrder(date, orderNumber);
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
    
    private void getOrderByDate() {
        view.displaySearchBanner();
        String date = view.getDateToSearch(); 
        
    }
    
    private void displayOrders() throws flooringMasteryPersistenceException {
        view.displayOrdersBanner();
        String date = view.getDateChoice();
        
        
    }
    
    /*
    private void save() throws flooringMasteryPersistenceException {
        
    }
*/
  
    

}
