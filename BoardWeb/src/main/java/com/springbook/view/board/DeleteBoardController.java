package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.impl.BoardDAO;

public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		 String seq = request.getParameter("seq");
		    
		    BoardVO vo = new BoardVO();
		    vo.setSeq(Integer.parseInt(seq));
		    BoardDAO boardDAO = new BoardDAO();
		    boardDAO.deleteBoard(vo);
		    System.out.println("여기서삭제");
		    ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:getBoardList.do");
			return mav;
	}

}
