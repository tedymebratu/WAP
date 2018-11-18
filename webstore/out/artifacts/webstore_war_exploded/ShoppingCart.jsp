<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 11/15/2018
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p><font face="Verdana, Arial, Helvetica, sans-serif"><strong>Shopping Cart</strong></font></p>
<p><a href="/ModelList.jsp" mce_href="ModelList.jsp">Model List</a> </p>
<table width="75%" border="1">
    <tr bgcolor="#CCCCCC">
        <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Model
            Description</font></strong></td>
        <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Quantity</font></strong></td>
        <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Unit
            Price</font></strong></td>
        <td><strong><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Total</font></strong></td>
    </tr>
    <jsp:useBean id="cart" scope="session" class="Model.CartBean" />
    <c:if test="${cart.lineItemCount==0}">
        <tr>
            <td colspan="4"><font size="2" face="Verdana, Arial, Helvetica, sans-serif">- Cart is currently empty -</font><br/>
        </tr>
    </c:if>
    <c:forEach var="cartItem" items="${cart.cartItems}" varStatus="counter">
        <form name="item" method="POST" action="servlet/CartController">
            <tr>
                <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><b><c:out value="${cartItem.partNumber}"/></b><br/>
                    <c:out value="${cartItem.modelDescription}"/></font></td>
                <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif"><input type='hidden' name='itemIndex' value='<c:out value="${counter.count}"/>'><input type='text' name="quantity" value='<c:out value="${cartItem.quantity}"/>' size='2'> <input type="submit" name="action" value="Update">
                    <br/>         <input type="submit" name="action" value="Delete"></font></td>
                <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">$<c:out value="${cartItem.unitCost}"/></font></td>
                <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">$<c:out value="${cartItem.totalCost}"/></font></td>
            </tr>
        </form>
    </c:forEach>
    <tr>
        <td colspan="2"> </td>
        <td> </td>
        <td><font size="2" face="Verdana, Arial, Helvetica, sans-serif">Subtotal: $<c:out value="${cart.orderTotal}"/></font></td>
    </tr>
</table>
</body>
</html>