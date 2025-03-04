<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - Employee Payroll System</title>

    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">

    <!-- Custom Styles -->
    <style>
        body {
            background: url('https://source.unsplash.com/1600x900/?office,workspace') no-repeat center center/cover;
            font-family: 'Poppins', sans-serif;
        }
        .register-card {
            background: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 15px;
            text-align: center;
            width: 100%;
            max-width: 500px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3);
        }
        .form-control {
            border-radius: 8px;
        }
        .btn {
            font-weight: 600;
            transition: all 0.3s ease-in-out;
        }
        .btn:hover {
            transform: scale(1.05);
        }
        label {
            color: #000 !important; /* Labels changed to black */
            font-weight: 500;
        }
        a {
            color: #000; /* Links changed to black */
            font-weight: 600;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body class="d-flex justify-content-center align-items-center vh-100">

    <div class="register-card shadow-lg bg-white">
        <h2 class="mb-4 fw-bold text-dark">Employee Registration</h2>
        <form action="RegisterServlet" method="post">
            <div class="mb-3 text-start">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" required>
            </div>
            <div class="mb-3 text-start">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" required>
            </div>
            <div class="mb-3 text-start">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="mb-3 text-start">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <div class="mb-3 text-start">
                <label for="phone" class="form-label">Phone</label>
                <input type="text" class="form-control" id="phone" name="phone" required>
            </div>
            <div class="mb-3 text-start">
                <label for="department" class="form-label">Department</label>
                <input type="text" class="form-control" id="department" name="department" required>
            </div>
            <div class="mb-3 text-start">
                <label for="designation" class="form-label">Designation</label>
                <input type="text" class="form-control" id="designation" name="designation" required>
            </div>
            <div class="mb-3 text-start">
                <label for="basicSalary" class="form-label">Basic Salary</label>
                <input type="number" class="form-control" id="basicSalary" name="basicSalary" required>
            </div>
            <button type="submit" class="btn btn-primary w-100 py-2">Register</button>
        </form>
        <p class="mt-3">Already registered? <a href="login.jsp">Login here</a></p>
    </div>

</body>
</html>
