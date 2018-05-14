package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.impl.BoardDAO;

@Controller
public class GetBoardListController  {

	
	@RequestMapping("getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo,BoardDAO boardDAO,ModelAndView mav) {
		
		System.out.println("여기서겟리스트");
		
		mav.addObject("boardList",boardDAO.getBoardList(vo));
		mav.setViewName("getBoardList.jsp");
		return mav;
	}

}
