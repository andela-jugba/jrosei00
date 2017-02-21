/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.dto.Snack;

/**
 *
 * @author apprentice
 */
public interface VendingMachineDao {

    public ArrayList<Snack> getAllSnacks() throws VendingMachinePersistenceException;

    public void writeLibrary(ArrayList<Snack> Snacking) throws VendingMachinePersistenceException;
}
