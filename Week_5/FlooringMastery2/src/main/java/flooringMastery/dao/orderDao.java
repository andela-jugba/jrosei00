/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

import flooringMastery.dto.Order;
import java.time.LocalDate;
import java.util.HashMap;

/**
 *
 * @author apprentice
 */
public interface orderDao {

    Order addOrder(String date, Order order);

    HashMap<LocalDate, String> getOrderByDate(String date) throws flooringMasteryPersistenceException;

    void removeOrder(String date, int orderNumber, Order order) throws flooringMasteryPersistenceException;

    void editOrder (Order order);

    void save() throws flooringMasteryPersistenceException;
    
    Order getOrder(String date, int orderNumber) throws flooringMasteryPersistenceException;
}