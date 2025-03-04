
Employee Payroll System 
A web-based payroll management system for calculating employee salaries based on work hours, bonuses, and deductions. The system provides an admin panel for managing employee records and allows employees to view their salary details and download payslips.

Features
Employee Features
✅ Employee login and registration.
✅ View personal details, salary information, and leave status.
✅ Download payslip in PDF format.

Admin Features
✅ Admin Panel for Employee Management.
✅ Manage employees – leaves and performance bonus.
✅ Salary calculation based on attendance, bonuses, and deductions.

Tech Stack:
Frontend: JSP, HTML, CSS, Bootstrap 
Backend: Core Java and Servlets 
Database: MySQL (via JDBC) 
IDE: IntelliJ IDE

Project Structure:
Employee_Payroll_System/
│── src/
│   ├── main/java/
│   │   ├── core/
│   │   │   ├── Admin_log.java
│   │   │   ├── AdminAuth.java
│   │   ├── dao/
│   │   │   ├── AdminDB.java
│   │   │   ├── EmployeeDB.java
│   │   │   ├── SalaryDB.java
│   │   ├── servlets/
│   │   │   ├── AdminPanelServlet.java
│   │   │   ├── AdminServlet.java
│   │   │   ├── DashboardServlet.java
│   │   │   ├── GeneratePayslipServlet.java
│   │   │   ├── LoginServlet.java
│   │   │   ├── RegisterServlet.java
│── webapp/
│   ├── WEB-INF/
│   │   ├── web.xml
│   ├── admin.jsp
│   ├── admin_dashboard.jsp
│   ├── admin_panel.jsp
│   ├── dashboard.jsp
│   ├── index.jsp
│   ├── login.jsp
│   ├── register.jsp
│── resources/
│── database/
│   ├── payroll_db.sql
│── README.md
│── pom.xml 
Database Design:
CREATE DATABASE employee_payroll;
USE employee_payroll;

-- Employees Table
CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255), 
    phone VARCHAR(15),
    department VARCHAR(50),
    designation VARCHAR(50),
    basic_salary DECIMAL(10,2)
);

-- Admin Table
CREATE TABLE admin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL UNIQUE,
    leaves_allowed INT NOT NULL DEFAULT 20, 
    leaves_taken INT NOT NULL DEFAULT 0,
    bonus DECIMAL(10,2) NOT NULL DEFAULT 0.00, 
    FOREIGN KEY (employee_id) REFERENCES employees(id) ON DELETE CASCADE
);

-- Salary Table
CREATE TABLE salary (
    sal_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL UNIQUE,
    basic_salary DECIMAL(10,2) NOT NULL,
    bonus DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    deduction DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    net_salary DECIMAL(10,2) GENERATED ALWAYS AS (basic_salary + bonus - deduction) STORED,
    FOREIGN KEY (employee_id) REFERENCES employees(id) ON DELETE CASCADE
);

How to Run:
Setup :

In IntelliJ Install Smart Tomcat Plugin
Install MySql Workbench 
Copy the Above database Schema Design
Run the create queries in the workbench

Deploy the Project :

download the project files in first folder.
Install Maven because of installing dependencies in pom.xml
in cmd,type mvn clean package to compile the java files.
After build success then run the JSP & Servlets using Apache Tomcat.

Open http://localhost:8080/Employee_Payroll_System in a browser.


Screenshots:
 Welcome Page
 
Employee Login
 
Employee Registration
 
Employee Dashboard
 
Admin Dashboard
 
Admin Panel
 

Downloadable Payslip PDF(Using itext.pdf library)


 
