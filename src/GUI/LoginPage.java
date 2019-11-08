/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import appharmacy3.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author pallerma_sd2022
 */
public class LoginPage extends JFrame implements ActionListener {

    public LoginPage() {
        Pharmacy rose = new Pharmacy();
        rose.addAccounts(rose);
        rose.getAccounts();
        
        JFrame f = new JFrame("ApPharmacy");

        JLabel label1 = new JLabel("Login", JLabel.CENTER);
        label1.setBounds(120, 10, 220, 20);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(170, 150, 120, 40);

        //enter email label
        JLabel email = new JLabel("Email: \t");
        email.setBounds(60, 10, 100, 100);

        //enter password label
        JLabel pass = new JLabel("Password: \t");
        pass.setBounds(60, 60, 100, 100);

        //textfield to enter email
        JTextField eField = new JTextField();
        eField.setBounds(140, 50, 200, 30);

        //textfield to enter password
        JPasswordField pField = new JPasswordField();
        pField.setBounds(140, 100, 200, 30);

        //add to frame
        f.add(label1);
        f.add(eField);
        f.add(email);
        f.add(btnLogin);
        f.add(pass);
        f.add(pField);
        
        f.add(getContentPane());

        f.setSize(500, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = eField.getText();
                String pass = pField.getText();
                for(int i = 0; i < rose.getAccounts().size(); i++){
                    if(email.equals(rose.getAccounts().get(i).getEmail()) && pass.equals(rose.getAccounts().get(i).getPassword())){    
                        User newUser = rose.getAccounts().get(i);
                        UserLogin u = new UserLogin(newUser);
                        u.setVisible(true);
                    }else{
//                        JOptionPane.showMessageDialog(null, "Email or Password is incorrect");
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
