package servlets;

import dao.EmployeeDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName, lastName, email, password, phone, department, designation;
        double basicSalary;

        try {
            firstName = request.getParameter("firstName");
            lastName = request.getParameter("lastName");
            email = request.getParameter("email");
            password = request.getParameter("password");
            phone = request.getParameter("phone");
            department = request.getParameter("department");
            designation = request.getParameter("designation");
            basicSalary = Double.parseDouble(request.getParameter("basicSalary"));
        } catch (Exception e) {
            response.getWriter().println("Registration failed. Try again.");
            return;  // Stop execution if parsing fails
        }

        boolean isRegistered = EmployeeDB.addEmployee(firstName, lastName, email, password, phone, department, designation, basicSalary);

        if (isRegistered) {
            response.sendRedirect("login.jsp?success=1");
        } else {
            response.getWriter().println("Registration failed. Try again.");
        }
    }
}
