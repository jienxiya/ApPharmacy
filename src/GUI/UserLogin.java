/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import appharmacy3.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author 2ndyrGroupB
 */
public class UserLogin extends JFrame implements ActionListener{
    public UserLogin(User user){
        
        JFrame f = new JFrame("ApPharmacy");
        JLabel label1;

        if(user instanceof Customer){
            label1 = new JLabel("Log in as Customer" , JLabel.CENTER);
            label1.setBounds(120, 10, 220, 20);
        }else{
            label1 = new JLabel("Log in as Pharmacist", JLabel.CENTER);
            label1.setBounds(120, 10, 220, 20);
        }
        
        JButton back = new JButton("Back"); 
        back.setBounds(100, 200, 120, 40);
        
        JButton next = new JButton("Next"); 
        next.setBounds(240, 200, 120, 40);
        
        JRadioButton add,view,remove,logout, pay;
        ButtonGroup G1 = new ButtonGroup(); 
        
        add = new JRadioButton();
        add.setBounds(40, 30, 150, 50);
        
        view = new JRadioButton();
        view.setBounds(40, 70, 150, 50);
        
        pay = new JRadioButton();
        pay.setBounds(40, 110, 180, 50);
        
        remove = new JRadioButton();
        remove.setBounds(240, 30, 180, 50);
        
        logout = new JRadioButton();
        logout.setBounds(240, 70, 150, 50);
        
        if(user instanceof Customer){
            add.setText(" View Medicine");
            view.setText("Purchased Medicine");
            remove.setText("View Purchases Medicine");
            pay.setText("Pay");
            logout.setText("Logout");
        }else{
            add.setText("Add Medicine");
            view.setText("View Medicine");
            remove.setText("Remove Medicine");
            pay.setText("Update Medicine Stock");
            logout.setText("Logout");
        }
        
        //add to frame
        f.add(add);
        f.add(view);
        f.add(remove);
        f.add(label1);
        f.add(next);
        f.add(back);
        f.add(logout);
        f.add(pay);
        
        
        //button group
        G1.add(add);
        G1.add(pay);
        G1.add(view);
        G1.add(remove);
        G1.add(logout);
        
        f.setSize(500, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
