<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="javax.servlet.http.Cookie" %>

<html>
<head>
    <title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null && cookies.length > 0) {
%>
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Value</th>
            </tr>

<%
        for (Cookie c : cookies) {
%>
            <tr>
                <td><%= c.getName() %></td>
                <td><%= c.getValue() %></td>
            </tr>
<%
        }
%>
        </table>
<%
    } else {
%>
        <h3>No Cookies Found!</h3>
<%
    }
%>

<br><br>
<a href="index.jsp">Add Another Cookie</a>

</body>
</html>