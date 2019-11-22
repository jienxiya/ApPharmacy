/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.pharmacistBehavior;
import javax.swing.JOptionPane;

/**
 *
 * @author pallerma_sd2022
 */
public class Pharmacist_Transaction {
    
    pharmacistBehavior a = new pharmacistBehavior();
    
    public void addMeds(String gName, String bName, String medType, String price, String stock){
        
        if(gName.equals("") || bName.equals("") || medType.equals("") || price.equals("")|| stock.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        a.addMedicine(gName, bName, medType, Integer.valueOf(price), Integer.valueOf(stock));
    }
}
