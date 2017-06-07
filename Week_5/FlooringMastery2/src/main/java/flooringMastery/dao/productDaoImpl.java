/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

import flooringMastery.dto.Product;
import flooringMastery.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class productDaoImpl {

    public static final String PRODUCTS = "Products.txt";
    public static final String DELIMITER = ",";

    ArrayList< Product> items = new ArrayList();

    private ArrayList< Product> readFromFile() throws flooringMasteryPersistenceException {

        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(PRODUCTS)));
        } catch (FileNotFoundException e) {
            throw new flooringMasteryPersistenceException("Could not load products.", e);
        }

        String currentLine;
        String[] currentTokens;
        items = new ArrayList();

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Product currentProduct = new Product(currentTokens[0]);
            currentProduct.setProductType(currentTokens[1]);
            currentProduct.setCostPerSquareFoot(new BigDecimal(currentTokens[2]));
            currentProduct.setLaborCostPerSquareFoot(new BigDecimal(currentTokens[3]));
            items.add(currentProduct);
        }
        return items;
    }

    public ArrayList<Product> getAllProducts() throws flooringMasteryPersistenceException {
        return readFromFile();
    }
}
