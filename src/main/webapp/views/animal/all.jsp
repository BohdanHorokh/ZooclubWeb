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
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Type</th>
					<th>Owner</th>
					<th>Zookeepers</th>
				</tr>
				<c:forEach items="${animals}" var="animal">
					<tr>
						<td>${animal.id}</td>
						<td>${animal.name}</td>
						<td>${animal.type}</td>
						<td>${animal.person.name}</td>
						<td>
							<c:forEach items="${animal.zookeepers}" var="zookeeper">
							${zookeeper.firstName}
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
		</table>
	</div>
	<div class="function">
		<div class="one">
		<a href="createAnimal" class="a_demo_three">Add </a> 
		</div>
		<div class="two">
		<a href="deleteAnimal" class="a_demo_three">Delete</a> 
		</div>
		<div class="three">
		<a href="editAnimal"  class="a_demo_three">Edit </a> 
		</div>
		<div class="four"> 
		<a href="findAnimalByName" class="a_demo_three">Find by name</a>
		</div>
	</div>
	<div class="goout">
		<div class="one">
			<a href="home" class="a_demo_three">Home</a> 
		</div>
		<div class="two">
		<a href="showAllPersons" class="a_demo_three">Go To Persons</a>
		</div> 
		<div class="three">
		<a href="showAllZookeepers" class="a_demo_three">Go To Zookeepers</a>
		</div>
		<div class="four">
		<a href="showAllZooclubs" class="a_demo_three">Go To Zooclubs</a>
		</div>
	</div>
</body>
</html>