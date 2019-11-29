/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.LoginPage;
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
//                medicines.add(rs.getString("id_medicine"));
//                medicines.add(rs.getString("brandName"));
//                medicines.add(rs.getString("price"));
//                medicines.add(rs.getString("stock"));
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

//    public double pay(String email, String bName, double money) {
//        Connection con = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        double bill = 0, price = 0;
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");
//
//            stmt = con.createStatement();
////            String query = String.format("SELECT * FROM  tbl_purchasedmedicines WHERE brandName = '%s'", bName);
//            String query = String.format("SELECT Email,userType,brandName FROM  tbl_accounts a JOIN tbl_purchasedmedicine pm  ON a.Email = pm.Email WHERE brandName = '%s'", bName);
//            rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                int qty = Integer.valueOf(rs.getString("stock"));
//                price = Double.valueOf(rs.getString("price")) * qty;
//                if (money < price) {
//                    JOptionPane.showMessageDialog(null, "Insufficient Money! Your bill is " + price, "Error", JOptionPane.ERROR_MESSAGE);
//                } else{
//                    bill = money - price;
//                    this.removePaidMeds(bName);
//                    JOptionPane.showMessageDialog(null, "Succesfully Paid! Your Change is " + bill);
//                }
//            }
//
//            con.close();
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println(e);
//        }
//        return bill;
//    }
    public double pay(String email, String bName, double money) {
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
//            String query = String.format("SELECT Email,userType,brandName FROM  tbl_accounts a JOIN tbl_purchasedmedicine pm  ON a.Email = pm.Email WHERE brandName = '%s'", bName);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int qty = Integer.valueOf(rs.getString("stock"));
                price = Double.valueOf(rs.getString("price"));
//                if (money < price) {
//                    JOptionPane.showMessageDialog(null, "Insufficient Money! Your bill is " + price, "Error", JOptionPane.ERROR_MESSAGE);
//                } else{
//                    bill = money - price;
//                    this.removePaidMeds(bName);
//                    JOptionPane.showMessageDialog(null, "Succesfully Paid! Your Change is " + bill);
//                }
//                System.out.println("db " +rs.getString("brandName"));
//                System.out.println("input " +bName);
                if (rs.getString("brandName").equals(bName)) {
                    System.out.println("AMBOTTTTTTTT");
                    ResultSet rs2 = stmt.executeQuery("SELECT * FROM tbl_accounts");
                    String user = rs2.getString("UserType");
                    System.out.println(user);
                    bill = price * qty;
                    if (user.equals("Adult")) {
                        if (money == bill) {
//                              JOptionPane.showMessageDialog(null, "Insufficient Money! Your bill is " + price, "Error", JOptionPane.ERROR_MESSAGE);
                            JOptionPane.showMessageDialog(null, "Succesfully Paid!");
                        } else if (money > bill) {
                            bill = money - bill;
                            this.removePaidMeds(bName);
                            JOptionPane.showMessageDialog(null, "Succesfully Paid! Your Change is " + bill);
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient Money! Your bill is " + price, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else if (user.equals("SeniorCitizen")) {
                        if (money == bill) {

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
