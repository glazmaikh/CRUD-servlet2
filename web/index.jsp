<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/19/2021
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@page session="false" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

    <form method="post" action="/">
      <input type="hidden" name="id" value="-1"/>
      <div>name:
        <input type="text" name="name" placeholder="name">
      </div>
      <div>surname:
        <input type="text" name="surname" placeholder="surname">
      </div>
      <div>age:
        <input type="text" name="age" placeholder="age">
      </div>
      <div>email:
        <input type="text" name="email" placeholder="email">
      </div>
      <button type="submit" name="action" value="add">add</button>
    </form>

    <div>
    <c:forEach var="user" items="${users}">
      <p>
      <form method="post" action="/">
        <c:out value="${user.id}"/>
        <c:out value="${user.name}"/>
        <c:out value="${user.surname}"/>
        <c:out value="${user.age}"/>
        <c:out value="${user.email}"/>
        <input type="hidden" name="userId" value="${user.id}"/>
      </form>
      </p>
    </c:forEach>
    </div>

  </body>
</html>
