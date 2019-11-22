/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;

/**
 *
 * @author pallerma_sd2022
 */
public class accountCRUD {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    String query;

    public void addAccount(String uName, String email, int age, String pass) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_appharmacy", "root", "");

            stmt = con.createStatement();
//            rs = stmt.executeQuery("select * from tbl");
            query = String.format("INSERT INTO tbl_accounts (Username, Email, Age, Password) VALUES ('%s','%s','%d','%s')", uName, email, age, pass);
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

    public void Delete(int account_id) { 

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
}
