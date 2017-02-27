/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringMastery.dto;

import java.math.BigDecimal;

/**
 *
 * @author apprentice
 */
public class Tax {

    private BigDecimal stateTax;
    private String state;

    /**
     * @return the stateTax
     */
    public BigDecimal getStateTax() {
        return stateTax;
    }

    /**
     * @param stateTax the stateTax to set
     */
    public void setStateTax(BigDecimal stateTax) {
        this.stateTax = stateTax;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

}
