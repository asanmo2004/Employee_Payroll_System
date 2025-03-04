package servlets;

import java.io.IOException;
import java.io.OutputStream;
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
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import core.AdminAuth;

public class GeneratePayslipServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminAuth obj=new AdminAuth();
        String URL = "jdbc:mysql://u6an8q1avyiafogr:XLLeuIS7nCx8fwDgedCq@b61tb0j8ijyl4rqzfdnn-mysql.services.clever-cloud.com:3306/b61tb0j8ijyl4rqzfdnn";
        String USER = obj.get_dbuser();
        String PASSWORD = obj.get_dbpassword();
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("employeeId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int employeeId = (int) session.getAttribute("employeeId");

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=payslip.pdf");

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "SELECT e.first_name, e.last_name, e.basic_salary, a.bonus, " +
                    "(a.leaves_taken - a.leaves_allowed) * (e.basic_salary / 264) AS deduction " +
                    "FROM employees e JOIN admin a ON e.id = a.employee_id WHERE e.id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, employeeId);
            ResultSet rs = pst.executeQuery();

            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            if (rs.next()) {
                document.add(new Paragraph("Payslip"));
                document.add(new Paragraph("Name: " + rs.getString("first_name") + " " + rs.getString("last_name")));
                document.add(new Paragraph("Basic Salary: $" + rs.getDouble("basic_salary")));
                document.add(new Paragraph("Bonus: $" + rs.getDouble("bonus")));
                document.add(new Paragraph("Deduction: $" + rs.getDouble("deduction")));
                document.add(new Paragraph("Net Salary: $" + (rs.getDouble("basic_salary") + rs.getDouble("bonus") - rs.getDouble("deduction"))));
            }

            document.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
