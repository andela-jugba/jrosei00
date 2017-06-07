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

    Order addOrder(LocalDate date, Order order);

    HashMap<LocalDate, String> getAllOrders();

    Order getOrder(LocalDate date);

    Order removeOrder(LocalDate date);
}