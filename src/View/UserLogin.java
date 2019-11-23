/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import appharmacy3.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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
public class UserLogin extends JFrame{
    public UserLogin(User user){
        Pharmacy rose = new Pharmacy();
        Medicine med = new Medicine();
        
        JFrame frame4 = new JFrame("ApPharmacy");
        JLabel label1;

        if(user instanceof Customer){
            label1 = new JLabel("Log in as Customer" , JLabel.CENTER);
            label1.setBounds(120, 10, 220, 20);
        }else{
            label1 = new JLabel("Log in as Pharmacist", JLabel.CENTER);
            label1.setBounds(120, 10, 220, 20);
        }
        
        label1.setFont(new Font("Serif", Font.BOLD, 20));

        
        JButton back = new JButton("Back"); 
        back.setBounds(100, 200, 120, 40);
        
        JButton next = new JButton("Next"); 
        next.setBounds(240, 200, 120, 40);
        
        JRadioButton add,view,remove,logout, pay;
        ButtonGroup G1 = new ButtonGroup(); 
        
        add = new JRadioButton();
        add.setBounds(40, 30, 150, 50);
        add.setActionCommand("Add Medicine");
        
        view = new JRadioButton();
        view.setBounds(40, 70, 150, 50);
        view.setActionCommand("View Medicine");
        
        pay = new JRadioButton();
        pay.setBounds(40, 110, 180, 50);
        pay.setActionCommand("Pay");
        
        remove = new JRadioButton();
        remove.setBounds(240, 30, 180, 50);
        remove.setActionCommand("Remove Medicine");
        
        logout = new JRadioButton();
        logout.setBounds(240, 70, 150, 50);
        logout.setActionCommand("logout");
        
        if(user instanceof Customer){
            add.setText("View Medicine");
            view.setText("Purchase Medicine");
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
        frame4.add(add);
        frame4.add(view);
        frame4.add(remove);
        frame4.add(label1);
        frame4.add(next);
        frame4.add(back);
        frame4.add(logout);
        frame4.add(pay);
        
        
        //button group
        G1.add(add);
        G1.add(pay);
        G1.add(view);
        G1.add(remove);
        G1.add(logout);
        
        frame4.setSize(500, 400);
        frame4.setLayout(null);
        frame4.setVisible(true);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame4.setLocation(dim.width/3-this.getSize().width/3, dim.height/3-this.getSize().height/3);
        
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String option = G1.getSelection().getActionCommand();
               if (user instanceof Customer){
                   if(option.equals("Add Medicine")){ //The action command is based on the given above. View Available Medicine for Customer side
                       ViewAvailableMeds v = new ViewAvailableMeds();
                       v.setVisible(true);
//                       frame4.setVisible(false);
                   }else if(option.equals("View Medicine")){ //Purchase Medicine
                       PurchasedMeds p = new PurchasedMeds();
                       p.setVisible(true);
//                       frame4.setVisible(false);
                   }else if(option.equals("Remove Medicine")){ // View Purchased Medicine
                       ViewPurchased vp = new ViewPurchased();
                       vp.setVisible(true);
                   }
               }
            }
        });
    }
    
}
