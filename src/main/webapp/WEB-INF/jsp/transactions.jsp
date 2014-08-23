<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Spring 3 MVC Series - Contact Manager</title>
	<style type="text/css">
		body {
			font-family: sans-serif;
		}
		.data, .data td {
			border-collapse: collapse;
			width: 100%;
			border: 1px solid #aaa;
			margin: 2px;
			padding: 2px;
		}
		.data th {
			font-weight: bold;
			background-color: #5C82FF;
			color: white;
		}
	</style>
</head>
<body>
<div>Wel come <c:out value="${sessionScope.email}"/> | <a href="${contextPath}/signOut">Sign Out</a></div><br/><br/>
Transactions | <a href="${contextPath}/homePage">Place Order</a>
<c:choose>
<c:when test="${!empty transactions}">
 You have not performed a transaction Yet.
<c:when>
<c:otherwise>
<table class="data">
<tr>
  <th>Date and Time</th>
  <th>Total Price</th>
  <th>Pizzas Ordered</th>
  <th>&nbsp;</th>
</tr>
<c:forEach items="${transactions}" var="transaction">
	<tr>
	    <td>${transaction.timestamp}</td>
		<td>${transaction.price}</td>
		<td>
		  <table>
		    <c:forEach items="${transactions.pizzas}" var="pizza">
		        <tr>
		         <td>
		           ${pizza.name}
		             <c:if  test="${!empty pizza.toppings}">
		                <c:forEach items="${pizza.toppings}" var="topping">
		                	+ ${topping.name}
		                </c:forEach>
		             </c:if>
		         </td>
		        </tr>
		    </c:forEach>
		  </table>
		</td>
	</tr>
</c:forEach>
</table>
</c:otherwise>
</c:choose>
</c:if>

</body>
</html>