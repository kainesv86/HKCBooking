/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
import repositories.HistoryDetailRepo;
import variables.UserRole;

/**
 *
 * @author Kaine
 */
@WebServlet(name = "BookingOrdersServlet", urlPatterns = {"/BookingOrdersServlet"})
public class BookingOrdersServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        GetVariable gv = new GetVariable(request);
        Integer historyId = gv.getInt("historyId", "History Id", 0, Integer.MAX_VALUE, null);
        String historyStatus = gv.getString("historyStatus", "HistoryStatus", 1, 20, null);
        String message = gv.getString("message", "Message", 0, 500, "");
        String location = gv.getString("location", "Location", 1, 20, null);

        if (historyId == null || historyStatus == null || message == null) {
            return false;
        }

        return true;
    }

    protected boolean handleOnGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        GetVariable gv = new GetVariable(request);
        String status = gv.getString("status", "status", 0, 15, null);
        HistoryDetailRepo historyDetailRepo = new HistoryDetailRepo();
        ArrayList<HistoryDetail> list = historyDetailRepo.getAllHistoryDetail(status);

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

        if (!useGuard.useRole("ADMIN")) {
            response.sendRedirect("IndexServlet");
            return;
        }

        try {
            handleOnGet(request, response);
        } catch (Exception ex) {
            Logger.getLogger(BookingOrdersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/WEB-INF/JSP/bookingOrders.jsp").forward(request, response);
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

        if (handleOnPost(request, response)) {
            response.sendRedirect("BookingOrdersServlet" + location);
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
