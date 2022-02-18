/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.RoomDetail;
import helper.GetVariable;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.RoomDetailRepository;
import services.RoomService;
import variables.Routers;

@WebServlet(name = "FilterServlet", urlPatterns = {"/" + Routers.FILTER_SERVLET})
public class FilterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        GetVariable gv = new GetVariable(request);
        String roomName = gv.getString("roomName", "Room name", 0, 256, "");
        String checkIn = gv.getString("checkIn", "Check In", 0, 30, null);
        String checkOut = gv.getString("checkOut", "Check In", 0, 30, null);
        Float minPrice = gv.getFloat("minPrice", "Min Price", 0, Float.MAX_VALUE, null);
        Float maxPrice = gv.getFloat("maxPrice", "Max Price", 0, Float.MAX_VALUE, null);

        RoomDetailRepository roomDetailRepo = new RoomDetailRepository();

        ArrayList<RoomDetail> roomDetails = roomDetailRepo.getAllRoomDetail();

        if (checkIn != null && checkOut != null) {
            Date checkInDate = Date.valueOf(checkIn);
            Date checkOutDate = Date.valueOf(checkOut);
            roomDetails = RoomService.filterRoomByDateBooking(roomDetails, checkInDate, checkOutDate);
        }

        request.setAttribute("roomDetails", roomDetails);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
            request.getRequestDispatcher(Routers.FILTER_PAGE).forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(FilterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
            request.getRequestDispatcher(Routers.FILTER_PAGE).forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(FilterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
