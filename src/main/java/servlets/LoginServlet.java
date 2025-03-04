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

public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminAuth obj=new AdminAuth();
        String URL = "jdbc:mysql://u6an8q1avyiafogr:XLLeuIS7nCx8fwDgedCq@b61tb0j8ijyl4rqzfdnn-mysql.services.clever-cloud.com:3306/b61tb0j8ijyl4rqzfdnn";
        String USER = obj.get_dbuser();
        String PASSWORD = obj.get_dbpassword();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // SQL query to check credentials
            String query = "SELECT id, first_name FROM employees WHERE email = ? AND password = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password); // Note: In production, use hashed passwords

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Login successful, create session
                HttpSession session = request.getSession();
                session.setAttribute("employeeId", rs.getInt("id"));
                session.setAttribute("employeeName", rs.getString("first_name"));

                response.sendRedirect("DashboardServlet");

            } else {
                // Login failed
                response.sendRedirect("login.jsp?status=failed");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?status=error");
        }
    }
}
