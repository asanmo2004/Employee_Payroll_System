<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - Employee Payroll System</title>

    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">

    <!-- Custom Styles -->
    <style>
        body {
            background: url('https://source.unsplash.com/1600x900/?office,corporate') no-repeat center center/cover;
            font-family: 'Poppins', sans-serif;
        }
        .dashboard-container {
            background: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3);
        }
        h2 {
            color: #000;
            font-weight: 700;
        }
        .list-group-item {
            font-size: 18px;
            font-weight: 500;
            transition: all 0.3s ease-in-out;
        }
        .list-group-item:hover {
            transform: scale(1.05);
            background-color: rgba(0, 0, 0, 0.1);
        }
        a {
            color: #000 !important;
            font-weight: 600;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body class="d-flex justify-content-center align-items-center vh-100">

    <div class="container dashboard-container text-center">
        <h2 class="mb-4">Admin Dashboard</h2>

        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="list-group">
                    <a href="view_employees.jsp" class="list-group-item list-group-item-action">📋 View All Employees</a>
                    <a href="modify_employee.jsp" class="list-group-item list-group-item-action">✏ Modify Employee Details</a>
                    <a href="delete_employee.jsp" class="list-group-item list-group-item-action">❌ Delete Employee</a>
                    <a href="admin_panel.jsp" class="list-group-item list-group-item-action bg-primary text-white">🔑 Admin Panel</a>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
