<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login - SmashMart</title>
        <link rel="stylesheet" href="./CSS/Start.css">
    </head>
    <body>
        <header>
            <nav class="navbar">
                <div class="logo-container">
                    <a class="logo-text" href="${pageContext.request.contextPath}/home">  
                        <h1>
                            Smash<span style="color: #2563eb;">Mart</span>
                        </h1>
                    </a>
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
                    <c:if test="${not empty error}">
                        <div class="error-message">
                            <h2 style="color:red">${error}</h2>
                        </div>
                    </c:if>
                    <button type="submit" class="auth-btn">Login</button>
                    <p class="switch">Dont have an account? <a href="${pageContext.request.contextPath}/register">Register</a></p>
                </form>

            </section>
        </main>

        <footer>
            <p>&copy; 2026 SmashMart. All rights reserved.</p>
        </footer>
    </body>
</html>