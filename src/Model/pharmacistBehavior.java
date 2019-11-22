/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author pallerma_sd2022
 */
public class pharmacistBehavior {

    public void addMedicine(String gName, String bName, String medType, double price, int stock) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
            query = String.format("INSERT INTO tbl_medicines (genericName, brandName, medType, price,stock) VALUES ('%s','%s','%s','%f','%d')", gName, bName, medType, price, stock);
            int result = stmt.executeUpdate(query);
            System.out.println(result);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void viewAvailableMedicine() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
//            query = String.format("INSERT INTO tbl_medicine (genericName, brandName, medicineType, price,stock) VALUES ('%s','%s','%s','%f','$d')", gName, bName, medType, price, stock);
            int result = stmt.executeUpdate("SELECT * FROM  tbl_medicines");
            System.out.println(result);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void removeMedicine(int med_id) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
//            rs = stmt.executeQuery("select * from tbl");
            query = String.format("DELETE FROM tbl_medicines where id_medicine = %d", med_id);
            int result = stmt.executeUpdate(query);
            System.out.println(result);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void updateMedicineStock(int stock,int med_id) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
//            rs = stmt.executeQuery("select * from tbl");
            query = String.format("UPDATE tbl_medicines SET stock = '%d' WHERE id_account = '%d'",stock,med_id);
            int result = stmt.executeUpdate(query);
            System.out.println(result);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
