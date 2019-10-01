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
public class Pharmacist extends Users implements Login {

    private ArrayList<Medicine> listOfMedicine;

    public Pharmacist() {
    }

    public Pharmacist(String name, String birthdate, int age) {
        super(name, birthdate, age);
    }

    public Pharmacist(String name, String birthdate, int age, ArrayList<Medicine> listOfMedicine) {
        super(name, birthdate, age);
        this.listOfMedicine = listOfMedicine;
    }
  
    
    

    public ArrayList<Medicine> getListOfMedicine() {
        return listOfMedicine;
    }

    public void setListOfMedicine(ArrayList<Medicine> listOfMedicine) {
        this.listOfMedicine = listOfMedicine;
    }

    public void addMedicine(Medicine med) {
        listOfMedicine.add(med);
        System.out.println( med.getBrandName()+" Successfully Added");
//        for (int i = 0; i < listOfMedicine.size() - 1; i++) {
//            listOfMedicine.add(med);
//                System.out.println(med.getBrandName() + " Successfully Added"); 
//            if (med == listOfMedicine.get(i)) {
//                System.out.println(med.getBrandName() + " is already added.");
//                break;
//            } else {
//                listOfMedicine.add(med);
//                System.out.println(med.getBrandName() + " Successfully Added");
//            }
//
//        }
    }
    public void removeMedicine(Medicine med){
        listOfMedicine.remove(med);
         System.out.println(med.getBrandName()+ " is removed from the list of Medicine.");
    }
    
    

    public void viewAvailableMedicine() {
        System.out.println("Available Medicines in the pharmacy: \n"+listOfMedicine);
    }

    Scanner input = new Scanner(System.in);

    @Override
    public void login() {
        System.out.println("Log In As Pharmacist");
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

//    public void validateCustomerIdentity(Customer c){
//        if(c instanceof Adult){
//            
//        }
//    }
}
