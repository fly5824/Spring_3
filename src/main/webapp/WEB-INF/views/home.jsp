<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<c:import url="./template/bootStrap.jsp"></c:import>

<link rel="stylesheet" href="./resources/css/test.css">
<title>Home</title>
</head>
<body>
	
<c:import url="./template/header.jsp"></c:import>

<button onclick="go()">Button</button>

<script type="text/javascript">
	
		
	let f1 = function(){
		alert('익명함수')
	}
	
	function sum(num1, num2){
		return num1+num2;
	}
	
	function go(){
		alert("hello");
		let s = sum(1,2);
		alert(s);
		f1();
	
	
	}
</script>


</body>
</html>