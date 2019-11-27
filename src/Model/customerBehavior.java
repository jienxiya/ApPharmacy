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

//    public void purchaseMeds(int med_id, int qty) {
//        
//    }

    public ArrayList<ArrayList> purchaseMedicine(int med_id, int qty) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<ArrayList> purchasedMeds = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
            String query = String.format("SELECT * FROM  tbl_medicines WHERE id_medicine='%d'", med_id);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                ArrayList medicines = new ArrayList();
                medicines.add(rs.getString("id_medicine"));
                medicines.add(rs.getString("genericName"));
                medicines.add(rs.getString("brandName"));
                medicines.add(rs.getString("medType"));
                medicines.add(rs.getString("price"));
                medicines.add(qty);
                purchasedMeds.add(medicines);
                
                this.addPurchasedMeds(rs.getString("genericName"), rs.getString("brandName"), rs.getString("medType"), Double.valueOf(rs.getString("price")), qty);
                System.out.println("Added to tbl_purchasedmedicines successfully");
                this.updateStock(med_id, (Integer.valueOf(rs.getString("stock")) - qty));
                System.out.println("new Stock "+ (Integer.valueOf(rs.getString("stock")) - qty));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return purchasedMeds;
    }
    
    public void addPurchasedMeds(String gName, String bName, String medType, double price, int stock){
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
    
    public void updateStock(int med_id, int qty){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
            query = String.format("UPDATE tbl_medicines SET stock = '%d' WHERE id_medicine = '%d'",med_id ,qty);
            int result = stmt.executeUpdate(query);
            System.out.println(result);
            while(rs.next()){
                
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
