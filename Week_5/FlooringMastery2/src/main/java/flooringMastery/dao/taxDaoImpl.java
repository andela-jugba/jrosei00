/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

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
public class taxDaoImpl {

    public static final String TAXES = "Taxes.txt";
    public static final String DELIMITER = ",";

    ArrayList< Tax> states = new ArrayList();

    private ArrayList< Tax> readFromFile() throws flooringMasteryPersistenceException {

        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(TAXES)));
        } catch (FileNotFoundException e) {
            throw new flooringMasteryPersistenceException("Could not load tax rates.", e);
        }

        String currentLine;
        String[] currentTokens;
        states = new ArrayList();

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Tax currentTax = new Tax(currentTokens[0]);
            currentTax.setState(currentTokens[1]);
            currentTax.setTaxRate(new BigDecimal(currentTokens[2]));
            states.add(currentTax);
        }
        return states;
    }
}
