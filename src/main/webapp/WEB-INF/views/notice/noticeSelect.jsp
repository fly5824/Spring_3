<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>NoticeSelect Page</h1>

<h3>num:${dto.num}</h3>
<h3>writer:${dto.writer }</h3>
<h3>contents:${dto.contents}</h3>

<c:catch>
<c:if test="${member.id eq 'admin'}">
<a href="./noticeUpdate?num=${dto.num }">글수정</a>
<a href="./noticeDelete?num=${dto.num }">글삭제</a>
</c:if>
</c:catch>
</body>
</html>