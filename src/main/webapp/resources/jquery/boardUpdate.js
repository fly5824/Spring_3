/**
 * 
 */

$(".fileDelete").click(function(){
	
	let check = confirm("삭제???");
	
	if(check){
		let fileNum =$(this).attr("title");
		let obj = $(this);
		//ajax로 보내기
		//noticeFileDelete
		//그 후 컨트롤러에서 받아주는 메서드가 필요함
	
	$.ajax({
		url:"./fileDelete",
		type:"GET",
		//위 두개가 필수요소
		data:{fileNum:fileNum},
		//파라미터
		success:function(result){
			
			result=result.trim();
			if(result>0){
				alert("삭제성공")
				$(obj).parent().remove();
				count--;
			}else{
				alert("삭제실패")
			}
		}
	});
};

});