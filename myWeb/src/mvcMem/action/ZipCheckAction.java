package mvcMem.action;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcMem.control.ActionForward;
import mvcMem.model.StudentDAO;
import mvcMem.model.ZipcodeVO;

public class ZipCheckAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response)throws IOException {
		request.setCharacterEncoding("utf-8");
		StudentDAO dao = StudentDAO.getInstance();
		String check = request.getParameter("check");
		String dong = request.getParameter("dong");
		System.out.println(dong);
		System.out.println(check);
		Vector<ZipcodeVO> zipcodeList = dao.zipcodeRead(dong);
		int totalList =zipcodeList.size();
		request.setAttribute("check", check);
		request.setAttribute("dong", dong);
		request.setAttribute("zipcodeList", zipcodeList);
		request.setAttribute("totalList",totalList);
		System.out.println(check +","+ dong+","+zipcodeList+","+totalList);
		return new ActionForward("/mvcMem/zipCheck.jsp",false);
}

}