<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.springbook.biz.board.BoardVO, com.springbook.biz.impl.BoardDAO" %>
    <%
    
   BoardVO board = (BoardVO) session.getAttribute("board");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>글 상세</h1>
	<a href="logout.do">log-out</a>
	<hr>
	<form action="updateBoard.do" method="post">
	<input type="hidden" name="seq" value="${board.seq }"/>
		<table border="1">
		<tr>
			<td width="70">제목</td>
			<td align="left"><input name="title" type="text" value="${board.title}"/></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td align="left">${board.writer }</td>
		</tr>
		<tr>
			<td>내영</td>
			<td align="left"><textarea rows="10" cols="40" name="content">${board.content}</textarea></td>
		</tr>
		<tr>
			<td>등록일</td>
			<td align="left">${board.regDate }</td>
			</tr>
		<tr>
			<td>조회수</td>
			<td align="left">${board.cnt }</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="글 수정"/>
				</td>
				</tr>
		</table>
	</form>
	<a href="insertBoard.jsp">글등록</a>
	<a href="deleteBoard.do?seq=${board.seq }">글삭제</a>
	<a href="getBoardList.do">글목록</a>
</center>

</body>
</html>