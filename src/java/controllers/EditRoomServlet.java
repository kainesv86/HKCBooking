/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.RoomDetail;
import entities.RoomType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.RoomDetailRepository;
import repositories.RoomTypeRepository;
import variables.roomStatus;

/**
 *
 * @author Kaine
 */
@WebServlet(name = "EditRoomServlet", urlPatterns = {"/EditRoomServlet"})
public class EditRoomServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected boolean handleOnGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        RoomDetailRepository roomDetailRepository = new RoomDetailRepository();
        ArrayList<RoomDetail> roomDetails = roomDetailRepository.getAllRoomDetail();

        for (RoomDetail roomDetail : (ArrayList<RoomDetail>) roomDetails.clone()) {
            if (roomDetail.getRoom().getRoomStatus().equals(roomStatus.status.DELETED.toString())) {
                roomDetails.remove(roomDetail);
            }
        }

        request.setAttribute("roomDetails", roomDetails);
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
            if (handleOnGet(request, response)) {
                request.getRequestDispatcher("/WEB-INF/JSP/editRoom.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
