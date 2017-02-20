<%--
  Created by IntelliJ IDEA.
  User: caesar-84
  Date: 2/10/17
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>User details</title>
    <style>
        <%@include file='styles/main.css'%>
    </style>
</head>
<body class="general">
<h3>User details</h3>

<c:if test="${empty userList}">
    <div>
        The requested user has not been found. Please, <a href="<c:url value="/finduser"/>">try again.</a>
        <br/>
    </div>
</c:if>

<c:if test="${!empty userList}">
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
        <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.admin}</td>
            <td>${user.createdDate}</td>
            <td><a href="<c:url value="/edit/${user.id}"/>">Edit</a></td>
            <td><a href="<c:url value="/remove/${user.id}"/>">Delete</a></td>
        </tr>
        </c:forEach>
    </table>
    <c:if test="${!empty pages}">
        <br/>
        <c:forEach items="${pages}" var="page">
            <a href="<c:url value="/userdata/${page}"/>">${page} </a>
        </c:forEach>
        <br/>
    </c:if>
    <br/>
    <a href="<c:url value="/finduser"/>"> Find another user</a>
</c:if>
<br/>
<a href="<c:url value="/userlist/1"/>">To users list</a>
<br/>
<a href="../../index.jsp">Back home</a>
</body>
</html>
