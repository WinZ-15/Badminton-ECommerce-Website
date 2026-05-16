<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Product Details</title>
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/CSS/productDetails.css">
    </head>
    <body>
        <header class="navbar">
            <div class="container">
                <h2>Product Details</h2>
                <a href="${pageContext.request.contextPath}/buyerDashboard">Back</a>
            </div>
        </header>

        <main class="container">
            <div class="product-detail-card">
                <div class="product-img">
                    <img src="${pageContext.request.contextPath}/${product.image}" 
                         alt="${product.name}">
                </div>
                <div class="product-info">
                    <h2>${product.name}</h2>
                    <p class="brand">${product.brand}</p>
                    <p class="description">
                        ${product.description}
                    </p>
                    <p class="price">$${product.price}</p>

                    <!-- Add to cart -->
                    <form action="
                          ${pageContext.request.contextPath}/addProductCart"
                          method="post">
                        <input type="hidden" name="productID" value="${product.productID}">
                        <input type="hidden" name="qty" value="1">
                        <button class="btn primary">Add to Cart</button>
                    </form>
                        
                    <a href="${pageContext.request.contextPath}/buyerDashboard" class="btn secondary">
                        Back
                    </a>
                        
                </div>
            </div>
        </main>
    </body>
</html>
