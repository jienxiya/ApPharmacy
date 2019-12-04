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
import static java.lang.System.exit;

/**
 *
 * @author pallerma_sd2022
 */
public class Customer_Transaction implements CommonControllerMethods{

    customerBehavior cusMethods = new customerBehavior();
    UserLogin u = new UserLogin();
    PurchasedMeds purchase = new PurchasedMeds();
    Pay pay = new Pay();
    String s = u.cusTrans();

    @Override
    public void Transaction() {
        if (s.equals("Add Medicine")) {
            this.viewAvailableMeds();
        } else if (s.equals("View Medicine")) {
            purchase.setVisible(true);
        } else if (s.equals("Remove Medicine")) {
            this.viewPurchasedMeds();
        } else if (s.equals("logout")) {
            this.logout();
        } else {
            pay.setVisible(true);
        }
    }

    @Override
    public void viewAvailableMeds() {
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

    public void viewPurchasedMeds() {
        ArrayList<ArrayList> data = cusMethods.viewPurchasedMedicine();
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
            "Medicine ID", "Generic name", "Brand name", "Medicine Type", "Price", "Stock"
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

    public void purchaseMeds(String medID, String qty) {
        if (medID.equals("") || qty.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            cusMethods.purchaseMedicine(Integer.valueOf(medID), Integer.valueOf(qty));
        }
    }

    public void pay(String email,  String bName, String money) {
        if (bName.equals("") || money.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            cusMethods.pay(email, bName, Double.valueOf(money));
        }
    }

    @Override
    public void logout() {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?");
        int yes = JOptionPane.YES_OPTION;

        if (option == yes) {
            cusMethods.logout();
            JOptionPane.showMessageDialog(null, "Thank you for visiting ApPharmacy. Come Again! ");
        }
        exit(1);
    }
}
