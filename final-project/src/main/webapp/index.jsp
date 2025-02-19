<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Home Page</title>
    <style type="text/css">
        .jumbotron-style {
            background-image: url("/images/jumb.jpg");
            background-repeat: no-repeat;
            background-size: cover;
            height: 100%;
            color: white;
        }
    </style>
</head>
<body class="body">
<jsp:include page="/WEB-INF/pages/common/navbar.jsp"/>
<div class="container-fluid p-0">

    <div class="jumbotron jumbotron-fluid jumbotron-style">
        <div class="container">
            <h1 class="display-4"><b>Car Rental Project</b></h1>
            <p class="lead">Project written in JAVA as the Back End & JSP as
                the Front End.</p>
        </div>
    </div>
    <div class="container">
        Java Web Application
    </div>
</div>

</body>
</html>