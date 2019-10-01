/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appharmacy2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static javafx.application.Platform.exit;

/**
 *
 * @author pallerma_sd2022
 */
public class SeniorCitizen extends Customer {
    private List<Medicine> addCart = new ArrayList<Medicine>();

    public SeniorCitizen() {
    }

    public SeniorCitizen(String name, String birthdate, int age) {
        super(name, birthdate, age);
    }

    ArrayList<Float> price = new ArrayList();

    @Override
    public void purchasedMedicine(Medicine med) {
//        Scanner s = new Scanner(System.in);
//        med = s.next();
        addCart.add(med);
        System.out.println("You added " + med.getBrandName() + " to your cart");
        float p = med.getPrice();
        price.add(p);
    }

    @Override
    public void viewPurchasedMedicine() {
        System.out.println("Medicines you added in your cart: \n" + addCart);
    }

    Scanner input = new Scanner(System.in);

    @Override
    public void pay() {
        System.out.println("Input Money: ");
        float money = input.nextInt();
        float sum = 0;
        double discount = 0, pay = 0;
        for (float a : price) {
            sum += a;
            if (money > sum) {

                discount = sum * 0.20;
                pay = money - discount;

            } else {
                System.out.println("Your Money is not enough to pay");
                System.exit(1);
            }
        }
        System.out.println("Money: " + money);
        System.out.println("Bill: " + (sum - discount));
        System.out.println("Discount: 20%");
        System.out.println("Change: " + (money - (sum - discount)));
    }
}
