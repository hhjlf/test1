<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%
	String id="";
	try{
		id=(String)session.getAttribute("id");
%>
<%
	if(id==null||id.equals("")){
%>
</head>
<body>
<div id="status">
	<ul>
		<li><label for="id">아이디</label>
		<input id="id" type="text" name="id" size="20" maxlength="50">
		<li><label for="pass">비밀번호</label>
		<input type="password"  id="pass" name="pass">
		<li class="label2" >
		<button id="login" >로그인</button>
		<button id="register" >회원가입</button>
	</ul>
</div>
<%
	}else{
%>
<div id="status">
	<ul>
		<li><b><%=id %></b>님이 로그인 하셨습니다.
		<li><button id="logout">로그아웃</button>
		<li><button id="update">정보수정</button>
	</ul>
</div>
<%}}catch(Exception e){
	e.printStackTrace();
}	
	%>

</body>
</html>