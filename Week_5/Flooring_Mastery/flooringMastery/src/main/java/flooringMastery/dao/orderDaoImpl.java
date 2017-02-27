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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class orderDaoImpl implements flooringMasteryDao {

    public static final String ORDER_FILE = "Order";
    public static final String DELIMITER = "::";

    public ArrayList<Order> getOrder() throws flooringMasteryPersistenceException {
    
        Scanner scanner;
        
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ORDER_FILE)));
        } catch (FileNotFoundException e) {
            throw new flooringMasteryPersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
        String currentLine;

        String[] currentTokens;

        ArrayList<Order> orders = new ArrayList();
        
        Order order = new Order();

        while (scanner.hasNextLine ()) {

            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            order.setOrderNumber(new Integer (currentTokens[0]));
            order.setOrderDate(LocalDate.parse(currentTokens[1]));
            order.setCustomerName(new String (currentTokens[2]));
            order.setState(currentTokens[3]);
            order.setStateTax(new BigDecimal(currentTokens[4]));
            order.setProduct(currentTokens[5]);
            order.setArea(new BigDecimal(currentTokens[6]));
            order.setCostPerSqFoot(new BigDecimal(currentTokens[7]));
            order.setTotalMaterialCost(new BigDecimal(currentTokens[8]));
            order.setLaborCost(new BigDecimal(currentTokens[9]));
            order.setTotalTax(new BigDecimal(currentTokens[10]));
            order.setTotalCost(new BigDecimal(currentTokens[11]));
        }
        return orders;
    }

    @Override
    public ArrayList<Products> getProduct() throws flooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void write(ArrayList<Order> orders) throws flooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Tax> getStateTax() throws flooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

