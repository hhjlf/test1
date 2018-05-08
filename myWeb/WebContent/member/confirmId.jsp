<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="member.MemberDAO" %>
<% request.setCharacterEncoding("utf-8");%>    

<%
	String id = request.getParameter("id");

MemberDAO dao = MemberDAO.getInstance();

int x = dao.confirmId(id);
System.out.println(id);
System.out.println(x);

out.println(x);

%>
