<%@ page import="com.ragheb.utility.ServletUtility" %>
<%@ page import="com.ragheb.utility.DataUtility" %><%--
  Created by IntelliJ IDEA.
  User: Ragheb
  Date: 2/17/2025
  Time: 3:22 PM
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Registration</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#datepicker").datepicker({
                dateFormat: 'mm/dd/yy',
                changeMonth: true,
                changeYear: true
            });
        });
    </script>
</head>
<body>

<%@ include file="header.jsp" %>

<main class="login-form">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header text-center font-weight-bold">
                        User Registration
                    </div>

                    <div class="card-body">
                        <h3 style="color: green"><%=ServletUtility.getSuccessMessage(request)%>
                        </h3>
                        <h3 style="color: red"><%=ServletUtility.getErrorMessage(request)%>
                        </h3>
                        <jsp:useBean id="bean" class="com.ragheb.bean.UserBean" scope="request"/>

                        <form action="<%=View.UserController%>" method="post">
                            <input type="hidden" name="id" value="<%=DataUtility.getStringData(bean.getId())%>"/>

                            <!-- First Name -->
                            <div class="form-group row">
                                <label class="col-md-4 col-form-label text-md-right">First Name</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" placeholder="Enter First Name"
                                           name="firstName" value="<%=bean.getFirstName()%>">
                                    <font color="red"></font>
                                </div>
                            </div>

                            <!-- Last Name -->
                            <div class="form-group row">
                                <label class="col-md-4 col-form-label text-md-right">Last Name</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" placeholder="Enter Last Name"
                                           name="lastName" value="<%=bean.getLastName()%>">
                                    <font color="red"></font>
                                </div>
                            </div>

                            <!-- Login ID -->
                            <div class="form-group row">
                                <label class="col-md-4 col-form-label text-md-right">Login ID</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" placeholder="Enter Login ID"
                                           name="login" value="<%=bean.getLogin()%>">
                                    <font color="red"></font>
                                </div>
                            </div>

                            <!-- Password -->
                            <div class="form-group row">
                                <label class="col-md-4 col-form-label text-md-right">Password</label>
                                <div class="col-md-6">
                                    <input type="password" class="form-control" placeholder="Enter Password"
                                           name="password" value="<%=bean.getPassword()%>">
                                    <font color="red"></font>
                                </div>
                            </div>

                            <!-- Date of Birth -->
                            <div class="form-group row">
                                <label class="col-md-4 col-form-label text-md-right">Date of Birth</label>
                                <div class="col-md-6">
                                    <input type="text" id="datepicker" class="form-control"
                                           placeholder="Enter Date of Birth"
                                           name="dob" value="<%=DataUtility.getStringData(bean.getDob())%>">
                                    <font color="red"></font>
                                </div>
                            </div>

                            <!-- Mobile Number -->
                            <div class="form-group row">
                                <label class="col-md-4 col-form-label text-md-right">Mobile No.</label>
                                <div class="col-md-6">
                                    <input type="text" class="form-control" placeholder="Enter Mobile No"
                                           name="mobile" value="<%=bean.getMobileNo()%>">
                                    <font color="red"></font>
                                </div>
                            </div>

                            <!-- Submit Button -->

                            <div class="col-md-6 offset-md-4">
                                <input type="submit" class="btn btn-primary" name="operation" value="Register">
                            </div>

                            <% if (bean.getId() > 0) { %>

                            <div class="col-md-6 offset-md-4">
                                <input type="submit" class="btn btn-primary" name="operation" value="Update">
                            </div>
                            <%} else {%>
                            <div class="col-md-6 offset-md-4">
                                <input type="submit" class="btn btn-primary" name="operation" value="Register">
                            </div>
                            <%} %>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<div style="margin-top: 120px">
    <%@ include file="footer.jsp" %>
</div>

</body>
</html>
