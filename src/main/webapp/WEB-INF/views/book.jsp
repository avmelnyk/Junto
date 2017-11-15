<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: avmelnyk
  Date: 11/5/17
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Junto</title>
</head>
<body>
    <h1> Book name: ${book.name} </h1>
    <h2> Author: ${book.author}</h2>
    <h2> ISBN: ${book.ISBN}</h2>
    <h2> Genre: ${book.genre} </h2>
    <h2> Rating: </h2>
        <table>
            <th>Owners:</th>
            <c:forEach var="owner" items="${book.owners}">
                <tr>
                    <td><a href="/user/${owner.userID}"><c:out value="${owner.firstName} ${owner.lastName}"/></a></td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>
