<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container mt-2">

<div class="container">

<h2 class="mt-4">Notice List Page</h2>

<table class="table">
<thead class="thead-dark">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>	
	</thead>
<tbody>	
<c:forEach items="${list}" var="dto">
	<tr>
		<td>${dto.num}</td>
		<td><a href="./noticeSelect?num=${dto.num}">${dto.title}</a></td>
		<td>${dto.writer}</td>
		<td>${dto.hit}</td>
		<td>${dto.regdate}</td>
</tr>
</c:forEach>


</tbody>
</table>

</div>
<c:catch>
<c:if test="${member.id eq 'admin'}">
<h3><a href="./noticeInsert">글작성</a></h3>
</c:if>
</c:catch>
</div>
</body>
</html>