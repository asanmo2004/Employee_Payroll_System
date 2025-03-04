package servlets;

import core.AdminAuth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminAuth obj=new AdminAuth();
        String URL = "jdbc:mysql://u6an8q1avyiafogr:XLLeuIS7nCx8fwDgedCq@b61tb0j8ijyl4rqzfdnn-mysql.services.clever-cloud.com:3306/b61tb0j8ijyl4rqzfdnn";
        String USER = obj.get_dbuser();
        String PASSWORD = obj.get_dbpassword();
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("employeeId") == null) {
            response.sendRedirect("login.jsp"); // Redirect to login if not authenticated
            return;
        }

        int employeeId = (int) session.getAttribute("employeeId");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Fetch employee details
            String empQuery = "SELECT first_name, last_name, email, phone, department, designation, basic_salary FROM employees WHERE id = ?";
            PreparedStatement empStmt = con.prepareStatement(empQuery);
            empStmt.setInt(1, employeeId);
            ResultSet empRs = empStmt.executeQuery();

            if (empRs.next()) {
                request.setAttribute("firstName", empRs.getString("first_name"));
                request.setAttribute("lastName", empRs.getString("last_name"));
                request.setAttribute("email", empRs.getString("email"));
                request.setAttribute("phone", empRs.getString("phone"));
                request.setAttribute("department", empRs.getString("department"));
                request.setAttribute("designation", empRs.getString("designation"));
                request.setAttribute("basicSalary", empRs.getDouble("basic_salary"));
            }

            // Fetch admin details
            String adminQuery = "SELECT leaves_allowed, leaves_taken, bonus FROM admin WHERE employee_id = ?";
            PreparedStatement adminStmt = con.prepareStatement(adminQuery);
            adminStmt.setInt(1, employeeId);
            ResultSet adminRs = adminStmt.executeQuery();

            if (adminRs.next()) {
                request.setAttribute("leavesAllowed", adminRs.getInt("leaves_allowed"));
                request.setAttribute("leavesTaken", adminRs.getInt("leaves_taken"));
                request.setAttribute("bonus", adminRs.getDouble("bonus"));
            }

            con.close();

            // Forward data to dashboard.jsp
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?status=error");
        }
    }
}
