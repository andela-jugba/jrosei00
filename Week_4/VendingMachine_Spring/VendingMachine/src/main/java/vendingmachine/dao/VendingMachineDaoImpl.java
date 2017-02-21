/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

    //VendingMachineDaoImpl Snack;

    public static final String SNACK_FILE = "VendingMachine";
    public static final String DELIMITER = "::";

    public ArrayList<Snack> getAllSnacks() throws VendingMachinePersistenceException {

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
    }

    @Override
    public void writeLibrary(ArrayList<Snack> Snacking) throws VendingMachinePersistenceException {
               PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(SNACK_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException(
                    "Could not save candy data.", e);
        }

        //List<Snack> VendingMachine = this.getAllSnacks();
        for (Snack currentSnack : Snacking) {

            out.println(currentSnack.getName() + DELIMITER
                    + currentSnack.getPrice() + DELIMITER
                    + currentSnack.getInventory());
            out.flush();
        }
        out.close();
    }

}
