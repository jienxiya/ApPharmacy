/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author pallerma_sd2022
 */
public class Update {
    public static void main(String args[]) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
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
