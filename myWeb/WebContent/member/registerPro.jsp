<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "member.*" %>
<%@ page import = "java.sql.Timestamp" %>

<meta name="viewport" content="width=device-width,initial-scale=1.0"/>



<% request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="members" class="member.MemberVO">
    <jsp:setProperty name="members" property="*"/>
</jsp:useBean>

<%  
  //폼으로 부터 넘어오지 않는 데이터인 가입날짜를 직접 데이터저장빈에 세팅
  members.setReg_date(new Timestamp(System.currentTimeMillis()));

  MemberDAO dao = MemberDAO.getInstance();
  //사용자가 입력한 데이터저장빈 객체를 가지고 회원가입 처리 메소드호출
  dao.insertMember(members);
%>