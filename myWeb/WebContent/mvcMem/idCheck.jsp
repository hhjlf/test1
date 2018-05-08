<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="memberone.StudentDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src= script.js></script>
</head>
<body>
<center>
<b>${id }</b>
<c:if test="${check eq true }"> 는 이미 존재 허는 아이디이이<br></c:if>
<c:if test="${check ne true }"> 는 사용가능 한 아디<br/></c:if>
<a href="#"onClick="javascrpt:self.close()">닫기</a>
</center>
</body>
</html>