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

import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositories.RoomRepository;
import repositories.RoomTypeRepository;
import variables.Routers;
import variables.UserRole;

@WebServlet(name = "EditRoomDetailServlet", urlPatterns = {"/" + Routers.EDIT_ROOM_DETAIL_SERVLET})
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
        HttpSession session = request.getSession();

        Integer roomId = gv.getInt("roomId", "Room Id", 0, Integer.MAX_VALUE, null);

        request.setAttribute("roomId", roomId);

        Integer roomTypeId = gv.getInt("roomTypeId", "Room Type Id", 0, Integer.MAX_VALUE, null);
        Float price = gv.getFloat("price", "price", 0, Float.MAX_VALUE, null);
        String imageUrl = gv.getFile("imageUrl", "Room Image", 1080 * 1080);
        String description = gv.getString("description", "desciption", 0, 500, "");
        String roomStatus = gv.getString("roomStatus", "Room Status", 1, 30, null);

        if (roomId == null || roomTypeId == null || price == null || description == null || roomStatus == null) {
            if (price == null) {
                session.setAttribute("priceError", request.getAttribute("priceError"));
            }
            if (description == null) {
                session.setAttribute("descriptionError", request.getAttribute("descriptionError"));
            }

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

            HttpSession session = request.getSession();

            String priceError = (String) session.getAttribute("priceError");
            if (priceError != null) {
                request.setAttribute("priceError", priceError);
            }

            session.setAttribute("priceError", null);

            String descriptionError = (String) session.getAttribute("descriptionError");
            if (descriptionError != null) {
                request.setAttribute("descriptionError", descriptionError);
            }
            session.setAttribute("descriptionError", null);

            if (!handlOnGet(request, response)) {
                request.getRequestDispatcher(Routers.ERROR_404_PAGE).forward(request, response);
                return;
            }
            request.getRequestDispatcher(Routers.EDIT_ROOM_DETAIL_PAGE).forward(request, response);
        } catch (Exception ex) {
            request.getRequestDispatcher(Routers.ERROR_500_PAGE).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UseGuard useGuard = new UseGuard(request, response);

            if (!useGuard.useAuth()) {
                response.sendRedirect(Routers.LOGIN_SERVLET);
                return;
            }

            if (!useGuard.useRole(UserRole.role.ADMIN)) {
                response.sendRedirect(Routers.INDEX_SERVLET);
                return;
            }

            if (handlOnPost(request, response)) {
                response.sendRedirect(Routers.EDIT_ROOM_SERVLET);
                return;
            }
            Integer roomId = (Integer) request.getAttribute("roomId");

            response.sendRedirect(Routers.EDIT_ROOM_DETAIL_SERVLET + "?roomId=" + roomId);

        } catch (Exception ex) {
            ex.printStackTrace();
            request.getRequestDispatcher(Routers.ERROR_500_PAGE).forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
