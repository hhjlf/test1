package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.impl.BoardDAO;

@Controller
public class UpdateBoardController  {

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo,BoardDAO board) {
		
		
		board.updateBoard(vo); 
		
		return "getBoardList.do";
	}

}
