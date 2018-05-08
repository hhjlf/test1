<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script src="../js/jquery-3.3.1.min.js" ></script>
<link rel="stylesheet" href="../css/style.css"/>
<%
	String id="";
	try{
		id= (String)session.getAttribute("id");
%>
<%if(id==null||id.equals("")){%>
<div id="display_board">로그인하세요 게시판은 회원만 볼 수 있습니다.</div>
<%}else{ %>
<div id="display_board"><jsp:include page="list.jsp"></jsp:include></div>
<%}}catch (Exception e){e.printStackTrace();}%>
