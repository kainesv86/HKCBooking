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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositories.UserRepository;
import variables.Routers;

@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/" + Routers.CHANGE_PASSWORD_SERVLET})
public class ChangePasswordServlet extends HttpServlet {

    protected boolean handleOnPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        GetVariable gv = new GetVariable(request);
        try {
            String password = gv.getString("password", "Password", 8, 30, null);
            String newPassword = gv.getString("newPassword", "New password", 8, 30, null);
            String newPasswordConfirm = gv.getString("newPasswordConfirm", "New password confirm", 8, 30, null);

            UserRepository ad = new UserRepository();
            User u = ad.getUserByUserId(userId);

            if (!u.getPassword().equals(password)) {
                request.setAttribute("passwordError", "Password is not correct");
                return false;
            }

            if (!newPassword.equals(newPasswordConfirm)) {
                request.setAttribute("newPasswordConfirmError", "Confirm Password is not match");
                return false;
            }

            u.setPassword(newPassword);
            if (ad.changePassword(u)) {
                return true;
            }

        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UseGuard useGuard = new UseGuard(request, response);
        if (!useGuard.useAuth()) {
            response.sendRedirect(Routers.LOGIN_PAGE);
            return;
        }

        request.getRequestDispatcher(Routers.CHANGE_PASSWORD_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UseGuard useGuard = new UseGuard(request, response);

        try {
            if (handleOnPost(request, response)) {
                request.setAttribute("message", "Update successful");
                useGuard.useAuth();
            } else {
                request.setAttribute("messageError", "Update failed, please check on fields above");
            }
        } catch (Exception ex) {
            Logger.getLogger(ChangePasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher(Routers.CHANGE_PASSWORD_PAGE).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
