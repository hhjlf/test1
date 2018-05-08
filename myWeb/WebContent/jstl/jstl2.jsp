<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList,jstl.MemberVO" %>
    <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
    <%
  MemberVO vo1=new MemberVO("손오공","son",500);
    
    MemberVO vo2=new MemberVO("사오정","son",50);
    MemberVO vo3=new MemberVO("공","son",300);
    ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
    memberList.add(vo1);
    memberList.add(vo2);
    memberList.add(vo3);
    request.setAttribute("memberList",memberList);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border= "1" width="450">
	<tr>
		<th width ="50">번호</th>
		<th width ="100">이름</th>
		<th width ="200">메일</th>
		<th width ="100">나이</th>
	</tr>
	 <c:forEach begin="1" end="2" step="1">
	 <tr>
	 	
	 	<td align="center">${memberList }</td>
	 	
	 	
	 	</tr>
	 </c:forEach>
	 
</table>
</body>
</html>