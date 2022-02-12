/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.User;
import guard.UseGuard;
import helper.GetVariable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repositories.UserRepository;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/ChangePasswordServlet"})
public class ChangePasswordServlet extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and
	 * <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected boolean processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException, Exception {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		GetVariable gv = new GetVariable(request);
		try {
			String password = gv.getString("password", "Password", 8, 30, null);
			String newPassword = gv.getString("newPassword", "New password", 8, 30, null);
			String newPasswordConfirm = gv.getString("newPasswordConfirm", "New password confirm", 8, 30, null);

			UserRepository ad = new UserRepository();
			User u = ad.getUserByUserId(userId);

			if (!u.getPassword().equals(password)) {
				request.setAttribute("passwordError", "Password is not correct");
				return false;
			}

			if (!newPassword.equals(newPasswordConfirm)) {
				request.setAttribute("newPasswordConfirmError", "Confirm Password is not match");
				return false;
			}

			u.setPassword(newPassword);
			if (ad.changePassword(u)) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
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
		UseGuard useGuard = new UseGuard(request, response);
		if (!useGuard.useAuth()) {
			response.sendRedirect("LoginServlet");
			return;
		}

		request.getRequestDispatcher("WEB-INF/JSP/changePassword.jsp").forward(request, response);
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

		UseGuard useGuard = new UseGuard(request, response);

		try {
			if (processRequest(request, response)) {
				request.setAttribute("message", "Update successful");
				useGuard.useAuth();
			} else {
				request.setAttribute("messageError", "Update failed, please check on fields above");
			}
		} catch (Exception ex) {
			Logger.getLogger(ChangePasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
		request.getRequestDispatcher("WEB-INF/JSP/changePassword.jsp").forward(request, response);
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
