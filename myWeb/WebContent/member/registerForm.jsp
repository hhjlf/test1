<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="register.js"></script>

</head>
<body>
<div id="regGrom" class="box">
	<ul>
		<li><label for="id">아이디</label>
		<input type="email" id="id" name="id">
		<button id="checkId">중복확인</button>
	
		<li><label for="pass">비밀번호</label>
		<input type="password" id="pass" name="pass">
		
		<li><label for="repass">비밀번호재입력</label> 
		<input type="password" id="repass" name="repass">
		
		<li><label for="name">이름</label> 
		<input type="text" id="name" name="name">
		
		<li><label for="address">주소</label> 
		<input type="text" id="address" name="address">
		
		<li><label for="tel">전화번호</label> 
		<input type="text" id="tel" name="tel">
		
		<li class="label2"><button id="process">가입하기</button>
		<button id="cancle">취소</button>
	</ul>
</div>
</body>
</html>