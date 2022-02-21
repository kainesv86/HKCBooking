/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.History;
import helper.GetVariable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.HistoryRepository;
import variables.Routers;

/**
 *
 * @author Kaine
 */
@WebServlet(name = "UserHistoriesServlet", urlPatterns = {"/" + Routers.USER_HISTORIES_SERVLET})
public class UserHistoriesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");

        GetVariable gv = new GetVariable(request);
        Integer userId = gv.getInt("userId", "User Id", 0, Integer.MAX_VALUE, null);

        HistoryRepository hr = new HistoryRepository();
        ArrayList<History> list = hr.getAllHistoryByUserId(userId);
        request.setAttribute("list", list);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);
            request.getRequestDispatcher(Routers.USER_HISTORIES_PAGE).forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UserHistoriesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
