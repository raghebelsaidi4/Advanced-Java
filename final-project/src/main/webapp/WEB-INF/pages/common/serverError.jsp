<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Server Error</title>
    <style type="text/css">
        .error-container {
            background-image: url("/images/500.png");
            background-repeat: round;
            background-size: cover;
            color: white;
        }
    </style>
</head>
<body>
<jsp:include
        page="${pageContext.request.contextPath}/WEB-INF/pages/common/navbar.jsp"/>

<div
        class="container-fluid d-flex align-items-center justify-content-center h-100 bg-success error-container">
    <div class="alert alert-warning" role="alert">
        <h1>It is better to Contact the Administration.</h1>
    </div>
</div>
</body>
</html>
