<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <meta charset="UTF-8">
	<title>Hurry Up!! Order Free Pizza.</title>
	<link rel="stylesheet" href="${contextPath}/resources/css/login-style.css" media="screen" type="text/css" />
</head>
<body>
<br/><br/>
<div class="login-card">
<!--h1>Hurry Up!! Pizza is ready.</h1-->
<h2>Sign In</h2>
<c:if test="${not empty notFound}">
   <label color="red"><font color="red"> ERROR : </font>User not found. Either you have not signed up or entered invalid email / password</label><br/><br/>
</c:if>

<form:form method="post" action="signIn" modelAttribute="user">
    <form:input path="email" placeholder="Email"/>
    <form:password path="password" placeholder="Password"/>
    <input type="submit" class="login login-submit" value="<spring:message code="label.signin"/>"/>
</form:form>

<div class="login-help">
Not a member?  <a href="${contextPath}/signUp">Register Here</a>
</div>
</div>
</body>
</html>