<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Employee Payroll System</title>

    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">

    <!-- Custom Styles -->
    <style>
        body {
            background: url('https://source.unsplash.com/1600x900/?corporate,office') no-repeat center center/cover;
            font-family: 'Poppins', sans-serif;
        }
        .login-card {
            background: rgba(255, 255, 255, 0.2);
            backdrop-filter: blur(10px);
            border: 1px solid rgba(255, 255, 255, 0.2);
            padding: 30px;
            border-radius: 15px;
            text-align: center;
            width: 100%;
            max-width: 400px;
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
            color: #000 !important; /* Changed labels to black */
            font-weight: 500;
        }
        a {
            color: #000; /* Changed link color for visibility */
            font-weight: 600;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body class="d-flex justify-content-center align-items-center vh-100">

    <div class="login-card shadow-lg bg-white">
        <h2 class="mb-4 fw-bold text-dark">Employee Login</h2>
        <form action="LoginServlet" method="post">
            <div class="mb-3 text-start">
                <label for="email" class="form-label">Email Address</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="mb-3 text-start">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary w-100 py-2">Login</button>
        </form>
        <p class="mt-3">New here? <a href="register.jsp">Register</a></p>
    </div>

</body>
</html>
