/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.customerBehavior;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pallerma_sd2022
 */
public class Customer_Transaction {
    
    customerBehavior cusMethods =  new customerBehavior();
    String[] cols = {"Generic name", "Brand name", "Medicine Type", "Price", "Stock"};
    
    
    
     public DefaultTableModel availableMeds() {
        Object[][] meds = cusMethods.viewAvailableMedicine();
        DefaultTableModel tableMedHeadache = new DefaultTableModel(meds, cols) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all ceisCellEditablells false
                return false;
            }
        };
        return tableMedHeadache;
    }
     
     
}
