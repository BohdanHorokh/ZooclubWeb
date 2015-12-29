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
	<div class="table">
		<table class="table table-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Animals</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${zookeepers}" var="zookeeper">
					<tr>
						<td>${zookeeper.id}</td>
						<td>${zookeeper.firstName}</td>
						<td>${zookeeper.lastName}</td>
						<td>
							<c:forEach items="${zookeeper.animals}" var="animal">
							${animal.name}
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
		</tbody>
	</table>
	</div>
	<div class="function">
		<div class="one">
	<a href="showAllZookeepers" class="a_demo_three">To Zookeepers</a>
		</div>			
	</div>
	<div class="goout">
		<div class="one">
	<a href="home" class="a_demo_three">Home</a>
	</div>
	</div>
</body>
</html>