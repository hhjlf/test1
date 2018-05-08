$(document).ready(function() {
	$("#register").click(function() {
		$("#main_auth").load("registerForm.jsp");
	});
	$("#login").click(function() {
		if ($("#id").val() && $("#pass").val()) {
			var query = {
				id : $("#id").val(),
				pass : $("#pass").val(),
			};
			$.ajax({
				type : "post",
				url : "loginProc.jsp",
				data : query,
				success : function(data) {
					if (data == 1) {
						alert("로그인성공~");
						$(location).attr('href',"http://localhost:8080/myWeb/member/main.jsp");
					} else if (data == 0) {
						alert("비밀번호오류");
					} else if (data == -1) {
						alert("아이디가없어요");
					}
				}
			});

		} else
			alert("아이디,비밀번호를 입력해주세요");
	});
	
	$("#logout").click(function() {
		var result = confirm("정말로그아웃하실겁니까?");
		if (result) {
			$.ajax({
				type : "post",
				url : "logoutProc.jsp",
				success : function(data) {
					
					$(location).attr('href',"http://localhost:8080/myWeb/member/main.jsp");
					
				}
			});
	} else{
		
		
	return;
	}
	});
	
	$("#update").click(function() {
		
		$("#main_auth").load("modify.jsp");
	})

});