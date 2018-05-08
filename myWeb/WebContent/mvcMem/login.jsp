<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var ="loginID" value="${sessionScope.loginID }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${loginID ne null }">
<table width ="300" border="1">
	<tr><td colspan="3" >
	<c:out value="${loginID }"/>님 화녕</td></tr>
	<tr><td width="100">
	<a href= "member.mdo?cmd=logout">로그아웃</a>
</table>
</c:when>
<c:otherwise>
	<c:if test="${requestScope.check eq 0 }">
	<script type="text/javascript">alert("비밀번호가틀림");</script></c:if>
	<c:if test="${requestScope.check eq -1 }">
	<script type="text/javascript">alert("아이디가틀림");</script></c:if>
	<form method="post" action="member.mdo?cmd=loginProc">
	<table width ="300" border ="1">
	<tr><td colspan ="2">회원로그인</td></tr>
	<tr>
		<td width="100">아이디: </td>
		<td width = "100">&nbsp;
		<input type="text"	name ="id" size="20"/></td>
		</tr>
		<tr>
		<td width="100">비밀번호 :</td>
		<td width="100">&nbsp;
		<input type="password" name="pass" size="20"/></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type= "submit" value="로그인"/>
			<input type="button" value="회원가입" onClick="javascript:window.location='?cmd=regForm'"/></td>
			</tr>
	</table>
	</form>
</c:otherwise>
</c:choose>

</body>
</html>