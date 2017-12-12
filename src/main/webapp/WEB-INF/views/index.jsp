<%--
  Created by IntelliJ IDEA.
  User: avmelnyk
  Date: 11/1/17
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hello World!</h1>
    <c:choose>
        <c:when test="${pageContext.request.userPrincipal.authenticated}">

                <form action="/logout" id="logout" method="post">
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}" />
                    <button type="submit" name=submit" value="logout" class="btn-link">Log out</button>
                </form>
                <a href="/books">Books</a>
        </c:when>
        <c:otherwise>
            <a href="/login">Log in</a>
        </c:otherwise>
    </c:choose>

</body>
</html>
