/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.RoomDetail;
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
import repositories.RoomDetailRepository;
import services.RoomService;
import variables.Routers;
import variables.RoomStatus;

@WebServlet(name = "IndexServlet", urlPatterns = {"/" + Routers.INDEX_SERVLET})
public class IndexServlet extends HttpServlet {

    protected boolean handleOnGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        RoomDetailRepository roomDetailRepo = new RoomDetailRepository();
        ArrayList<RoomDetail> roomDetails = roomDetailRepo.getAllRoomDetail();
        roomDetails = RoomService.filterRoomByStatus(roomDetails, RoomStatus.status.READY);

        request.setAttribute("roomDetails", roomDetails);
        return true;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        long millis = System.currentTimeMillis();
        java.sql.Date minDateCheckIn = new java.sql.Date(millis);
        System.out.println(minDateCheckIn);
//        session.setAttribute("minDate", minDateCheckIn);
        try {
            if (!handleOnGet(request, response)) {
                request.getRequestDispatcher(Routers.ERROR_404_PAGE).forward(request, response);
                return;
            }
            request.getRequestDispatcher(Routers.INDEX_PAGE).forward(request, response);
        } catch (Exception ex) {
            request.getRequestDispatcher(Routers.ERROR_500_PAGE).forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
