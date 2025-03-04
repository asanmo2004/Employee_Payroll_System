package servlets;

import dao.AdminDB;
import dao.SalaryDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminPanelServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Fetch form data
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            int leavesAllowed = Integer.parseInt(request.getParameter("leavesAllowed"));
            int leavesTaken = Integer.parseInt(request.getParameter("leavesTaken"));
            double bonus = Double.parseDouble(request.getParameter("bonus"));

            // Update admin table
            boolean isUpdated = AdminDB.updateAdminDetails(employeeId, leavesAllowed, leavesTaken, bonus);

            if (isUpdated) {
                // Update salary details
                boolean isSalaryUpdated = SalaryDB.updateSalary(employeeId, leavesAllowed, leavesTaken, bonus);

                if (isSalaryUpdated) {
                    response.sendRedirect("admin_panel.jsp?status=success");
                } else {
                    response.sendRedirect("admin_panel.jsp?status=salary_failed");
                }
            } else {
                response.sendRedirect("admin_panel.jsp?status=failed");
            }
        } catch (Exception e) {
            response.sendRedirect("admin_panel.jsp?status=failed");
        }
    }
}
