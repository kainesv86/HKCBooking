/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.CartItem;
import entities.History;
import entities.Review;
import entities.Room;
import entities.RoomDetail;
import entities.RoomType;
import helper.GetVariable;
import java.io.IOException;
import java.sql.Date;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositories.HistoryRepository;
import repositories.ReviewRepository;
import repositories.RoomDetailRepository;
import repositories.RoomRepository;
import repositories.RoomTypeRepository;
import services.HistoryService;
import services.ReviewService;
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

        HttpSession session = request.getSession();
        Date minCheckIn = (Date) session.getAttribute("minCheckIn");
        Date minCheckOut = (Date) session.getAttribute("minCheckOut");

        String checkInString = (String) session.getAttribute("checkIn");
        String checkOutString = (String) session.getAttribute("checkOut");

        request.setAttribute("checkIn", checkInString);
        request.setAttribute("checkOut", checkOutString);

        if (minCheckIn == null || minCheckOut == null) {
            minCheckIn = new Date(System.currentTimeMillis());
            minCheckOut = Date.valueOf(minCheckIn.toLocalDate().plusDays(1));
        }

        ReviewRepository reviewRepo = new ReviewRepository();
        ArrayList<Review> reviews = reviewRepo.getReviewByRoomId(roomId);
        Float rateOverall = ReviewService.reviewRateOverall(reviews);

        request.setAttribute("rateOverall", rateOverall);
        request.setAttribute("reviews", reviews);
        request.setAttribute("minCheckIn", minCheckIn.toString());
        request.setAttribute("minCheckOut", minCheckOut.toString());
        request.setAttribute("roomDetail", roomDetail);
        request.setAttribute("roomId", roomId);

        return true;
    }

    protected boolean handleOnPost(HttpServletRequest request, HttpServletResponse respone) throws Exception {

        HttpSession session = request.getSession();
        GetVariable gv = new GetVariable(request);
        Integer roomId = gv.getInt("roomId", "Room Id", 0, Integer.MAX_VALUE, null);
        Date checkIn = gv.getDate("checkIn", "Check In", null);
        Date checkOut = gv.getDate("checkOut", "Check Out", null);

        request.setAttribute("roomId", roomId);

        if (roomId == null || checkOut == null || checkIn == null) {
            session.setAttribute("message", "End date and start date is required");
            return false;
        }

        if (!HistoryService.isValidDateInput(checkIn, checkOut)) {
            session.setAttribute("message", "End date must greater than start date");
            return false;
        }

        HistoryRepository historyRepo = new HistoryRepository();
        ArrayList<History> histories = historyRepo.getAllHistoryByRoomId(roomId);

        if (!HistoryService.isValidDateBooking(histories, checkIn, checkOut)) {
            session.setAttribute("message", "Someone have booked this room in those date, please try to another date");
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

        cart.add(new CartItem(room, roomType.getRoomName(), checkIn, checkOut, total, ""));

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
            HttpSession session = request.getSession();
            session.setAttribute("message", null);
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
