/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.User;
import guard.UseGuard;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.UserRepository;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    private UserRepository ur = new UserRepository();

    protected boolean processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean check = true;
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cfpassword = request.getParameter("cfpassword");
        
        String username_err = "", email_err = "", pwd_err = "", cfpwd_err = "";
        if (username.equals("")) {
            username_err = "Can not be plank!";
        }
        if (username_err.length() > 0) {
            request.setAttribute("username_err", username_err);
            check = false;
            return check;
        }
        if (email.equals("")) {
            email_err = "Can not be plank!";
        }
        if (email_err.length() > 0) {
            request.setAttribute("email_err", email_err);
            check = false;
            return check;
        }
        if (password.equals("")) {
            pwd_err = "Can  not be plank!";
        }
        if (pwd_err.length() > 0) {
            request.setAttribute("pwd_err", pwd_err);
            check = false;
            return check;
        }
        if (cfpassword.equals("") || !cfpassword.equals(password)) {
            cfpwd_err = "Confirm password is not valid!";
        }
//        if (cfpassword.equals(check))
        if (cfpwd_err.length() > 0) {
            request.setAttribute("cfpwd_err", cfpwd_err);
            check = false;
            return check;
        }
        return check;
       

    }


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
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        String fullname= request.getParameter("fullname");
        String address= request.getParameter("address");
        String phone= request.getParameter("phone");
        String email= request.getParameter("email");
        User u = new User();
        u.setUsername(username);
        u.setFullname(fullname);
        u.setPassword(password);
        u.setAddress(address);
        u.setPhone(phone);
        u.setRole("1");
        u.setEmail(email);
        try{
            ur.registerUser(u);
            
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
       request.getRequestDispatcher("WEB-INF/JSP/login.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
