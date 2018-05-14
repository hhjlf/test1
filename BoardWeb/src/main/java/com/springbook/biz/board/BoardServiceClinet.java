package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class BoardServiceClinet {
	
	public static void main(String[]ar) {
		
	
	AbstractApplicationContext c = new GenericXmlApplicationContext("applicationContext.xml");
	
	BoardService boardService = (BoardService) c.getBean("boardSerivce");
	
	BoardVO vo = new BoardVO();
	
	vo.setTitle("�ӽ�����");
	vo.setWriter("�ӽ��̸�");
	vo.setContent("�ӽó���");

	boardService.insertBoard(vo);
	
	
	List<BoardVO> boardList = boardService.getBoardList(vo);
	for(BoardVO boarda : boardList ) {
		System.out.println(boarda.toString());
	}
	
	
	
	c.close();
	
	}
}
