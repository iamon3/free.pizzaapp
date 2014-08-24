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
			width: 50%;
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
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div>Wel come <c:out value="${sessionScope.email}"/> | <a href="${contextPath}/signOut">Sign Out</a></div><br/><br/>
Transactions | <a href="${contextPath}/homePage">Place Order</a><br/></br>
<c:choose>
<c:when test="${empty transactions}">
 You have not performed a transaction yet.
</c:when>
<c:otherwise>
<table class="data">
<tr>
  <th>Date and Time</th>
  <th>Pizzas Ordered</th>
  <th>Total Price</th>
</tr>
<c:forEach items="${transactions}" var="transaction">
	<tr>
	    <td>${transaction.timestamp}</td>
		<td>
		  <table>
		    <c:forEach items="${transaction.pizzas}" var="pizza">
		        <tr>
		         <td>
		           <b>${pizza.name} Pizza</b>
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
        <td>${transaction.price}</td>
	</tr>
</c:forEach>
</table>
</c:otherwise>
</c:choose>
</body>
</html>