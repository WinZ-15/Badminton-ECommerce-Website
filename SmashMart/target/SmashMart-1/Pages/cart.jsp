<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cart.css">
</head>

<body>
<header class="navbar">
    <div class="container">
        <h2>🛒 Your Cart</h2>
    </div>
</header>
<main class="container">

    <!-- ✅ EMPTY -->
    <c:if test="${empty cartItems}">
        <p class="empty">Your cart is empty.</p>
        <a href="${pageContext.request.contextPath}/buyerDashboard" class="btn">
            ← Continue Shopping
        </a>
    </c:if>

    <!-- ✅ CART ITEMS -->
    <c:if test="${not empty cartItems}">
        <table class="cart-table">
            <thead>
                <tr>
                    <th>Product</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="item" items="${cartItems}">
                    <tr>
                        <td>
                            <img src="${pageContext.request.contextPath}/${item.image}" 
                                     alt="${item.name}" width="60">
                        </td>
                        <td>${item.name}</td>
                        <td>$${item.price}</td>
                        <td>${item.quantity}</td>
                        <td>$${item.price * item.quantity}</td>

                        <td>
                            <!--  REMOVE -->
                            <form action="${pageContext.request.contextPath}/removeCartItem"
                                  method="post">
                                <input type="hidden" name="product_ID"
                                       value="${item.productID}">
                                <button type="submit" class="btn danger"  
                                        onclick="return confirm('Remove this item?')">
                                    Remove
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!--  TOTAL + CHECKOUT -->
        <div class="cart-total">
            <h3>Total: $${cartTotal}</h3>
            
            <form action="${pageContext.request.contextPath}/CheckOut"
                  method="post">
                <button class="btn primary">Checkout</button>
            </form>
        </div>

        <!-- ✅BACK -->
        <a href="${pageContext.request.contextPath}/buyerDashboard"
           class="btn">
            Continue Shopping
        </a>
    </c:if>
</main>
</body>
</html>