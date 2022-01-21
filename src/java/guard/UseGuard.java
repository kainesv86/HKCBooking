/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import variables.UserRole;

/**
 *
 * @author kaine
 */
public class UseGuard {

    private HttpServletRequest request;
    private HttpServletResponse response;

    public UseGuard(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public boolean checkRole(UserRole role) {
        HttpSession session = request.getSession();
        String userRole = (String) session.getAttribute("role");
        if (userRole == null || userRole.equals(role)) {
            return false;
        }

        return true;
    }
}
