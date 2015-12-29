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
			<h2>Enter Data of new Zookeeper</h2>
			<form action="showAllZookeepers" method="post">
				<div class="field">
					<label for="firstName"> First Name</label> <input
						class="text-input" type="text" name="firstName" value="">
				</div>
				<div class="field">
					<label for="lastName"> Last Name</label> <input class="text-input"
						type="text" name="lastName" value="">
				</div>
				<div class="field">
					<label for="animalId[]"> Animal ID</label> 
					<c:forEach items="${animals}" var="animal">
					<input type="checkbox" name="animalId[]" value="${animal.id}">${animal.name}
						</c:forEach>
				</div>
				<div class="action clearfix">
					<input type="submit" value="Create Zookeeper" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>