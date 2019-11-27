/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import View.*;

/**
 *
 * @author pallerma_sd2022
 */
public class Customer_Transaction {

    customerBehavior cusMethods = new customerBehavior();
    UserLogin u = new UserLogin();
    PurchasedMeds purchase = new PurchasedMeds();
    String s = u.cusTrans();
    

    public void cusTransaction() {
        if (s.equals("Add Medicine")) {
            this.availableMeds();
        }else if(s.equals("View Medicine")){
            purchase.setVisible(true);
        }
    }

    public void availableMeds() {
        ArrayList<ArrayList> data = cusMethods.viewAvailableMedicine();
        Object[][] rows = new Object[data.size()][6];
        for (int index = 0; index < data.size(); index++) {
            rows[index][0] = data.get(index).get(0);
            rows[index][1] = data.get(index).get(1);
            rows[index][2] = data.get(index).get(2);
            rows[index][3] = data.get(index).get(3);
            rows[index][4] = data.get(index).get(4);
            rows[index][5] = data.get(index).get(5);
        }
        Object[] cols = {
            "Medicine ID", "Generic Name", "Brand Name", "Medicine Type", "Price", "Stock"
        };
        DefaultTableModel tableModel = new DefaultTableModel(rows, cols) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        JTable table = new JTable(rows, cols);
        Font font = new Font("Verdana", Font.PLAIN, 12);
        table.setModel(tableModel);
        table.setFont(font);
        table.setRowHeight(25);
        table.getTableHeader().setPreferredSize(new Dimension(100, 30));
        table.getTableHeader().setFont(font);
        JOptionPane.showMessageDialog(null, new JScrollPane(table), "Available Medicines", JOptionPane.PLAIN_MESSAGE);
    }
    
    public void viewPurchasedMeds(int med_id, int qty) {
        ArrayList<ArrayList> data = cusMethods.purchaseMedicine(med_id, qty);
        Object[][] rows = new Object[data.size()][5];
        for (int index = 0; index < data.size(); index++) {
            rows[index][0] = data.get(index).get(0);
            rows[index][1] = data.get(index).get(1);
            rows[index][2] = data.get(index).get(2);
            rows[index][3] = data.get(index).get(3);
            rows[index][4] = data.get(index).get(4);
        }
        Object[] cols = {
            "Generic name", "Brand name", "Medicine Type", "Price", "Stock"
        };
        DefaultTableModel tableModel = new DefaultTableModel(rows, cols) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        JTable table = new JTable(rows, cols);
        Font font = new Font("Verdana", Font.PLAIN, 12);
        table.setModel(tableModel);
        table.setFont(font);
        table.setRowHeight(25);
        table.getTableHeader().setPreferredSize(new Dimension(100, 30));
        table.getTableHeader().setFont(font);
        JOptionPane.showMessageDialog(null, new JScrollPane(table), "Purchased Medicines", JOptionPane.PLAIN_MESSAGE
        );
    }
    
    public void purchaseMeds(String medID,String qty){
        if(medID.equals("") || qty.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            cusMethods.purchaseMedicine(Integer.valueOf(medID), Integer.valueOf(qty));
        }
    }
}
