/**
 * 
 */

function deleteFile(files){
	let fileName = files[0]
}


		
function uploadFile(files){
	const formData = new FormData(); //Form 태그 생성
	formData.append('file',files[0]); // input type = "File" name = "file"

	let fileName="";
	
	$.ajax({
		type: "post",
		url:"",
		data:formData,
		enctype:"multipart/form-data",
		cache:false,
		processData:false,
		contentType:false,
		success:function(result){
			fileName = result.trim();
			$("#contents").summernote('insertImage',fileName);
		}
	});	

}