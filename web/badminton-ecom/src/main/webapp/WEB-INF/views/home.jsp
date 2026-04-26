<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ShuttlePro | Home</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/home.css">
    </head>
    <body>
        <header class="site-header">
            <div class="brand">
                <span class="brand-mark" aria-hidden="true">s</span>
                <span class="brand-name">Smash Mart</span>
            </div>
            <nav class="site-nav">
                <a class="active" href="#">Home</a>
                <a href="#">Products</a>
                <a href="#">About</a>
                <a href="#">Contact</a>
            </nav>
            <div class="site-actions">
                <button class="icon-btn" aria-label="Favorites">Fav</button>
                <button class="icon-btn" aria-label="Cart">Cart</button>
                <button class="primary-outline">Sign In</button>
            </div>
        </header>

        <main class="hero">
            <div class="hero-content">
                <span class="pill">Premium badminton equipment</span>
                <h1>
                    <span class="title-main">Play Like</span>
                    <span class="title-accent">a Pro.</span>
                </h1>
                <p class="hero-body">Discover professional-grade rackets and shuttlecocks engineered for champions. Elevate your game with ShuttlePro's curated collection.</p>
                <div class="hero-actions">
                    <button class="primary-btn">Shop Now</button>
                    <button class="secondary-btn">Explore</button>
                </div>
                <div class="hero-stats">
                    <div>
                        <span class="stat-value">50K+</span>
                        <span class="stat-label">Happy players</span>
                    </div>
                    <div>
                        <span class="stat-value">200+</span>
                        <span class="stat-label">Pro products</span>
                    </div>
                    <div>
                        <span class="stat-value">4.9</span>
                        <span class="stat-label">Avg rating</span>
                    </div>
                </div>
            </div>
            <div class="hero-image" aria-hidden="true"></div>
        </main>
    </body>
</html>
