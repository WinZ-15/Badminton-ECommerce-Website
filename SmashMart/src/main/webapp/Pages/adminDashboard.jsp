<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Admin Dashboard - SmashMart</title>
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/CSS/adminDashboard.css">
    </head>
    <body>

        <!--NAVBAR -->
        <header class="navbar">
            <div class="container navbar-inner">
                <span class="logo-text"> Smash<span>Mart</span></span>
                <div class="user-info">
                    <a href="${pageContext.request.contextPath}/profile">
                        <strong>${user.name}</strong>
                    </a>
                </div>
                <a href="${pageContext.request.contextPath}/logout"
                   class="nav-btn-logout">
                    Logout
                </a>
            </div>
        </header>

        <!--  MAIN -->
        <main class="dashboard-container">
            <!--  HEADER -->
            <div class="dashboard-header">
                <h1>Admin Dashboard</h1>
                <a href="${pageContext.request.contextPath}/analytics"
                   class="btnprimary">
                    View Analytics
                </a>
            </div>

            <!-- STATS -->
            <div class="stats-grid">
                <div class="stat-card">
                    <h2>${totalUsers}</h2>
                    <p>Total Users</p>
                </div>
                <div class="stat-card">
                    <h2>${totalProducts}</h2>
                    <p>Total Products</p>
                </div>
                <div class="stat-card">
                    <h2>${totalOrders}</h2>
                    <p>Total Orders</p>
                </div>
                <div class="stat-card">
                    <h2>$${totalRevenue}</h2>
                    <p>Total Revenue</p>
                </div>
            </div>

            <!-- ADD PRODUCT -->
            <div class="card">
                <h2>Add Product</h2>
                <c:if test="${not empty error}">
                    <div style="
                         background-color: #ffe6e6;
                         color: #cc0000;
                         padding: 10px;
                         border: 1px solid #cc0000;
                         border-radius: 5px;
                         margin-bottom: 15px;">
                        ${error}
                    </div>
                </c:if>
                <form action="${pageContext.request.contextPath}/AddProduct"
                      method="post"
                      enctype="multipart/form-data"
                      class="product-form">
                    <input type="text" name="name" placeholder="Product Name" required>
                    <input type="text" name="brand" placeholder="Brand" required>
                    <textarea name="description" placeholder="Description"></textarea>
                    <input type="number" step="0.01"
                           name="price"
                           placeholder="Price"
                           required>
                    <input type="file" name="image" required>
                    <select name="categoryID" required>
                        <option value="">-- Category --</option>
                        <c:forEach var="cat" items="${categories}">
                            <option value="${cat.categoryID}">
                                ${cat.categoryName}
                            </option>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn primary">
                        Add Product
                    </button>
                </form>
            </div>

            <!-- ORDERS -->
            <div class="card">
                <h2> Orders</h2>
                <div class="table-wrapper">
                    <table class="product-table">
                        <thead>
                            <tr>
                                <th>Order ID</th>
                                <th>User ID</th>
                                <th>Total</th>
                                <th>Status</th>
                                <th>Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="order" items="${orders}">
                                <tr>
                                    <td>${order.orderID}</td>
                                    <td>${order.userID}</td>
                                    <td>${order.totalAmount}</td>
                                    <td>${order.status}</td>
                                    <td>${order.createdAt}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!--  PRODUCTS -->
            <div class="card">
                <h2 style="margin-bottom: 10px;">All Products</h2>
                <div class="table-wrapper">
                    <table class="product-table">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Brand</th>
                                <th>Price</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="product" items="${products}">
                                <tr>
                                    <td>${product.name}</td>
                                    <td>${product.brand}</td>
                                    <td>$${product.price}</td>
                                    <td>
                                        <div class="actions">
                                            <a class="btnedit" href="${pageContext.request.contextPath}/editProduct?productID=${product.productID}">
                                                Edit
                                            </a>

                                            <form action="${pageContext.request.contextPath}/deleteProduct"
                                                  method="post"
                                                  class="inline-form">
                                                <input type="hidden"
                                                       name="productID"
                                                       value="${product.productID}">
                                                <button class ="btndelete"
                                                        onclick="return confirm('Delete this product?')">
                                                    Delete
                                                </button>
                                            </form>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- Users -->
            <div class="card">
                <h2>All Users</h2>
                <div class="table-wrapper">
                    <table class="product-table">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Role</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="u" items="${users}">
                                <tr>
                                    <td>${u.name}</td>
                                    <td>${u.email}</td>
                                    <td>${u.role}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>

        <!--  FOOTER -->
        <footer class="footer">
            <p>&copy; 2026 SmashMart</p>
        </footer>
    </body>
</html>