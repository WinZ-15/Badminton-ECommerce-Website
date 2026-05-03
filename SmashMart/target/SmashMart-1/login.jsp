<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login - SmashMart</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/auth.css">
    </head>
    <body>
        <header>
            <nav class="navbar">
                <div class="logo-container">
                    <img src="${pageContext.request.contextPath}/Resources/logo.png" alt="SmashMart Logo" class="logo-img">
                    <h1 class="logo-text">SmashMart</h1>
                </div>
            </nav>
        </header>

        <main class="auth-container">
            <section class="auth-card">
                <h2>Welcome Back!</h2>
                <p class="subtitle">Login to your account</p>
                <form action="${pageContext.request.contextPath}/login" method="post">
                    <div class="form-group">
                        <label>Email</label>
                      <input type="email" name="email" placeholder="Enter your email" required>

                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" name="password" placeholder="Enter your password" required>
                    </div>
                    <button type="submit" class="auth-btn">Login</button>
                    <p class="switch">Don?t have an account? <a href="${pageContext.request.contextPath}/register">Register</a></p>
                </form>
            </section>
        </main>

        <footer>
            <p>&copy; 2026 SmashMart. All rights reserved.</p>
        </footer>
    </body>
</html>