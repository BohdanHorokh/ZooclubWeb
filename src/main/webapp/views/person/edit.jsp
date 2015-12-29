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
		<div class="stackedbig">
			<h2>To Edit Person enter id :</h2>
			<form action="editPerson" method="post">
				<div class="field">
					<label for="personId"> Enter a Name of Person</label>
					<select name="id" >
						<c:forEach items="${persons}" var="person">
							<option  value="${person.id}">${person.name}</option>
						</c:forEach>
					</select> 
				</div>
				<div class="field">
					<label for="name">New Name : </label> <input class="text-input"
						type="text" name="name" value="">
				</div>
				<div class="field">
					<label for="age">New Age : </label> <input class="text-input"
						type="text" name="age" value="">
				</div>
				<div class="action clearfix">
					<input type="submit" value="Ok" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>