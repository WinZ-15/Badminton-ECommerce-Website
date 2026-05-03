<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>ShuttlePro</title>
  
  <!-- Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@600;700&family=Jost:wght@400;500;600;700&display=swap" rel="stylesheet" />
  
  <!-- CSS Components -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/base/global.css?v=3" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/header.css?v=3" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/footer.css?v=3" />
  
  <!-- Feather Icons -->
  <script src="https://unpkg.com/feather-icons"></script>
</head>
<body>

  <!-- NAVBAR -->
  <nav class="navbar">
    <div class="nav-container">
      <a href="${pageContext.request.contextPath}/home" class="nav-logo">
        <div class="logo-icon">🏸</div>
        <div class="logo-text">Shuttle<span>Pro</span></div>
      </a>

      <div class="nav-links hidden-mobile">
        <a href="${pageContext.request.contextPath}/home" class="nav-link active">Home</a>
        <a href="#" class="nav-link">Products</a>
        <a href="#" class="nav-link">About</a>
        <a href="#" class="nav-link">Contact</a>
      </div>

      <div class="nav-actions">
        <a href="#" class="action-icon">
          <i data-feather="heart"></i>
          <span class="badge badge-gold">2</span>
        </a>
        <button class="action-icon">
          <i data-feather="shopping-cart"></i>
          <span class="badge badge-green">3</span>
        </button>
        <a href="${pageContext.request.contextPath}/login" class="btn-signin">Sign In</a>
        <button class="mobile-menu-btn">
          <i data-feather="menu"></i>
        </button>
      </div>
    </div>
  </nav>
