package appharmacy3;

import java.util.Scanner;
import static javafx.application.Platform.exit;

public class User implements Login {

    Scanner strInput = new Scanner(System.in);
    Scanner intInput = new Scanner(System.in);

    private String userName;
    private String email;
    private int age;
    private String password;

    public User() {
    }

    public User(String userName, String email, int age, String password) {
        this.userName = userName;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void signUp(Pharmacy a) {
        String uName, uEmail, pass;
        int edad;
        System.out.println("Sign up as :");
        System.out.println("Press 1 if Pharmacist\nPress 2 if Customer");
        int option = intInput.nextInt();
        if (option == 1) {
            System.out.print("Username: ");
            uName = strInput.nextLine();
            System.out.print("Email: ");
            uEmail = strInput.nextLine();
            System.out.print("Age: ");
            edad = intInput.nextInt();
            System.out.print("Password: ");
            pass = strInput.nextLine();
            if (edad >= 18) {
                Pharmacist e = new Pharmacist(uName, uEmail, edad, pass);
                a.getAccounts().add(e);
                System.out.println("Registered!");
            } else {
                System.out.println("You're not allowed to sigup");
            }
        } else if (option == 2) {
            System.out.print("Username: ");
            uName = strInput.nextLine();
            System.out.print("Email: ");
            uEmail = strInput.nextLine();
            System.out.print("Age: ");
            edad = intInput.nextInt();
            System.out.print("Password: ");
            pass = strInput.nextLine();
            if (edad >= 18 && edad <= 59) {
                Adult e = new Adult(uName, uEmail, edad, pass);
                a.getAccounts().add(e);
            } else if (edad >= 60) {
                SeniorCitizen e = new SeniorCitizen(uName, uEmail, edad, pass);
                a.getAccounts().add(e);
            }else{
                System.out.println("You're not Adult nor Senior Citizen");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Username: %s\nEmail: %s\nPassword: %s", this.userName, this.email, this.password);
    }

    @Override
    public User login(User e, Pharmacy a) {
        User b = new User();
        int count = 0;
        System.out.print("Enter email: ");
        String uEmail = strInput.nextLine();
        for (int i = 0; i < a.getAccounts().size(); i++) {
            if (uEmail.equals(a.getAccounts().get(i).getEmail()) == true) {
                System.out.print("Enter password: ");
                String pass = strInput.nextLine();
                if (pass.equals(a.getAccounts().get(i).getPassword()) == true) {
                    b = a.getAccounts().get(i);
                    return b;
                }
            }
            count++;
        }
        if (a.getMj().getEmail().equals(uEmail) == true) {
            System.out.print("Enter password: ");
            String pass = strInput.nextLine();
            if (a.getMj().getPassword().equals(pass) == true) {
                b = a.getMj();
                return b;
            }
        }

        if (count == a.getAccounts().size()) {
            System.out.println("Error! Account doesn't exist!");
        }
        return b;
    }

    @Override
    public void logout() {
        System.out.println("-----------------------------Thankyou-----------------------------");
        exit();
    }
}
