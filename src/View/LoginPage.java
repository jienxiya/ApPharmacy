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
public class LoginPage extends JFrame {

    JFrame frame2 = new JFrame("ApPharmacy");
    Boolean flag = false;

    public LoginPage() {
        Pharmacy rose = new Pharmacy();
        rose.addAccounts(rose);

//        JFrame frame2 = new JFrame("ApPharmacy");
        JOptionPane optionPane = new JOptionPane();

        JLabel label1 = new JLabel("Login", JLabel.CENTER);
        label1.setBounds(120, 10, 220, 20);
        label1.setFont(new Font("Serif", Font.BOLD, 20));

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
        frame2.add(label1);
        frame2.add(eField);
        frame2.add(email);
        frame2.add(btnLogin);
        frame2.add(pass);
        frame2.add(pField);

//        frame2.add(getContentPane());
        frame2.setSize(500, 400);
        frame2.setLayout(null);
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame2.setLocation(dim.width/3-this.getSize().width/3, dim.height/3-this.getSize().height/3);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                flag = true;
                String email = eField.getText();
                String pass = pField.getText();
                User newUser = null;
                for (int i = 0; i < rose.getAccounts().size(); i++) {
                    if (email.equals(rose.getAccounts().get(i).getEmail()) && pass.equals(rose.getAccounts().get(i).getPassword())) {
                        newUser = rose.getAccounts().get(i);
                    }
                }
                if(newUser != null){
                    UserLogin u = new UserLogin(newUser); 
                    frame2.dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"Email or Password is incorrect!");
                }  
            }
        });
    }
}