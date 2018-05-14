<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.springbook.biz.board.BoardVO, com.springbook.biz.impl.BoardDAO" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page import="java.util.List" %>
<%


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>글 목록</h1>
<h3>테스트님 환영합니다...<a href="logout.do">log-out</a></h3>

<form action="getBoardList.jsp" method="post">
<table border="1" width="700">
	<tr>
		<td align="center">
		<select name="searchCondition">
		<option value="title">제목
		<option value="content">내용
		</select>
		<input name ="searchKeyword" type="text"/>
		<input type="submit" value="검색"/>
		</td>
	</tr>
</table>
</form>	

<table border="1" width="700">
	<tr>
		<th width="100">번호</th>
		<th width="200">제목</th>
		<th width="150">작성자</th>
		<th width="150">등록일</th>
		<th width="100">조회수</th>
	</tr>

<c:forEach items="${boardList }" var="board">

<tr>
	<td>${board.seq }</td>
	<td align="left"><a href="getBoard.do?seq=${board.seq }">
	${board.title }</a></td>
	<td>${board.writer }</td>
	<td>${board.regDate }</td>
	<td>${board.cnt }</td>
</tr>

</c:forEach>
</table>
<br>

<a href="insertBoard.jsp">새글 등록</a>	
</center>


</body>
</html>