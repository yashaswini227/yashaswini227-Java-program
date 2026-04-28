<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Result</title>
</head>
<body>

<h2>Student Result</h2>

<%
    String roll = (String) request.getAttribute("roll");
    String name = (String) request.getAttribute("name");

    int sub1 = (Integer) request.getAttribute("sub1");
    int sub2 = (Integer) request.getAttribute("sub2");
    int sub3 = (Integer) request.getAttribute("sub3");
    int sub4 = (Integer) request.getAttribute("sub4");
    int sub5 = (Integer) request.getAttribute("sub5");

    int total = sub1 + sub2 + sub3 + sub4 + sub5;
    double avg = total / 5.0;

    boolean pass = (sub1 >= 40 && sub2 >= 40 && sub3 >= 40 && sub4 >= 40 && sub5 >= 40);
%>

Roll No: <%= roll %> <br>
Name: <%= name %> <br><br>

Marks:<br>
Sub1: <%= sub1 %><br>
Sub2: <%= sub2 %><br>
Sub3: <%= sub3 %><br>
Sub4: <%= sub4 %><br>
Sub5: <%= sub5 %><br><br>

Average: <%= avg %> <br>

Result: 
<b style="color:<%= pass ? "green" : "red" %>;">
    <%= pass ? "PASS" : "FAIL" %>
</b>

<br><br>
<a href="index.jsp">Go Back</a>

</body>
</html>