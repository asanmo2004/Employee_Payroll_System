package servlets;

import core.AdminAuth;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminAuth admin = new AdminAuth();

        if (admin.validate(username, password)) {
            response.sendRedirect("admin_dashboard.jsp");
        } else {
            response.sendRedirect("admin.jsp?error=1"); // Redirect back with error message
        }
    }
}