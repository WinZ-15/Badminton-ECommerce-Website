<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>User Profile</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/profile.css">
    </head>

    <body>
        <header class="navbar">
            <div class="container">
                <h2>Profile</h2>
                <div class="navbar-inner">
                    Welcome, ${user.name}
                    <a class="btnback" href="${pageContext.request.contextPath}/buyerDashboard">
                        Back
                    </a>
                </div>
            </div>
        </header>

        <main class="container">
            <div class="card">
                <h2>User Details</h2>
                <p><strong>Name:</strong> ${user.name}</p>
                <p><strong>Email:</strong> ${user.email}</p>
                <p><strong>Role:</strong> ${user.role}</p>
                <p><strong>Address:</strong> ${user.address}</p>
                <p><strong>Contact:</strong> ${user.phone}</p>
            </div>

            <form action="${pageContext.request.contextPath}/editProfile" method="get">
                <button type="submit" class="btn">Edit Profile</button>
            </form>

        </main>

    </body>
</html>
