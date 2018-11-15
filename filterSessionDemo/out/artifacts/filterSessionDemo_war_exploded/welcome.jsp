<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 11/14/2018
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h2>Welcome </h2>
<%= request.getSession().getAttribute("username") %>

<br />
<br />
<form action="/login" method="post">
    <input type="submit" value="Logout">
</form>

</body>
</html>
