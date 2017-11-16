<%--
  Created by IntelliJ IDEA.
  User: avmelnyk
  Date: 11/5/17
  Time: 10:22 PM
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
    <h2>Username: ${user.username} </h2>
    <a href="/edituser/${user.userID}">Edit</a>
    <h3> ${user.firstName} ${user.lastName}</h3>
    <h3>Email: ${user.email}</h3>
    <h3>Books</h3>
    <a href="/user/${user.userID}/book">add new book</a>
    <table>
        <th>Name</th>
        <th>Author</th>
        <th>Genre</th>
        <th>ISBN</th>
        <c:forEach var="book"  items="${user.bookList}">
            <tr>
                <td><c:out value="${book.name}"/></td>
                <td><c:out value="${book.author}"/></td>
                <td><c:out value="${book.genre}"/></td>
                <td><c:out value="${book.ISBN}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
