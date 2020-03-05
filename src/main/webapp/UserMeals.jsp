<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--
  Created by IntelliJ IDEA.
  User: voland
  Date: 28.02.2020
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
    <title>Meal</title>
    <style>
        .normal {color: green;}
        .exceeded {color: red;}
    </style>
</head>
<body>
<a href="meals?action=create">Add meal</a>
<table border="1">
    <c:forEach items="${mealList}" var="meals">
        <jsp:useBean id="meals" scope="page" type="ru.javawebinar.topjava.to.UserMealWithExceed"/>
        <tr class="${meals.exceeded ? 'exceeded':'normal'}">
            <td>${meals.id}</td>
            <td><%=TimeUtil.toString(meals.getDateTime())%></td>
            <td>${meals.calories}</td>
            <td>${meals.description}</td>
            <td><a href="meals?action=delete&id=${meals.id}">Delete</a></td>
            <td><a href="meals?action=update&id=${meals.id}">Update</a></td>
        </tr>


    </c:forEach>
</table>

</body>
</html>
