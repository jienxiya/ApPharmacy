/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appharmacy3;

import java.util.Scanner;

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
        rose.populateMedicine(rose);

        System.out.println("---------Sign Up to ApPharmacy---------");

        while (true) {
            System.out.println("Press 1 to Login\nPress 2 to Register");
            int choice = input.nextInt();
            if (choice == 1) {
                User a = u.login(u, rose);
//            while (true) {
                if (a == rose.getMj() || a instanceof Pharmacist) {
                    System.out.println("---------Logged in as Pharmacist---------");
                    while (true) {
                        System.out.println("Press 1 to add medicine\nPress 2 to view medicines\nPress 3 to Remove medicine\nPress 4 to Update Medicine Stock\nPress 5 to Logout");
                        int option = input.nextInt();
                        if (option == 1) {
                            rose.addMedicine(b,rose);
                        } else if (option == 2) {
                            rose.viewAvailableMedicine();
                        } else if (option == 3) {
                            rose.removeMedicine(b);
                        } else if (option == 4) {
                            rose.updateMedicineStock(b);
                        } else {
                            a.logout();
                            break;
                        }
                    }
                } else if (a instanceof Adult) {
                    System.out.println("---------Logged in as Adult---------");
                    while (true) {
                        System.out.println("Press 1 to view medicines\nPress 2 to purchase medicine\nPress 3 to view purchases medicine\nPress 4 to pay\nPress 5 to Logout");
                        int option = input.nextInt();
                        if (option == 1) {
                            rose.viewAvailableMedicine();
                        } else if (option == 2) {
                            c.purchasedMedicine(b, rose);
                        } else if (option == 3) {
                            c.viewPurchasedMedicine();
                        } else if (option == 4) {
                            c.pay(a, rose);
                        } else {
                            a.logout();
                            break;
                        }
                    }
                } else if (a instanceof SeniorCitizen) {
                    System.out.println("---------Logged in as Senior Citizen---------");
                    while (true) {
                        System.out.println("Press 1 to view medicines\nPress 2 to purchase medicine\nPress 3 to view purchases medicine\nPress 4 to pay\nPress 5 to Logout");
                        int option = input.nextInt();
                        if (option == 1) {
                            rose.viewAvailableMedicine();
                        } else if (option == 2) {
                            c.purchasedMedicine(b, rose);
                        } else if (option == 3) {
                            c.viewPurchasedMedicine();
                        } else if (option == 4) {
                            c.pay(a, rose);
                        } else {
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
