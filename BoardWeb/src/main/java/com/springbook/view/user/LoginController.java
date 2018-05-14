package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.user.UserVo;
import com.springbook.biz.user.impl.UserDAO;


public class LoginController implements org.springframework.web.servlet.mvc.Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인컨트롤러 로그인처리 ");
		String id = request.getParameter("id");
		String pass =request.getParameter("pass");
		System.out.println(id);
		System.out.println(pass);


		UserVo vo = new UserVo();
		vo.setId(id);
		vo.setPass(pass);

		UserDAO userDAO = new UserDAO();
		UserVo user = userDAO.getUser(vo);
		ModelAndView mav = new ModelAndView();
		
		if(user !=null){
			mav.setViewName("redirect:getBoardList.do");
		}else{
			mav.setViewName("redirect:login.jsp");
			
	}
		return mav;
	}

}
