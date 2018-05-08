<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "board.BoardDAO" %>
<%@ page import = "board.BoardVO" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.text.SimpleDateFormat" %>

   <%
    int num = Integer.parseInt(request.getParameter("num"));
String pageNum = request.getParameter("pageNum");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
try{
	BoardDAO dbPro = BoardDAO.getInstance();
	BoardVO article = dbPro.getArticle(num);
	
	int ref= article.getRef();
	int step=article.getStep();
	int depth=article.getDepth();
String id = (String)session.getAttribute("id");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="500" cellpadding="0" cellspacing = "0" align="center">
<tr height="30">
<td align="center" width="125">글번호</td>
<td align="center" width="125" ><%=article.getNum() %></td>
<td align="center" width="125"> 조회수 </td>
<td align="center" width="125" align="center"><%=article.getReadcount() %></td>
</tr>
<tr height="30">
<td align="center" width="125" >작성자 </td>
<td align="center" width="125" ><%=article.getWriter() %></td>
<td align="center" width="125" >작성일 </td>
<td align="center" width="125" ><%=sdf.format(article.getRegdate()) %></td>
</tr>
<tr height ="30">
<td align="center" width="125" >글제목 </td>
<td align="center" width="375" align="center" colspan="3"><%=article.getSubject() %></td>
</tr>
<tr>
<td align="center" width="125">글내용 </td>
<td align="left" width="375" colspan="3"><pre><%=article.getContent() %></pre></td>
</tr>
<tr>
<td colspan="4"align="right">
<%if(id.equals(article.getWriter())) {%>
	  <button id="edit" 
	   name="<%=num+","+pageNum%>" onclick="edit(this)">수정</button>
	  <button id="delete" 
	   name="<%=num+","+pageNum%>" onclick="del(this)">삭제</button>
	<%}else{ %>
	  <button id="reply" 
	   name="<%=num+","+ref+","+step+","+depth+","+pageNum%>" 
	  onclick="reply(this)">댓글쓰기</button>
	<%}%>
	<button name="<%=pageNum %>" onclick="ahrfhr(this)">글목록</button>
</td>

</tr>
</table>
<%}catch(Exception e){}
	%>

</body>
</html>