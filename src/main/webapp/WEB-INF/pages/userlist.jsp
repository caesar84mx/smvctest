<%--
 Created by IntelliJ IDEA.
 User: caesar-84
 Date: 2/11/17
 Time: 3:23 PM
 To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
    <style>
        <%@include file='styles/main.css'%>
    </style>
</head>
<body class="general">

<h1>Users list</h1>

<c:if test="${!empty userListOnPage}">
    <table class="tg">
        <tr>
            <th width="80">Id</th>
            <th width="120">Name</th>
            <th width="70">Age</th>
            <th width="70">Admin</th>
            <th width="120">Created</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${userListOnPage}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.admin}</td>
                <td>${user.createdDate}</td>
                <td><a href="<c:url value='/edit/${user.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${user.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${!empty pages}">
        <br/>
        <c:forEach items="${pages}" var="pageNum">
            <a href="<c:url value="/userlist/${pageNum}"/>">${pageNum} </a>
        </c:forEach>
        <br/>
    </c:if>
</c:if>

<br/>
<a href="<c:url value="/users"/>">Add a new user</a>
<br/>
<a href="<c:url value="/finduser"/>">Find a user</a>
<br/>
<a href="<c:url value="../../index.jsp"/>">Back home</a>

</body>
</html>