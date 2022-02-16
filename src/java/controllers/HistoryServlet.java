/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.History;
import entities.HistoryDetail;
import guard.UseGuard;
import helper.GetVariable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositories.HistoryDetailRepo;
import repositories.HistoryRepository;

/**
 *
 * @author Kaine
 */
@WebServlet(name = "HistoryServlet", urlPatterns = {"/HistoryServlet"})
public class HistoryServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected boolean handleOnPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        GetVariable gv = new GetVariable(request);
        Integer historyId = gv.getInt("historyId", "History Id", 0, Integer.MAX_VALUE, null);
        String note = gv.getString("note", "Note", 0, 500, "");

        if (historyId == null || note == null) {
            return false;
        }

        History history = new History();
        history.setHistoryId(historyId);
        history.setNote(note);

        HistoryRepository historyRepo = new HistoryRepository();
        historyRepo.updateHistoryByUser(history);

        return true;
    }

    protected boolean handleOnGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        GetVariable gv = new GetVariable(request);
        String status = gv.getString("status", "status", 0, 15, null);

        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        HistoryDetailRepo historyDetailRepo = new HistoryDetailRepo();
        ArrayList<HistoryDetail> list = historyDetailRepo.getHistoryDetailByUserId(userId, status);

        if (status != null) {
            request.setAttribute("location", status);
        }
        request.setAttribute("list", list);
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
        UseGuard useGuard = new UseGuard(request, response);

        if (!useGuard.useAuth()) {
            response.sendRedirect("LoginServlet");
            return;
        }

        try {
            handleOnGet(request, response);
        } catch (Exception ex) {
            Logger.getLogger(BookingOrdersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getRequestDispatcher("/WEB-INF/JSP/history.jsp").forward(request, response);
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
        GetVariable gv = new GetVariable(request);
        String location = gv.getString("location", "Location", 1, 15, null);

        if (location == null || "null".equals(location)) {
            location = "";
        } else {
            location = "?status=" + location;
        }

        try {
            if (handleOnPost(request, response)) {
                response.sendRedirect("HistoryServlet" + location);
            }
        } catch (Exception ex) {
            Logger.getLogger(BookingOrdersServlet.class.getName()).log(Level.SEVERE, null, ex);
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
