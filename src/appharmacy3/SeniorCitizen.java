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
        this(e.getUserName(),e.getEmail(),e.getAge(),e.getPassword());
    }
    
    public SeniorCitizen(String userName, String email,int age, String password) {
        super(userName,email,age,password);
    }
    

   @Override
    public String toString(){
        return String.format("Username: %s \nEmail: %s \nPassword: %s", super.getUserName(),super.getEmail(),super.getPassword());
    }
}
