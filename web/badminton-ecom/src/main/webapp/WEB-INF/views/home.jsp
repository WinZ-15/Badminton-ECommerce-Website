<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ShuttlePro | Home</title>
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/css/home.css"
    />
  </head>
  <body>
    <header class="site-header">
      <div class="brand">
        <span class="brand-mark" aria-hidden="true">p</span>
        <span class="brand-name">Smash Mart</span>
      </div>
      <nav class="site-nav">
        <a class="active" href="#">Home</a>
        <a href="#">Products</a>
        3
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
        <p class="hero-body">
          Discover professional-grade rackets and shuttlecocks engineered for
          champions. Elevate your game with ShuttlePro's curated collection.
        </p>
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
      <img
        class="hero-image"
        src="${pageContext.request.contextPath}/assets/images/hero-image.jpg"
        alt="Badminton court"
      />
    </main>

    <section class="features">
      <div class="feature-card">
        <span class="feature-icon">Q</span>
        <h3>Premium Quality</h3>
        <p>Handpicked professional-grade equipment from top manufacturers.</p>
      </div>
      <div class="feature-card">
        <span class="feature-icon">T</span>
        <h3>Trusted by Pros</h3>
        <p>Equipment used by champions in international tournaments.</p>
      </div>
      <div class="feature-card">
        <span class="feature-icon">F</span>
        <h3>Fast Delivery</h3>
        <p>Quick and secure shipping to get you playing faster.</p>
      </div>
    </section>

    <section class="featured">
      <div class="section-title">
        <h2>Featured <span>Products</span></h2>
        <p>Discover our most popular professional-grade gear.</p>
      </div>
      <div class="product-grid">
        <article class="product-card">
          <div class="product-image"></div>
          <span class="product-tag">Racket</span>
          <h3>Pro Carbon X1</h3>
          <p>Professional carbon fiber racket for advanced players.</p>
          <div class="product-row">
            <span class="product-price">$149.99</span>
            <button class="primary-outline">View Details</button>
          </div>
        </article>
        <article class="product-card">
          <div class="product-image"></div>
          <span class="product-tag">Shuttlecock</span>
          <h3>Elite Feather Shuttles</h3>
          <p>Premium goose feather shuttlecocks (12 pack).</p>
          <div class="product-row">
            <span class="product-price">$24.99</span>
            <button class="primary-outline">View Details</button>
          </div>
        </article>
        <article class="product-card">
          <div class="product-image"></div>
          <span class="product-tag">Racket</span>
          <h3>Thunder Strike Pro</h3>
          <p>High-tension racket for powerful smashes.</p>
          <div class="product-row">
            <span class="product-price">$179.99</span>
            <button class="primary-outline">View Details</button>
          </div>
        </article>
      </div>
      <div class="view-all">
        <button class="secondary-btn">View All Products</button>
      </div>
    </section>
  </body>
</html>
