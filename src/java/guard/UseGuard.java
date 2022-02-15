/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guard;

import entities.CartItem;
import entities.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositories.UserRepository;
import variables.UserRole;

/**
 *
 * @author kaine
 */
public class UseGuard {

    private HttpServletRequest request;
    private HttpServletResponse response;

    public UseGuard(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public boolean useRole(UserRole role) {

        // Get role from session
        HttpSession session = request.getSession();
        String userRole = (String) session.getAttribute("role");

        // Check user role
        if (userRole == null || userRole.equals(role)) {
            return false;
        }

        return true;
    }

    private ArrayList<CartItem> holdCart() {
        HttpSession session = request.getSession();
        ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<CartItem>();
        }
        return cart;
    }

    public void clearSession() {

        HttpSession session = request.getSession();
        ArrayList<CartItem> cart = this.holdCart();

        session.invalidate();
        session = request.getSession();
        session.setAttribute("cart", cart);
    }

    public boolean useAuth() {
        // Get userId from session
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        ArrayList<CartItem> cart = this.holdCart();

        try {
            // Check userId exist
            if (userId == null) {
                // Clear sessoin and return false
                clearSession();
                return false;
            }

            // Check userId is exist in  database
            UserRepository userRepo = new UserRepository();
            User user = userRepo.getUserByUserId(userId);

            if (user == null) {
                // Clear sessoin and return false
                clearSession();
                return false;
            }

            // Set user if it exist
            request.setAttribute("user", user);
        } catch (Exception e) {
            //Something got error and clear session
            session.invalidate();
            session = request.getSession();
            session.setAttribute("cart", cart);
            return false;
        }

        return true;
    }

}
