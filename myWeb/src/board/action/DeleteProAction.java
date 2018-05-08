package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;

public class DeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("ref")+"가나다라마바사");
		int ref = Integer.parseInt(request.getParameter("ref"));
		int num =Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String pass = request.getParameter("pass");
		BoardDAO dao = BoardDAO.getInstance();
		int check = dao.deleteArticle(num, pass,ref);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("check", check);
		return "/board/deletePro.jsp";
	}

}
