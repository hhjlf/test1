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
<div id="display_board">�α����ϼ��� �Խ����� ȸ���� �� �� �ֽ��ϴ�.</div>
<%}else{ %>
<div id="display_board"><jsp:include page="list.jsp"></jsp:include></div>
<%}}catch (Exception e){e.printStackTrace();}%>
