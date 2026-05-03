<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>SmashMart | Welcome</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/home.css">
    </head>
    <body>
        <!-- Navbar -->
        <header class="navbar">
            <div class="logo-container">
                <img src="${pageContext.request.contextPath}/Resources/logo.png" alt="SmashMart Logo" class="logo-img">
                <h1 class="logo-text">SmashMart</h1>
            </div>
            <nav>
                <a href="${pageContext.request.contextPath}/login" class="nav-btn">Login</a>
                <a href="${pageContext.request.contextPath}/register" class="nav-btn">Register</a>
            </nav>
        </header>

        <!-- Hero Section -->
        <section class="hero">
            <h2>Welcome to SmashMart</h2>
            <p>
                SmashMart is your one-stop badminton marketplace.  
                We specialize in premium <strong>badminton rackets</strong> and <strong>shuttlecocks</strong>,  
                designed for players of all levels — from beginners to champions.
            </p>
            <div class="hero-buttons">
                <a href="register.jsp" class="btn">Get Started</a>
            </div>
        </section>

        <!-- Trust Badges -->
        <section class="trust">
            <div class="trust-item">Free Shipping</div>
            <div class="trust-item">2-Year Warranty</div>
            <div class="trust-item">30-Day Returns</div>
            <div class="trust-item">Expert Support</div>
        </section>

        <!-- Testimonials -->
        <section class="testimonials">
            <h2>What Players Say</h2>
            <div class="testi-grid">
                <div class="testi-card">
                    <p>"SmashMart’s rackets gave me unmatched control and power."</p>
                    <span>- Marcus Chen, National Player</span>
                </div>
                <div class="testi-card">
                    <p>"The shuttlecocks are tournament quality and last longer."</p>
                    <span>- Sarah Williams, Club Champion</span>
                </div>
                <div class="testi-card">
                    <p>"I recommend SmashMart to all my students — best value."</p>
                    <span>- David Park, Junior Coach</span>
                </div>
            </div>
        </section>

        <!-- Footer -->
        <footer class="footer">
            <div class="footer-content">
                <p>&copy; 2026 SmashMart. All rights reserved.</p>
            </div>
        </footer>
    </body>
</html>
