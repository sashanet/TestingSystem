<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
     
     

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="js/jquery-3.1.1.min.js"></script>

<link rel="stylesheet" href="css/home.css"> 
</head>
<body>
<h1>add Answers</h1>


<form:form modelAttribute="answer" action="saveAnswer" method="post">
<form:input path="text" placeholder ="name"/><br>
correct ?<form:checkbox path="correct" value="true"/><br>
<form:select path="question">

			<c:forEach var="questions" items="${questions}">
	
			<option value="${questions.id}">${questions.name}</option>

	</c:forEach>
</form:select> 

<button>Save</button>
</form:form>


<div id="error"></div>
<input type="text" id="nameAnswer"><br>

correct ? 

<select id="cor">
<option value="false">false</option>
<option value="true">correct</option>
</select>
<br>
<select id="idQuestion">
	<c:forEach var="questions" items="${questions}">
	
			<option value="${questions.id}">${questions.name}</option>

	</c:forEach>
</select>



<button id="save">save country</button>

<div id="allCountries"></div>
<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />

<script src="js/answer.js"></script>


</body>
</html>