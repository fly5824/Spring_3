<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>

<div class = "container"></div>
<h2>Bank Book List</h2>

<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Rate</th>
			<th>Sale</th>
	
		</tr>	
	</thead>
	
	<tbody>
	<c:forEach items="${list}" var="dto">
		<tr>
			<td><a href="./bankbookSelect?bookNumber=${dto.bookNumber}">${dto.bookName}</a></td>
			<td>${dto.bookRate}</td>
			<td>${dto.bookSale}</td>
		</tr>
	</c:forEach>
	</tbody>

</table>



</body>
</html>