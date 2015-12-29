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
		<h2>Enter Name of Zookeeper :</h2>
		<form action="findZookeeperByName" method="POST">
			<div class="field">
					<label for="name">Choose Name of Zookeeper</label>
					<select name="name" >
						<c:forEach items="${zookeepers}" var="zookeeper">
							<option  value="${zookeeper.firstName}">${zookeeper.firstName}</option>
						</c:forEach>
					</select> 
				</div>
			<div class="action clearfix">
				<input type="submit" value="Ok" />
			</div>
		</form>
	</div>
	</div>
</body>
</html>