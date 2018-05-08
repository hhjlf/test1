package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFormAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		int ref = Integer.parseInt(request.getParameter("ref"));
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("ref", ref);
		return "/board/deleteForm.jsp";
	}

}
