<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>BankBook Select Page</h1>
	
	<h3>name : ${dto.bookName}</h3>
	<h3>number : ${dto.bookNumber}</h3>
	
	<a href="./bankbookDelete?bookNumber=${dto.bookNumber}">Delete</a>
	
	<a href="./bankbookUpdate?bookNumber=${dto.bookNumber}">Update</a>
	
	<!-- a태그의 주소는 현재 위치를 기준으로 상대경로 -->
	
</body>
</html>