<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script.js"></script>
</head>
<body>
<center><b>글쓰ㅣㄱ기기</b>
<br>
<form method="post" name="writeForm" action="/myWeb/board/writePro.do" onsubmit="return writeSave()">
<input type="hidden" name="num" value="${num }">
<input type="hidden" name="ref" value="${ref }">
<input type="hidden" name="step" value="${step }">
<input type="hidden" name="depth" value="${depth }">
<table width="400" border="1" >
<tr>
	<td align="rigth" colspan="2">
	<a href="/myWeb/board/list.do">글목록</a>
	</td>
	</tr>
	<tr>
		<td width="70" >이 름</td>
		<td width="330">
		<input type="text" size="10" maxlength="10" name="writer"></td>
		</tr>
		<tr>
			<td width="70" align="center">제목</td>
			<td width="330">
			<c:if test="${num==0 }">
			<input type="text" size= "40" maxlength="50" name="subject">
			</c:if>
			<c:if test="${num!=0 }">
			<input type="text" size="40" maxlength="50" name="subject" value="[답변]">
			</c:if>
			</td>
			</tr>
		<tr>
		<td width="70" align="center">Email</td>
		<td width="330">
		<input type="text" size="40" maxlength="30" name="email"></td>
		</tr>
		<tr>
		<td width="70" align="center">내 용</td>
		<td width="330">
		<textarea name ="content" rows="13" cols="40"></textarea></td>
		</tr>
		<tr>
		<td width="70" align="center">비밀번호</td>
		<td width="330">
		<input type="password" size="8" name="pass">
		</td>
		</tr>
		<tr>
		<td colspan="2" align="center">
		<input type="submit" value="글쓰기">
		<input type="reset" value="다시쓰기">
		<input type="button" value="목록보기" onClick="window.location='/myWeb/board/list.do'">
		</td>
		</tr>
		
</table>

</form>

</center>
</body>
</html>