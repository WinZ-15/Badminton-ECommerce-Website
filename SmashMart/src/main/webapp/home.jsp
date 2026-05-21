<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>SmashMart | Welcome</title>
        <link rel="stylesheet" href="./CSS/home.css">
    </head>
    <body>

        <header class="navbar">
            <div class="container nav-container">
                <h2>
                    Smash<span style="color: #2563eb;">Mart</span>
                </h2>
                <div class ="nav-mid">  
                    <a href="Pages/about.html">About</a>
                    <a href="Pages/contact.html">Contact</a>
                </div>
                <div class="nav-right">
                    <a href="${pageContext.request.contextPath}/login" class="nav-log">Login</a>
                    <a href="${pageContext.request.contextPath}/register" class="nav-btn">Register</a>
                </div>
            </div>
        </header>

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

        <!--  TRUST/ SPECIALITY -->
        <section class="trust">
            <div class="container trust-grid">
                <div> Free Shipping</div>
                <div>Warranty</div>
                <div>Easy Returns</div>
                <div>Support</div>
            </div>
        </section>

        <!--  PRODUCTS IMAGE SHOW -->
        <section class="products container">
            <div class="section-header">
                <h2>Featured Products</h2>
                <span>Top picks for you</span>
            </div>
            <div class="product-grid">
                <div class="product-card">
                    <img src="${pageContext.request.contextPath}/Resources/home1.jpeg">
                    <h3>Carbon Pro Racket</h3>
                    <p class="price">$89.99</p>
                    <button onclick="showPopup()">Add to Cart</button>
                </div>
                <div class="product-card">
                    <img src="${pageContext.request.contextPath}/Resources/home2.jpeg">
                    <h3>Elite Tournament Racket</h3>
                    <p class="price">$129.99</p>
                    <button onclick="showPopup()">Add to Cart</button>
                </div>
                <div class="product-card">
                    <img src="${pageContext.request.contextPath}/Resources/home3.jpeg">
                    <h3>Feather Shuttlecock</h3>
                    <p class="price">$24.99</p>
                    <button onclick="showPopup()">Add to Cart</button>
                </div>
            </div>
        </section>

        <!--  CATEGORIES/ PRODUCT TYPE-->
        <section class="categories">
            <div class="container">
                <h2>Shop by Category</h2>

                <div class="category-grid">
                    <div class="category-card">Rackets</div>
                    <div class="category-card">Shuttlecocks</div>
                </div>
            </div>
        </section>

        <!--  Review PART/ FEEDBACK -->
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

        <!-- SECTION BOTTOM -->
        <section class="cta">
            <div class="container">
                <h2>Upgrade Your Game Today</h2>
                <p>Join SmashMart and experience professional performance.</p>
            </div>
        </section>

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

        <div id="popup" class="popup-bg">
            <div class="popup">
                <span class="icon"><img src="${pageContext.request.contextPath}/Resources/warning.png"></span>
                <h3>Login Required</h3>
                <p>Please login first to add items to cart</p>

                <div class="popup-buttons">
                    <button class="btn-login" id="loginBtn">Login</button>
                    <button class="btn-cancel" id="closeBtn">Cancel</button>
                </div>
            </div>
        </div>
        <script>
            const popup = document.getElementById("popup");
            const closeBtn = document.getElementById("closeBtn");
            const loginBtn = document.getElementById("loginBtn");

            function showPopup() {
                popup.style.display = "flex";
            }

            //  for pop up close
            closeBtn.onclick = () => {
                popup.style.display = "none";
            };

            // go to login page after button click
            loginBtn.onclick = () => {
                window.location.href = "${pageContext.request.contextPath}/login";
            };

            // function for clciking outside to close
            window.onclick = (e) => {
                if (e.target === popup) {
                    popup.style.display = "none";
                }
            };
        </script>
    </body>
</html>
