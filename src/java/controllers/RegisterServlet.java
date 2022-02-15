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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositories.UserRepository;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    private UserRepository ur = new UserRepository();

    protected boolean processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        GetVariable gv = new GetVariable(request);
        String username = gv.getString("username", "Username", 8, 30, null);
        String password = gv.getString("password", "Password", 8, 30, null);
        String fullname = gv.getString("fullname", "FullName", 1, 50, null);
        String confirmPassword = gv.getString("confirmPassword", "confirmPassword", 1, 50, null);
        String phone = gv.getString("phone", "Phone", 9, 11, null);
        String email = gv.getString("email", "Email", 1, 50, null);

        if (username == null || password == null || fullname == null || confirmPassword == null || phone == null || email == null) {
            return false;
        }
        if (!confirmPassword.equals(password)) {
            request.setAttribute("confirmPasswordError", "Confirm password is not correct");
            return false;
        }
        User user = new User(username, password, fullname, "", phone, "USER", email);

        try {
            UserRepository ur = new UserRepository();
            User u = ur.getUserByUsername(username);
            if (u != null) {
                request.setAttribute("usernameError", "Username is already exist");
                return false;
            }
            ur.registerUser(user);

        } catch (Exception e) {
            return false;
        }
        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getUserId());
        session.setAttribute("fullname", user.getFullname());
        return true;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (processRequest(request, response)) {
                response.sendRedirect("LoginServlet");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("WEB-INF/JSP/register.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
