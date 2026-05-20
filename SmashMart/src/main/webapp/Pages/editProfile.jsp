<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Profile</title>
<link rel="stylesheet" 
      href="${pageContext.request.contextPath}/CSS/editProfile.css">

</head>
<body> 
<div class="form-container">
<h2>Edit Profile</h2>

<form action="${pageContext.request.contextPath}/editProfile" method="post">
    <label>Name:</label>
    <input type="text" name="name" value="${user.name}" required><br>

    <label>Email:</label>
    <input type="email" value="${user.email}" disabled><br>

    <label>Address:</label>
    <input type="text" name="address" value="${user.address}" ><br>

    <label>Contact:</label>
    <input type="text" name="phone" value="${user.phone}" disabled><br>

    <label>Password:</label>
    <input type="password" name="password" placeholder="Leave blank to keep same"><br>

    <button type="submit">Update</button>
</form>
</div>
</body>
</html>
