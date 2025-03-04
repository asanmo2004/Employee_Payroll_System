package core;

public abstract class Admin_log {
    // Abstract methods to be implemented by subclasses
    public abstract String get_username();
    public abstract String get_password();
    public abstract String get_dbuser();
    public abstract String get_dbpassword();
    public abstract boolean validate(String username, String password);
}
