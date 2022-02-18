/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.CartItem;
import entities.Room;
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
import repositories.RoomRepository;
import repositories.RoomTypeRepository;
import services.HistoryService;

/**
 *
 * @author Kaine
 */
@WebServlet(name = "RoomDetailServlet", urlPatterns = {"/RoomDetailServlet"})
public class RoomDetailServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @return
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected boolean getHandler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        GetVariable gv = new GetVariable(request);

        Integer roomId = gv.getInt("roomId", "Room Id", 0, Integer.MAX_VALUE, null);

        if (roomId == null) {
            return false;
        }

        RoomRepository roomRepo = new RoomRepository();
        Room room = roomRepo.getRoomById(roomId);

        RoomTypeRepository roomTypeRepo = new RoomTypeRepository();
        RoomType roomType = roomTypeRepo.getRoomTypeById(room.getRoomTypeId());

        Date minCheckIn = new Date(System.currentTimeMillis());
        LocalDate minCheckOut = minCheckIn.toLocalDate().plusDays(1);

        request.setAttribute("room", room);
        request.setAttribute("roomType", roomType);
        request.setAttribute("minCheckIn", minCheckIn.toString());
        request.setAttribute("minCheckOut", minCheckOut.toString());

        return true;
    }

    protected boolean postHanlding(HttpServletRequest request, HttpServletResponse respone) throws Exception {

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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (getHandler(request, response)) {
                request.getRequestDispatcher("/WEB-INF/JSP/roomDetail.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(RoomDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            if (postHanlding(request, response)) {

            }

        } catch (Exception ex) {
            Logger.getLogger(RoomDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("RoomDetailServlet" + "?roomId=" + request.getAttribute("roomId"));
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
