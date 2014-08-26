<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Hurry Up!! Order Free Pizza.</title>
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

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1>Hurry Up!! Pizza is ready.</h1><br/><br/>
<h2>Sign In</h2>
<c:if test="${not empty notFound}">
   <label color="red"><font color="red"> ERROR : </font>User not found. Either you have not signed up or entered invalid email / password</label><br/><br/>
</c:if>
<form:form method="post" action="signIn" modelAttribute="user">

	<table>
	<tr>
		<td><form:label path="email"><spring:message code="label.email"/></form:label></td>
		<td><form:input path="email" /></td>
	</tr>
	<tr>
		<td><form:label path="password"><spring:message code="label.password"/></form:label></td>
		<td><form:password path="password" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="<spring:message code="label.signin"/>"/>
		</td>
	</tr>
</table>
</form:form>

Not a member?  <a href="${contextPath}/signUp">Register Here</a>

</body>
</html>