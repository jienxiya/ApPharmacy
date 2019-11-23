/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import appharmacy3.User;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author pallerma_sd2022
 */
public class accountCRUD {


    public void addAccount(String uName, String email, String userType, int age, String pass) {

        try {
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;
            String query;
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();

            if (userType.equals("Pharmacist") && age >= 18) {
                query = String.format("INSERT INTO tbl_accounts (Username, Email, UserType, Age, Password) VALUES ('%s','%s', 'Pharmacist','%d','%s')", uName, email, age, pass);
                int result = stmt.executeUpdate(query);
                System.out.println(result + "rows affected");
            } else if (userType.equals("Customer") && age >= 18 && age <= 59) {
                query = String.format("INSERT INTO tbl_accounts (Username, Email, UserType, Age, Password) VALUES ('%s','%s', 'Adult','%d','%s')", uName, email, age, pass);
                int result = stmt.executeUpdate(query);
                System.out.println(result + "rows affected");
            } else if (userType.equals("Customer") && age >= 60) {
                query = String.format("INSERT INTO tbl_accounts (Username, Email, UserType, Age, Password) VALUES ('%s','%s', 'SeniorCitizen','%d','%s')", uName, email, age, pass);
                int result = stmt.executeUpdate(query);
                System.out.println(result + "rows affected");
            } else {
                JOptionPane.showMessageDialog(null, "Sorry! Underage are not allowed to register.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Delete(int account_id) {
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
            query = String.format("DELETE FROM tbl_accounts where id_account = %d", account_id);
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

    public void Retrieve() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM tbl_accounts");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Update() {
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
            int result = stmt.executeUpdate("UPDATE tbl_accounts SET Username = 'Jane' WHERE id_account = 1");
            System.out.println(result);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean login(String email, String pass) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query;
        User newUser = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
//            rs = stmt.executeQuery("select * from tbl");
            query = String.format("SELECT Email, Password FROM tbl_accounts WHERE Email = '%s' && Password = '%s'", email, pass);
            int result = stmt.executeUpdate(query);
            System.out.println(result);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
}
