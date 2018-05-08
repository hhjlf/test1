<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.3.1.min.js" ></script>
<script src="login.js"></script>
<script src="list.js"></script>
<link rel="stylesheet" href="../css/style.css"/>
</head>
<body>
<div id="main_auth" class="box"><jsp:include page="loginForm.jsp"/></div>
<div id="main_board" class="box2"><jsp:include page="main_board.jsp"/></div>
</body>
</html>