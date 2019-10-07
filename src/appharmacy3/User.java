package appharmacy3;

import java.util.Scanner;

public class User implements Login {

    private String userName;
    private String email;
    private String password;

    public User() {
    }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    Scanner intInput = new Scanner(System.in);
    Scanner stringInput = new Scanner(System.in);
    Pharmacy rose = new Pharmacy();

//    uli nata guys ta :(
//    @Override
//    @Override
//    public User signUp(User e) {
//        System.out.println("Log in as :");
//        System.out.println("Press 1 if Adult\nPress 2 if SeniorCitizen\nPress 3 if Pharmacist");
//        int option = intInput.nextInt();
//        if (option == 1) {
//            e = new Adult();
//            System.out.print("Username: ");
//            String uName = stringInput.nextLine();
//            System.out.print("Email: ");
//            String email = stringInput.nextLine();
//            System.out.print("Password: ");
//            String pass = stringInput.nextLine();
//            
//            e.setUserName(uName);
//            e.setEmail(email);
//            e.setPassword(pass);
//        } else if (option == 2) {
//            System.out.print("Username: ");
//            this.userName = stringInput.nextLine();
//            System.out.print("Email: ");
//            this.email = stringInput.nextLine();
//            System.out.print("Password: ");
//            this.password = stringInput.nextLine();
//            e = new SeniorCitizen();
//            e.setUserName(userName);
//            e.setEmail(email);
//            e.setPassword(password);
//        } else {
//            System.out.print("Username: ");
//            this.userName = stringInput.nextLine();
//            System.out.print("Email: ");
//            this.email = stringInput.nextLine();
//            System.out.print("Password: ");
//            this.password = stringInput.nextLine();
//            e = new Pharmacist();
//            e.setUserName(userName);
//            e.setEmail(email);
//            e.setPassword(password);
//        }
//        return e;
//    }
    
    @Override
    public User login(User e, Pharmacy a) {
        System.out.println("--------------Log In to ApPharmacy--------------");
        System.out.println("Email: ");
        String email = stringInput.nextLine();
        System.out.println("Password: ");
        String pass = stringInput.nextLine();
        for (int i = 0; i < a.getAccounts().size(); i++) {
            if (e.getEmail().equals(email) && e.getPassword().equals(pass)) {
                System.out.println("--------------Log In to ApPharmacy--------------");
            }
        }
        
        
        return e;
    }

//
//    @Override
//    public void logout() {
//
//    }
    
    @Override
    public String toString(){
        return String.format("Username: %s\nEmail: %s\nPassword: %s", this.userName,this.email,this.password);
    }
}
