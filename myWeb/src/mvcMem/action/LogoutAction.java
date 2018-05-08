package mvcMem.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcMem.control.ActionForward;

public class LogoutAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response)throws IOException {
		request.getSession().invalidate();
		return new ActionForward("/mvcMem/login.jsp",false);
	}
}
