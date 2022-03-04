/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.RoomType;
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
import repositories.RoomTypeRepository;
import variables.Routers;
import variables.UserRole;

/**
 *
 * @author Kaine
 */
@WebServlet(name = "AddRoomTypeServlet", urlPatterns = {"/" + Routers.ADD_ROOM_TYPE_SERVLET})
public class AddRoomTypeServlet extends HttpServlet {

    protected boolean handleOnPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        GetVariable gv = new GetVariable(request);
        String roomName = gv.getString("roomName", "Room Name", 0, 100, null);
        Integer capacity = gv.getInt("capacity", "Capacity", 0, Integer.MAX_VALUE, null);
        Integer acreage = gv.getInt("acreage", "Acreage", 0, Integer.MAX_VALUE, null);

        if (roomName == null || capacity == null || acreage == null) {
            return false;
        }

        RoomType roomType = new RoomType();
        roomType.setRoomName(roomName);
        roomType.setCapacity(capacity);
        roomType.setAcreage(acreage);

        RoomTypeRepository roomRepo = new RoomTypeRepository();
        return roomRepo.addRoomType(roomType);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UseGuard useGuard = new UseGuard(request, response);

        if (!useGuard.useAuth()) {
            response.sendRedirect(Routers.LOGIN_SERVLET);
            return;
        }

        if (!useGuard.useRole(UserRole.role.ADMIN)) {
            response.sendRedirect(Routers.INDEX_SERVLET);
            return;
        }

        try {
            request.getRequestDispatcher(Routers.ADD_ROOM_TYPE_PAGE).forward(request, response);
        } catch (Exception ex) {
            request.getRequestDispatcher(Routers.ERROR_500_PAGE).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            if (!handleOnPost(request, response)) {
                request.setAttribute("message", "Add room type failed, roomTypeId or RoomName existed");
            } else {
                request.setAttribute("message", "Add room type successful");
            }
            response.sendRedirect("AddRoomTypeServlet");
        } catch (Exception ex) {
            request.getRequestDispatcher(Routers.ERROR_500_PAGE).forward(request, response);
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
