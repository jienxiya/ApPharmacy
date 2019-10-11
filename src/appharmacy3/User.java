package appharmacy3;

import java.util.Scanner;
import static javafx.application.Platform.exit;

public class User implements Login {

    Scanner input = new Scanner(System.in);

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
        Scanner input = new Scanner(System.in);
        String uName, email, pass;
        int age;
        System.out.println("Log in as :");
        System.out.println("Press 1 if Pharmacist\nPress 2 if Adult\nPress 3 if SeniorCitizen");
        int option = input.nextInt();
        if (option == 1) {
            Pharmacist e = new Pharmacist();
            System.out.print("Username: ");
            uName = input.next();
            System.out.print("Email: ");
            email = input.next();
            System.out.print("Age: ");
            age = input.nextInt();
            System.out.print("Password: ");
            pass = input.next();
            e = new Pharmacist(uName, email, age, pass);
            a.getAccounts().add(e);
            System.out.println("Registered!");

        } else if (option == 2) {
            Adult e = new Adult();
            System.out.print("Username: ");
            uName = input.next();
            System.out.print("Email: ");
            email = input.next();
            System.out.print("Age: ");
            age = input.nextInt();
            System.out.print("Password: ");
            pass = input.next();
            e = new Adult(uName, email, age, pass);
            a.getAccounts().add(e);
        } else if (option == 3) {
            SeniorCitizen e = new SeniorCitizen();
            System.out.print("Username: ");
            uName = input.next();
            System.out.print("Email: ");
            email = input.next();
            System.out.print("Age: ");
            age = input.nextInt();
            System.out.print("Password: ");
            pass = input.next();
            e = new SeniorCitizen(uName, email, age, pass);
            a.getAccounts().add(e);
        } else {
            System.out.println("Sorry! Wrong input!");
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
        String email = input.nextLine();
        for (int i = 0; i < a.getAccounts().size(); i++) {
            if (email.equals(a.getAccounts().get(i).getEmail()) == true) {
                System.out.print("Enter password: ");
                String pass = input.nextLine();
                if (pass.equals(a.getAccounts().get(i).getPassword()) == true) {
                    b = a.getAccounts().get(i);
                    return b;
                }
            }
            count++;
        }
        if (a.getMj().getEmail().equals(email) == true) {
            System.out.print("Enter password: ");
            String pass = input.nextLine();
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
