<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Session Created</title>
</head>
<body>

<%
    String name = request.getParameter("username");
    String timeStr = request.getParameter("time");

    if (name == null || name.isEmpty() || timeStr == null || timeStr.isEmpty()) {
%>
        <h3 style="color:red;">All fields are required!</h3>
        <a href="index.jsp">Go Back</a>
<%
    } else {
        try {
            int minutes = Integer.parseInt(timeStr);

            if (minutes <= 0) {
%>
                <h3 style="color:red;">Enter valid time (greater than 0)</h3>
                <a href="index.jsp">Go Back</a>
<%
            } else {
                // 🔴 Convert minutes → seconds
                int seconds = minutes * 60;

                // Create session
                session.setAttribute("user", name);

                // Set session expiry
                session.setMaxInactiveInterval(seconds);
%>

                <h2 style="color:green;">Hello <%= name %>!</h2>
                <h3>Session will expire in <%= minutes %> minute(s).</h3>

                <a href="checkSession.jsp">Click here to check session</a>

<%
            }
        } catch (NumberFormatException e) {
%>
            <h3 style="color:red;">Invalid time value!</h3>
            <a href="index.jsp">Go Back</a>
<%
        }
    }
%>

</body>
</html>