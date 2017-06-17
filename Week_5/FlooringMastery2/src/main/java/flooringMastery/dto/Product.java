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
public class Product {

    private String productType;
    private BigDecimal materialCostPerSquareFoot;
    private BigDecimal laborCostPerSquareFoot;

    public Product(String productType, BigDecimal costPerSquareFoot, BigDecimal laborCostPerSquareFoot) {
        this.productType = productType;
        this.materialCostPerSquareFoot = costPerSquareFoot;
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }

    public Product() {
    }

    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return the materialCostPerSquareFoot
     */
    public BigDecimal getMaterialCostPerSquareFoot() {
        return materialCostPerSquareFoot;
    }

    /**
     * @param costPerSquareFoot the materialCostPerSquareFoot to set
     */
    public void setMaterialCostPerSquareFoot(BigDecimal costPerSquareFoot) {
        this.materialCostPerSquareFoot = costPerSquareFoot;
    }

    /**
     * @return the laborCostPerSquareFoot
     */
    public BigDecimal getLaborCostPerSquareFoot() {
        return laborCostPerSquareFoot;
    }

    /**
     * @param laborCostPerSquareFoot the laborCostPerSquareFoot to set
     */
    public void setLaborCostPerSquareFoot(BigDecimal laborCostPerSquareFoot) {
        this.laborCostPerSquareFoot = laborCostPerSquareFoot;
    }
}
