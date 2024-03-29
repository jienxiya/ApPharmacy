/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.pharmacistBehavior;
import View.Add;
import View.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.lang.System.exit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pallerma_sd2022
 */
public class Pharmacist_Transaction implements CommonControllerMethods {

    pharmacistBehavior a = new pharmacistBehavior();
    Add add = new Add();
    Remove remove = new Remove();
    Update update = new Update();
    Dashboardd u = new Dashboardd();
    String s = u.cusTrans();

    @Override
    public void Transaction() {
        if (s.equals("View")) {
            add.setVisible(true);
        } else if (s.equals("Purchased")) {
            this.viewAvailableMeds();
        } else if (s.equals("View Purchased")) {
            remove.setVisible(true);
        } else if (s.equals("Pay")) {
            update.setVisible(true);
        } else {
            this.logout();
        }
    }

    public void addMeds(String gName, String bName, String medType, String price, String stock) {
        if (gName.equals("") || bName.equals("") || medType == null || price.equals("") || stock.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            a.addMedicine(gName, bName, medType, Integer.valueOf(price), Integer.valueOf(stock));
            JOptionPane.showMessageDialog(null, "Successfully Added!");
        }
    }

    @Override
    public void viewAvailableMeds() {
        ArrayList<ArrayList> data = a.viewAvailableMedicine();
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
        Color color = new Color(255, 204, 204);
        JTable table = new JTable(rows, cols);
        Font font = new Font("Verdana", Font.PLAIN, 12);
        table.setModel(tableModel);
        table.setFont(font);
        table.setRowHeight(25);
        table.getTableHeader().setPreferredSize(new Dimension(100, 30));
        table.getTableHeader().setFont(font);
        table.setBackground(color);
        JOptionPane.showMessageDialog(null, new JScrollPane(table), "Available Medicines", JOptionPane.PLAIN_MESSAGE);
    }

    public void removeMeds(String med_id, String bName) {
        if (med_id.equals("") || bName.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            a.removeMedicine(Integer.valueOf(med_id));
            JOptionPane.showMessageDialog(null, "Successfully Removed!");
        }
    }

    public void updateMeds(String med_id, String gName, String bName, String price, String stock) {
        if (med_id.equals("") || gName.equals("") || bName.equals("") || price.equals("") || stock.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            a.updateMedicine(Integer.valueOf(med_id), gName, bName, Double.valueOf(price), Integer.valueOf(stock));
            JOptionPane.showMessageDialog(null, "Successfully Updated!");
        }
    }

    @Override
    public void logout() {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?");
        int yes = JOptionPane.YES_OPTION;

        if (option == yes) {
            JOptionPane.showMessageDialog(null, "Thank you for Serving ApPharmacy. Come Again! ");
            exit(1);
        }
    }
}
