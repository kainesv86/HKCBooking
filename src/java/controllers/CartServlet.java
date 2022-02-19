/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.CartItem;
import entities.History;
import entities.User;
import helper.GetVariable;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositories.HistoryRepository;
import repositories.UserRepository;
import variables.Routers;

@WebServlet(name = "CartServlet", urlPatterns = {"/" + Routers.CART_SERVLET})
public class CartServlet extends HttpServlet {

    protected boolean handleOnGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        Integer userId = (Integer) session.getAttribute("userId");

        if (userId != null) {
            UserRepository userRepo = new UserRepository();
            try {
                User user = userRepo.getUserByUserId(userId);
                session.setAttribute("user", user);
            } catch (Exception ex) {
                return false;
            }

        }

        ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<CartItem>();
        }

        request.setAttribute("cart", cart);
        return true;
    }

    protected boolean handleOnPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        GetVariable gv = new GetVariable(request);

        Integer index = gv.getInt("index", "Index", 0, Integer.MAX_VALUE, null);
        String fullname = gv.getString("fullname", "FullName", 1, 50, null);
        String phone = gv.getString("phone", "Phone", 9, 11, null);
        String address = gv.getString("address", "Address", 5, 100, null);

        if (index == null) {
            return false;
        }

        HttpSession session = request.getSession();

        ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<CartItem>();
            return false;
        }

        CartItem cartItem = cart.get(index);

        Integer userId = (Integer) session.getAttribute("userId");
        String message = "";
        String historyStatus = "PENDING";
        Integer roomId = cartItem.getRoom().getRoomId();
        Date startDate = (Date) cartItem.getStartDate();
        Date endDate = (Date) cartItem.getEndDate();
        String note = "";
        Float total = cartItem.getTotal();

        cart.remove(cartItem);
        session.setAttribute("cart", cart);

        History history = new History(userId, userId, message, historyStatus, fullname, phone, address, roomId, startDate, endDate, note, total);
        HistoryRepository historyRepo = new HistoryRepository();
        return historyRepo.addHistory(history);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (handleOnGet(request, response)) {
            request.getRequestDispatcher(Routers.CART_PAGE).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (!handleOnPost(request, response)) {
                request.getRequestDispatcher(Routers.ERROR_404_PAGE).forward(request, response);
                return;
            };
            HttpSession session = request.getSession();

            ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");

            request.setAttribute("cart", cart);

            request.getRequestDispatcher(Routers.CART_PAGE).forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher(Routers.ERROR_404_PAGE).forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
