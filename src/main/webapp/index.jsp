<%--9.c Build a Session Management using JSP program for getting  session expiry time and 
your name through text box and press submit to display the message by greeting Hello your name!.
press the following link to check it within  the set session time  or wait there for the minutes set  to see the session expiry.
 --%>


<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Session Management</title>
</head>
<body>

<h2>Session Management Form</h2>

<form action="setSession.jsp" method="post">
    Enter Your Name:
    <input type="text" name="username"><br><br>

    Session Expiry Time (in minutes):
    <input type="text" name="time"><br><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>