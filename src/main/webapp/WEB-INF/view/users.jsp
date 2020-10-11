<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MSI GF63
  Date: 10.10.2020
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users List</title>
</head>
<body>
<div align="center">
    <h1>Users List</h1>
    <h3>
        <a href="userForm.jsp">Add User</a>
    </h3>
    <table border="1">

        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>

        <c:forEach var="user" items="${userList}">
            <tr>

                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td><a href="${pageContext.request.contextPath}/users/delete?id=${user.id}">Delete</a>
                <a href="${pageContext.request.contextPath}/users/update_user?id=${user.id}">Update</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
