<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="memberone.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var ="flag" value="${flag }"/>
<br/>
<center>
	<c:choose>
		<c:when test="${flag }">
		<b>회원가입을 축하드립니다.</b><br>
		<a href="member.mdo?cmd=login">로그인</a>
		</c:when>
		<c:otherwise>
		<b>다시입력해주세요</b><br>
		<a href="member.mdo?cmd=regForm">다시입력해주세요</a>
		</c:otherwise>
		</c:choose>
		
</center>
</body>
</html>