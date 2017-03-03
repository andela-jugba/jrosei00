/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

import flooringMastery.dto.Order;
import flooringMastery.dto.Products;
import flooringMastery.dto.Tax;
import flooringMastery.dto.flooringMasteryPersistenceException;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public interface flooringMasteryDao {

    public ArrayList<Products> getProduct() throws flooringMasteryPersistenceException;

    public ArrayList<Order> getOrder() throws flooringMasteryPersistenceException;

    public void write(ArrayList<Order> orders) throws flooringMasteryPersistenceException;

    public ArrayList<Tax> getStateTax() throws flooringMasteryPersistenceException;

}
