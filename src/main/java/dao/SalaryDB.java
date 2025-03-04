package dao;

import core.AdminAuth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SalaryDB {

    public static boolean updateSalary(int employeeId, int leavesAllowed, int leavesTaken, double bonus) {
        boolean success = false;
        AdminAuth obj=new AdminAuth();
        String URL = "jdbc:mysql://u6an8q1avyiafogr:XLLeuIS7nCx8fwDgedCq@b61tb0j8ijyl4rqzfdnn-mysql.services.clever-cloud.com:3306/b61tb0j8ijyl4rqzfdnn";
        String USER = obj.get_dbuser();
        String PASSWORD = obj.get_dbpassword();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Fetch basic salary from employees table
            String fetchSalaryQuery = "SELECT basic_salary FROM employees WHERE id = ?";
            PreparedStatement fetchSalaryStmt = con.prepareStatement(fetchSalaryQuery);
            fetchSalaryStmt.setInt(1, employeeId);
            ResultSet rs = fetchSalaryStmt.executeQuery();

            double basicSalary = 0.00;
            if (rs.next()) {
                basicSalary = rs.getDouble("basic_salary");
            } else {
                System.out.println("⚠️ Employee ID not found in employees table.");
                return false;
            }

            // Calculate deduction
            double deduction = (leavesTaken > leavesAllowed) ? (leavesTaken - leavesAllowed) * (basicSalary / 264) : 0.00;

            // Insert or update salary details
            String upsertQuery = "INSERT INTO salary (employee_id, basic_salary, bonus, deduction) " +
                    "VALUES (?, ?, ?, ?) " +
                    "ON DUPLICATE KEY UPDATE " +
                    "basic_salary = VALUES(basic_salary), " +
                    "bonus = VALUES(bonus), " +
                    "deduction = VALUES(deduction)";

            PreparedStatement upsertStmt = con.prepareStatement(upsertQuery);
            upsertStmt.setInt(1, employeeId);
            upsertStmt.setDouble(2, basicSalary);
            upsertStmt.setDouble(3, bonus);
            upsertStmt.setDouble(4, deduction);

            int rows = upsertStmt.executeUpdate();
            success = (rows > 0);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

}
