/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.io.FileNotFoundException;

/**
 *
 * @author apprentice
 */
public class VendingMachinePersistenceException extends Exception {

    public VendingMachinePersistenceException(String message, FileNotFoundException e) {
        super(message);
    }

    public VendingMachinePersistenceException(String message, Throwable cause) {
        super(message);
    }
}
