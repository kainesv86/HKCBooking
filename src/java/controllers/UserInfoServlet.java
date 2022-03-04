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

@WebServlet(name = "UserInfoServlet", urlPatterns = {"/" + Routers.USER_INFO_SERVLET})
public class UserInfoServlet extends HttpServlet {

    protected boolean processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        GetVariable gv = new GetVariable(request);
        try {
            String fullname = gv.getString("fullname", "Fullname", 1, 30, null);
            String address = gv.getString("address", "Address", 1, 50, "");
            String phone = gv.getString("phone", "Phone", 10, 30, null);
            String email = gv.getString("email", "Email", 1, 50, null);

            if (fullname == null || phone == null || email == null) {
                System.out.println("WTF: " + fullname);
                return false;
            }

            UserRepository ad = new UserRepository();
            User u = ad.getUserByUserId(userId);
            u.setFullname(fullname);
            u.setAddress(address);
            u.setPhone(phone);
            u.setEmail(email);

            if (!ad.updateInforUser(u)) {
                return false;
            }

            session.setAttribute("fullname", fullname);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UseGuard useGuard = new UseGuard(request, response);

        if (!useGuard.useAuth()) {
            response.sendRedirect(Routers.LOGIN_SERVLET);
            return;
        }

        request.getRequestDispatcher(Routers.USER_INFO_PAGE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UseGuard useGuard = new UseGuard(request, response);
        if (!useGuard.useAuth()) {
            response.sendRedirect(Routers.LOGIN_PAGE);
        }

        try {

            if (processRequest(request, response)) {
                request.setAttribute("message", "Update successful");
                useGuard.useAuth();
            } else {
                request.setAttribute("messageError", "Update failed, please check on fields above");
            }
            request.getRequestDispatcher(Routers.USER_INFO_PAGE).forward(request, response);
        } catch (Exception ex) {
            request.getRequestDispatcher(Routers.ERROR_500_PAGE).forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
