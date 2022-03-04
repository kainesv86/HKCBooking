/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import helper.GetVariable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import variables.Routers;

/**
 *
 * @author Kaine
 */
@WebServlet(name = "AddParamsServlet", urlPatterns = {"/AddParamsServlet"})
public class AddParamsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GetVariable gv = new GetVariable(request);

        String redirectTo = gv.getString("redirectTo", "", 0, 256, Routers.INDEX_SERVLET);

        String urlParams = redirectTo;

        Integer roomId = gv.getInt("roomId", "Room Id", 0, Integer.MAX_VALUE, null);
        urlParams += roomId != null ? "&?roomId=" + roomId : "";

        String roomName = gv.getString("roomName", "Room name", 0, 256, null);
        urlParams += roomName != null ? "&?roomName=" + roomName : "";

        Integer capacity = gv.getInt("capacity", "Capacity", 1, 256, null);
        urlParams += capacity != null ? "&?capacity=" + capacity : "";

        Float minPrice = gv.getFloat("minPrice", "Min Price", 0, Float.MAX_VALUE, null);
        urlParams += minPrice != null ? "&?minPrice=" + minPrice : "";

        Float maxPrice = gv.getFloat("maxPrice", "Max Price", 0, Float.MAX_VALUE, null);
        urlParams += maxPrice != null ? "&?maxPrice=" + maxPrice : "";

        Integer roomTypeId = gv.getInt("roomTypeId", "Room Type Id", 0, Integer.MAX_VALUE, null);
        urlParams += roomTypeId != null ? "&?roomTypeId=" + roomTypeId : "";

        String roomStatus = gv.getString("roomStatus", "Room status", 0, 256, null);
        urlParams += roomStatus != null ? "&?roomStatus=" + roomStatus : "";

        Date checkIn = gv.getDate("checkIn", "Check In", null);
        Date checkOut = gv.getDate("checkOut", "Check Out", null);
        urlParams += checkIn != null && checkOut != null ? "&?checkIn=" + checkIn + "&?checkOut=" + checkOut : "";

        Integer page = gv.getInt("page", "Page", 0, Integer.MAX_VALUE, null);
        urlParams += page != null ? "&?page=" + page : "";

        Integer userId = gv.getInt("userId", "User Id", 0, Integer.MAX_VALUE, null);
        urlParams += userId != null ? "&?userId=" + userId : "";

        Date startDate = gv.getDate("startDate", "Start Date", null);
        Date endDate = gv.getDate("endDate", "End Date", null);
        urlParams += startDate != null && endDate != null ? "&?startDate=" + startDate + "&?endDate=" + endDate : "";

        urlParams = urlParams.replace(redirectTo + "&?", redirectTo + "?");
        urlParams = urlParams.replace("&?", "&");

//        System.out.println(urlParams);
        response.sendRedirect(urlParams);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
