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
			<h2>Enter Data of new Person</h2>
			<form action="showAllPersons" method="post">
				<div class="field">
					<label for="name"> Name</label> <input class="text-input"
						type="text" name="name" value="">
				</div>
				<div class="field">
					<label for="age"> Age:</label> <input class="text-input"
						type="text" name="age" value="">
				</div>
				<div class="field">
					<label for="zooclubId"> Zooclub</label>
					<select name="zooclubId">
						<c:forEach items="${zooclubs}" var="zooclub">
							<option  value="${zooclub.id}">${zooclub.name}</option>
						</c:forEach>
					</select> 
				</div>
				<div class="action clearfix">
					<input type="submit" value="Create Person" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>