/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.RoomDetail;
import helper.GetVariable;
import java.io.IOException;
import static java.lang.Float.NaN;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositories.RoomDetailRepository;
import services.HistoryService;
import services.RoomService;
import variables.RoomStatus;
import variables.Routers;

@WebServlet(name = "FilterServlet", urlPatterns = {"/" + Routers.FILTER_SERVLET})
public class FilterServlet extends HttpServlet {

    protected void handleOnPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        GetVariable gv = new GetVariable(request);

        //Get page number
        Integer page = gv.getInt("page", "Page", 1, Integer.MAX_VALUE, 1);
        page = page != null ? page : 1;
        request.setAttribute("page", page);

        //Get all room but only show ready room
        RoomDetailRepository roomDetailRepo = new RoomDetailRepository();

        ArrayList<RoomDetail> roomDetails = roomDetailRepo.getAllRoomDetail();

        roomDetails = RoomService.filterRoomByStatus(roomDetails, RoomStatus.status.READY);

        //Filter by date but required in input tag, not in post param
        Date checkIn = gv.getDate("checkIn", "Check in", null);
        Date checkOut = gv.getDate("checkOut", "Check out", null);

        if (checkIn != null && checkOut != null) {
            roomDetails = RoomService.filterRoomByDateBooking(roomDetails, checkIn, checkOut);
            request.setAttribute("checkIn", checkIn.toString());
            request.setAttribute("checkOut", checkOut.toString());
            if (!HistoryService.isValidDateInput(checkIn, checkOut)) {
                roomDetails.clear();
                request.setAttribute("checkOutError", "End date must greater than start date");
            }
        }

        String roomName = gv.getString("roomName", "Room name", 0, 256, null);
        roomDetails = RoomService.filterRoomByName(roomDetails, roomName);
        request.setAttribute("roomName", roomName);

        //Filter by price (NaN for someone try to make wrong in param)
        Float minPrice = gv.getFloat("minPrice", "Min Price", 0, Float.MAX_VALUE, Float.valueOf("-1"));

        Float maxPrice = gv.getFloat("maxPrice", "Max Price", minPrice != null && !minPrice.equals(NaN) ? minPrice : 0, Float.MAX_VALUE, Float.valueOf("-1"));

        // -1 only set by getFloat function when that min or max price didn't provide and if it had, it will dependent on condition
        if (minPrice != -1 && maxPrice != -1) {
            roomDetails = RoomService.filterRoomByPriceBooking(roomDetails, minPrice, maxPrice);
        }

        String minPriceError = (String) request.getAttribute("minPriceError");
        String maxPriceError = (String) request.getAttribute("maxPriceError");

        if (minPriceError != null || maxPriceError != null) {
            String priceError = "";
            priceError += minPriceError != null ? minPriceError : "";
            priceError += minPriceError != null && maxPriceError != null ? ", " : "";
            priceError += maxPriceError != null ? maxPriceError : "";
            request.setAttribute("priceError", priceError);
        } else {
            // this condition will work to set default value in input tag
            if (minPrice != -1 && maxPrice == -1) {
                request.setAttribute("minPrice", minPrice);
                request.setAttribute("maxPrice", maxPrice);
            }
        }

//        Set min date that input date can set
        HttpSession session = request.getSession();

        Date minCheckIn = (Date) session.getAttribute("minCheckIn");
        Date minCheckOut = (Date) session.getAttribute("minCheckOut");

        if (minCheckIn == null || minCheckOut
                == null) {
            minCheckIn = new Date(System.currentTimeMillis());
            minCheckOut = Date.valueOf(minCheckIn.toLocalDate().plusDays(1));
        }

        request.setAttribute("minCheckIn", minCheckIn.toString());
        request.setAttribute("minCheckOut", minCheckOut.toString());

        //Room after filter all condition
        request.setAttribute("roomDetails", roomDetails);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            handleOnPost(request, response);
            request.getRequestDispatcher(Routers.FILTER_PAGE).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.getRequestDispatcher(Routers.ERROR_500_PAGE).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            handleOnPost(request, response);
            request.getRequestDispatcher(Routers.FILTER_PAGE).forward(request, response);
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
