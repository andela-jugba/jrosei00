/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

import flooringMastery.dto.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class orderDaoImpl implements orderDao {

    private Map<LocalDate, List<Order>> orders = new HashMap<>();
    public static final String Order_List = "DateToFile.txt";
    public static final String DELIMITER = ",";
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMddyyyy");
    private Integer orderNumber = 0;
    
    public orderDaoImpl () {       
    }

    public String DateToFile(LocalDate date) {
        Set<String> dates = new HashSet<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        return "Orders_" + date.format(formatter) + ".txt";
    }

    @Override
    public Order addOrder(Order order) throws flooringMasteryPersistenceException {
        List< Order> newDate = orders.get(LocalDate.now());
        if (!orders.containsKey(order.getDate())) {
        orders.put(order.getDate(), ArrayList < noOrders > noDate); 
        }
          orders.get(order.getDate());
        newDate.add(order);
         
        save();
        
        //orders.put(order.getDate(), );
        order.setOrderNumber(orderNumber);
        return order;
    }

    /*
    @Override
    public Order removeOrder(LocalDate date, int orderNumber, Order order) throws flooringMasteryPersistenceException {
        //Order removedOrder = orders.remove(date, orderNumber);
        orders.remove(date, orderNumber);
        return order;
    }
*/

    /*
    @Override
    public Order editOrder(Order newOrder) {
        String date = newOrder.getDate().format(DateTimeFormatter.ofPattern("MMddyyyy"));
        List<Order> orderList = orders.get(date);
        for (Order o : orderList) {
            if (o.getOrderNumber() == orderNumber) {
                orderList.remove(o);
                orderList.add(newOrder);
            }
        }
        orders.remove(date);
        orders.put(newOrder.getDate(), orderList);
        return null;
    }
*/

    @Override
    public void save() throws flooringMasteryPersistenceException {
        writeToOrder();
    }

    @Override
    public List<Order> getOrders(LocalDate date) {
        return orders.get(date);
    }

    public void writeToOrder() throws flooringMasteryPersistenceException {
        PrintWriter out = null;
        for (LocalDate entry : orders.keySet()) {
            try {
                out = new PrintWriter(new FileWriter(DateToFile(entry)));
            } catch (IOException ex) {
                System.out.println("cannot write to file.");
            }
            List<Order> purchases = orders.get(entry);
            for (Order entryPoint : purchases) {
                out.println(
                        +entryPoint.getOrderNumber()
                        + DELIMITER + entryPoint.getDate()
                        + DELIMITER + entryPoint.getCustomerName()
                        + DELIMITER + entryPoint.getState()
                        + DELIMITER + entryPoint.getTaxRate()
                        + DELIMITER + entryPoint.getProductType()
                        + DELIMITER + entryPoint.getArea()
                        + DELIMITER + entryPoint.getCostPerSquareFoot()
                        + DELIMITER + entryPoint.getLaborCostPerSquareFoot()
                        + DELIMITER + entryPoint.getMaterialCost()
                        + DELIMITER + entryPoint.getLaborCost()
                        + DELIMITER + entryPoint.getTax()
                        + DELIMITER + entryPoint.getTotal());
                out.flush();
            }

            out.close();
        }
    }

    private int getLargestOrderNumber(LocalDate date) {
        if (orders.get(date) == null) {
            return 1;
        } else {
            List< Order> ordernum = orders.get(date);
            int max = Integer.MIN_VALUE;
            for (Order i : ordernum) {
                if (i.getOrderNumber() > max) {
                    max = i.getOrderNumber();
                }
            }
            return max + 1;
        }
    }

    @Override
    public Order getOrder(LocalDate date, int orderNumber) throws flooringMasteryPersistenceException {
        return orders.get(date).get(orderNumber);
    }

}
