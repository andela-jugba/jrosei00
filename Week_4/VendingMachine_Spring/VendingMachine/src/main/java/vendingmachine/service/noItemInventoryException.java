/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

/**
 *
 * @author apprentice
 */
public class noItemInventoryException extends Exception {

    public noItemInventoryException(String Warning) {
        super(Warning);
    }
    
}
