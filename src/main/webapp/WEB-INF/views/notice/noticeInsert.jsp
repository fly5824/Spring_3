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
<h1>Notice Insert Page</h1>

<form action="./noticeInsert" method="post">


title: <input type="text" name="title"><br>
writer: <input type="text" name="writer"><br>
contents: <input type="text" name="contents"><br>
hit: <input type="text" name="hit"><br>


<button>submit</button>

</form>
</body>
</html>