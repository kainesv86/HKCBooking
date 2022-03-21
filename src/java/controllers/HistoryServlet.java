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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositories.HistoryDetailRepository;
import repositories.HistoryRepository;
import variables.Routers;

@WebServlet(name = "HistoryServlet", urlPatterns = {"/" + Routers.HISTORY_SERVLET})
public class HistoryServlet extends HttpServlet {

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
        historyRepo.updateNoteHistory(history);

        return true;
    }

    protected boolean handleOnGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        GetVariable gv = new GetVariable(request);
        String status = gv.getString("status", "status", 0, 15, null);

        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        HistoryDetailRepository historyDetailRepo = new HistoryDetailRepository();
        ArrayList<HistoryDetail> list = historyDetailRepo.getHistoryDetailByUserId(userId, status);

        if (status != null) {
            request.setAttribute("location", status);
        }
        request.setAttribute("list", list);
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

        try {
            if (!handleOnGet(request, response)) {
                request.getRequestDispatcher(Routers.ERROR_404_PAGE).forward(request, response);
                return;
            };
            request.getRequestDispatcher(Routers.HISTORY_PAGE).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.getRequestDispatcher(Routers.ERROR_500_PAGE).forward(request, response);
        }

    }

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
            handleOnPost(request, response);
            response.sendRedirect(Routers.HISTORY_SERVLET + location);

        } catch (Exception ex) {
            request.getRequestDispatcher(Routers.ERROR_500_PAGE).forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
