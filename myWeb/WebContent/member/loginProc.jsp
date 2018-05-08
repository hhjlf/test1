<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="member.MemberDAO" %>
<% request.setCharacterEncoding("utf-8");%>    

<%
	String id = request.getParameter("id");
String pass = request.getParameter("pass");
MemberDAO dao = MemberDAO.getInstance();

int x = dao.userCheck(id,pass);
if(x==1){
	session.setAttribute("id",id);
}

out.println(x);

%>
