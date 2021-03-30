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

<form action="./noticeInsert" method="post">
<div class="container">
<h1>Notice Insert Page</h1>
<div class="form-group">
  <label for="usr">title:</label>
  <input type="text" class="form-control" name="title">
</div>
<div class="form-group">
  <label for="usr">writer:</label>
  <input type="text" class="form-control" name="writer" readonly="readonly"value="${member.id}">

</div>
<div class="form-group">
  <label for="comment">contents:</label>
  <textarea class="form-control" rows="5" name="contents"></textarea>
</div>
<button>submit</button>
</div>

</form>
</body>
</html>