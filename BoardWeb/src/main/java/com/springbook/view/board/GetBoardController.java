package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.impl.BoardDAO;

@Controller
public class GetBoardController  {

	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo,BoardDAO boardDAO,ModelAndView mav) {
	    
	
	    mav.addObject("board",boardDAO.getBoard(vo));
	    mav.setViewName("getBoard.jsp");
		
	return mav;
	}

}
