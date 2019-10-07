/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appharmacy3;

import java.util.ArrayList;
import java.util.Scanner;
import static javafx.application.Platform.exit;

/**
 *
 * @author pallerma_sd2022
 */
public class Adult extends Customer{
    
    private ArrayList<Medicine> listOfPurchasedMed = new ArrayList<Medicine>();
    
    public Adult() {
        
    }

    public Adult(Adult e){
        this(e.getUserName(),e.getEmail(),e.getPassword());
    }
    
    public Adult(String userName, String email, String password) {
        super(userName, email, password);
       
    }

    public ArrayList<Medicine> getListOfPurchasedMed() {
        return listOfPurchasedMed;
    }

    public void setListOfPurchasedMed(ArrayList<Medicine> listOfPurchasedMed) {
        this.listOfPurchasedMed = listOfPurchasedMed;
    }
    
     ArrayList<Double> price = new ArrayList();
    Scanner input = new Scanner(System.in);

    public void purchasedMedicine(Medicine med) {
        System.out.println("You added " + med.getBrandName() + " to your cart");
        listOfPurchasedMed.add(med);
        double p = med.getPrice();
        price.add(p);
    }

    public void viewPurchasedMedicine() {
        System.out.println("Medicines you added in your cart: \n" + listOfPurchasedMed);
    }

    public void pay() {
        System.out.println("Input Money: ");
        double money = input.nextInt();
        double sum = 0;
        for (double a : price) {
            sum += a;
            if (money > sum) {
                double pay = money - sum;

            } else {
                System.out.println("Your Money is not enough to pay");
                exit();
            }
        }
        System.out.println("Money: " + money);
        System.out.println("Bill: " + sum);
        System.out.println("Change: " + (money - sum));
    }

    
    @Override
    public String toString(){
        return String.format("Username: %s \nEmail: %s \nPassword: %s", super.getUserName(),super.getEmail(),super.getPassword());
    }
    
}
