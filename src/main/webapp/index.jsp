<%--7b. Build a servlet program to create a cookie to get your name through text box and press
submit button to display the message by greeting Welcome back your name ! , you have
visited this page n times ( n = number of your visit ) and demonstrate the expiry of cookie
also. --%>

<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Cookie Management</title>
</head>
<body>

<h2>Cookie Management Form</h2>

<form action="addCookie.jsp" method="post">
    Name: <input type="text" name="name"><br><br>
    Domain: <input type="text" name="domain"><br><br>
    Max Expiry Age (sec): <input type="text" name="maxAge"><br><br>

    <input type="submit" value="Add Cookie">
</form>

</body>
</html>