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
@WebServlet(name = "AddRoomTypeServlet", urlPatterns = {"/AddRoomTypeServlet"})
public class AddRoomTypeServlet extends HttpServlet {

    protected boolean handleOnPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        GetVariable gv = new GetVariable(request);
        Integer roomTypeId = gv.getInt("roomTypeId", "Room Type Id", 0, Integer.MAX_VALUE, null);
        String roomName = gv.getString("roomName", "Room Name", 0, 500, "");
        Integer capacity = gv.getInt("capacity", "Capacity", 0, Integer.MAX_VALUE, null);
        Integer acreage = gv.getInt("acreage", "Acreage", 0, Integer.MAX_VALUE, null);

        if (roomTypeId == null || roomName == null || capacity == null || acreage == null) {
            return false;
        }

        RoomType roomType = new RoomType();
        roomType.setRoomTypeId(roomTypeId);
        roomType.setRoomName(roomName);
        roomType.setCapacity(capacity);
        roomType.setAcreage(acreage);

        RoomTypeRepository roomRepo = new RoomTypeRepository();
        if (roomRepo.checkRoomTypeExist(roomTypeId, roomName)) {
            return false;
        }
        return roomRepo.addRoomType(roomType);

    }

    protected boolean handleOnGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        RoomTypeRepository roomTypeRepo = new RoomTypeRepository();
        ArrayList<RoomType> roomTypes = roomTypeRepo.getAllRoomType();
        request.setAttribute("roomTypes", roomTypes);

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

        if (!useGuard.useRole(UserRole.role.ADMIN)) {
            response.sendRedirect(Routers.INDEX_SERVLET);
            return;
        }

        try {
            if (!handleOnGet(request, response)) {
                request.getRequestDispatcher(Routers.ERROR_404_PAGE).forward(request, response);
                return;
            }
            request.getRequestDispatcher(Routers.ADD_ROOM_TYPE_PAGE).forward(request, response);
        } catch (Exception ex) {
            request.getRequestDispatcher(Routers.ERROR_500_PAGE).forward(request, response);
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
        if (!handleOnPost(request, response)) {
            request.setAttribute("message", "Add room type failed, roomTypeId or RoomName existed");
        } else {
            request.setAttribute("message", "Add room type successful");
        }

        try {
            RoomTypeRepository roomTypeRepo = new RoomTypeRepository();
            ArrayList<RoomType> roomTypes;
            roomTypes = roomTypeRepo.getAllRoomType();
            request.setAttribute("roomTypes", roomTypes);
        } catch (Exception ex) {
            Logger.getLogger(AddRoomServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("AddRoomTypeServlet");
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
