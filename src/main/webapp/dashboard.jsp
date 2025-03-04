<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h2 class="text-center">Employee Dashboard</h2>

    <!-- Personal Information -->
    <div class="card mt-4">
        <div class="card-header bg-primary text-white">
            <h5>Personal Information</h5>
        </div>
        <div class="card-body">
            <p><strong>Name:</strong> <%= request.getAttribute("firstName") %> <%= request.getAttribute("lastName") %></p>
            <p><strong>Email:</strong> <%= request.getAttribute("email") %></p>
            <p><strong>Phone:</strong> <%= request.getAttribute("phone") %></p>
            <p><strong>Department:</strong> <%= request.getAttribute("department") %></p>
            <p><strong>Designation:</strong> <%= request.getAttribute("designation") %></p>
            <p><strong>Basic Salary:</strong> $<%= request.getAttribute("basicSalary") %></p>
        </div>
    </div>

    <!-- Leave and Bonus Information -->
    <div class="card mt-4">
        <div class="card-header bg-success text-white">
            <h5>Leave & Bonus Information</h5>
        </div>
        <div class="card-body">
            <p><strong>Leaves Allowed:</strong> <%= request.getAttribute("leavesAllowed") %></p>
            <p><strong>Leaves Taken:</strong> <%= request.getAttribute("leavesTaken") %></p>
            <p><strong>Bonus:</strong> $<%= request.getAttribute("bonus") %></p>
        </div>
    </div>

    <!-- Payslip Download Button -->
    <div class="text-center mt-4">
        <a href="GeneratePayslipServlet" class="btn btn-primary">Download Payslip</a>
    </div>

    <!-- Logout Button -->
    <div class="text-center mt-3">
        <a href="logout.jsp" class="btn btn-secondary">Logout</a>
    </div>
</body>
</html>
