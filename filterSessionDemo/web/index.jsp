<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 11/14/2018
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Login</title>
</head>
<body>
<form action="/login" method="post">
  <Label>Username <input type='text' name='username' value="${cookie.user.value}"/></Label><br /><br />
  <Label>Password <input type='password' name='password'/></Label><br /><br />

  <LABEL><input type="checkbox"
                <c:if test="${cookie.containsKey('user')}">checked</c:if>
                name="remember" value="yes">Remember Me</LABEL><br /><br />
  <input type='submit' value='Login'/>
</form>
<span style="color: red">${err_msg}</span>
</body>
</html>



