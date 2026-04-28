<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Check Session</title>
</head>
<body>

<%
    String user = (String) session.getAttribute("user");

    if (user != null) {
%>
        <h2 style="color:blue;">Hello <%= user %>! Your session is still active.</h2>
        <p>Try refreshing after some time to test expiry.</p>
<%
    } else {
%>
        <h2 style="color:red;">Session expired! Please login again.</h2>
        <a href="index.jsp">Go Back</a>
<%
    }
%>

</body>
</html>