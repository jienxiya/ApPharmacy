/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author pallerma_sd2022
 */
public class customerBehavior {

    public ArrayList<ArrayList> viewAvailableMedicine() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<ArrayList> meds = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM  tbl_medicines");
            while (rs.next()) {
                ArrayList medicines = new ArrayList();
                medicines.add(rs.getString("id_medicine"));
                medicines.add(rs.getString("genericName"));
                medicines.add(rs.getString("brandName"));
                medicines.add(rs.getString("medType"));
                medicines.add(rs.getString("price"));
                medicines.add(rs.getString("stock"));
                meds.add(medicines);
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return meds;
    }

    public ArrayList<ArrayList> viewPurchasedMedicine() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<ArrayList> meds = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM  tbl_purchasedmedicines");
            while (rs.next()) {
                ArrayList medicines = new ArrayList();
                medicines.add(rs.getString("id_pMed"));
                medicines.add(rs.getString("genericName"));
                medicines.add(rs.getString("brandName"));
                medicines.add(rs.getString("medType"));
                medicines.add(rs.getString("price"));
                medicines.add(rs.getString("stock"));
                meds.add(medicines);
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return meds;
    }

    public void purchaseMedicine(int med_id, int qty) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
            String query = String.format("SELECT * FROM  tbl_medicines WHERE id_medicine='%d'", med_id);
            rs = stmt.executeQuery(query);
            while (rs.next()) {

                this.addPurchasedMeds(rs.getString("genericName"), rs.getString("brandName"), rs.getString("medType"), Double.valueOf(rs.getString("price")), qty);
                System.out.println("Added to tbl_purchasedmedicines successfully");
                System.out.println("new Stock " + (Integer.valueOf(rs.getString("stock")) - qty));
                this.updateStock(med_id, (Integer.valueOf(rs.getString("stock")) - qty));

            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addPurchasedMeds(String gName, String bName, String medType, double price, int stock) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
            query = String.format("INSERT INTO tbl_purchasedmedicines (genericName, brandName, medType, price,stock) VALUES ('%s','%s','%s','%f','%d')", gName, bName, medType, price, stock);
            int result = stmt.executeUpdate(query);
            System.out.println(result);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateStock(int med_id, int qty) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
            query = String.format("UPDATE tbl_medicines SET stock = '%d' WHERE id_medicine = '%d'", qty, med_id);
            int result = stmt.executeUpdate(query);
            System.out.println(result);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public double pay(String bName, double money) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        double bill = 0, price = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
            String query = String.format("SELECT * FROM  tbl_purchasedmedicines WHERE brandName = '%s'", bName);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                price = Double.valueOf(rs.getString("price"));
                if (money < price) {
                    JOptionPane.showMessageDialog(null, "Insufficient Money", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                     bill = money - price;
                     this.removePaidMeds(bName);
                     JOptionPane.showMessageDialog(null, "Succesfully Paid! Your Change is "+ bill);
                }
            }

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return bill;
    }
    
    public void removePaidMeds(String bName){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
            String query = String.format("DELETE FROM  tbl_purchasedmedicines WHERE brandName = '%s'", bName);
            int result = stmt.executeUpdate(query);
            
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

}
