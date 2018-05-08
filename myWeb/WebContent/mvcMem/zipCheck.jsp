<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script.js"></script>
<script type="text/javascript">
	function dongCheck(){
		document.zipForm.submit();
	}
	function sendAddress(zipcode,sido,gugun,dong,ri,bunji){
		var address = sido+""+gugun+""+dong+""+ri+""+bunji;
		opener.document.regForm.zipcode.value=zipcode;
		opener.document.regForm.address1.value = address;
		self.close();
	}

</script>
</head>
<body>
<center><b>우편번호찾기</b>
<form action="member.mdo?cmd=zipCheck" method="post" name="zipForm">
<input type="hidden" value="n" name="check">
<table>
<tr>
	<td>동이름임력 : <input type="text"name="dong"/>
	<input type="button" value="검색" onclick="dongCheck()"/>
	</td>
	</tr>
</table>
</form>
<table border="1">
<c:if test="${check eq 'n'}">
<c:if test="${zipcodeList.isEmpty()}">
<tr>
<td><br>검색된결과가없어</td>
</tr>
</c:if>
<c:if test="${!zipcodeList.isEmpty() }">
<tr>
<td><br>
검색후아래우편번호를 클릭하면자동으로입력됩니다.</td>
</tr>
<c:forEach var="vo" items="${zipcodeList }">
<tr>
<td>
<a href="javascript:sendAddress('${vo.getZipcode() }','${vo.getSido() }','${vo.getGugun() }','${vo.getDong() }','${vo.getRi() }','${vo.getBunji() }')">
${vo.getZipcode()}&nbsp;${vo.getSido() }&nbsp;${vo.getGugun() }&nbsp;${vo.getDong() }&nbsp;${vo.getRi() }&nbsp;${vo.getBunji() }

</a><br></td></tr>
</c:forEach>
</c:if>
</c:if>
<tr>
<td>
<a href="javascript:this.close();">닫기</a></td>
</tr>
</table>
</center>
</body>
</html>