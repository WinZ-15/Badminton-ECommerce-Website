<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - SmashMart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/auth.css">
</head>
<body>

<header>
    <nav class="navbar">
        <div class="logo-container">
            <img src="${pageContext.request.contextPath}/Resources/logo.png" class="logo-img">
            <h1 class="logo-text">SmashMart</h1>
        </div>
    </nav>
</header>

<main class="auth-container">
    <section class="auth-card">

        <h2>Create Account</h2>
        <p class="subtitle">Join SmashMart today!</p>

        <form action="${pageContext.request.contextPath}/register" method="post">

            <div class="form-group">
                <label>Full Name</label>
                <input type="text" name="fullName" placeholder="Enter your full name" required>
            </div>

            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" placeholder="Enter your email" required>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" placeholder="Create a password" required>
            </div>

            <div class="form-group">
                <label>Confirm Password</label>
                <input type="password" name="confirmPassword" placeholder="Confirm your password" required>
            </div>

            <button type="submit" class="auth-btn">Register</button>

            <p class="switch">
                Already have an account?
                <a href="${pageContext.request.contextPath}/login">Login</a>
            </p>

        </form>

    </section>
</main>

<footer>
    <p>&copy; 2026 SmashMart. All rights reserved.</p>
</footer>

</body>
</html>