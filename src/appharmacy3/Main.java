/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appharmacy3;

import java.util.Scanner;
import static javafx.application.Platform.exit;

/**
 *
 * @author pallerma_sd2022
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Pharmacy rose = new Pharmacy();
        Medicine b = new Medicine();
        User u = new User();
        Customer c = new Customer();
        SeniorCitizen sc = new SeniorCitizen();
        Adult ad = new Adult();

        //Populate Account
        rose.addAccounts(rose);

        //Populate Medicine
        rose.addMedicine(rose);

        System.out.println("---------Sign Up to ApPharmacy---------");
        System.out.println("Press 1 to Login\nPress 2 to Register");
        int choice = input.nextInt();
        while (true) {
            if (choice == 1) {
                User a = u.login(u, rose);
//            while (true) {
                if (a == rose.getMj() || a instanceof Pharmacist) {
                    System.out.println("---------Logged in as Pharmacist---------");
                    while (true) {                       
                        System.out.println("Press 1 to add medicine\nPress 2 to view medicines\nPress 3 to Remove medicine\nPress 4 to Update Medicine Info\nPress 5 to Logout");
                        int option = input.nextInt();
                        switch (option) {
                            case 1:
                                rose.getMj().addMedicine(rose);
                                break;
                            case 2:
                                rose.viewAvailableMedicine();
                                break;
                            case 3:
                                rose.removeMedicine(b);
                                break;
                            case 4:
                                rose.updateMedicine();
                                break;
                            case 5:
                                a.logout();
                                break;
                        }
                    }
                } else if (a instanceof Adult) {
                    System.out.println("---------Logged in as Adult---------");
                    while (true) {                      
                        System.out.println("Press 1 to view medicines\nPress 2 to purchased medicine\nPress 3 to view purchases medicine\nPress 4 to pay\nPress 5 to Logout");
                        int option = input.nextInt();
                        switch (option) {
                            case 1:
                                rose.viewAvailableMedicine();
                                break;
                            case 2:
                                c.purchasedMedicine(b, rose);
                                break;
                            case 3:
                                c.viewPurchasedMedicine();
                                break;
                            case 4:
                                c.pay(a, rose);
                                break;
                            case 5:
                                a.logout();
                                break;
                        }
                    }
                } else if (a instanceof SeniorCitizen) {
                    System.out.println("---------Logged in as Senior Citizen---------");
                    while (true) {                       
                        System.out.println("Press 1 to view medicines\nPress 2 to purchased medicine\nPress 3 to view purchases medicine\nPress 4 to pay\nPress 5 to Logout");
                        int option = input.nextInt();
                        switch (option) {
                            case 1:
                                rose.viewAvailableMedicine();
                                break;
                            case 2:
                                c.purchasedMedicine(b, rose);
                                break;
                            case 3:
                                c.viewPurchasedMedicine();
                                break;
                            case 4:
                                c.pay(a, rose);
                                break;
                            case 5:
                                a.logout();
                                break;
                        }
                    }
                }
            } else if (choice == 2) {
                u.signUp(rose);
            } else {
                System.out.println("Invalid Input!");
            }
        }
    }
}
