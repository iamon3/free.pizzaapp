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
<h2>Sign up for FREE!!</h2>
<form:form method="post" action="signUp" modelAttribute="user">
    <form:label path="name"><spring:message code="label.name"/></form:label>
    <form:input path="name" placeholder="Username"/>

    <form:label path="password"><spring:message code="label.password"/></form:label>
    <form:password path="password" placeholder="Password"/>

    <form:label path="email"><spring:message code="label.email"/></form:label>
    <form:input path="email" placeholder="user1@free.com" />

    <input type="submit" class="login login-submit" value="<spring:message code="label.signup"/>"/>
</form:form>
<div class="login-help">
Already Registered?  <a href="${contextPath}/signIn">Sign In</a>
</div>
</div>
</body>
</html>