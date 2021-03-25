<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>memberpage</h1>

<h3>id :${member.id} </h3>
<h3>name :${member.name} </h3>
<h3>email :${member.email} </h3>

<a href="./memberUpdate">수정</a>

<a href="./memberDelete">탈퇴</a>

<a href="../account/accountList">계좌관리</a>



</body>
</html>