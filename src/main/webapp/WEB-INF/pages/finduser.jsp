<%--
  Created by IntelliJ IDEA.
  User: caesar-84
  Date: 2/11/17
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Find User</title>
    <style>
        <%@include file='styles/main.css'%>
    </style>
</head>
<body class="general">

<h3>Find a user</h3>

<c:url var="findAction" value="passnameparam"/>
<form:form action="${findAction}" commandName="nameParam">
    <table>
        <tr>
            <td>
                <form:label path="value">
                    <spring:message text="Enter user name to find him"/>
                </form:label>
            </td>
            <td>
                <form:input path="value"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message text="Find"/>"/>
            </td>
        </tr>
    </table>
</form:form>
<br/>
<a href="<c:url value="/userlist/1"/>">See all users</a>
<br/>
<a href="../../index.jsp">Back home</a>
</body>
</html>
