<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>SmashMart Buyer Dashboard</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/buyerDashboard.css">
</head>
<body>
  <header class="navbar">
    <div class="container navbar-inner">
      <a href="home.jsp" class="logo">
        <img src="${pageContext.request.contextPath}/Resources/logo.png" alt="logo" class="logo-img">
        <span class="logo-text">Smash<span>Mart</span></span>
      </a>
      <nav class="nav-actions">
        <a href="cart.jsp" class="nav-btn">Cart (<span id="cart-count">${cartCount}</span>)</a>
        <a href="logout" class="nav-btn">Logout</a>
      </nav>
    </div>
  </header>

  <main class="content">
    <section class="hero compact">
      <div class="container">
        <div class="hero-copy">
          <div class="hero-eyebrow">Shop</div>
          <h1>Browse <span class="accent">Products</span></h1>
          <p class="hero-sub">Find premium rackets, shuttlecocks and accessories. Click a product for details and add to cart.</p>
        </div>
      </div>
    </section>

    <section class="product-list">
      <div class="container">
        <div class="section-header">
          <h2>All Products</h2>
          <div class="controls">
            <form action="BuyerProductServlet" method="get" class="search-form">
              <input type="text" name="q" placeholder="Search products" value="${param.q}">
              <button type="submit" class="btn small">Search</button>
            </form>
          </div>
        </div>

        <div class="products-grid">
          <c:forEach var="product" items="${products}">
            <div class="product-card">
              <div class="card-img">
                <c:choose>
                  <c:when test="${not empty product.image}">
                    <img src="${product.image}" alt="${product.name}">
                  </c:when>
                  <c:otherwise>
                    <div class="img-placeholder">No Image</div>
                  </c:otherwise>
                </c:choose>
              </div>
              <div class="card-body">
                <div class="brand">${product.brand}</div>
                <h3 class="card-name">${product.name}</h3>
                <p class="card-desc">${product.description}</p>
                <div class="card-footer">
                  <div class="price">$${product.price}</div>
                  <div class="actions">
                    <form action="AddToCartServlet" method="post" class="inline-form">
                      <input type="hidden" name="product_ID" value="${product.productID}">
                      <input type="number" name="qty" value="1" min="1" class="qty-input">
                      <button type="submit" class="btn small primary">Add</button>
                    </form>
                    <a href="ProductDetailServlet?product_ID=${product.productID}" class="btn small">Details</a>
                  </div>
                </div>
              </div>
            </div>
          </c:forEach>
        </div>

        <c:if test="${empty products}">
          <p class="muted">No products found.</p>
        </c:if>
      </div>
    </section>
  </main>

  <footer class="site-footer">
    <div class="container footer-inner">
      <div class="footer-logo">Smash<span>Mart</span></div>
      <p>&copy; 2026 SmashMart. All rights reserved.</p>
    </div>
  </footer>
</body>
</html>
