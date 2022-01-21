/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import guard.UseGuard;
import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

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
        boolean check = true;
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cfpassword = request.getParameter("cfpassword");
//        System.out.println(username + " " + password);
//        request.setAttribute("info", username + password);
        String username_err = "", email_err = "", pwd_err = "", cfpwd_err = "";
        if (username.equals("")) {
            username_err = "Can not be plank!";
        }
        if (username_err.length() > 0) {
            request.setAttribute("username_err", username_err);
            check = false;
        }
        if (email.equals("")) {
            email_err = "Can not be plank!";
        }
        if (email_err.length() > 0) {
            request.setAttribute("email_err", email_err);
            check = false;
        }
        if (password.equals("")) {
            pwd_err = "Can  not be plank!";
        }
        if (pwd_err.length() > 0) {
            request.setAttribute("pwd_err", pwd_err);
            check = false;
        }
        if (cfpassword.equals("") || !cfpassword.equals(password)) {
            cfpwd_err = "Confirm password is not valid!";
        }
//        if (cfpassword.equals(check))
        if (cfpwd_err.length() > 0) {
            request.setAttribute("cfpwd_err", cfpwd_err);
            check = false;
        }
        return check;

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

        if (useGuard.useAuth()) {
            response.sendRedirect("IndexServlet");
            return;
        }

        request.getRequestDispatcher("WEB-INF/JSP/register.jsp").forward(request, response);
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
            response.sendRedirect("LoginServlet");
            return;
        }
        request.getRequestDispatcher("WEB-INF/JSP/register.jsp").forward(request, response);
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
