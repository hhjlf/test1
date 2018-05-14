package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class BoardServiceClinet {
	
	public static void main(String[]ar) {
		
	
	AbstractApplicationContext c = new GenericXmlApplicationContext("applicationContext.xml");
	
	BoardService boardService = (BoardService) c.getBean("boardSerivce");
	
	BoardVO vo = new BoardVO();
	
	vo.setTitle("임시제목ㅎ");
	vo.setWriter("임시이름");
	vo.setContent("임시내용");

	boardService.insertBoard(vo);
	
	
	List<BoardVO> boardList = boardService.getBoardList(vo);
	for(BoardVO boarda : boardList ) {
		System.out.println(boarda.toString());
	}
	
	
	
	c.close();
	
	}
}
