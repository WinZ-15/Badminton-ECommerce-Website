<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Product - SmashMart</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/sellerDashboard.css">
</head>

<body>

<!-- Navbar (same as dashboard) -->
<header class="navbar">
    <div class="container navbar-inner">
        <a href="sellerDashboard" class="logo">
            <img src="${pageContext.request.contextPath}/Resources/logo.png" class="logo-img" alt="logo">
            <span class="logo-text">Smash<span>Mart</span></span>
        </a>

        <nav class="nav-actions">
            <a href="sellerDashboard" class="nav-btn">Back</a>
            <a href="logout" class="nav-btn">Logout</a>
        </nav>
    </div>
</header>

<main class="content">

    <!-- Hero -->
    <section class="hero compact">
        <div class="container">
            <div class="hero-copy">
                <div class="hero-eyebrow">Edit Product</div>
                <h1>Update <span class="accent">Details</span></h1>
                <p class="hero-sub">Modify product information and save changes.</p>
            </div>
        </div>
    </section>

    <!-- Edit Form -->
    <section class="seller-dashboard">
        <div class="container" style="display:flex; justify-content:center;">

            <div class="card" style="width: 500px;">

                <h2>Edit Product</h2>

                <form action="updateProduct" method="post" class="product-form">

                    <!-- hidden ID -->
                    <input type="hidden" name="product_ID" value="${product.productID}">

                    <label>Product Name</label>
                    <input type="text" name="name" value="${product.name}" required>

                    <label>Brand</label>
                    <input type="text" name="brand" value="${product.brand}" required>

                    <label>Description</label>
                    <textarea name="description">${product.description}</textarea>

                    <label>Price</label>
                    <input type="number" name="price" value="${product.price}" step="0.01" required>

                    <button type="submit" class="btn primary" style="margin-top:15px;">
                        Save Changes
                    </button>

                </form>

            </div>

        </div>
    </section>

</main>

<!-- Footer -->
<footer class="site-footer">
    <div class="container footer-inner">
        <div class="footer-logo">Smash<span>Mart</span></div>
        <p>&copy; 2026 SmashMart. All rights reserved.</p>
    </div>
</footer>

</body>
</html>