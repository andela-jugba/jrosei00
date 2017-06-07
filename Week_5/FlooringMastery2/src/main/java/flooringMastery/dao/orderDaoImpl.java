/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

import flooringMastery.dto.Order;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class orderDaoImpl implements orderDao {

    private Map<LocalDate, Order> orders = new HashMap<>();

    @Override
    public Order addOrder(LocalDate date, Order order) {
        Order newOrder = orders.put(date, order);
        return newOrder;
    }

    @Override
    public HashMap<LocalDate, String> getAllOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public Order removeOrder(LocalDate date) {
        Order removedOrder = orders.remove(date);
        return removedOrder;
    }

    @Override
    public Order getOrder(LocalDate date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
