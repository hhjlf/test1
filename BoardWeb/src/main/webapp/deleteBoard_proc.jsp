<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.springbook.biz.board.BoardVO, com.springbook.biz.impl.BoardDAO" %>
    
    <%
    String seq = request.getParameter("seq");
    
    BoardVO vo = new BoardVO();
    vo.setSeq(Integer.parseInt(seq));
    BoardDAO boardDAO = new BoardDAO();
    boardDAO.deleteBoard(vo);
    
    response.sendRedirect("getBoardList.jsp");
    
    
    %>