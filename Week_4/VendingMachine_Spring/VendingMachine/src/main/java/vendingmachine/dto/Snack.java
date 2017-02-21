/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dto;


/**
 *
 * @author apprentice
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigDecimal;

/**
 *
 * @author apprentice
 */
public class Snack {

    public Snack(String Food) {
        Name = Food;
    }

    
    private int Inventory;
    private String Name;
    private BigDecimal Price;

    /**
     * @return the Inventory
     */
    public int getInventory() {
        return Inventory;
    }

    /**
     * @param Inventory the Inventory to set
     */
    public void setInventory(int Inventory) {
        this.Inventory = Inventory;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Price
     */
    public BigDecimal getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(BigDecimal Price) {
        this.Price = Price;
    }
    
    @Override
    public String toString() {
        return "Name: " + Name + " |Price: " + Price + " |Inventory: " + Inventory;
        
    }
    
    
}


