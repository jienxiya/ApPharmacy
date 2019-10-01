/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appharmacy2;

import java.util.ArrayList;

/**
 *
 * @author pallerma_sd2022
 */
public class Pharmacy {
    private String pharmacyName;
    private String location;
    private ArrayList<Users> accounts;

    public Pharmacy() {
    }

    public Pharmacy(String pharmacyName, String location) {
        this.pharmacyName = pharmacyName;
        this.location = location;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public void addAccounts(Users user){
        this.accounts.add(user);
    }
    
    
}
