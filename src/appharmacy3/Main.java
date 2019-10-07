/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appharmacy3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pallerma_sd2022
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        Scanner input = new Scanner(System.in);
        Pharmacy rose = new Pharmacy("Rose Pharmacy", "Nasipit Branch", new ArrayList<Medicine>(), new ArrayList<User>());
        Medicine b = new Medicine("Paracetamol", "Biogesic", "For Headache", 12);
        User u = new User();
        SeniorCitizen sc = new SeniorCitizen();
        Adult ad = new Adult();
        
        
//        while (true) {
//            System.out.println("---------Sign Up to ApPharmacy---------");
//            u.signUp(u);
//            rose.addUser(u);
//            System.out.println(rose.getAccounts());
//            for (int i = 0; i < rose.getAccounts().size(); i++) {
//                if (rose.getAccounts().get(i) != null) {
////                    System.out.println(rose.getAccounts().get(i));
//                    if (rose.getAccounts().get(i) instanceof Adult || rose.getAccounts().get(i) instanceof SeniorCitizen) {
//                        System.out.println("Press 1 to View Available Medicine \nPress 2 to Purchase Medicine");
//                        int options = input.nextInt();
//                        switch (options) {
//                            case 1:
//                                rose.viewAvailableMedicine();
//                                break;
//                            case 2:
//                                ad.purchasedMedicine(b);
//                        }
//                    }else if(rose.getAccounts().get(i) instanceof Pharmacist){
//                        System.out.println("Press 1 to View Available Medicine \nPress 2 to Add Medicine");
//                        int options = input.nextInt();
//                        switch (options) {
//                            case 1:
//                                rose.viewAvailableMedicine();
//                                break;
//                            case 2:
//                                rose.addMedicine(b);
//                        }
//                    }
//                }
//            }
        }
//    }
}
