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
				<th>Name</th>
				<th>Persons</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${zooclubs}" var="zooclub">
				<tr>
					<td>${zooclub.id}</td>
					<td>${zooclub.name}</td>
					<td>
						<c:forEach items="${zooclub.persons}" var="person">
							<ul>
								<li>${person.name}</li>
							</ul>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<div class="function">
		<div class="one">
		<a href="createZooclub" class="a_demo_three">Add </a>
		</div>
		<div class="two">
		<a href="deleteZooclub" class="a_demo_three">Delete </a>
		</div>
		<div class="three">
		<a href="editZooclub" class="a_demo_three">Edit </a>
		</div>
		<div class="four"> 
		<a href="findZooclubByName" class="a_demo_three">Find by Name</a>
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
		<a href="showAllZookeepers" class="a_demo_three">Go To Zookeepers</a>
		</div>
		<div class="four">
		<a href="showAllPersons" class="a_demo_three">Go To Persons</a>
	</div>
	</div>
</body>
</html>