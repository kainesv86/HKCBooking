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
import java.io.PrintWriter;
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
import javax.websocket.Session;
import repositories.HistoryRepository;
import repositories.UserRepository;

/**
 *
 * @author Kaine
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected boolean processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        GetVariable gv = new GetVariable(request);

        Integer index = gv.getInt("index", "Index", 0, Integer.MAX_VALUE, null);
        String fullname = gv.getString("fullname", "FullName", 1, 50, null);
        String phone = gv.getString("phone", "Phone", 9, 11, null);
        String address = gv.getString("address", "Address", 5, 100, null);

        System.out.println("Index: " + index);

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
        historyRepo.addHistory(history);

        return true;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        Integer userId = (Integer) session.getAttribute("userId");

        if (userId != null) {
            UserRepository userRepo = new UserRepository();
            try {
                User user = userRepo.getUserByUserId(userId);
                session.setAttribute("user", user);
            } catch (Exception ex) {
                Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<CartItem>();
        }

        request.setAttribute("cart", cart);

        request.getRequestDispatcher("WEB-INF/JSP/cart.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        HttpSession session = request.getSession();

        ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");

        System.out.println("Cart Size: " + cart.size());

        request.setAttribute("cart", cart);

        request.getRequestDispatcher("WEB-INF/JSP/cart.jsp").forward(request, response);
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
