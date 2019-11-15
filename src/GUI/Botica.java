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
public class Botica extends JFrame {

    public Botica() {
        JFrame frame1 = new JFrame("ApPharmacy");
        JPanel panel = new JPanel();
        
        JLabel label1 = new JLabel("Welcome to ApPharmacy", JLabel.CENTER);
        label1.setBounds(120, 30, 220, 20);
//        label1.setForeground(Color.red);
        label1.setFont(new Font("Serif", Font.BOLD, 20));
      
        JButton login = new JButton("Login");
        login.setBounds(90, 100, 120, 40);
        JButton register = new JButton("Register");
        register.setBounds(260, 100, 120, 40);

        //add to frame
//        panel.add(label1);
//        panel.add(login);
//        panel.add(register);
//        panel.setBackground(Color.pink);
        
        frame1.add(label1);
        frame1.add(login);
        frame1.add(register);
//        frame1.add(panel);
        frame1.setSize(500, 400);
        frame1.setLayout(null);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        login.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               LoginPage page = new LoginPage();
               frame1.dispose();
//               page.setVisible(true);
           }
       });
        
        register.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               RegisterPage reg = new RegisterPage();
               frame1.dispose();
//               reg.setVisible(true);
           }
       });
    }
}
