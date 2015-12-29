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
			<h2>Edit Zookeeper enter id  :</h2>
			<form action="editZookeeper" method="post">
				<div class="field">
					<label for="id">Choose Name of Zookeeper</label>
					<select name="id" >
						<c:forEach items="${zookeepers}" var="zookeeper">
							<option  value="${zookeeper.id}">${zookeeper.firstName} ${zookeeper.lastName}</option>
						</c:forEach>
					</select> 
				</div>
				<div class="field">
					<label for="firstName">New First Name : </label> <input class="text-input"
						type="text" name="firstName" value="">
				</div>
				<div class="field">
					<label for="lastName">New Last Name : </label> <input class="text-input"
						type="text" name="lastName" value="">
				</div>
				<div class="action clearfix">
					<input type="submit" value="Ok" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>