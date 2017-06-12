/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.service;

import flooringMastery.dao.flooringMasteryPersistenceException;
import flooringMastery.dao.orderDao;
import flooringMastery.dao.productDao;
import flooringMastery.dao.taxDao;
import flooringMastery.dto.Order;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 *
 * @author apprentice
 */
public class flooringMasteryServiceLayerImpl implements flooringMasteryServiceLayer {

    private orderDao OrderDao;
    private productDao product;
    private taxDao taxdao;

    public flooringMasteryServiceLayerImpl(orderDao myDao, productDao product, taxDao taxdao) {
        this.OrderDao = OrderDao;
        this.product = product;
        this.taxdao = taxdao;
    }
    

    @Override
    public void addOrder(String date, Order order) throws invalidStateException, invalidProductTypeException {
        throw new UnsupportedOperationException("Please enter the correct information type.");
    }

    @Override
    public void save() throws flooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BigDecimal getMaterialCosts(BigDecimal area, BigDecimal costPerSquareFoot) throws invalidProductTypeException, flooringMasteryPersistenceException {
        BigDecimal materialCost = (area).multiply(costPerSquareFoot);
        return materialCost;
    }

    @Override
    public BigDecimal getLaborCosts(BigDecimal area, BigDecimal laborCostPerSquareFoot) throws flooringMasteryPersistenceException {
        BigDecimal laborCost = (area).multiply(laborCostPerSquareFoot);
        return laborCost;
    }

    @Override
    public BigDecimal getTax(BigDecimal taxRate, BigDecimal materialCosts, BigDecimal laborCosts) throws flooringMasteryPersistenceException, invalidStateException {
        BigDecimal tax = (taxRate).multiply((laborCosts.multiply(materialCosts)));
        return tax;
    }

    @Override
    public BigDecimal getTotal(BigDecimal tax, BigDecimal laborCosts, BigDecimal materialCosts) throws flooringMasteryPersistenceException {
        BigDecimal total = (tax).add(materialCosts.add(laborCosts));
        return total;
    }
}
