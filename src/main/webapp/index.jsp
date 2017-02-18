<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: caesar-84
  Date: 2/10/17
  Time: 10:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Manager Test App by caesar_84</title>
    <style>
        <%@include file='WEB-INF/pages/styles/main.css'%>
    </style>
</head>
<body class="general">
<h3>User Manager</h3>
<br/>
<a href="<c:url value="/finduser"/>">Find a user</a>
<br/>
<a href="<c:url value="/users"/>">Add a new user</a>
<br/>
<a href="<c:url value="/userlist/1"/>">See all users</a>
</body>
</html>
