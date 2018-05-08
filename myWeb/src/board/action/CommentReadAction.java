package board.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import board.comment.CommentVo;
import board.model.BoardDAO;

public class CommentReadAction extends HttpServlet {

	
	public ArrayList requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		System.out.println("하이헬로우안녕?");	
		response.setCharacterEncoding("utf-8");       
	        
	        int commPageNum = Integer.parseInt(request.getParameter("commPageNum"));
	        int articleNumber =Integer.parseInt(request.getParameter("num"));
	        ArrayList<CommentVo> comments = null;
	        CommentVo vo = new CommentVo();
	        
	        
	        try {
	            comments = BoardDAO.getInstance().selectComments(articleNumber, commPageNum);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        /*request.setAttribute("c", comments);
	        for(int i=0;i<comments.size();i++) {
	        vo.setCommentContent(comments.get(i).getCommentContent());
	        }*/
	        
	        JSONArray jsonArr = new JSONArray(comments);        // 스프링에선 애노테이션(?)
	        PrintWriter pw = response.getWriter();
	        pw.println(jsonArr);
	        
	        /*for( CommentVo a : comments) {
	        	System.out.println(a);
	        }*/
	        
	        
	        return comments;
	    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}


	

}
