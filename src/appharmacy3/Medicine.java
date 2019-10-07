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
    private double price;

    public Medicine() {
    }

    public Medicine(String genericName, String brandName, String type, double price) {
        this.genericName = genericName;
        this.brandName = brandName;
        this.type = type;
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

    public String getDescription() {
        return type;
    }

    public void setDescription(String description) {
        this.type = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Brand Name: %-17s \nGeneric Name: %s \nType: %s \nPrice: %f", genericName, brandName, type, price);
    }
}
