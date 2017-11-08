<%--
  Created by IntelliJ IDEA.
  User: avmelnyk
  Date: 11/8/17
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Junto</title>
</head>
<body>
<form:form name="addUser" action="/user"  method="POST"  modelAttribute="user" acceptCharset="UTF-8">
    <p>
        <form:label path="username">Username</form:label>
        <form:input path="username"/>
    </p>
    <p>
        <form:label path="password">Password</form:label>
        <form:input path="password" type= "password"/>
    </p>
    <p>
        <form:label path="firstName">Firstname</form:label>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Lastname</form:label>
        <form:input path="lastName"/>
    </p>
    <p>
        <form:label path="email">Email</form:label>
        <form:input path="email"/>
    </p>

    <td colspan="2"><input type="submit" value="add user" class="btn"></td>
    </div>
</form:form>
</body>
</html>
