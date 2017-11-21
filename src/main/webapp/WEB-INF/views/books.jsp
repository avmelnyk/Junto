<%--
  Created by IntelliJ IDEA.
  User: avmelnyk
  Date: 11/5/17
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Junto</title>
</head>
<body>
    <h1>Books</h1>
    <table>
    <c:forEach var="book"  items="${bookList}">
        <tr>
            <td><a href="/book/${book.bookID}"><c:out value="${book.name}"/></a></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.genre}"/></td>
            <td><c:out value="${book.ISBN}"/></td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
