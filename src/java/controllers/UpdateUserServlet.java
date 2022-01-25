/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.User;
import guard.UseGuard;
import helper.GetVariable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositories.UserRepository;

/**
 *
 * @author DELL
 */
@WebServlet(name = "UpdateUserServlet", urlPatterns = {"/UpdateUserServlet"})
public class UpdateUserServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        GetVariable gv = new GetVariable(request);
        try {
            String fullname = gv.getString("fullname", "Fullname", 1, 30, null);
            String address = gv.getString("address", "Address", 1, 30, null);
            String phone = gv.getString("phone", "Phone", 1, 30, null);
            String email = gv.getString("email", "Email", 1, 30, "");
            UserRepository ad = new UserRepository();
            User u = ad.getUserByUserId(userId);
            if (fullname != null && address != null && phone != null) {
                u.setFullname(fullname);
                u.setAddress(address);
                u.setPhone(phone);
                u.setEmail(email);
                if (ad.updateInforUser(u)) {
                    session.setAttribute("fullname", fullname);
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
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
        UseGuard useGuard = new UseGuard(request, response);

        if (!useGuard.useAuth()) {
            response.sendRedirect("LoginServlet");
            return;
        }
//        if (useGuard.useAuth()) {
//            response.sendRedirect("IndexServlet");
//            return;
//        }
        request.getRequestDispatcher("/WEB-INF/JSP/userdetails.jsp").forward(request, response);
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
        if (processRequest(request, response)) {
            request.getRequestDispatcher("WEB-INF/JSP/index.jsp").forward(request, response);
            return;
        }
        response.sendRedirect("UpdateUserServlet");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
