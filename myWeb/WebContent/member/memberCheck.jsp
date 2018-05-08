<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="member.*" %>
<% request.setCharacterEncoding("utf-8"); %>

<%
String id = (String)session.getAttribute("id");
String pass = request.getParameter("pass");
MemberDAO dao = MemberDAO.getInstance();
int x = -1;
x=dao.userCheck(id, pass);

out.println(x);
%>