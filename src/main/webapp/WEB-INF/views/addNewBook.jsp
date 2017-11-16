<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: avmelnyk
  Date: 11/16/17
  Time: 1:51 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Junto</title>
</head>
<body>
        <table>
            <form:form action="/user/${user.userID}/book" method="POST" modelAttribute="book" acceptCharset="UTF-8">
                <tr>
                    <td><form:label path="name">Name:</form:label>
                        <form:input path="name" type="text"></form:input>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="author">Author:</form:label>
                        <form:input path="author" type="text" ></form:input>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="ISBN">ISBN:</form:label>
                        <form:input path="ISBN" type="text" ></form:input>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="genre">Genre:</form:label>
                        <form:input path="genre" type="text" ></form:input>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="add Book" class="btn">
                    </td>
                </tr>
            </form:form>
        </table>
</body>
</html>
