<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>SmashMart | Welcome</title>
        <link rel="stylesheet" href="./CSS/home.css">
    </head>
    <body>

        <!-- ✅ NAVBAR -->
        <header class="navbar">
            <div class="container nav-container">
                <div class="logo">SmashMart</div>
                <div class =" nav-mid">  
                    <a href="Pages/about.html">About</a>
                    <a href="Pages/contact.html">Contact</a>
                </div>
                <div class="nav-right">
                    <a href="${pageContext.request.contextPath}/login" class="nav-log">Login</a>
                    <a href="${pageContext.request.contextPath}/register" class="nav-btn">Register</a>
                </div>
            </div>
        </header>

        <!-- ✅ HERO -->
        <section class="hero">
            <div class="container hero-content">

                <div class="hero-text">
                    <h1>Elevate Your Badminton Game</h1>
                    <p>
                        Discover premium rackets and shuttlecocks designed for performance,
                        precision, and durability.
                    </p>

                    <div class="hero-buttons">
                        <a href="${pageContext.request.contextPath}/register" class="btn primary">Get Started</a>
                    </div>
                </div>
            </div>
        </section>

        <!-- ✅ TRUST -->
        <section class="trust">
            <div class="container trust-grid">
                <div> Free Shipping</div>
                <div>Warranty</div>
                <div>Easy Returns</div>
                <div>Support</div>
            </div>
        </section>

        <!-- ✅ PRODUCTS -->
        <section class="products container">
            <div class="section-header">
                <h2>Featured Products</h2>
                <span>Top picks for you</span>
            </div>

            <div class="product-grid">
                <div class="product-card">
                    <img src="${pageContext.request.contextPath}/Resources/racket1.jpg">
                    <h3>Carbon Pro Racket</h3>
                    <p class="price">$89.99</p>
                    <button>Add to Cart</button>
                </div>

                <div class="product-card">
                    <img src="${pageContext.request.contextPath}/Resources/racket2.jpg">
                    <h3>Elite Tournament Racket</h3>
                    <p class="price">$129.99</p>
                    <button>Add to Cart</button>
                </div>

                <div class="product-card">
                    <img src="${pageContext.request.contextPath}/Resources/shuttle.jpg">
                    <h3>Feather Shuttlecock</h3>
                    <p class="price">$24.99</p>
                    <button>Add to Cart</button>
                </div>

            </div>
        </section>

        <!-- ✅ CATEGORIES -->
        <section class="categories">
            <div class="container">
                <h2>Shop by Category</h2>

                <div class="category-grid">
                    <div class="category-card">Rackets</div>
                    <div class="category-card">Shuttlecocks</div>
                    <div class="category-card">Accessories</div>
                </div>
            </div>
        </section>

        <!-- ✅ TESTIMONIALS -->
        <section class="testimonials container">
            <h2>What Players Say</h2>

            <div class="testi-grid">
                <div class="testi-card">
                    <p>"Amazing control and power!"</p>
                    <span>- National Player</span>
                </div>

                <div class="testi-card">
                    <p>"High quality and reliable."</p>
                    <span>- Club Champion</span>
                </div>

                <div class="testi-card">
                    <p>"Best for training players."</p>
                    <span>- Coach</span>
                </div>
            </div>
        </section>

        <!-- ✅ CTA -->
        <section class="cta">
            <div class="container">
                <h2>Upgrade Your Game Today</h2>
                <p>Join SmashMart and experience professional performance.</p>
            </div>
        </section>

        <!-- ✅ FOOTER -->
        <footer class="footer">
            <div class="container footer-grid">
                <div>
                    <h3>SmashMart</h3>
                    <p>Your trusted badminton marketplace.</p>
                </div>
                <br>
            </div>

            <div class="footer-bottom">
                © 2026 SmashMart
            </div>
        </footer>

    </body>
</html>
