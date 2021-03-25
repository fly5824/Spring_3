<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


<a href="./bankbook/bankbookList">bank book list</a>
<!-- views 까지 현재위치 -->

<c:if test="${empty member}">
<a href="./member/memberJoin">Join</a>
<a href="./member/memberLogin">Login</a>
</c:if>

<c:if test="${not empty member}">
<h3>${member.id}님 환영합니다</h3>
<a href="./member/memberPage">MyPage</a>
<a href="./member/memberLogout">Logout</a>
</c:if>


</body>
</html>
