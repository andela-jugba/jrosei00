/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

import flooringMastery.dto.Order;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class orderDaoImpl implements orderDao {

    private Map<String, Order> orders = new HashMap<>();
    public static final String Order_List = "DateToFile.txt";
    public static final String DELIMITER = ",";
    
    private Integer orderNumber = 0;
    Date date = new Date();

    public String DateToFile() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMddYYYY");
        return "Orders_" + formatter + ".txt";
    }


    
    private void writeToOrder() {

        PrintWriter out = null;
        Date date = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("MMddYYYY");

        try {
            out = new PrintWriter(new FileWriter(Order_List));
        } catch (IOException e) {

        }

        Map<String, Order> orders = new HashMap<>(orders.values()) {};
        for (Order currentOrder : orderList) {
            //write student object to file
            out.print(currentOrder.getCustomerName() + DELIMITER
                    + currentOrder.getState() + DELIMITER
                    + currentOrder.getProductType() + DELIMITER
                    + currentOrder. + DELIMITER
                    + currentOrder.getDirector() + DELIMITER
                    + currentOrder.getComment());
            out.flush();
        }
        out.close();
    }
     
 
    public void readFromOrderFile() throws flooringMasteryPersistenceException {

        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(Order_List)));
        } catch (FileNotFoundException e) {
            throw new flooringMasteryPersistenceException("Could not load orders.", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Order order = new Order();
            order.setDate(currentTokens[0]);
            order.setOrderNumber(new Integer(currentTokens[1]));
            order.setCustomerName(currentTokens[2]);
            order.setState(currentTokens[3]);
            order.setTaxRate(new BigDecimal(currentTokens[4]));
            order.setProductType(currentTokens[5]);
            order.setArea(new BigDecimal(currentTokens[6]));
            order.setCostPerSquareFoot(new BigDecimal(currentTokens[7]));
            order.setLaborCostPerSquareFoot(new BigDecimal(currentTokens[8]));
            order.setMaterialCost(new BigDecimal(currentTokens[9]));
            order.setLaborCost(new BigDecimal(currentTokens[10]));
            order.setTax(new BigDecimal(currentTokens[11]));
            order.setTotal(new BigDecimal(currentTokens[12]));

            orders.put(order.getDate(), order);
        }
        scanner.close();
    }
    
 /*
    @Override
    public void save() throws flooringMasteryPersistenceException {
    }
     */

 /*
    @Override
    public Order removeOrder(String date, int orderNumber, Order order) throws flooringMasteryPersistenceException {
        Order removedOrder = orders.remove(date);
        return removedOrder;
    }
     */

    @Override
    public Order addOrder(String date, Order order) {
        DateToFile();
        Order newOrder = orders.put(date, order);
        orderNumber ++;
        return newOrder;
    }

    @Override
    public HashMap<LocalDate, String> getOrderByDate(String date) throws flooringMasteryPersistenceException {
        return new HashMap<>(orders.get(date).getOrderNumber());
    }

    @Override
    public void removeOrder(String date, int orderNumber, Order order) throws flooringMasteryPersistenceException {
    }

    @Override
    public void save() throws flooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order getOrder(String date, int orderNumber) throws flooringMasteryPersistenceException {
        return orders.get(date).getOrder(date);
    }

    //will do later
    /*
    @Override
    public void editOrder(Order order) {
        
        
    }
*/

}
