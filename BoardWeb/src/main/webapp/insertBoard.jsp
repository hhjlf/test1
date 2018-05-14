<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>글 등록</h1>
	<a href="logout_proc.jsp">log-out</a>
	<hr>
	<form action="insertBoard.do" method="post">
		<table width="400s" border="1">
			<tr>
				<td width="70">제목</td><td align="left">
				<input type="text" name="title"/></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td align="left"><input type="text" name="writer" size="10"/></td>
			</tr>
			<tr>
				<td>내용</td><td align="left">
				<textarea rows="10" cols="40" name="content"></textarea> </td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value=" 새글 등록"/></td>
				</tr>
		</table>
	</form>
	<hr>
	<a href="getBoardList.jsp">글목록</a>
</center>

</body>
</html>