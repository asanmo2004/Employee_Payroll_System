<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Payroll Management System</title>

    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;600&display=swap" rel="stylesheet">

    <!-- Custom Styles -->
    <style>
        body {
            background: url('https://source.unsplash.com/1600x900/?business,corporate') no-repeat center center/cover;
            font-family: 'Poppins', sans-serif;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
        }
        .container-box {
            background: rgba(255, 255, 255, 0.2);
            backdrop-filter: blur(10px);
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.2);
            width: 90%;
            max-width: 600px;
        }
        .btn {
            font-size: 18px;
            font-weight: bold;
            padding: 12px 20px;
            border-radius: 8px;
            transition: all 0.3s ease-in-out;
        }
        .btn:hover {
            transform: scale(1.05);
        }
        h1 {
            font-size: 32px;
            font-weight: 600;
            margin-bottom: 20px;
            color: #000; /* Changed to black */
        }
    </style>
</head>
<body>

    <div class="container-box">
        <h1>Welcome to Employee Payroll Management System!!!</h1>
        <a href="login.jsp" class="btn btn-primary m-2 shadow-lg">Employee Login</a>
        <a href="admin.jsp" class="btn btn-secondary m-2 shadow-lg">Admin Login</a>
    </div>

</body>
</html>
