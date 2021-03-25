<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Member Update Page</h1>


<form action="./memberUpdate" method="post">	
		id<input type= "text" readonly="readonly" name="id" value="${member.id}"><br>
		<!-- 사람눈에 보이지 않지만 넘어가는 데이터 
		어떤 정보를 업뎃해야할지 알아야하기때문에 넘버데이터를 넘겨줘야함 -->
		
		pw<input type= "text" name="pw" value="${member.pw}"><br>
		name<input type= "text" name="name" value="${member.name}"><br>
		phone<input type="text" name="phone" value="${member.phone}">
		email<input type="text" name="email" value="${member.email}"><br>
		<button>Update</button>
	</form>

</body>
</html>