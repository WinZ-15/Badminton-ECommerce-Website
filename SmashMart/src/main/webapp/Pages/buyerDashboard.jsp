<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>SmashMart Buyer Dashboard</title>
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/CSS/buyerDashboard.css">
    </head>
    <body>
        <!--  NAVBAR -->
        <header class="navbar">
            <div class="container navbar-inner">
                <span class="logo-text">Smash<span>Mart</span></span>
                <div class="user-position">
                    <a  class="user-info" href="${pageContext.request.contextPath}/profile">
                        <strong>${user.name}</strong>
                    </a>
                </div>

                <!--   ACTIONS -->
                <nav class="nav-actions">
                    <a href="${pageContext.request.contextPath}/cart"
                       class="nav-btn">
                        Cart (<span id="cart-count">${cartCount}</span>)
                    </a>
                    <a href="${pageContext.request.contextPath}/logout"
                       class="nav-btn">
                        Logout
                    </a>
                </nav>
            </div>
        </header>

        <c:if test="${param.added == '1'}">
            <div class="success-msg" id="addMsg">
                Item added to cart!
            </div>
            <script>
                setTimeout(function () {
                    document.getElementById("addMsg").style.display = "none";
                }, 1000); // 1000 ms = 1 second
            </script>
        </c:if>

        <!--  MAIN -->
        <main class="content">
            <c:if test="${param.success == '1'}">
                <div class="success-msg">
                    Order placed successfully!
                </div>
            </c:if>

            <!--  HERO -->
            <section class="hero compact">
                <div class="container">
                    <div class="hero-copy">
                        <div class="hero-eyebrow">Shop</div>
                        <h1>Browse <span class="accent">Products</span></h1>
                        <p class="hero-sub">
                            Find premium rackets, shuttlecocks and accessories. 
                            Add products to your cart and explore more.
                        </p>
                    </div>
                </div>
            </section>

            <!-- PRODUCTS -->
            <section class="product-list">
                <div class="container">
                    <!-- HEADER -->

                    <div class="section-header">
                        <h2>All Products</h2>
                        <div class="controls">
                            <form action="${pageContext.request.contextPath}/buyerDashboard"
                                  method="get"
                                  class="search-form">

                                <!--  SEARCH -->
                                <input type="text"
                                       name="search"
                                       placeholder="Search products"
                                       value="${param.search}">

                                <!--  FILTER -->
                                <select name="category">
                                    <option value="">All Categories</option>
                                    <c:forEach var="cat" items="${categories}">
                                        <option value="${cat.categoryID}"
                                                <c:if test="${param.category == cat.categoryID}">selected</c:if>>
                                            ${cat.categoryName}
                                        </option>
                                    </c:forEach>
                                </select>
                                <button type="submit" class="btn small">
                                    Filter
                                </button>
                            </form>
                        </div>
                    </div>

                    <!--  GRID -->
                    <div class="products-grid">
                        <c:forEach var="product" items="${products}">
                            <div class="product-card">

                                <!-- IMAGE -->
                                <div class="card-img">
                                    <c:choose>
                                        <c:when test="${not empty product.image}">
                                            <img src="${pageContext.request.contextPath}/${product.image}"
                                                 alt="${product.name}">
                                        </c:when>
                                        <c:otherwise>
                                            <div class="img-placeholder">No Image</div>
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                                <!-- BODY -->
                                <div class="card-body">
                                    <div clzss="brand">${product.brand}</div>
                                    <h3 class="card-name">${product.name}</h3>
                                    <p class="card-desc">
                                        ${product.description}
                                    </p>

                                    <!-- FOOTER -->
                                    <div class="card-footer">
                                        <div class="price">
                                            $${product.price}
                                        </div>
                                        <div class="actions">

                                            <!-- ADD TO CART -->
                                            <form action="${pageContext.request.contextPath}/addProductCart"
                                                  method="post"
                                                  class="inline-form">

                                                <input type="hidden"
                                                       name="productID"
                                                       value="${product.productID}">

                                                <input type="number"
                                                       name="qty"
                                                       value="1"
                                                       min="1"
                                                       class="qty-input">

                                                <button type="submit"
                                                        class="btn small primary">
                                                    Add
                                                </button>
                                            </form>

                                            <!-- DETAILS -->
                                            <a href="${pageContext.request.contextPath}/productDetail?productID=${product.productID}"
                                               class="btn small primary" style="text-decoration: none;">
                                                Details
                                            </a>

                                        </div>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>
                    </div>

                    <!--  EMPTY STATE -->
                    <c:if test="${empty products}">
                        <p class="muted">No products found.</p>
                    </c:if>
                </div>
            </section>
        </main>

        <!-- FOOTER -->
        <footer class="site-footer">
            <div class="container footer-inner">
                <div class="footer-logo">
                    Smash<span>Mart</span>
                </div>
                <p>&copy; 2026 SmashMart. All rights reserved.</p>
            </div>
        </footer>

    </body>
</html>