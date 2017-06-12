/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.service;

import flooringMastery.dao.flooringMasteryPersistenceException;
import flooringMastery.dto.Order;
import java.math.BigDecimal;

/**
 *
 * @author apprentice
 */
public interface flooringMasteryServiceLayer {

    public void addOrder(String date, Order order) throws invalidStateException, invalidProductTypeException;

    public void save() throws flooringMasteryPersistenceException;
    
    public BigDecimal getMaterialCosts(BigDecimal area, BigDecimal costPerSquareFoot) throws invalidProductTypeException, flooringMasteryPersistenceException;
    
    public BigDecimal getLaborCosts(BigDecimal area, BigDecimal laborCostPesssrSquareFoot) throws flooringMasteryPersistenceException;
    
    public BigDecimal getTax(BigDecimal taxRate, BigDecimal materialCosts, BigDecimal laborCosts) throws flooringMasteryPersistenceException, invalidStateException;
    
    public BigDecimal getTotal(BigDecimal tax, BigDecimal laborCosts, BigDecimal materialCosts) throws flooringMasteryPersistenceException;
}
