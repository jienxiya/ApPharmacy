/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.Customer_Transaction;
import Controller.Pharmacist_Transaction;
import Model.customerBehavior;
import Model.accountCRUD;
import Model.pharmacistBehavior;
import View.Pharmacy;

/**
 *
 * @author pallerma_sd2022
 */
public class Main {

    public static void main(String[] args) {

//        Model
        accountCRUD accManagement = new accountCRUD();
        customerBehavior cb = new customerBehavior();
        pharmacistBehavior pb = new pharmacistBehavior();

//        Controller
        Customer_Transaction cm = new Customer_Transaction();
        Pharmacist_Transaction pt = new Pharmacist_Transaction();

//        view
//        Botica botica = new Botica();
//        Register reg = new Register();
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setVisible(true);
        
         

    }
}
