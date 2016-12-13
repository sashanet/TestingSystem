<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/home.css"> 

</head>
<body>
home
<sec:authentication property="name" />
<br>
<sec:authorize access="hasRole('ROLE_ADMIN')">

	<a href="admin">admin page</a>

</sec:authorize>

<sec:authorize access="isAuthenticated()">

	<form:form action="logout" method="post">
		<button>logout</button>
	</form:form>
	<a href="profile">Profile</a>
</sec:authorize>
<br><br>

<sec:authorize access="!isAuthenticated()">
<a href="loginpage">login</a>
<a href="signUp">sign Up User</a>
</sec:authorize>

<br><br>

<a href="groupsAdd">Add Group</a><br>
<a href="testAdd">Add test</a>
<a href="questionAdd">Add Questions</a>

<br>

You have watched tests : 
<c:forEach var="tests" items="${tests}">
		<div style="background-color: grey">
			${tests.name}
		</div>
		<br>
	</c:forEach>

</body>
</html>