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
	<div class="stacked">
		<h2>Find Zooclub By Name :</h2>
		<form action="findZooclubByName" method="POST">
			<div class="field">
					<label for="name"> Choose Zooclub</label>
					<select name="name" >
						<c:forEach items="${zooclubs}" var="zooclub">
							<option  value="${zooclub.name}">${zooclub.name}</option>
						</c:forEach>
					</select> 
				</div>
			<div class="action clearfix">
				<input type="submit" value="Ok" />
			</div>
		</form>
	</div>
</body>
</html>