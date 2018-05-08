package board.action;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import board.model.BoardDAO;

public class CommentAction implements CommandAction {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	        
	        
	        String commentContent = request.getParameter("commentContent");
	        int articleNumber = Integer.parseInt(request.getParameter("num"));
	        
	        HashMap<String, Object> result = null;
	        
	        try {
	            result = BoardDAO.getInstance().insertComment(commentContent, articleNumber);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        JSONObject jsonObj = new JSONObject(result);
	        PrintWriter pw = response.getWriter();
	        pw.println(jsonObj);
	        
	        
	        return "/board/content.jsp";
	    }


	
}
