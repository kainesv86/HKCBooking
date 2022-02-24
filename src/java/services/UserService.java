/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

public class UserService {

    public static boolean isValidPhone(String inputPhone) {
        if (!inputPhone.matches("^0[1-9][0-9]{8}$")) {
            return false;
        }

        return true;
    }

    public static boolean isValidEmail(String inputEmail) {
        if (!inputEmail.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            return false;
        }
        return true;
    }
}
