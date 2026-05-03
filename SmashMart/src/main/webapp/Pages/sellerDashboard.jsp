<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>SmashMart Seller Dashboard</title>
    
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/sellerDashboard.css">
    </head>
    <body>
        <header class="navbar">
            <div class="container navbar-inner">
                <a href="home.jsp" class="logo">
                    <img src="${pageContext.request.contextPath}/Resources/logo.png" alt="logo" class="logo-img">
                    <span class="logo-text">Smash<span>Mart</span></span>
                </a>
                <nav class="nav-actions">
                    <a href="logout" class="nav-btn">Logout</a>
                </nav>
            </div>
        </header>

        <main class="content">
            <section class="hero compact">
                <div class="container">
                    <div class="hero-copy">
                        <div class="hero-eyebrow">Dashboard</div>
                        <h1>Manage <span class="accent">Products</span></h1>
                        <p class="hero-sub">Add new items, update details, and track your sales analytics.</p>
                    </div>
                </div>
            </section>

            <section class="seller-dashboard">
                <div class="container two-column">
                    <!-- Left column: Product management -->
                    <div class="left-col">
                        <div class="card">
                            <h2>Add Product</h2>
                            <form action="addProduct" method="post" class="product-form" enctype="multipart/form-data">
                                <input type="text" name="name" placeholder="Product Name" required>
                                <input type="text" name="brand" placeholder="Brand" required>
                                <textarea name="description" placeholder="Description"></textarea>
                                <input type="number" name="price" placeholder="Price" step="0.01" required>
                                <input type="file" name="image" accept="image/*" required>
                                <select name="category_ID" required>
                                    <option value="">-- Select Category --</option>
                                    <c:forEach var="cat" items="${categories}">
                                        <option value="${cat.categoryID}">
                                            ${cat.categoryName}
                                        </option>
                                    </c:forEach>
                                </select>
                                <button type="submit" class="btn primary">Add Product</button>
                            </form>
                        </div>

                        <div class="card">
                            <h2>Your Products</h2>
                            <table class="product-table">
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Brand</th>
                                        <th>Price</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="product" items="${products}">
                                        <tr>
                                            <td>${product.name}</td>
                                            <td>${product.brand}</td>
                                            <td>$${product.price}</td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/editProduct?product_ID=${product.productID}">
                                                    Edit
                                                </a>


                                                <!-- Delete -->
                                                <form action="deleteProduct" method="post" class="inline-form">
                                                    <input type="hidden" name="product_ID" value="${product.productID}">
                                                    <button type="submit" class="btn small danger">Delete</button>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>

                   
                    <div class="right-col">
                        <div class="analytics-stack">
                            <div class="analytics-box">
                                <h3>This Week</h3>
                                <p><strong>${weeklySales}</strong></p>
                            </div>
                            <div class="analytics-box">
                                <h3>This Month</h3>
                                <p><strong>${monthlySales}</strong></p>
                            </div>
                            <div class="analytics-box">
                                <h3>This Year</h3>
                                <p><strong>${yearlySales}</strong></p>
                            </div>
                            <div class="analytics-box">
                                <h3>Total Sales</h3>
                                <p><strong>${totalSales}</strong></p>
                            </div>
                        </div>
                    </div>
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
