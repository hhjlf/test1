<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%
	String a = "빨,주,노,초,파";
request.setAttribute("a",a);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forTokens var ="car" items="Sprinter Trueno Ae86,RX-7 SavannaFC3S,Lancer Evoluton III,RX-7 Efini FD3S" delims=",">
자동차 이름 :<c:out value="${car }"/><br>
</c:forTokens>
<c:set var = "color" value="<%=a %>"/>
<c:forTokens var = "aa" items="${color }"  delims=",">
<br>${aa }
</c:forTokens>
</body>
</html>