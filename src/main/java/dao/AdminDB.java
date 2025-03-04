package dao;
import core.AdminAuth;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AdminDB {
    public static boolean updateAdminDetails(int employeeId, int leavesAllowed, int leavesTaken, double bonus) {
        boolean success = false;
        AdminAuth obj=new AdminAuth();
        String URL = "jdbc:mysql://u6an8q1avyiafogr:XLLeuIS7nCx8fwDgedCq@b61tb0j8ijyl4rqzfdnn-mysql.services.clever-cloud.com:3306/b61tb0j8ijyl4rqzfdnn";
        String USER = obj.get_dbuser();
        String PASSWORD = obj.get_dbpassword();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // UPSERT: Insert or Update admin details
            String query = "INSERT INTO admin (employee_id, leaves_allowed, leaves_taken, bonus) " +
                    "VALUES (?, ?, ?, ?) " +
                    "ON DUPLICATE KEY UPDATE " +
                    "leaves_allowed = VALUES(leaves_allowed), " +
                    "leaves_taken = VALUES(leaves_taken), " +
                    "bonus = VALUES(bonus)";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, employeeId);
            pst.setInt(2, leavesAllowed);
            pst.setInt(3, leavesTaken);
            pst.setDouble(4, bonus);

            int rows = pst.executeUpdate();
            success = (rows > 0);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

}
