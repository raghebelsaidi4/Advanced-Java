<%@ page import="com.ragheb.utility.ServletUtility" %>
<%@ page import="static com.ragheb.controller.View.LoginController" %><%--
  Created by IntelliJ IDEA.
  User: Ragheb
  Date: 2/17/2025
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<body>
<%@ include file="header.jsp" %>
<main class="login-form">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        Login
                        <h6 style="color: green;"></h6>
                        <h2 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h2>
                        <h2 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h2>
                    </div>
                    <div class="card-body">

                        <form action="<%=View.LoginController%>" method="post">

                            <div class="form-group row">
                                <label for="login" class="col-md-4 col-form-label text-md-right">
                                    Login Id<font color="red">*</font>
                                </label>
                                <div class="col-md-6">
                                    <input type="text" id="login" class="form-control"
                                           placeholder="Enter Login Id" name="login" value="">
                                    <font color="red"></font>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="password" class="col-md-4 col-form-label text-md-right">
                                    Password<font color="red">*</font>
                                </label>
                                <div class="col-md-6">
                                    <input type="password" id="password" class="form-control"
                                           placeholder="Enter Password" name="password" value="">
                                    <font color="red"></font>
                                </div>
                            </div>

                            <div class="col-md-6 offset-md-4">
                                <input type="submit" class="btn btn-primary" name="operation" value="Login">
                                <a href="#" class="btn btn-link"> Forgot Your Password? </a>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<div style="margin-top: 170px">
    <%@ include file="footer.jsp" %>
</div>
