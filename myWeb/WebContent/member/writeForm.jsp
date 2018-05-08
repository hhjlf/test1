<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="../js/jquery-3.3.1.min.js" ></script>
<html>

<script src="write.js"></script>
<% request.setCharacterEncoding("utf-8"); %>
<%
int num =0,ref=1, step=0, depth=0;
int pageNum=1;

try{
	if(request.getParameter("num")!=null){
		num = Integer.parseInt(request.getParameter("num"));
		ref = Integer.parseInt(request.getParameter("ref"));
		step =Integer.parseInt(request.getParameter("step"));
		depth = Integer.parseInt(request.getParameter("depth"));
		pageNum = Integer.parseInt(request.getParameter("pageNum"));

		
	}

	
%>
<input type="hidden" id= "num" value="<%=num%>">
<input type="hidden" id= "ref" value="<%=ref%>">
<input type="hidden" id= "step" value="<%=step%>">
<input type="hidden" id= "depth" value="<%=depth%>">
	
<div id="writeForm">
	<ul>
		<li><label for ="subject">제목</label>
		<%if(num!=0){%>
		<img src = "../image/re.gif">
		<%} %>
		<input type="text" id = "subject" name="subject">
		<li><label for ="content">내용</label>
		<textarea rows="13" cols="50" id="content"></textarea>
		<li><label for ="pass">비밀번호</label>
		<input type="password" id = "pass" name="pass">
		<li>
		<button id="regist" value="<%=pageNum%>">등록</button>
		<button id="cancle" value="<%=pageNum%>">취소</button>
		
	</ul>
</div>
<%}catch (Exception e){
	e.printStackTrace();
	}%>

</html>
