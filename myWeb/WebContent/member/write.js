var wStatus = true;

$(document).ready(function(){
	$("#regist").click(function(){
		formCheckIt();
		if(wStatus){
			var pageNum=$("#regist").val();
			var query = {subject:$("#subject").val(),
						content:$("#content").val(),
						pass:$("#pass").val(),
						ref:$("#ref").val(),
						step:$("#step").val(),
						depth:$("#depth").val(),
						num:$("#num").val()
			};
			$.ajax({
				type:"post",
				url:"wirteProc.jsp",
				data:query,
				success:function(data){
					if(data==1){
						alert("등록성공");
						var query = "list.jsp?pageNum="+pageNum;
						$("#main_board").load(query);
					}
				}
			});
		}
	});
	
	$("#cancle").click(function(){
		var pageNum = $("#cancle").val();
		var query = "list.jsp?pageNum"+pageNum;
		$("#main_board").load(query);
	})	;

});

function formCheckIt(){
	wStatus=true;
	
	if(!$.trim($("#subject").val())){
		alert("제목입력");
		$("#subject").focus();
		wStatus=false;
		return false;
	}
	if(!$.trim($("#content").val())){
		alert("내용입력");
		$("#content").focus();
		wStatus=false;
		return false;
	}
	if(!$.trim($("#pass").val())){
		alert("비번입력");
		$("#pass").focus();
		wStatus=false;
		return false;
	}
	
	
}