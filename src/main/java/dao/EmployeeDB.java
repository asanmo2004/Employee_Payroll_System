package dao;
import core.AdminAuth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeDB {

    public static boolean addEmployee(String firstName, String lastName, String email, String password, String phone, String department, String designation, double basicSalary) {
        boolean success = false;
        AdminAuth obj=new AdminAuth();
        String URL = "jdbc:mysql://u6an8q1avyiafogr:XLLeuIS7nCx8fwDgedCq@b61tb0j8ijyl4rqzfdnn-mysql.services.clever-cloud.com:3306/b61tb0j8ijyl4rqzfdnn";
        String USER = obj.get_dbuser();
        String PASSWORD = obj.get_dbpassword();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "INSERT INTO employees (first_name, last_name, email, password, phone, department, designation, basic_salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, email);
            pst.setString(4, password);
            pst.setString(5, phone);
            pst.setString(6, department);
            pst.setString(7, designation);
            pst.setDouble(8, basicSalary);

            int rows = pst.executeUpdate();
            if (rows > 0) {
                success = true;
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
