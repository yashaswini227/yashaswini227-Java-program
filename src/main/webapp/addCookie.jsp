<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page import="javax.servlet.http.Cookie" %>

<html>
<head>
    <title>Add Cookie</title>
</head>
<body>

<%
    String name = request.getParameter("name");
    String domain = request.getParameter("domain");
    String maxAgeStr = request.getParameter("maxAge");

    if (name == null || name.isEmpty() ||
        domain == null || domain.isEmpty() ||
        maxAgeStr == null || maxAgeStr.isEmpty()) {
%>
        <h3 style="color:red;">All fields are required!</h3>
        <a href="index.jsp">Go Back</a>
<%
    } else {
        int maxAge = 0;

        try {
            maxAge = Integer.parseInt(maxAgeStr);

            // Create cookie
            Cookie cookie = new Cookie(name, domain);
            cookie.setMaxAge(maxAge);
            cookie.setPath("/");

            response.addCookie(cookie);
%>

            <h2 style="color:green;">Cookie Added Successfully!</h2>

            <h3>Cookie Details:</h3>
            Name: <%= name %> <br>
            Domain(Value): <%= domain %> <br>
            Max Age: <%= maxAge %> seconds <br><br>

            <a href="viewCookies.jsp">Go to Active Cookie List</a>

<%
        } catch (NumberFormatException e) {
%>
            <h3 style="color:red;">Invalid Max Age!</h3>
            <a href="index.jsp">Go Back</a>
<%
        }
    }
%>

</body>
</html>