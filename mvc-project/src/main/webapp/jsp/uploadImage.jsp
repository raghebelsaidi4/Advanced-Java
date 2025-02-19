<%--
  Created by IntelliJ IDEA.
  User: Ragheb
  Date: 2/17/2025
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Upload Image</title>
</head>
<%@ include file="header.jsp"%>

<body>
<form action="<%=View.UploadImageController%>" method="post" enctype="multipart/form-data">
    Select Image to Upload:<input type="file" name="photo">
    <br>
    <input type="submit" value="Upload">
</form>
</body>
<%@include file="footer.jsp"%>
</html>