<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src= "script.js"></script>
</head>
<body>
<center><b>글수정</b>
<form method="post" name ="writeform" action="/myWeb/board/updatePro.do?pageNum=${pageNum }">
<table width="400" border="1">
<tr>
	<td width="70" align="center">이 름</td>
	<td align="left" width="330">
		<input type="text" size="10" name="writer" value="${article.writer }">
		<input type="hidden" name= "num" value="${article.num }"></td>
		
	</tr>
	<tr>
		<td width="70" align="center">제 목</td>
		<td align="left" width="330">
		<input type="text" size="40" name="subject" value="${article.subject }"></td>
		</tr>
	<tr>
		<td width="70" align="center">Email</td>
		<td align="left" width="330">
		<input type="text" name="email" value="${article.email }"></td>
		</tr>
		<tr>
		<td width="70" align="center">내 용</td>
		<td align="left" width="330">
		<textarea name="content" rows="13" cols="40"></textarea></td>
		</tr>
		<tr>
		<td width="70" align="center">비밀번호</td>
		<td align="left" width="330">
		<input type="password" name="pass"></td>
		</tr>
		<tr>
		<td colspan ="2"align="center">
		<input type="submit" value="글수정">
		<input type="reset" value="다시쓰기">
		<input type="button" value= "목록으로" onclick="document.location.href='/myWeb/board/list.do?pageNum=${pageNum}'">
		</td>
		</tr>
		
		
		
</table>

</form>
</center>
</body>
</html>