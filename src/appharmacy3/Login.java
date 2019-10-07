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
public interface Login {
    public User login(User e, Pharmacy a);
//    public void logout();
    public User signUp(User e);
}
