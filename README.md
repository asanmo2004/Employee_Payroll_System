# Employee Payroll System
A web-based payroll management system for calculating employee salaries based on work hours, bonuses, and deductions. The system provides an admin panel for managing employee records and allows employees to view their salary details and download payslips.

## Features
### Employee Features
✅ Employee login and registration.  
✅ View personal details, salary information, and leave status.  
✅ Download payslip in PDF format.

### Admin Features
✅ Admin Panel for Employee Management.  
✅ Manage employees – leaves and performance bonus.  
✅ Salary calculation based on attendance, bonuses, and deductions.  

## Tech Stack
- **Frontend:** JSP, HTML, CSS, Bootstrap  
- **Backend:** Core Java and Servlets  
- **Database:** MySQL (via JDBC)  
- **IDE:** IntelliJ IDEA  

## Project Structure
```
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
```

## Database Design
```sql
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
```

## How to Run
### Setup
1. Install **Smart Tomcat Plugin** in IntelliJ.
2. Install **MySQL Workbench**.
3. Copy the above **database schema design**.
4. Run the **CREATE queries** in MySQL Workbench.

### Deploy the Project
1. Download the project files.
2. Install **Maven** (to manage dependencies in `pom.xml`).
3. In the command line, run:
   mvn clean package
   This compiles the Java files.
4. Once the build is successful, run the JSP & Servlets using **Apache Tomcat**.
5. Open the application in a browser:
   ```
   http://localhost:8080/Employee_Payroll_System
   ```
