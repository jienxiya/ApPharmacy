/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import appharmacy3.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author 2ndyrGroupB
 */
public class RegisterPage extends JFrame {

    public RegisterPage() {
        Pharmacy rose = new Pharmacy();
        rose.addAccounts(rose);
        
        JFrame frame3 = new JFrame("ApPharmacy");
        
        JLabel label1 = new JLabel("Register", JLabel.CENTER);
        label1.setBounds(120, 10, 250, 20);
        label1.setFont(new Font("Serif", Font.BOLD, 20));

        JButton btnLogin = new JButton("Register");
        btnLogin.setBounds(200, 280, 120, 40);
        
        //enter username label
        JLabel uname = new JLabel("Username: \t");
        uname.setBounds(80, 15, 100, 100);

        //enter email label
        JLabel email = new JLabel("Email: \t");
        email.setBounds(80, 50, 100, 100);
        
        //enter email label
        JLabel age = new JLabel("Age: \t");
        age.setBounds(80, 85, 100, 100);

        //enter password label
        JLabel pass = new JLabel("Password: \t");
        pass.setBounds(80, 120, 100, 100);
        
        //textfield to enter username
        JTextField unameField = new JTextField();
        unameField.setBounds(160, 50, 200, 30);

        //textfield to enter email
        JTextField eField = new JTextField();
        eField.setBounds(160, 85, 200, 30);
        
        //textfield to enter email
        JTextField aField = new JTextField();
        aField.setBounds(160, 120, 200, 30);

        //textfield to enter password
        JPasswordField pField = new JPasswordField();
        pField.setBounds(160, 155, 200, 30);
        
        JLabel label2 = new JLabel("Register as: ", JLabel.CENTER);
        label2.setBounds(150, 205, 220, 20);
        
        JRadioButton pharma,customer;
        ButtonGroup G1 = new ButtonGroup(); 
        
        pharma = new JRadioButton();
        pharma.setBounds(150, 220, 120, 50);
        pharma.setActionCommand("Pharmacist");
        
        customer = new JRadioButton();
        customer.setBounds(290, 220, 120, 50);
        customer.setActionCommand("Customer");
        
        
        pharma.setText("Pharmacist");
        customer.setText("Customer");
        

        //add to frame
        frame3.add(pharma);
        frame3.add(customer);
        frame3.add(label2);
        frame3.add(label1);
        frame3.add(eField);
        frame3.add(aField);
        frame3.add(email);
        frame3.add(age);
        frame3.add(uname);
        frame3.add(unameField);
        frame3.add(btnLogin);
        frame3.add(pass);
        frame3.add(pField);
        
        frame3.add(getContentPane());
        
        
        //button group
        G1.add(customer);
        G1.add(pharma);
        
        frame3.setSize(500, 400);
        frame3.setLayout(null);
        frame3.setVisible(true);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame3.setLocation(dim.width/3-this.getSize().width/3, dim.height/3-this.getSize().height/3);
        
        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String option = G1.getSelection().getActionCommand();
                String age = aField.getText();
                int edad = Integer.parseInt(age);
//                User newUser = new User(unameField.getText(),eField.getText(),edad,pField.getText());
                if(option.equals("Pharmacist") && edad >= 18){
                    rose.addUser(new Pharmacist(unameField.getText(),eField.getText(),edad,pField.getText()));
                }else if(option.equals("Customer")){
                    if(edad < 18){
                        JOptionPane.showMessageDialog(null,"Sorry! Underage not allowed to register");
                    }else if(edad >= 18 && edad <= 59){
                        rose.addUser(new Adult(unameField.getText(),eField.getText(),edad,pField.getText()));
                    }else{
                        rose.addUser(new SeniorCitizen(unameField.getText(),eField.getText(),edad,pField.getText()));
                    }
                }
                  
                  LoginPage l = new LoginPage();
                  frame3.dispose();
            }
        });
        
    }

}
