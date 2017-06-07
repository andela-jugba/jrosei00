/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dao;

import java.io.FileNotFoundException;

/**
 *
 * @author apprentice
 */
public class flooringMasteryPersisteneException extends Exception {

    public flooringMasteryPersisteneException(String message, FileNotFoundException e) {
        super(message);
    }

    public flooringMasteryPersisteneException(String message, Throwable cause) {
        super(message);
    }
}
