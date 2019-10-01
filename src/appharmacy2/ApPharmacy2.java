/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appharmacy2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pallerma_sd2022
 */
public class ApPharmacy2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //initialization
        Scanner input = new Scanner(System.in);
        Pharmacist jana = new Pharmacist("jane","December 29, 1999", 19, new ArrayList<Medicine>());
        Adult maria = new Adult("Maria","December 29, 1999", 30);
        SeniorCitizen juana = new SeniorCitizen("Juana","December 29, 1999", 80);
        Medicine biogesic = new Medicine("Paracetamol", "Biogesic", 10);
        Medicine solmux = new Medicine ("Carbocisteine", "Solmux", 12);
        Medicine mefenamic = new Medicine("Mefenamic Acid","Biomef",5);
        Medicine citirizine = new Medicine ("Citirizine", "Irizine 10", 5);
        Medicine alaxan = new Medicine ("Ibufrofen + Paracetamol", "Alaxan FR", 10);
        
        

        //Pharmacist
//        jana.login();
//        System.out.println("Press 1 to add medicine");
//        System.out.println("Press 2 to view available medicines");
//        System.out.println("Press 3 to remove medicines");
//        System.out.println("Press 4 to logout");
//        while (true) {
//            int option = input.nextInt();
//            switch (option) {
//                case 1:
//                    jana.addMedicine(biogesic);
//                    jana.addMedicine(solmux);   
//                    jana.addMedicine(alaxan);
//                    jana.addMedicine(citirizine);
//                    jana.addMedicine(mefenamic);
//                    break;
//                case 2:
//                    jana.viewAvailableMedicine();
//                    break;
//                case 3:
//                    jana.removeMedicine(solmux);
//                    break;
//                case 4:
//                    jana.logout();
//                    return;
//                default:
//                    System.out.println("Invalid Input");
//            }
//
//        }
//        //Adult
//        maria.login(); 
//        System.out.println("Press 1 to Purchase Medicine");
//        System.out.println("Press 2 to View Purchase Medicine");
//        System.out.println("Press 3 to Pay");
//        System.out.println("Press 4 to log out");
//
//        while (true) {
//            int option = input.nextInt();
//            switch (option) {
//                case 1:
//                    maria.purchasedMedicine(biogesic);
//                    maria.purchasedMedicine(solmux);
//                    break;
//                case 2:
//                    maria.viewPurchasedMedicine();
//                    break;
//                case 3:
//                    maria.pay();
//                    break;
//                case 4:
//                    maria.logout();
//                    return;
//                default:
//                    System.out.println("Invalid Input");
//            }
////            break;
//        }
        //SeniorCitizen
        String categ;
        Scanner input1 = new Scanner(System.in);
        juana.login();
        System.out.println("Press 0 to Purchase Medicine");
        System.out.println("Press 1 to Purchase Medicine");
        System.out.println("Press 2 to View Purchase Medicine");
        System.out.println("Press 3 to Pay");
        System.out.println("Press 4 to logout");
        while (true) {
            int option = input.nextInt();
            switch (option) {
                case 0:
                    jana.viewAvailableMedicine();
                case 1:
                    juana.purchasedMedicine(biogesic);
                    juana.purchasedMedicine(solmux);
                    juana.purchasedMedicine(mefenamic);
                    break;
                case 2:
                    juana.viewPurchasedMedicine();
                    break;
                case 3:
                    juana.pay();
                    break;
                case 4:
                    juana.logout();
                    return;
                default:
                    System.out.println("Invalid Input");

            }

        }

    }
}
