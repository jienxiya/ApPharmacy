/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.accountCRUD;
import View.Login;
import View.Register;
import javax.swing.JOptionPane;

/**
 *
 * @author pallerma_sd2022
 */
public class Account_Management {
    
    accountCRUD acc = new accountCRUD();
    Login l = new Login();
    Register r = new Register();
       
    
    public  void register(String uName, String email, String userType, String age, String pass){
        if(uName.equals("") || email.equals("") || userType.equals("") || age.equals("") || pass.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(acc.addAccount(uName, email,userType, Integer.valueOf(age), pass)== true){
//            acc.addAccount(uName, email,userType, Integer.valueOf(age), pass);
            l.setVisible(true);
        }else{
            r.setVisible(true);
        }
    }
    
    public boolean login(String email, String pass){
        if(email.equals("") || pass.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill in the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            return acc.login(email, pass);
        }
        return false;
    }
    
    public String getUserType(String email, String pass){
        return acc.getUser(email, pass);
        
    }
}
