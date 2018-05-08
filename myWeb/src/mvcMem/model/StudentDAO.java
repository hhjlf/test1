package mvcMem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import mvcMem.model.*;





public class StudentDAO {
private StudentDAO() {	
}
	private static StudentDAO instance = null;
	
	public static StudentDAO getInstance() {
	if(instance==null) {
		synchronized (StudentDAO.class) {
			instance = new StudentDAO();
		}
	}
	return instance;
	}
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context init= new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/myOracle");
			conn = ds.getConnection();
		}catch(Exception e) {
			System.out.println("目池记 积己 角菩局局局局巨局局局巨");
		}
		return conn;
	}
	public boolean idCheck(String id) {
		boolean result = true;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from student where id = ?");
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				result = false;
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				if(rs!=null) try{rs.close();}catch(SQLException e) {}
				if(pstmt!=null) try{rs.close();}catch(SQLException e) {}
				if(conn!=null) try{rs.close();}catch(SQLException e) {}
				}
		return result;
			}
		
	public Vector<ZipcodeVO> zipcodeRead(String dong){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<ZipcodeVO> vecList = new Vector<ZipcodeVO>();
		try {
			conn = getConnection();
			String strQuery="select * from zipcode where dong like'"+dong+"%'";
			pstmt = conn.prepareStatement(strQuery);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ZipcodeVO tempZipcode = new ZipcodeVO();
				tempZipcode.setZipcode(rs.getString("zipcode"));
				tempZipcode.setSido(rs.getString("sido"));
				tempZipcode.setGugun(rs.getString("gugun"));
				tempZipcode.setDong(rs.getString("dong"));
				tempZipcode.setRi(rs.getString("ri"));
				tempZipcode.setBunji(rs.getString("bunji"));
				vecList.addElement(tempZipcode);
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}finally {if(rs!=null)try {rs.close();}catch(SQLException sqle1) {};
		if(pstmt!=null)try {pstmt.close();}catch(SQLException sqle1) {};
		if(conn!=null)try {conn.close();}catch(SQLException sqle1) {};
			
		}
		return vecList;
	}
	
	public boolean memberInsert(StudentVO vo) {
		System.out.println(vo.getEmail());
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag =false;
		try {
			conn = getConnection();
			String strQuery = "insert into student values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(strQuery);
			pstmt.setString(1,vo.getId());
			pstmt.setString(2,vo.getPass());
			pstmt.setString(3,vo.getName());
			pstmt.setString(4,vo.getPhone1());
			pstmt.setString(5,vo.getPhone2());
			pstmt.setString(6,vo.getPhone3());
			pstmt.setString(7,vo.getEmail());
			pstmt.setString(8,vo.getZipcode());
			pstmt.setString(9,vo.getAddress1());
			pstmt.setString(10,vo.getAddress2());
			int count = pstmt.executeUpdate();
			if(count>0)flag = true;
			System.out.println(flag);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException sqle1) {};
			if(pstmt!=null)try {pstmt.close();}catch(SQLException sqle2) {};
			if(conn!=null)try {conn.close();}catch(SQLException sqle3) {};
		}
			return flag;
	}
	public int loginCheck(String id,String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check= -1;
		try {
			conn = getConnection();
			String strQuery ="select pass from student where id =?";
			pstmt = conn.prepareStatement(strQuery);
			pstmt.setString(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbPass = rs.getString("pass");
				if(pass.equals(dbPass)) {
					check=1;
				}
				else {check =0;
				
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException sqle1) {};
			if(pstmt!=null)try {pstmt.close();}catch(SQLException sqle2) {};
			if(conn!=null)try {conn.close();}catch(SQLException sqle3) {};
		}
		return check;
	}


}

