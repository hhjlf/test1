<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "member.*" %>


<meta name="viewport" content="width=device-width,initial-scale=1.0"/>



<% request.setCharacterEncoding("utf-8");%>

<% 
  String id = (String)session.getAttribute("id");
  String pass = request.getParameter("pass");
  MemberDAO manager = MemberDAO.getInstance();
  //아이디와 비밀번호에 해당하는 사용자의 정보를 얻어냄
  MemberVO m = manager.getMember(id,pass); 
  try{//얻어낸 사용자 정보를 화면에 표시
%>

<div id="regForm" class="box">
   <ul>
      <li><p class="center">회원 정보 수정
      <li><label for="id">아이디</label>
          <input id="id" name="id" type="email" size="20" 
          value="<%=id%>" >
      <li><label for="pass">비밀번호</label>
          <input id="pass" name="pass" type="password" 
         value="<%=pass%>"  >
      <li><label for="name">이름</label>
          <input id="name" name="name" type="text" 
           value="<%=m.getName()%>">
      <li><label for="address">주소</label>
          <input id="address" name="address" type="text" 
            value="<%=m.getAddress()%>">
      <li><label for="tel">전화번호</label>
          <input id="tel" name="tel" type="tel" 
           value="<%=m.getTel()%>">
      <li><button id="modifyProcess">수정</button>
          <button id="cancle">취소</button>
   </ul>
</div>
<%}catch(Exception e){}%>