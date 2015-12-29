<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
					<th>Name</th>
					<th>Age</th>
					<th>Zooclub</th>
					<th>Animals</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allPersons}" var="person">
					<tr>
						<td>${person.id}</td>
						<td>${person.name}</td>
						<td>${person.age}</td>
						<td>${person.zooclub.name}</td>
						<td>
						<c:forEach items="${person.animals}" var="animal">
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
			<a href="createPerson" class="a_demo_three">Add </a>
		</div>
		<div class="two">
			<a href="deletePerson" class="a_demo_three">Delete Person</a>
		</div>
		<div class="three">
			<a href="editPerson" class="a_demo_three">Edit Person</a>
		</div>
		<div class="four"> 
			<a href="findPersonByName" class="a_demo_three">Find Person</a>
		</div>
	</div>
	<div class="goout">
		<div class="one">
			<a href="home" class="a_demo_three">Home</a>
		</div>
		<div class="two">
			<a href="showAllAnimals" class="a_demo_three">Go To Animals</a>
		</div> 
		<div class="three">
			<a href="showAllZooclubs" class="a_demo_three">Go To Zooclubs</a>
		</div>
		<div class="four"> 
			<a href="showAllZookeepers" class="a_demo_three">Go To Zookeepers</a>
		</div>
	</div>
</body>
</html>