/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Room;
import entities.RoomType;
import helper.GetVariable;
import java.io.IOException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.RoomRepository;
import repositories.RoomTypeRepository;

/**
 *
 * @author Kaine
 */
@WebServlet(name = "EditRoomDetailServlet", urlPatterns = {"/EditRoomDetailServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1024, maxFileSize = 1024 * 1024 * 1024, maxRequestSize = 1024 * 1024 * 1024)
public class EditRoomDetailServlet extends HttpServlet {

    protected boolean handlOnGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        GetVariable gv = new GetVariable(request);
        Integer roomId = gv.getInt("roomId", "Room Id", 0, Integer.MAX_VALUE, null);
        RoomRepository roomRepo = new RoomRepository();

        Room room = roomRepo.getRoomById(roomId);
        if (room == null) {
            return false;
        }

        request.setAttribute("room", room);

        RoomTypeRepository roomTypeRepo = new RoomTypeRepository();
        ArrayList<RoomType> roomTypes = roomTypeRepo.getAllRoomType();
        request.setAttribute("roomTypes", roomTypes);

        return true;
    }

    protected boolean handlOnPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        GetVariable gv = new GetVariable(request);

        Integer roomId = gv.getInt("roomId", "Room Id", 0, Integer.MAX_VALUE, null);

        request.setAttribute("roomId", roomId);

        Integer roomTypeId = gv.getInt("roomTypeId", "Room Type Id", 0, Integer.MAX_VALUE, null);
        Float price = gv.getFloat("price", "price", 0, Float.MAX_VALUE, null);
        String imageUrl = gv.getFile("imageUrl", "Room Image", 1080 * 1080);
        String description = gv.getString("description", "desciption", 0, 500, "");
        String roomStatus = gv.getString("roomStatus", "Room Status", 1, 30, null);

        if (roomId == null || roomTypeId == null || price == null || description == null || roomStatus == null) {
            return false;
        }

        RoomRepository roomRepo = new RoomRepository();

        if (!roomRepo.updateRoom(new Room(roomId, roomTypeId, description, price, imageUrl, roomStatus))) {
            return false;
        };

        return true;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (handlOnGet(request, response)) {
                request.getRequestDispatcher("WEB-INF/JSP/editRoomDetail.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(EditRoomDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            if (handlOnPost(request, response)) {
                response.sendRedirect("EditRoomServlet");
                return;
            }
            Integer roomId = (Integer) request.getAttribute("roomId");

            response.sendRedirect("EditRoomDetailServlet?roomId" + roomId);

        } catch (Exception ex) {
            Logger.getLogger(EditRoomDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
