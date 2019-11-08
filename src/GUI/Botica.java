/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.*;

/**
 *
 * @author pallerma_sd2022
 */
public class Botica extends JFrame implements ActionListener{

    public Botica() {
        JFrame f = new JFrame("ApPharmacy");
        
        JLabel label1 = new JLabel("Welcome to ApPharmacy", JLabel.CENTER);
        label1.setBounds(120, 30, 220, 20);
//        label1.setForeground(Color.red);
        label1.setFont(new Font("Serif", Font.BOLD, 20));
      
        JButton login = new JButton("Login");
        login.setBounds(90, 100, 120, 40);
        JButton register = new JButton("Register");
        register.setBounds(260, 100, 120, 40);

        //add to frame
        f.add(label1);
        f.add(login);
        f.add(register);
        f.setSize(500, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        login.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               LoginPage page = new LoginPage();
               page.setVisible(true);
           }
       });
        
        register.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               RegisterPage reg = new RegisterPage();
               reg.setVisible(true);
           }
       });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
