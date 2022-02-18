/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.History;
import helper.GetVariable;
import java.io.IOException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.HistoryRepository;
import repositories.RoomRepository;
import variables.Routers;

@WebServlet(name = "DeleteRoomServlet", urlPatterns = {"/" + Routers.DELETE_ROOM_SERVLET})
public class DeleteRoomServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        GetVariable gv = new GetVariable(request);
        Integer roomId = gv.getInt("roomId", "Room Id", 0, Integer.MAX_VALUE, null);

        RoomRepository roomRepo = new RoomRepository();
        roomRepo.deleteRoom(roomId);

        History history = new History();
        Date startDate = new Date(System.currentTimeMillis());

        history.setRoomId(roomId);
        history.setStartDate(startDate);

        history.setMessage("We apologize for the inconvenience, this room no longer exist from now on.");

        HistoryRepository historyRepo = new HistoryRepository();
        historyRepo.updateHistoryByDeleteRoom(history);

        response.sendRedirect(Routers.EDIT_ROOM_SERVLET);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(DeleteRoomServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(DeleteRoomServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
