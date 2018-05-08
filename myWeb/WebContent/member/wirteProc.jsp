<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import= "board.*,java.sql.Timestamp"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="article" class="board.BoardVO">
<jsp:setProperty name="article" property="*"/>
</jsp:useBean>
<%
String id="";
try{
	id=(String)session.getAttribute("id");
}catch (Exception e){
	e.printStackTrace();
}
article.setWriter(id);
article.setRegdate(new Timestamp(System.currentTimeMillis()));
article.setIp(request.getRemoteAddr());
BoardDAO dao = BoardDAO.getInstance();
System.out.println(article.getNum()+"0나오면오바다");
System.out.println(article.getRef());
System.out.println(article.getStep());
System.out.println(article.getDepth());
int check = dao.insertArticle(article);

out.println(check);

%>
