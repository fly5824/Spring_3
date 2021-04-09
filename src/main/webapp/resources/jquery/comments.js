/**
 * 
 */

let num = $("#commnets").attr("title");
$.get("../comments/commentsList?num="+num,function(data){
	console.log(data);
	
	$("$comments").html(data.trim());
});

$("#write").click(function(){
	let writer = $("#writer").val();
	let contents = $("#contents").val();
	
	alert(writer);
	alert(contents);
});