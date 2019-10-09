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
public class Pharmacist extends User {

    public Pharmacist() {
    }

    public Pharmacist(String userName, String email, int age, String password) {
        super(userName, email, age, password);
    }

    public void addMedicine(Pharmacy a) {
        System.out.print("Enter brandname: ");
        String bname = input.next();
        System.out.print("Enter generic name: ");
        String gname = input.next();
        System.out.print("Enter price: ");
        String price = input.next();
        System.out.print("Stock: ");
        String stock = input.next();
        System.out.println("1. Cough\n2. Headache\n3. Allergies\n4. BodyPain");
        System.out.print("Choose type of medicine: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                a.getMedicines().add(new Medicine(gname, bname, "Cough",Integer.valueOf(stock), Double.valueOf(price)));
                break;
            case 2:
                a.getMedicines().add(new Medicine(gname, bname, "Headache",Integer.valueOf(stock), Double.valueOf(price)));
                break;
            case 3:
                a.getMedicines().add(new Medicine(gname, bname, "Allergies",Integer.valueOf(stock), Double.valueOf(price)));
                break;
            case 4:
                a.getMedicines().add(new Medicine(gname, bname, "BodyPain",Integer.valueOf(stock), Double.valueOf(price)));
                break;
            default:
                System.out.println("Error choice! Please try again!");
                break;
        }
    }
    
    @Override
    public String toString() {
        return String.format("Username: %s \nEmail: %s \nPassword: %s", super.getUserName(), super.getEmail(), super.getPassword());
    }
}
