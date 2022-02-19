/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.CartItem;
import entities.Room;
import entities.RoomDetail;
import entities.RoomType;
import helper.GetVariable;
import java.io.IOException;
import java.sql.Date;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
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
import repositories.RoomRepository;
import repositories.RoomTypeRepository;
import services.HistoryService;
import variables.Routers;

@WebServlet(name = "RoomDetailServlet", urlPatterns = {"/" + Routers.ROOM_DETAIL_SERVLET})
public class RoomDetailServlet extends HttpServlet {

    protected boolean handleOnGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        GetVariable gv = new GetVariable(request);

        Integer roomId = gv.getInt("roomId", "Room Id", 0, Integer.MAX_VALUE, null);

        if (roomId == null) {
            return false;
        }

        RoomDetailRepository roomDetailRepo = new RoomDetailRepository();
        RoomDetail roomDetail = roomDetailRepo.getRoomDetailByRoomId(roomId);
        if (roomDetail == null) {
            return false;
        }

        Date minCheckIn = new Date(System.currentTimeMillis());
        LocalDate minCheckOut = minCheckIn.toLocalDate().plusDays(1);

        request.setAttribute("roomDetail", roomDetail);
        request.setAttribute("minCheckIn", minCheckIn.toString());
        request.setAttribute("minCheckOut", minCheckOut.toString());

        return true;
    }

    protected boolean handleOnPost(HttpServletRequest request, HttpServletResponse respone) throws Exception {

        HttpSession session = request.getSession();
        GetVariable gv = new GetVariable(request);
        Integer roomId = gv.getInt("roomId", "Room Id", 0, Integer.MAX_VALUE, null);
        String startDate = gv.getString("startDate", "Start date", 0, 20, null);
        String endDate = gv.getString("endDate", "End date", 0, 20, null);

        request.setAttribute("roomId", roomId);

        if (roomId == null || startDate == null || endDate == null) {
            session.setAttribute("message", "End date and start date is required");
            return false;
        }

        Date checkIn = Date.valueOf(startDate);
        Date checkOut = Date.valueOf(endDate);

        if (!HistoryService.isValidDateInput(checkIn, checkOut)) {
            session.setAttribute("message", "End date must greater than start date");
            return false;
        }

        LocalDate lower = checkIn.toLocalDate();
        LocalDate upper = checkOut.toLocalDate();

        RoomRepository roomRepo = new RoomRepository();
        Room room = roomRepo.getRoomById(roomId);

        long days = ChronoUnit.DAYS.between(lower, upper);
        Float total = room.getPrice() * Math.abs(days);

        ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<CartItem>();
        }

        RoomTypeRepository roomTypeRepo = new RoomTypeRepository();
        RoomType roomType = roomTypeRepo.getRoomTypeById(room.getRoomTypeId());

        cart.add(new CartItem(room, roomType.getRoomName(), checkIn, checkOut, total));

        session.setAttribute("cart", cart);
        session.setAttribute("message", "Add cart successful");
        return true;

    }

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (!handleOnGet(request, response)) {
                request.getRequestDispatcher(Routers.ERROR_404_PAGE).forward(request, response);
                return;
            }
            request.getRequestDispatcher(Routers.ROOM_DETAIL_PAGE).forward(request, response);
        } catch (Exception ex) {
            request.getRequestDispatcher(Routers.ERROR_500_PAGE).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            handleOnPost(request, response);
            response.sendRedirect(Routers.ROOM_DETAIL_SERVLET + "?roomId=" + request.getAttribute("roomId"));
        } catch (Exception ex) {
            request.getRequestDispatcher(Routers.ERROR_500_PAGE).forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
