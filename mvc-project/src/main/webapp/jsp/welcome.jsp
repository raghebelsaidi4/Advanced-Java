<%--
  Created by IntelliJ IDEA.
  User: Ragheb
  Date: 2/17/2025
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<%@include file="header.jsp"%>
<body>
<%="Welcome: "+session.getAttribute("user")%>
<h1>Welcome To The Java Web App .....</h1>

</body>
<%@include file="footer.jsp"%>
</html>
