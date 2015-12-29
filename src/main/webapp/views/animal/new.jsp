<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
		<div class="stacked">
			<h2>Enter Data of new Animal</h2>
			<form action="showAllAnimals" method="post">
				<div class="field">
					<label for="name"> Name</label> 
					<input class="text-input" type="text" name="name" value="">
				</div>
				<div class="field">
					<label for="type"> Type</label> <select name="type">
						<option value='Mouse'>Mouse</option>
						<option value='Turtle'>Turtle</option>
						<option value='Snake'>Snake</option>
						<option value='Dog'>Dog</option>
						<option value='' selected>Select a Type</option>
						<option value='Cat'>Cat</option>
					</select>
				</div>
				<div class="field">
					<label for="personId"> Enter a Name of Person</label>
					<select name="personId" >
						<c:forEach items="${persons}" var="person">
							<option  value="${person.id}">${person.name}</option>
						</c:forEach>
					</select> 
				</div>
				<div class="action clearfix">
					<input type="submit" value="Create Animal"/>
				</div>
			</form>
		</div>
	</div>
</body>
</html>