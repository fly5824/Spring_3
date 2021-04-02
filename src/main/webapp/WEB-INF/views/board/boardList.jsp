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

<h2 class="mt-4">${board}List</h2>



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
		<td><a href="./${board}Select?num=${dto.num}">${dto.title}</a></td>
		<td>${dto.writer}</td>
		<td>${dto.hit}</td>
		<td>${dto.regdate}</td>
</tr>
</c:forEach>


</tbody>
</table>

</div>

<div class="container">
    <ul class="pagination">
    <c:if test="${pager.pre}">
    <li class="page-item"><a class="page-link" href="./noticeList?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
   </c:if>
   <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
    <li class="page-item"><a class="page-link" href="./noticeList?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
</c:forEach>
	<c:if test="${pager.next}">
    <li class="page-item"><a class="page-link" href="./noticeList?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">Next</a></li>
  	</c:if>
  </ul>
  
  <div class="input-group mt-3 mb-3">
<form action="./${board}List" class="form-inline">
  <div class="input-group-prepend">
   <select class="form-control" name="kind" id="sel1">
    <option>Title</option>
    <option>Contents</option>
    <option>Writer</option>
  </select>
  </div>
  <input type="text" class="form-control" name="search" placeholder="">
    <div class="input-group-append">
    <button class="btn btn-success" type="submit">Search</button>
  </div>
 </form> 
  
  
</div>
<c:catch>
<c:if test="${member.id eq 'admin'}">
<a href="./${board}Insert" class="btn btn-info" role="button">글작성</a>
</c:if>
</c:catch>
</div>
</body>
</html>