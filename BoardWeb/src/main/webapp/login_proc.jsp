<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.user.UserVo , com.springbook.biz.user.impl.UserDAO" %>


<%

String id = request.getParameter("id");
String pass =request.getParameter("pass");
System.out.println(id);
System.out.println(pass);


UserVo vo = new UserVo();
vo.setId(id);
vo.setPass(pass);

UserDAO userDAO = new UserDAO();
UserVo user = userDAO.getUser(vo);

if(user !=null){
response.sendRedirect("getBoardList.jsp");
}else{
	response.sendRedirect("login.jsp");
	
}
%>