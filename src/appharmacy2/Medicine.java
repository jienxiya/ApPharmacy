/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appharmacy2;

/**
 *
 * @author pallerma_sd2022
 */
public class Medicine {
    private String genericName;
    private String brandName;
    private String description;
    private float price;

    public Medicine() {
    }

    public Medicine(String genericName, String brandName, float price) {
        this.genericName = genericName;
        this.brandName = brandName;
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
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    @Override
    public String toString(){
        return String.format("Brand Name: %s \nGeneric Name: %s \nPrice: %f", genericName,brandName,price);
    }
    
    
}





