/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Review;
import guard.UseGuard;
import helper.GetVariable;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repositories.ReviewRepository;
import variables.Routers;

@WebServlet(name = "ReviewServlet", urlPatterns = {"/" + Routers.REVIEW_SERVLET})
public class ReviewServlet extends HttpServlet {

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
        Integer roomId = gv.getInt("roomId", "Room Id", 0, Integer.MAX_VALUE, null);
        String fullname = gv.getString("fullname", "Fullname", 1, 30, null);
        String comment = gv.getString("comment", "Commnet", 0, 500, "");
        Integer rate = gv.getInt("rate", "rate", 1, 5, null);

        if (roomId == null || fullname == null || comment == null || rate == null) {
            response.sendRedirect(Routers.INDEX_SERVLET);
            return;
        }

        Review review = new Review();
        review.setRoomId(roomId);
        review.setFullname(fullname);
        review.setComment(comment);
        review.setRate(rate);

        ReviewRepository reviewRepo = new ReviewRepository();
        if (!reviewRepo.addReview(review)) {
            response.sendRedirect(Routers.INDEX_SERVLET);
            return;
        }

        response.sendRedirect(Routers.ROOM_DETAIL_SERVLET + "?roomId=" + roomId);

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
        processRequest(request, response);
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
        processRequest(request, response);
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
