<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>

<head>
	<title>User Home Page</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/menu.css" media="screen" type="text/css" />
    <script type="text/javascript" src="${contextPath}/resources/js/menu.js">
    </script>
</head>

<body>
<div>Wel come <c:out value="${sessionScope.email}"/> | <a href="${contextPath}/signOut">Sign Out</a></div><br/><br/>
<div id="myDiv">
<h2>Menu. Just a moment. Loading ....</h2>
</div>
<input id="pa" type="hidden" name="pa" value="${pizzasAPI}">
<input id="ta" type="hidden" name="ta" value="${toppingsAPI}">
<input id="trn" type="hidden" name="trn" value="${contextPath}/transactions">
<script>
loadDoc();
</script>
</body>
</html>