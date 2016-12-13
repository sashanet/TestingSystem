<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${test.name}  To start Test  ${test.minutes} minutes. 

${test.description}

<button id="start"> start</button>

<div id="timer"></div>

<div id="answerList"></div>




<br>
 Questions :
<br>

  <c:forEach var="question" items="${test.questionsList}">
	${question.name} ${question.question} ${question.points}
	
	

	<br> Answers : <br>
	
	<a href="GiveAnswer"> some</a>
	
	<form action="GiveAnswer" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			 <c:forEach var="answers" items="${question.answers}">
			
			 <input type="radio" value="${answers.id}" name="answerid"> 	${answers.text}<Br>
			</c:forEach> 

	<br>
	
	
		<button>GiveAnswer</button>
	</form>	
	
</c:forEach> 










</body>
</html>