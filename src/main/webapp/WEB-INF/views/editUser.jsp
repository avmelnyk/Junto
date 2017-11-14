<%--
  Created by IntelliJ IDEA.
  User: avmelnyk
  Date: 11/14/17
  Time: 11:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Junto</title>
</head>
<body>
    <form:form name = "editUser" action="/user/${user.userID}" modelAttribute ="user" method="POST" acceptCharset="UTF-8" >
        <table>
            <tr>
                <td>
                    <form:input path = "userID" value = "${user.userID}" type = "hidden"></form:input>
                    <form:label path = "username">Username</form:label>
                    <form:input path = "username" value = "${user.username}"></form:input>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path = "firstName">Firstname</form:label>
                    <form:input path = "firstName" value = "${user.firstName}"></form:input>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path = "lastName">Lastname</form:label>
                    <form:input path = "lastName" value = "${user.lastName}"></form:input>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path = "email" >Email</form:label>
                    <form:input path = "email" value = "${user.email}"></form:input>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Edit User" class="btn">
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
