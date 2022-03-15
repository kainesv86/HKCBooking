/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.CartItem;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Kaine
 */
public class CartService {

    public static boolean isValidDateBooking(ArrayList<CartItem> cartItems, Date inputCheckIn, Date inputCheckOut) {
        for (CartItem cartItem : cartItems) {

            if (cartItem.getCheckIn().equals(inputCheckIn) || cartItem.getCheckOut().equals(inputCheckIn)) {
                return false;
            }

            if (cartItem.getCheckIn().equals(inputCheckOut) || cartItem.getCheckOut().equals(inputCheckOut)) {
                return false;
            }

            if (inputCheckIn.after(cartItem.getCheckIn()) && (inputCheckIn.before(cartItem.getCheckOut()))) {
                return false;
            }

            if (inputCheckOut.after(cartItem.getCheckIn()) && (inputCheckOut.before(cartItem.getCheckOut()))) {
                return false;
            }

            if (cartItem.getCheckIn().after(inputCheckIn) && (cartItem.getCheckOut().before(inputCheckOut))) {
                return false;
            }

            if ((cartItem.getCheckIn().after(inputCheckOut)) && (cartItem.getCheckOut().before(inputCheckOut))) {
                return false;
            }
        }
        return true;
    }
}
