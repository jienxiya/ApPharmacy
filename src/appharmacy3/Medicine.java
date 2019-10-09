/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appharmacy3;

/**
 *
 * @author pallerma_sd2022
 */
public class Medicine {
    private String genericName;
    private String brandName;
    private String type;
    private int medStock;
    private double price;

    public Medicine() {
    }

    public Medicine(String genericName, String brandName, String type,int medStock, double price) {
        this.genericName = genericName;
        this.brandName = brandName;
        this.type = type;
        this.medStock = medStock;
        this.price = price;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getMedStock() {
        return medStock;
    }

    public void setMedStock(int medStock) {
        this.medStock = medStock;
    }

    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return String.format("| Brand Name: %s, Generic Name: %s, Type: %s, Price: %.2f |", genericName, brandName, type, price);
    }
}
