<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     %>
<fmt:setLocale value ="en"/> 
    <fmt:bundle basename="jstl.a_ko"/>
    <fmt:message key = "TITLE" var = "title"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title }</title></head>
<body>
<c:if test="${!empty param.id }">
<fmt:message key="TITLE">
<fmt:param value = "${param.id }"/>
</fmt:message>
</c:if>
</body>
</html>