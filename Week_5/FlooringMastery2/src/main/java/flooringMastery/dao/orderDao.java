/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

import flooringMastery.dto.Order;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface orderDao {

    Order addOrder(Order order) throws flooringMasteryPersistenceException;

    Order removeOrder(LocalDate date, int orderNumber, Order order) throws flooringMasteryPersistenceException;

    Order editOrder(Order order);

    void save() throws flooringMasteryPersistenceException;

    public List<Order> getOrders(LocalDate date);
    
    public Order getOrder(LocalDate date, int orderNumber) throws flooringMasteryPersistenceException;
}
