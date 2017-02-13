/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import vendingmachine.dto.Snack;

/**
 *
 * @author apprentice
 */
public class VendingMachineDaoImpl implements VendingMachineDao {

    VendingMachineDaoImpl Snack;

    public static final String SNACK_FILE = "VendingMachine.txt";
    public static final String DELIMITER = "::";

    public List<Snack> getAllSnacks() throws VendingMachinePersistenceException {

        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(SNACK_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
        String currentLine;

        String[] currentTokens;

        ArrayList<Snack> Foods = new ArrayList();

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Snack currentSnack = new Snack(currentTokens[0]);
            currentSnack.setPrice(new BigDecimal(currentTokens[1]));
            currentSnack.setInventory(Integer.parseInt(currentTokens[2]));
            Foods.add(currentSnack);
        }
        return Foods;

        private PurchasedItem() {
            
        }
    }
}
