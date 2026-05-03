<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>ShuttlePro | Sign In</title>
  
  <!-- Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link href="https://fonts.googleapis.com/css2?family=Cormorant+Garamond:wght@600;700&family=Jost:wght@400;500;600;700&display=swap" rel="stylesheet" />
  
  <!-- CSS -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/base/global.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/pages/login.css" />
  
  <!-- Feather Icons -->
  <script src="https://unpkg.com/feather-icons"></script>
</head>
<body>

  <div class="auth-page">
    <div class="auth-bg"></div>

    <div class="auth-wrapper">
      <div class="auth-logo">
        <a href="${pageContext.request.contextPath}/home" style="text-decoration: none;">
          <div class="logo-icon" style="width: 44px; height: 44px; font-size: 22px; border-radius: 12px;">🏸</div>
          <div class="logo-text" style="font-size: 26px;">Shuttle<span>Pro</span></div>
        </a>
      </div>

      <div class="auth-card">
        <div class="auth-tabs">
          <button type="button" class="auth-tab active" onclick="window.location.href='${pageContext.request.contextPath}/login'">Sign In</button>
          <button type="button" class="auth-tab" onclick="window.location.href='${pageContext.request.contextPath}/register'">Create Account</button>
        </div>

        <div class="auth-form-body">
          <form id="auth-form" action="${pageContext.request.contextPath}/login" method="POST">
            <div class="input-group" id="group-email">
              <label class="form-label">Email Address</label>
              <div class="input-wrapper">
                <i data-feather="mail" class="input-icon"></i>
                <input type="email" name="email" class="input-field" placeholder="your@email.com" required />
              </div>
            </div>

            <div class="input-group" id="group-password">
              <label class="form-label">Password</label>
              <div class="input-wrapper">
                <i data-feather="lock" class="input-icon"></i>
                <input type="password" id="input-password" name="password" class="input-field" placeholder="Enter your password" style="padding-right: 44px;" required />
                <button type="button" class="input-action" onclick="togglePassword('input-password', 'icon-pass')">
                  <i data-feather="eye" id="icon-pass"></i>
                </button>
              </div>
            </div>

            <div class="forgot-password">
              <span>Forgot password?</span>
            </div>

            <button type="submit" class="btn-submit">Sign In</button>
          </form>
        </div>
      </div>

      <p class="auth-footer">
        <span>Don't have an account? </span>
        <button type="button" class="btn-link" onclick="window.location.href='${pageContext.request.contextPath}/register'">Create one</button>
      </p>
    </div>
  </div>

  <script>
    feather.replace();

    function togglePassword(inputId, iconId) {
      const input = document.getElementById(inputId);
      const icon = document.getElementById(iconId);
      
      if (input.type === 'password') {
        input.type = 'text';
        icon.setAttribute('data-feather', 'eye-off');
      } else {
        input.type = 'password';
        icon.setAttribute('data-feather', 'eye');
      }
      feather.replace();
    }
  </script>
</body>
</html>
