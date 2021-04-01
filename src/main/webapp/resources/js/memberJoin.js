/**
 * 
 */

let id = document.getElementById("id");
let pw = document.getElementById("pw");
let pw2 = document.getElementById("pw2");
let btn = document.getElementById("btn");

btn.addEventListener("click", function(){
	id.focus();
});

pw2.addEventListener("blur",function(){
	
	if(pw.value == pw2.value){
		pw2.value="";
	}
});

pw.addEventListener("change", function(){
	pw.value;
});


pw.addEventListener("blur",function(){
	let message = "8글자 미만입니다"
	let c1 = "r1";
	if(pw.value.length>7){
		message = "8글자 이상입니다"
		c = "r2";
	}
	
	let pwResult = document.getElementById("pwResult");
	pwResult.innerHTML=message;
	pwResult.setAttribute("class" , c);
})

id.addEventListener("blur", function(){
	let message = "6글자 미만입니다";
	let c = "r1"
	if(id.value.length>5){
		message = "6글자 이상 입니다";
		c="r2";
	}
	
	let idResult = document.getElementById("idResult");
	idResult.innerHTML=message;
	idResult.setAttribute("class", c);
});