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
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class productDaoImpl implements flooringMasteryDao {

    public static final String PRODUCT_FILE = "Product";
    public static final String DELIMITER = "::";

    public ArrayList<Products> getProduct() throws flooringMasteryPersistenceException {

        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(PRODUCT_FILE)));
        } catch (FileNotFoundException e) {
            throw new flooringMasteryPersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
        String currentLine;

        String[] currentTokens;

        ArrayList<Products> products = new ArrayList();

        Products product = new Products();

        while (scanner.hasNextLine()) {
                
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            product.setProduct(currentTokens[0]);
            product.setAreaCost(new BigDecimal(currentTokens[1]));
            product.setLaborCost(new BigDecimal(currentTokens[2]));
        }
        return products;
    }

    @Override
    public ArrayList<Order> getOrder() throws flooringMasteryPersistenceException {
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
