<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>


<div class = "container">
<h1> ${board} Select Page</h1>
<h3>Title : ${dto.title}</h3>
<h3>Writer : ${dto.writer}</h3>
<h3>Contents : ${dto.contents}</h3>

<a href="./${board}Update?num=${dto.num}" class="btn btn-danger">Update</a>
<a href="#" id="del" class="btn btn-info">Delete</a>

<c:if test="${board ne 'notice'}">
<a href="./${board}Reply?num=${dto.num}" class="btn btn-primary">Reply</a>
</c:if>

<form action="./${board}Delete" id="frm" method="get">
	<input type="hidden" name="num" value="${dto.num}">

</form>


</div>
<script type="text/javascript">
	const del = document.getElementById("del")
	const frm = document.getElementById("frm");
	del.addEventListener("click",function(){
		let result = confirm("Delete???")
	if(result){
		frm.setAttribute("method","post")
		frm.submit();
	//location.href="./${board}Delete?num=${dto.num}";
		}
})

</script>

</body>
</html>