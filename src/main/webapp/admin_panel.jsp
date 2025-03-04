<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel - Update Employee</title>

    <!-- Bootstrap for styling -->
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
        .admin-card {
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
        .alert {
            display: none;
        }
    </style>
</head>
<body class="d-flex justify-content-center align-items-center vh-100">

    <div class="admin-card shadow-lg bg-white">
        <h2 class="mb-4 fw-bold text-dark">Update Employee Details</h2>

        <!-- Success / Error Alert Messages -->
        <div id="success-alert" class="alert alert-success">✅ Employee details updated successfully!</div>
        <div id="error-alert" class="alert alert-danger">❌ Update failed. Please try again.</div>

        <form action="AdminPanelServlet" method="post">
            <div class="mb-3 text-start">
                <label class="form-label">Employee ID</label>
                <input type="number" class="form-control" name="employeeId" required>
            </div>
            <div class="mb-3 text-start">
                <label class="form-label">Leaves Allowed</label>
                <input type="number" class="form-control" name="leavesAllowed" required>
            </div>
            <div class="mb-3 text-start">
                <label class="form-label">Leaves Taken</label>
                <input type="number" class="form-control" name="leavesTaken" required>
            </div>
            <div class="mb-3 text-start">
                <label class="form-label">Bonus</label>
                <input type="number" step="0.01" class="form-control" name="bonus" required>
            </div>
            <button type="submit" class="btn btn-primary w-100 py-2">Update</button>
        </form>

        <a href="admin_dashboard.jsp" class="btn btn-secondary mt-3">Back to Dashboard</a>
    </div>

    <!-- Show success or error message dynamically -->
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const urlParams = new URLSearchParams(window.location.search);
            if (urlParams.get("status") === "success") {
                document.getElementById("success-alert").style.display = "block";
                setTimeout(() => window.location.href = "admin_panel.jsp", 2000);
            } else if (urlParams.get("status") === "failed") {
                document.getElementById("error-alert").style.display = "block";
            }
        });
    </script>

</body>
</html>
