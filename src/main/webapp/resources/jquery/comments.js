/**
 * 
 */

let num = $("#commnets").attr("title");
getList();

//이벤트위임
$('#comments').on("click","#remove", function(){
	const ar = []; //빈 배열 만들기
	$(".del").each(function(){
		let ch = $(this).prop("checked");
		if(ch){
			ar.push($(this).val());
		}
	});
	
	$.ajax({
		
		type: "post",
		url: "../comments/commentsDelete",
		traditional:true,
		data: {num:ar},
		success:function(data){
			alert(data)
		}
	});
	
	
	
	$.post("../comments/commentsDelete",{num:ar},function(data){
		
		alert(data)
		
	})
	
});


$.get("../comments/commentsList?num="+num,function(data){
	console.log(data);
	
	$("$comments").html(data.trim());
});

$("#write").click(function(){
	let writer = $("#writer").val();
	let contents = $("#contents").val();
	
	$.post("../comments/commentsInsert",
	{num:num,writer:writer,contents:contents},
	function(){
	data=data.trim();
	if(data==1){
		alert("등록성공");
		$("#writer").val('');
		$("#contents").val('');
		getList();
	}else{
		alert("등록실패");
	}
		
	})
});