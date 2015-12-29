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
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>All</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${zookeepers}" var="zookeeper">
				<tr>
					<td>${zookeeper.id}</td>
					<td>${zookeeper}</td>
					<td>${zookeeper}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="showAllAnimals" class="myButton">To Animals</a>
	<a href="showAllPersons" class="myButton">To Persons</a>
	<a href="home" class="myButton">Home</a>
</body>
</html>