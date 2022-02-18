/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.RoomDetail;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.RoomDetailRepository;
import variables.Routers;
import variables.roomStatus;

@WebServlet(name = "EditRoomServlet", urlPatterns = {"/" + Routers.EDIT_ROOM_SERVLET})
public class EditRoomServlet extends HttpServlet {

    protected boolean handleOnGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        RoomDetailRepository roomDetailRepository = new RoomDetailRepository();
        ArrayList<RoomDetail> roomDetails = roomDetailRepository.getAllRoomDetail();

        for (RoomDetail roomDetail : (ArrayList<RoomDetail>) roomDetails.clone()) {
            if (roomDetail.getRoom().getRoomStatus().equals(roomStatus.status.DELETED.toString())) {
                roomDetails.remove(roomDetail);
            }
        }

        request.setAttribute("roomDetails", roomDetails);
        return true;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            if (handleOnGet(request, response)) {
                request.getRequestDispatcher(Routers.EDIT_ROOM_PAGE).forward(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
