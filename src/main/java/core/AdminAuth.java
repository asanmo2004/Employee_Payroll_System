package core;

import core.Admin_log;

public class AdminAuth extends Admin_log {
    int id;
    @Override
    public String get_username() {
        return "admin";
    }

    @Override
    public String get_password() {
        return "admin";
    }

    @Override
    public String get_dbuser() {
        return "u6an8q1avyiafogr";
    }

    @Override
    public String get_dbpassword() {
        return "XLLeuIS7nCx8fwDgedCq";
    }

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false; // Prevent NullPointerException
        }
        return username.equals(get_username()) && password.equals(get_password());
    }
}
