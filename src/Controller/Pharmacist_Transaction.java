/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.customerBehavior;
import Model.pharmacistBehavior;
import View.Add;
import View.Remove;
import View.UserLogin;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pallerma_sd2022
 */
public class Pharmacist_Transaction {

    pharmacistBehavior a = new pharmacistBehavior();
    Add add = new Add();
    
    Remove remove = new Remove();
    UserLogin u = new UserLogin();
    
    String s = u.cusTrans();
    
    public void pharmaTransaction() {
        if (s.equals("Add Medicine")) {
            add.setVisible(true);
        } else if (s.equals("View Medicine")) {
            this.availableMeds();
        } else if (s.equals("Remove Medicine")) {
            this.removeMeds(remove.getMedID());
        }
    }

    public void addMeds(String gName, String bName, String medType, String price, String stock) {
        
        if (gName.equals("") || bName.equals("") || medType.equals("") || price.equals("") || stock.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        a.addMedicine(gName, bName, medType, Integer.valueOf(price), Integer.valueOf(stock));
        JOptionPane.showMessageDialog(null, "Successfully Added.", "", JOptionPane.PLAIN_MESSAGE);
    }
    
    public void availableMeds() {
        ArrayList<ArrayList> data = a.viewAvailableMedicine();
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
        JOptionPane.showMessageDialog(null, new JScrollPane(table), "Available Medicines", JOptionPane.PLAIN_MESSAGE
        );
    }
    
    public void removeMeds(int med_id) {
        if (med_id != 0) {
            a.removeMedicine(med_id);
            JOptionPane.showMessageDialog(null, "Successfully Removed!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nothing to remove.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
