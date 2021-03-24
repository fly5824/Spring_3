<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Bankbook UPdate Page</h1>
	
	<form action="./bankbookUpdate" method="post">	
		Number<input type= "text" readonly="readonly" name="bookNumber" value="${dto.bookNumber}"><br>
		<!-- 사람눈에 보이지 않지만 넘어가는 데이터 
		어떤 정보를 업뎃해야할지 알아야하기때문에 넘버데이터를 넘겨줘야함 -->
		
		Name<input type= "text" name="bookName" value="${dto.bookName}"><br>
		Rate<input type="text" name="bookRate" value="${dto.bookRate}"><br>
		Sale<input type="text" name="bookSale" value="${dto.bookSale}">
		<button>Update</button>
	</form>
	
	
</body>
</html>