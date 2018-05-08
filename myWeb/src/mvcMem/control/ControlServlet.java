package mvcMem.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.RequestDispatcher;

import mvcMem.action.Action;



public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
	  request.setCharacterEncoding("utf-8");
	  response.setContentType("text/html;charset=utf-8");
	  String cmd = request.getParameter("cmd");
	  System.out.println(cmd+"컨트롤서블릿에서받는거");
	  if(cmd!=null) {
		  ActionFactory factory = ActionFactory.getInstance();
		  Action action = factory.getAction(cmd);
		  ActionForward af = action.execute(request, response);
		  if(af.isRedirect()) {
			  response.sendRedirect(af.getUrl());
		  }else {
			javax.servlet.RequestDispatcher rd = request.getRequestDispatcher(af.getUrl());  
			
			 rd.forward(request, response);
		  }
	  }else {
		  PrintWriter out = response.getWriter();
		  out.println("<html>");
		  out.println("<head><title>Error</title></head>");
		  out.println("<body>");
		  out.println("<h4>올바른 요청이 아넵니다!</h4>");
		  out.println("<h4>http://localhost:8080/myWeb/mvcMem/member.mdo?cmd=요청키월드<h4>");
		  out.println("</body");
		  out.println("</html>");
		  
	  }
   }
}