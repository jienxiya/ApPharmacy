/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appharmacy2;

/**
 *
 * @author pallerma_sd2022
 */
public class Users {
    private String name;
    private String birthdate;
    private int age;

    public Users() {
    }

    public Users(String name, String birthdate, int age) {
        this.name = name;
        this.birthdate = birthdate;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
}
