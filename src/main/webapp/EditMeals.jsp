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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
   Create Meal
   <jsp:useBean id="meal" scope="request" type="ru.javawebinar.topjava.model.UserMeal"/>
    <form method="post" action="meals">
        <input name="id" type="hidden" value="${meal.id}">
        <dl>
            <dt>Date Time: </dt>
            <dd><input type="datetime-local" value="${meal.dateTime}" name="dateTime"></dd>
        </dl>
        <dl>
            <dt>Description: </dt>
            <dd><input type="text" value="${meal.description}" name="description"></dd>
        </dl>
        <dl>
            <dt>Calories: </dt>
            <dd><input type="number" value="${meal.calories}" name="calories"></dd>
        </dl>
        <button type="submit">Save</button>

    </form>
</body>
</html>
