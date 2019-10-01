/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appharmacy2;

import java.util.ArrayList;
import java.util.Scanner;
import static javafx.application.Platform.exit;

/**
 *
 * @author pallerma_sd2022
 */
public abstract class Customer extends Users implements Login {


    public Customer() {
    }

    public Customer(String name, String birthdate, int age) {
        super(name, birthdate, age);
    }

//    public void viewAvailableMedicines() {
//        Pharmacist p = new Pharmacist();
//        ArrayList<Medicine> availableMeds = p.getListOfMedicine();
//        System.out.println(availableMeds);
//    }

    public String askQuestion(String question) {
        System.out.println(question);
        return question;
    }

    public abstract void viewPurchasedMedicine();

    public abstract void purchasedMedicine(Medicine med);

    public abstract void pay();
 
    Scanner input = new Scanner(System.in);
    @Override
    public void login() {
        System.out.println("Log In As Customer");
        System.out.print("Name: ");
        String name = input.next();
        System.out.print("Birthdate: ");
        String bdate = input.next();
        System.out.print("Age: ");
        int age = input.nextInt();
        if (age < 18) {
            System.out.println("Sorry, You cannot Log in.");
            exit();
        } else if (age >= 18) {
            System.out.println("Successfully Log in");
            System.out.println("-------------Welcome to ApPharmacy!----------------");
        }
    }
    
    @Override
    public void logout() {
        System.out.println("-------------------Thank you for visiting out pharmacy. Come Again! :)------------------------");
        exit();
    }
    
    //    @Override
//    public String toString(){
//        return String.format("Name: %s /nPurchased Medicine: %s", name, listOfPurchasedMedecine);
//    }

}
