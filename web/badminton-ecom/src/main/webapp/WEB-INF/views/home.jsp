<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="partials/header.jsp" />

<!-- Page Specific CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/pages/home.css?v=3" />

  <!-- HERO SECTION -->
  <section class="hero">
    <div class="hero-bg" style="background-image: url('https://images.unsplash.com/photo-1613918431551-b2ef2720387c?w=1200&q=80')"></div>
    <div class="hero-overlay"></div>
    <div class="hero-accent-line"></div>
    
    <div class="hero-container">
      <div class="hero-content">
        <div class="hero-badge">
          <i data-feather="award" width="13" height="13"></i>
          <span>Premium Badminton Equipment</span>
        </div>
        <h1 class="hero-title">
          Play Like<br /><span>a Pro.</span>
        </h1>
        <p class="hero-desc">
          Discover professional-grade rackets and shuttlecocks engineered for champions.
          Elevate your game with ShuttlePro's curated collection.
        </p>
        <div class="hero-buttons">
          <a href="#" class="btn-primary">Shop Now <i data-feather="arrow-right" width="16" height="16"></i></a>
          <a href="#" class="btn-secondary">Explore <i data-feather="chevron-right" width="16" height="16"></i></a>
        </div>
      </div>
    </div>

    <div class="hero-stats">
      <div class="stat-item">
        <div class="stat-value">50K+</div>
        <div class="stat-label">Happy Players</div>
      </div>
      <div class="stat-item">
        <div class="stat-value">200+</div>
        <div class="stat-label">Pro Products</div>
      </div>
      <div class="stat-item">
        <div class="stat-value">4.9★</div>
        <div class="stat-label">Avg Rating</div>
      </div>
    </div>
  </section>

  <!-- TRUST BADGES -->
  <section class="trust-badges">
    <div class="trust-container">
      <div class="trust-item">
        <div class="trust-icon"><i data-feather="truck"></i></div>
        <div class="trust-info">
          <div class="trust-title">Free Shipping</div>
          <div class="trust-sub">Orders over $100</div>
        </div>
      </div>
      <div class="trust-item">
        <div class="trust-icon"><i data-feather="shield"></i></div>
        <div class="trust-info">
          <div class="trust-title">2-Year Warranty</div>
          <div class="trust-sub">On all rackets</div>
        </div>
      </div>
      <div class="trust-item">
        <div class="trust-icon"><i data-feather="rotate-ccw"></i></div>
        <div class="trust-info">
          <div class="trust-title">30-Day Returns</div>
          <div class="trust-sub">Hassle-free</div>
        </div>
      </div>
      <div class="trust-item" style="border-right: none;">
        <div class="trust-icon"><i data-feather="zap"></i></div>
        <div class="trust-info">
          <div class="trust-title">Expert Support</div>
          <div class="trust-sub">7 days a week</div>
        </div>
      </div>
    </div>
  </section>

  <!-- CATEGORIES -->
  <section class="categories">
    <div class="section-header">
      <span class="section-subtitle">Shop by Category</span>
      <h2 class="section-title">Our Collections</h2>
      <p class="section-desc">From tournament-grade rackets to premium feather shuttlecocks</p>
    </div>

    <div class="category-grid">
      <!-- Rackets -->
      <a href="#" class="category-card">
        <div class="cat-img" style="background-image: url('https://images.unsplash.com/photo-1586768402600-714186e09479?w=800')"></div>
        <div class="cat-overlay"></div>
        <div class="cat-content">
          <span class="cat-badge badge-green">Rackets</span>
          <h3 class="cat-title">Premium Rackets</h3>
          <p class="cat-desc">Tournament-grade frames for every playing style</p>
          <div class="cat-link">Explore Collection <i data-feather="arrow-right" width="14" height="14"></i></div>
        </div>
      </a>
      
      <!-- Shuttlecocks -->
      <a href="#" class="category-card">
        <div class="cat-img" style="background-image: url('https://images.unsplash.com/photo-1625480859555-1e8c10bad7c5?w=800')"></div>
        <div class="cat-overlay"></div>
        <div class="cat-content">
          <span class="cat-badge badge-gold">Shuttlecocks</span>
          <h3 class="cat-title">Pro Shuttlecocks</h3>
          <p class="cat-desc">Feather & nylon for every court condition</p>
          <div class="cat-link">Explore Collection <i data-feather="arrow-right" width="14" height="14"></i></div>
        </div>
      </a>
    </div>
  </section>

  <!-- FEATURED PRODUCTS -->
  <section class="featured-products">
    <div class="featured-container">
      <div class="featured-header-row">
        <div>
          <span class="section-subtitle">Handpicked For You</span>
          <h2 class="section-title" style="margin-bottom: 0;">Featured Products</h2>
        </div>
        <div class="tabs">
          <button class="tab-btn active">All</button>
          <button class="tab-btn">Rackets</button>
          <button class="tab-btn">Shuttlecocks</button>
        </div>
      </div>

      <div class="product-grid">
        <!-- Product 1 -->
        <div class="product-card">
          <div class="prod-img-wrap">
            <img src="https://images.unsplash.com/photo-1622279457486-62dcc4a431d6?w=600" alt="Product 1" class="prod-img" />
            <div class="prod-badge badge-new">New</div>
            <button class="prod-wishlist">❤️</button>
          </div>
          <div class="prod-info">
            <div class="prod-meta">
              <span class="prod-type type-racket">🏸 Racket</span>
              <div class="prod-rating"><i data-feather="star" width="11" height="11"></i> 4.9 (124)</div>
            </div>
            <h3 class="prod-name">AeroPro Strike 99</h3>
            <p class="prod-desc">Advanced offensive frame with carbon nanotube technology for explosive power...</p>
            <div class="prod-footer">
              <div class="prod-price-box">
                <span class="prod-price">$189.99</span>
                <span class="prod-original-price">$220.00</span>
              </div>
              <button class="btn-add-cart">Add to Cart</button>
            </div>
          </div>
        </div>

        <!-- Product 2 -->
        <div class="product-card">
          <div class="prod-img-wrap">
            <img src="https://images.unsplash.com/photo-1549471013-3364d7220b75?w=600" alt="Product 2" class="prod-img" />
            <button class="prod-wishlist">🤍</button>
          </div>
          <div class="prod-info">
            <div class="prod-meta">
              <span class="prod-type type-shuttlecock">🪶 Shuttlecock</span>
              <div class="prod-rating"><i data-feather="star" width="11" height="11"></i> 4.8 (89)</div>
            </div>
            <h3 class="prod-name">FeatherFlight AS-50</h3>
            <p class="prod-desc">Premium goose feather shuttlecocks optimized for international tournaments...</p>
            <div class="prod-footer">
              <div class="prod-price-box">
                <span class="prod-price">$34.50</span>
              </div>
              <button class="btn-add-cart">Add to Cart</button>
            </div>
          </div>
        </div>

        <!-- Product 3 -->
        <div class="product-card">
          <div class="prod-img-wrap">
            <img src="https://images.unsplash.com/photo-1613918431631-f103b41d227b?w=600" alt="Product 3" class="prod-img" />
            <div class="prod-badge badge-sale">Sale</div>
            <button class="prod-wishlist">🤍</button>
          </div>
          <div class="prod-info">
            <div class="prod-meta">
              <span class="prod-type type-racket">🏸 Racket</span>
              <div class="prod-rating"><i data-feather="star" width="11" height="11"></i> 4.7 (56)</div>
            </div>
            <h3 class="prod-name">SpeedX Light 100</h3>
            <p class="prod-desc">Ultra-lightweight design for rapid defensive maneuvers and front-court dominance...</p>
            <div class="prod-footer">
              <div class="prod-price-box">
                <span class="prod-price">$145.00</span>
                <span class="prod-original-price">$180.00</span>
              </div>
              <button class="btn-add-cart">Add to Cart</button>
            </div>
          </div>
        </div>

        <!-- Product 4 -->
        <div class="product-card">
          <div class="prod-img-wrap">
            <img src="https://images.unsplash.com/photo-1579952363873-27f3bade9f55?w=600" alt="Product 4" class="prod-img" />
            <button class="prod-wishlist">❤️</button>
          </div>
          <div class="prod-info">
            <div class="prod-meta">
              <span class="prod-type type-shuttlecock">🪶 Shuttlecock</span>
              <div class="prod-rating"><i data-feather="star" width="11" height="11"></i> 4.9 (210)</div>
            </div>
            <h3 class="prod-name">NylonPro Tour 6</h3>
            <p class="prod-desc">Highly durable nylon shuttlecocks perfect for training and recreational play...</p>
            <div class="prod-footer">
              <div class="prod-price-box">
                <span class="prod-price">$18.99</span>
              </div>
              <button class="btn-add-cart">Add to Cart</button>
            </div>
          </div>
        </div>
      </div>

      <div style="text-align: center; margin-top: 48px;">
        <a href="#" class="btn-view-all">View All Products <i data-feather="arrow-right" width="15" height="15"></i></a>
      </div>
    </div>
  </section>

  <!-- BRAND STORY -->
  <section class="brand-story">
    <div class="story-container">
      <div class="story-content">
        <span class="section-subtitle">Our Story</span>
        <h2 class="story-title">Born from the Court,<br /><span>Built for Champions.</span></h2>
        <p class="story-desc">
          ShuttlePro was founded by former national players who knew what elite equipment truly means.
          Every product in our collection is tested on professional courts and approved by coaches at the highest level.
        </p>
        <a href="#" class="story-link">Read Our Story <i data-feather="arrow-right" width="14" height="14"></i></a>
      </div>
      <div class="story-images">
        <img src="https://images.unsplash.com/photo-1613918431551-b2ef2720387c?w=400" alt="Badminton" class="story-img-1" />
        <img src="https://images.unsplash.com/photo-1775993167393-f2add1f8eec2?w=400" alt="Training" class="story-img-2" />
      </div>
    </div>
  </section>

  <!-- TESTIMONIALS -->
  <section class="testimonials">
    <div class="testi-container">
      <div class="section-header">
        <span class="section-subtitle">What Players Say</span>
        <h2 class="section-title">Trusted by Champions</h2>
      </div>
      
      <div class="testi-grid">
        <div class="testi-card">
          <div class="testi-stars">
            <i data-feather="star" width="14" height="14"></i><i data-feather="star" width="14" height="14"></i><i data-feather="star" width="14" height="14"></i><i data-feather="star" width="14" height="14"></i><i data-feather="star" width="14" height="14"></i>
          </div>
          <p class="testi-review">"ShuttlePro's equipment has completely transformed my game. The control and power balance is simply unmatched at this price point."</p>
          <div class="testi-user">
            <div class="testi-avatar">MC</div>
            <div class="testi-info">
              <div class="testi-name">Marcus Chen</div>
              <div class="testi-role">National Team Player</div>
            </div>
          </div>
          <div class="testi-quote-mark">"</div>
        </div>

        <div class="testi-card">
          <div class="testi-stars">
            <i data-feather="star" width="14" height="14"></i><i data-feather="star" width="14" height="14"></i><i data-feather="star" width="14" height="14"></i><i data-feather="star" width="14" height="14"></i><i data-feather="star" width="14" height="14"></i>
          </div>
          <p class="testi-review">"The AS-50 feather shuttlecocks are tournament quality. Consistent flight, excellent durability — worth every penny."</p>
          <div class="testi-user">
            <div class="testi-avatar">SW</div>
            <div class="testi-info">
              <div class="testi-name">Sarah Williams</div>
              <div class="testi-role">Club Champion</div>
            </div>
          </div>
          <div class="testi-quote-mark">"</div>
        </div>

        <div class="testi-card">
          <div class="testi-stars">
            <i data-feather="star" width="14" height="14"></i><i data-feather="star" width="14" height="14"></i><i data-feather="star" width="14" height="14"></i><i data-feather="star" width="14" height="14"></i><i data-feather="star" width="14" height="14"></i>
          </div>
          <p class="testi-review">"I recommend ShuttlePro to all my students. The quality, pricing, and support are simply the best I've experienced in 15 years."</p>
          <div class="testi-user">
            <div class="testi-avatar">DP</div>
            <div class="testi-info">
              <div class="testi-name">David Park</div>
              <div class="testi-role">Junior Coach</div>
            </div>
          </div>
          <div class="testi-quote-mark">"</div>
        </div>
      </div>
    </div>
  </section>

  <!-- CTA BANNER -->
  <section class="cta-banner">
    <div class="cta-bg" style="background-image: url('https://images.unsplash.com/photo-1613918702390-48771f69c133?w=1400')"></div>
    <div class="cta-overlay"></div>
    <div class="cta-content">
      <span class="cta-subtitle">Limited Time Offer</span>
      <h2 class="cta-title">Up to 20% Off<br />Premium Rackets</h2>
      <p class="cta-desc">Don't miss your chance to own professional-grade equipment at exceptional prices. Limited stock available.</p>
      <a href="#" class="btn-cta">Shop the Sale <i data-feather="arrow-right" width="15" height="15"></i></a>
    </div>
  </section>

<jsp:include page="partials/footer.jsp" />
