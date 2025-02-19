<%@ page import="java.util.List" %>
<%@ page import="com.ragheb.utility.ServletUtility" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.ragheb.bean.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: Ragheb
  Date: 2/17/2025
  Time: 9:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp" %>
<%=ServletUtility.getSuccessMessage(request) %>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">FName</th>
        <th scope="col">LName</th>
        <th scope="col">Login</th>
        <%--        <th scope="col">Password</th>--%>
        <th scope="col">MobileNo</th>
        <th scope="col">DOB</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <%
        int index = 1;
        List list = ServletUtility.getList(request);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            UserBean user = (UserBean) iterator.next();
    %>
    <tbody>
    <tr>
        <th scope="row"><%=user.getId()%>
        </th>
        <td><%=user.getFirstName()%>
        </td>
        <td><%=user.getLastName()%>
        </td>
        <td><%=user.getLogin()%>
        </td>
        <td><%=user.getMobileNo()%>
        </td>
        <td><%=user.getDob()%>
        </td>
        <td><a href="UserController?id=<%=user.getId()%>">Edit</a></td>
        <td><a href="UserListController?id=<%=user.getId()%>">Delete</a></td>

    </tr>
    <% }%>
    </tbody>
</table>
<%@ include file="footer.jsp" %>