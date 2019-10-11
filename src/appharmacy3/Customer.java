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
public class Customer extends User {

    private ArrayList<Medicine> listOfPurchasedMed = new ArrayList();

    ArrayList<Double> price = new ArrayList();
    
    Scanner strInput = new Scanner(System.in);
    Scanner intInput = new Scanner(System.in);
    public int quantity = 0;
    public double amount = 0;

    public Customer() {
    }

    public Customer(Customer e) {
        this(e.getUserName(), e.getEmail(), e.getAge(), e.getPassword());
    }

    public Customer(String userName, String email, int age, String password) {
        super(userName, email, age, password);
    }

    public ArrayList<Medicine> getListOfPurchasedMed() {
        return listOfPurchasedMed;
    }

    public void setListOfPurchasedMed(ArrayList<Medicine> listOfPurchasedMed) {
        this.listOfPurchasedMed = listOfPurchasedMed;
    }

    public void purchasedMedicine(Medicine med, Pharmacy a) {
        System.out.print("Medicine ID: ");
        int bName = intInput.nextInt();
        System.out.print("Quantity: ");
        quantity = intInput.nextInt();
        for (int i = 0; i < a.getMedicines().size(); i++) {
            if (a.getMedicines().get(i).getMedID()== bName ) {
                if (quantity <= a.getMedicines().get(i).getMedStock()) {
                    amount = quantity * a.getMedicines().get(i).getPrice();
                    this.listOfPurchasedMed.add(a.getMedicines().get(i));
                    System.out.println("You added " + a.medicines.get(i).getBrandName() + " to your cart");
                    a.getMedicines().get(i).setMedStock(a.getMedicines().get(i).getMedStock() - quantity);
                }else{
                    System.out.println("Medicine Stock is not enough");
                }
            } 
        }
    }

    public void viewPurchasedMedicine() {
        System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s %15s %5s\n", "Generic name", "|", "Brand Name", "|", "Medicine Type", "|", "Price", "|", "Quantity", "|");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < this.getListOfPurchasedMed().size(); i++) {
            System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s %15s %5s\n", this.getListOfPurchasedMed().get(i).getGenericName(), "|", this.getListOfPurchasedMed().get(i).getBrandName(), "|", this.getListOfPurchasedMed().get(i).getType(), "|", this.getListOfPurchasedMed().get(i).getPrice(), "|", this.quantity, "|");
        }
    }

    public void pay(User c, Pharmacy rose) {
        System.out.print("Enter ordered medicine (brand name): ");
        String choose = strInput.nextLine();
        int count = 0;
        for (int i = 0; i < this.listOfPurchasedMed.size(); i++) {
            if (this.getListOfPurchasedMed().get(i).getBrandName().equals(choose) == true) {
                System.out.print("Enter money: ");
                double cash = intInput.nextDouble();
                if (c instanceof Adult == true) {
                    if (cash == this.getListOfPurchasedMed().get(i).getPrice()) {
                        this.getListOfPurchasedMed().remove(this.getListOfPurchasedMed().get(i));
                        System.out.println("Successfully paid!");

                    } else if (cash > this.getListOfPurchasedMed().get(i).getPrice()) {
                        double cash1 = this.getListOfPurchasedMed().get(i).getPrice();
                        System.out.println("Change is: " + (cash - cash1));
                        this.getListOfPurchasedMed().remove(this.getListOfPurchasedMed().get(i));
                        System.out.println("Successfully paid!");

                    } else {
                        System.out.println("Insufficient cash!");

                    }
                } else {
                    if (cash == this.getListOfPurchasedMed().get(i).getPrice()) {
                        this.getListOfPurchasedMed().remove(this.getListOfPurchasedMed().get(i));
                        System.out.println("Successfully paid!");

                    } else if (cash > this.getListOfPurchasedMed().get(i).getPrice()) {

                        System.out.println("Successfully paid!");
                        System.out.println("Change is: " + (cash - this.getListOfPurchasedMed().get(i).getPrice() * 0.20));
                        this.getListOfPurchasedMed().remove(this.getListOfPurchasedMed().get(i));

                    } else {
                        System.out.println("Insufficient cash!");

                    }
                }
            }
            count++;
        }
        if (count == this.listOfPurchasedMed.size()) {
            System.out.println("No ordered medicine exist!");
        }
    }
}
