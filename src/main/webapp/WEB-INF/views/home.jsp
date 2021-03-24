<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
<a href="./member/memberPage">MyPage</a>
<a href="./member/memberLogout">Logout</a>
</c:if>

</body>
</html>
