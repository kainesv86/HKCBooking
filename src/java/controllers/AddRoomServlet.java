/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Room;
import entities.RoomType;
import guard.UseGuard;
import helper.GetVariable;
import java.io.IOException;
import static java.lang.Float.NaN;
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
import variables.Routers;
import variables.UserRole;

@WebServlet(name = "AddRoomServlet", urlPatterns = {"/" + Routers.ADD_ROOM_SERVLET})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1024, maxFileSize = 1024 * 1024 * 1024, maxRequestSize = 1024 * 1024 * 1024)
public class AddRoomServlet extends HttpServlet {

    protected boolean handleOnPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        GetVariable gv = new GetVariable(request);
        Integer roomTypeId = gv.getInt("roomTypeId", "Room Type Id", 0, Integer.MAX_VALUE, null);
        Float price = gv.getFloat("price", "price", 0, Float.MAX_VALUE, null);
        String imageUrl = gv.getFile("imageUrl", "Room Image", 1080 * 1080);
        String description = gv.getString("description", "desciption", 0, 500, "");

        if (price == null || imageUrl == null || description == null || price.equals(NaN)) {
            return false;
        }

        Room room = new Room();
        room.setRoomTypeId(roomTypeId);
        room.setPrice(price);
        room.setUrlImage(imageUrl);
        room.setDescription(description);
        room.setRoomStatus("READY");

        RoomRepository roomRepo = new RoomRepository();

        return roomRepo.addRoom(room);
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
            request.getRequestDispatcher(Routers.ADD_ROOM_PAGE).forward(request, response);
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
            request.setAttribute("message", "Add room failed");
        } else {
            request.setAttribute("message", "Add room successful");
        }

        try {
            RoomTypeRepository roomTypeRepo = new RoomTypeRepository();
            ArrayList<RoomType> roomTypes;
            roomTypes = roomTypeRepo.getAllRoomType();
            request.setAttribute("roomTypes", roomTypes);
        } catch (Exception ex) {
            Logger.getLogger(AddRoomServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getRequestDispatcher(Routers.ADD_ROOM_PAGE).forward(request, response);
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
