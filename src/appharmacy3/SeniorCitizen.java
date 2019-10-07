/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appharmacy3;

/**
 *
 * @author pallerma_sd2022
 */
public class SeniorCitizen extends Customer{

    public SeniorCitizen() {
        
    }
    
    public SeniorCitizen(SeniorCitizen e){
        this(e.getUserName(),e.getEmail(),e.getPassword());
    }
    
    public SeniorCitizen(String userName, String email, String password) {
        super(userName,email,password);
    }
    
//    @Override
//    public void pay() {
//        System.out.println("Input Money: ");
//        double money = input.nextInt();
//        double sum = 0;
//        double discount = 0, pay = 0;
//        for (double a : price) {
//            sum += a;
//            if (money > sum) {
//
//                discount = sum * 0.20;
//                pay = money - discount;
//
//            } else {
//                System.out.println("Your Money is not enough to pay");
//                System.exit(1);
//            }
//        }
//        System.out.println("Money: " + money);
//        System.out.println("Bill: " + (sum - discount));
//        System.out.println("Discount: 20%");
//        System.out.println("Change: " + (money - (sum - discount)));
//    }

   @Override
    public String toString(){
        return String.format("Username: %s \nEmail: %s \nPassword: %s", super.getUserName(),super.getEmail(),super.getPassword());
    }
}
