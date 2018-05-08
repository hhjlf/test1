<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
<!-- 
function deleteSave(){
	if(!document.delForm.pass.value){
		alert("비밀번호입력");
		document.delForm.pass.focus();
		return false;
		
	}
}
-->
</script>

</head>
<body>
<center><b>글삭제</b>
<form method="post" name = "delForm" action="/myWeb/board/deletePro.do?pageNum=${pageNum }" onsubmit="return deleteSave()">
	<table border="1" align="center" width="360">
	<tr height="30">
	<td><b>비밀번호입력</b><br>
	</td>
	</tr>
	<tr height="30">
	<td>비밀번호: <input type="password" name="pass" >
	<input type="hidden" name="num" value="${num }"></td>
	</tr>
	<tr height="30">
	<td>
	<input type="submit" value="글삭제">
	<input type="button" value="글목록"
	onclick= "document.location.href='myWeb/board/list.do?pageNum=${pageNum }'">
	</table>
</form>
</center>

</body>
</html> 