/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import BackUpC_Classes.LoginPage;
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
public class customerBehavior implements CommonModelMethods{

    @Override
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
            String query = "SELECT * FROM  tbl_purchasedmedicine";
//            String query = "SELECT m.id_medicine,m.brandName,m.price,p.QuantityPurchased FROM  tbl_medicines m JOIN tbl_purchasedmeds p ON m.id_medicine = p.id_medicine";
            rs = stmt.executeQuery(query);
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
        LoginPage login = new LoginPage();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String emel = login.getEmail();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
            String query = String.format("SELECT * FROM  tbl_medicines WHERE id_medicine='%d'", med_id);
//            String query = "SELECT id_medicine,id_account,userType FROM  tbl_medicines m JOIN tbl_accounts a ON m.id_";
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                this.addPurchasedMeds(emel, rs.getString("genericName"), rs.getString("brandName"), rs.getString("medType"), Double.valueOf(rs.getString("price")), qty);
//                this.addPurchasedMeds(med_id, Integer.valueOf(rs.getString("id_account")), qty);
                this.updateStock(med_id, (Integer.valueOf(rs.getString("stock")) - qty));

            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addPurchasedMeds(String email, String gName, String bName, String medType, double price, int stock) {
        Connection con = null;
        Statement stmt = null;
//        ResultSet rs = null;
        String query;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
            query = String.format("INSERT INTO tbl_purchasedmedicine (Email, genericName, brandName, medType, price,stock) VALUES ('%s', '%s','%s','%s','%f','%d')", email, gName, bName, medType, price, stock);
            int result = stmt.executeUpdate(query);
//            System.out.println(result);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    public void addPurchasedMeds(int med_id, int account_id, int qtyPurchased) {
//        Connection con = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        String query;
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");
//
//            stmt = con.createStatement();
//            query = String.format("INSERT INTO tbl_purchasedmedicines (id_medicine, id_account, QuantityPurchased) VALUES ('%d','%d','%d')", med_id, account_id, qtyPurchased);
//            int result = stmt.executeUpdate(query);
//            System.out.println(result);
//            con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
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

    public double pay(String email, String bName, double money) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        double bill = 0, price = 0;
        String userType = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
            String query = String.format("SELECT * FROM  tbl_purchasedmedicine WHERE brandName = '%s'", bName);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int qty = Integer.valueOf(rs.getString("stock"));
                price = Double.valueOf(rs.getString("price"));
                userType = this.getUserType(email);
                bill = price * qty;
                if (userType.equals("Adult")) {
                    if (money == bill) {
                        this.removePaidMeds(bName);
                        JOptionPane.showMessageDialog(null, "Succesfully Paid!");
                    } else if (money > bill) {
                        bill = money - bill;
                        this.removePaidMeds(bName);
                        JOptionPane.showMessageDialog(null, "Succesfully Paid! Your Change is " + bill);
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient Money! You purchased " +qty+ " medicine .Your bill is " + bill, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (userType.equals("SeniorCitizen")) {
                    if (money == bill) {
                        this.removePaidMeds(bName);
                        JOptionPane.showMessageDialog(null, "Succesfully Paid!");
                    } else if (money > bill) {
                        double discount = bill * 0.20;
                        double change = money - (bill - discount);
                        this.removePaidMeds(bName);
                        JOptionPane.showMessageDialog(null, "Succesfully Paid! Your Change is " + change);
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient Money! Your bill is " + price, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return bill;
    }

    public void removePaidMeds(String bName) {
        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
            String query = String.format("DELETE FROM  tbl_purchasedmedicine WHERE brandName = '%s'", bName);
            int result = stmt.executeUpdate(query);
            System.out.println(result + " rows affected");

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public String getUserType(String email) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String userType = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
            String query = String.format("SELECT * FROM tbl_accounts WHERE Email = '%s'", email);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                userType = rs.getString("UserType");
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return userType;
    }
    
    public void logout(){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
            int result = stmt.executeUpdate("DELETE FROM  tbl_purchasedmedicine");

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

}
