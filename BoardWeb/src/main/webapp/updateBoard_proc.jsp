<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="com.springbook.biz.board.BoardVO, com.springbook.biz.impl.BoardDAO" %>
<%
request.setCharacterEncoding("utf-8");
String title = request.getParameter("title");
String seq = request.getParameter("seq");
String content = request.getParameter("content");

BoardVO vo = new BoardVO();
vo.setTitle(title);
vo.setSeq(Integer.parseInt(seq));
vo.setContent(content);

BoardDAO boardDAO = new BoardDAO();
boardDAO.updateBoard(vo);

response.sendRedirect("getBoardList.jsp");
%>>