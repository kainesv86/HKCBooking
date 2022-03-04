/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.History;
import guard.UseGuard;
import helper.GetVariable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositories.HistoryRepository;
import variables.HistoryStatus;
import variables.Routers;

/**
 *
 * @author Kaine
 */
@WebServlet(name = "CancelHistoryServlet", urlPatterns = {"/" + Routers.CANCEL_HISTORY_SERVLET})
public class CancelHistoryServlet extends HttpServlet {

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

        UseGuard useGuard = new UseGuard(request, response);
        if (!useGuard.useAuth()) {
            response.sendRedirect(Routers.LOGIN_SERVLET);
            return;
        }

        GetVariable gv = new GetVariable(request);
        Integer historyId = gv.getInt("historyId", "History Id", 0, Integer.MAX_VALUE, null);

        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        HistoryRepository historyRepo = new HistoryRepository();
        History history = new History();
        history.setUserId(userId);
        history.setHistoryId(historyId);
        history.setHistoryStatus(HistoryStatus.status.CANCEL.toString());

        if (historyId != null) {
            historyRepo.updateHistoryByBookingCancel(history);
        }

        response.sendRedirect(Routers.HISTORY_SERVLET);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            response.sendRedirect(Routers.ERROR_500_PAGE);
        }
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
        } catch (Exception ex) {
            response.sendRedirect(Routers.ERROR_500_PAGE);
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
