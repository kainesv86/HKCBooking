/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import helper.GetVariable;
import java.io.IOException;
import java.io.PrintWriter;
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

        String urlParams = "";

        Integer roomTypeId = gv.getInt("roomTypeId", "Room Type Id", 0, Integer.MAX_VALUE, null);
        urlParams += roomTypeId != null ? "?roomTypeId=" + roomTypeId : "";

        Integer roomId = gv.getInt("roomId", "Room Id", 0, Integer.MAX_VALUE, null);
        urlParams += roomId != null ? "?roomId=" + roomId : "";

        String roomName = gv.getString("roomName", "Room name", 0, 256, null);
        urlParams += roomName != null ? "?roomName=" + roomName : "";

        Integer capacity = gv.getInt("capacity", "Capacity", 1, 256, null);
        urlParams += capacity != null ? "?capacity=" + capacity : "";

        Float minPrice = gv.getFloat("minPrice", "Min Price", 0, Float.MAX_VALUE, null);
        urlParams += minPrice != null ? "?minPrice=" + minPrice : "";

        Float maxPrice = gv.getFloat("maxPrice", "Max Price", 0, Float.MAX_VALUE, null);
        urlParams += maxPrice != null ? "?maxPrice=" + maxPrice : "";

        response.sendRedirect(Routers.EDIT_ROOM_SERVLET + urlParams);
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
