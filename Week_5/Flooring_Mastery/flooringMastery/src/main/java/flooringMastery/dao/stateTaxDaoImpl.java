/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

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
public class stateTaxDaoImpl {

    public static final String TAX_FILE = "Tax";
    public static final String DELIMITER = "::";

    public ArrayList<Tax> getStateTax() throws flooringMasteryPersistenceException {

        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(TAX_FILE)));
        } catch (FileNotFoundException e) {
            throw new flooringMasteryPersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
        String currentLine;

        String[] currentTokens;

        ArrayList<Tax> stateTax = new ArrayList();

        Tax tax = new Tax();

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            tax.setStateTax(new BigDecimal(currentTokens[0]));
            tax.setState(new String(currentTokens[1]));
        }
        return stateTax;
    }
}
