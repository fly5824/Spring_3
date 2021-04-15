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
<style type="text/css">
	#d1 {
		width: 200px;
		height: 200px;
		background-color: red;
		overflow: hidden;
	}
	
	#d2 {
		width: 50px;
		height: 50px;
		background-color: yellow;
		margin: 75px auto;
	}
</style>
</head>
<body>
	
<c:import url="./template/header.jsp"></c:import>

<button class="b">BUTTON</button>
<button id="btn" class="b">CLICK</button>
<button id="btn2" class="b">CLICK2</button>
<button id="btn3" class="b">CLICK3</button>
<input type ="text" id="num">
<h1 id="t">version 3</h1>
<ol id="result">
	<li>A</li>
</ol>
	
<select id="mon">
	
</select>	

<div id="d1">
	<div id="d2"></div>
	<h3 id="d3"></h3>
	<h3 id="d4"></h3>
</div>

<div id="exchange">
	<h3 id="krw"></h3>
	<h3 id="usd"></h3>
</div>

<div id="users">

</div>

<script type="text/javascript">
	$("#btn2").click(function() {
		$.{get}("./test?num=3",function(data){
			console.log(data);
		$("#d2").html(data);
		});
	});
	
	
		
	for(let i=1;i<13;i++){
		$("#mon").append("<option>"+i+"</option>");
	}
	
	$("#d1").click(function(){
		console.log("parent");
	});
	
	$("#d2").click(function() {
		console.log("child");
	});
		
		
	$("#btn2").click(function(){
		let num =$("#num").val();
		
		$.get("https://jsonplaceholder.typicode.com/posts/"+num, function(data){
			console.log(data);
			$("#d3").html(data.title);
			$("#d4").html(data.body);
		});
	});
	

$("#btn").clic(function(){
	$.ajax({
		type:"GET",
		url : "https://api.manana.kr/exchange/price.json",
		data: {
			base:"KRW", price:1000, code:"KRW,USD,JPY"
		},
		success:function(data){
			console.log(data)
			$("#krw").html(data.KRW);
			$("#use").html(data.USD);
		}
	});
});

$("btn3").click(function(){
	$.get("https://jsonplaceholder.typicode.com/users", function(data){
		console.log(data);
		
		for(index in data){
			console.log(index.company.name);
		}
		
		//첫번째 user의 내용 중
		console.log(data[0].address.geo.lat);
		console.log(data[0].address.geo.lng);
		let t = parseFloat(data[0].)
	});
});
	
</script>




</body>
</html>