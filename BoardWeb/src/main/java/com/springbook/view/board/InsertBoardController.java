package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.impl.BoardDAO;

@Controller
public class InsertBoardController {

	
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		
		
		boardDAO.insertBoards(vo);
		
		System.out.println("여기서인설트");
		
		return "redirect:getBoardList.do";
		

		
		
	}

}
