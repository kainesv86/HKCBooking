/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.RoomDetail;
import entities.RoomType;
import guard.UseGuard;
import helper.GetVariable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.RoomDetailRepository;
import repositories.RoomTypeRepository;
import services.RoomService;
import variables.Routers;
import variables.RoomStatus;
import variables.UserRole;

@WebServlet(name = "EditRoomServlet", urlPatterns = {"/" + Routers.EDIT_ROOM_SERVLET})
public class EditRoomServlet extends HttpServlet {

    protected boolean handleOnGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        RoomDetailRepository roomDetailRepository = new RoomDetailRepository();
        ArrayList<RoomDetail> roomDetails = roomDetailRepository.getAllRoomDetail();

        GetVariable gv = new GetVariable(request);
        String roomName = gv.getString("roomName", "Room Name", 0, 100, null);
        Integer capacity = gv.getInt("capacity", "Capacity", 0, Integer.MAX_VALUE, null);
        Float minPrice = gv.getFloat("minPrice", "Min Price", 0, Float.MAX_VALUE, null);
        Float maxPrice = gv.getFloat("maxPrice", "Max Price", 0, Float.MAX_VALUE, null);
        Integer roomTypeId = gv.getInt("roomTypeId", "Room Type Id", 0, Integer.MAX_VALUE, null);
        String roomStatus = gv.getString("roomStatus", "Room status", 0, 256, null);

        for (RoomDetail roomDetail : (ArrayList<RoomDetail>) roomDetails.clone()) {

            boolean isValidExistRoom = !roomDetail.getRoom().getRoomStatus().equals(RoomStatus.status.DELETED.toString());
            boolean isValidRoomTypeId = roomTypeId == null || Objects.equals(roomTypeId, roomDetail.getRoomType().getRoomTypeId());
            boolean isValidRoomName = roomName == null || (roomName != null && roomDetail.getRoomType().getRoomName().toLowerCase().contains(roomName.toLowerCase()));
            boolean isValidCapacity = capacity == null || Objects.equals(roomDetail.getRoomType().getCapacity(), capacity);
            boolean isValidRoomStatus = roomStatus == null || (roomStatus != null && roomDetail.getRoom().getRoomStatus().equals(roomStatus));

            boolean isValid = isValidExistRoom && isValidRoomTypeId && isValidRoomName && isValidCapacity && isValidRoomStatus;
            if (!isValid) {
                roomDetails.remove(roomDetail);
            }
        }

        roomDetails = RoomService.filterRoomByPriceBooking(roomDetails, minPrice, maxPrice);

        RoomTypeRepository roomTypeRepo = new RoomTypeRepository();
        ArrayList<RoomType> roomTypes = roomTypeRepo.getAllRoomType();

        request.setAttribute("roomTypes", roomTypes);
        request.setAttribute("roomDetails", roomDetails);
        return true;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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

            if (!handleOnGet(request, response)) {
                request.getRequestDispatcher(Routers.ERROR_404_PAGE).forward(request, response);
                return;
            }
            request.getRequestDispatcher(Routers.EDIT_ROOM_PAGE).forward(request, response);
        } catch (Exception ex) {
            request.getRequestDispatcher(Routers.ERROR_500_PAGE).forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
