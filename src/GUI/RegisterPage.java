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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author 2ndyrGroupB
 */
public class RegisterPage extends JFrame implements ActionListener {

    public RegisterPage() {
        Pharmacy rose = new Pharmacy();
        rose.addAccounts(rose);
        
        JFrame f = new JFrame("ApPharmacy");
        
        JLabel label1 = new JLabel("Register", JLabel.CENTER);
        label1.setBounds(120, 10, 250, 20);

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
        f.add(pharma);
        f.add(customer);
        f.add(label2);
        f.add(label1);
        f.add(eField);
        f.add(aField);
        f.add(email);
        f.add(age);
        f.add(uname);
        f.add(unameField);
        f.add(btnLogin);
        f.add(pass);
        f.add(pField);
        
        f.add(getContentPane());
        
        
        //button group
        G1.add(customer);
        G1.add(pharma);
        
        f.setSize(500, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String option = G1.getSelection().getActionCommand();
                String age = aField.getText();
                int edad = Integer.parseInt(age);
                if(option.equals("Pharmacist") && edad >= 18){
                    rose.getAccounts().add(new Pharmacist(unameField.getText(),eField.getText(),edad,pField.getText()));
                }else if(option.equals("Customer")){
                    if(edad < 18){
                        JOptionPane.showMessageDialog(null,"Sorry! Underage not allowed to register");
                    }else if(edad >= 18 && edad <= 59){
                        rose.getAccounts().add(new Adult(unameField.getText(),eField.getText(),edad,pField.getText()));
                    }else{
                        rose.getAccounts().add(new SeniorCitizen(unameField.getText(),eField.getText(),edad,pField.getText()));
                    }
                }
//                User newUser = new User(unameField.getText(),eField.getText(),edad,pField.getText());
//                UserLogin u = new UserLogin(newUser);
//                u.setVisible(true);
                  
                  LoginPage l = new LoginPage();
                  l.setVisible(true);
            }
        });
        
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
