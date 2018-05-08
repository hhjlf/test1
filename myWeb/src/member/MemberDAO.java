package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import work.crypt.BCrypt;
import work.crypt.SHA256;

public class MemberDAO {
	private MemberDAO() {
	}

	private static MemberDAO instance = null;

	public static MemberDAO getInstance() {
				instance = new MemberDAO();
		return instance;
	}

	private Connection getConnection() {
		Connection conn = null;
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/myOracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.err.println("Connection 생성실패");
		}
		return conn;
	}

	/*
	 * public List<MemberVO> getMembers(){ Connection conn = null; PreparedStatement
	 * pstmt = null; ResultSet rs = null; List<MemberVO> memberList = null; int x=0;
	 * try { conn = getConnection(); pstmt =
	 * conn.prepareStatement("select count(*) from member"); rs=
	 * pstmt.executeQuery(); if(rs.next()) x = rs.getInt(1);
	 * 
	 * pstmt=conn.prepareStatement("select * from member"); rs =
	 * pstmt.executeQuery(); if(rs.next()) { memberList = new
	 * ArrayList<MemberVO>(x); do { MemberVO member = new MemberVO();
	 * member.setName(rs.getString("name")); member.setId(rs.getString("id"));
	 * member.setPass(rs.getString("pass")); member.setEmail(rs.getString("email"));
	 * memberList.add(member);
	 * 
	 * }while(rs.next());
	 * 
	 * }
	 * 
	 * }catch(Exception e) { e.printStackTrace(); }finally { if(rs!=null)try
	 * {rs.close();}catch(SQLException sqle1) {}; if(pstmt!=null)try
	 * {pstmt.close();}catch(SQLException sqle1) {}; if(conn!=null)try
	 * {conn.close();}catch(SQLException sqle1) {}; } return memberList; }
	 */
	public int updateMember(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1; //실패

		SHA256 sha = SHA256.getInsatnce();
		try {
			conn = getConnection();
			String orgPass = member.getPass();
			String shaPass = sha.getSha256(orgPass.getBytes());
			pstmt = conn.prepareStatement("select pass from member where id=?");
			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String dbpass = rs.getString("pass");
				
				

				if (BCrypt.checkpw(shaPass, dbpass)) {
		
					pstmt = conn.prepareStatement("update member set name=?,address=?,tel=? where id =?");
					pstmt.setString(1, member.getName());
					pstmt.setString(2, member.getAddress());
					pstmt.setString(3, member.getTel());
					pstmt.setString(4, member.getId());
					pstmt.executeUpdate();
					x = 1; // 성공
				} else
					x = 0; //실패
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException sqle1) {
				}
			;
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle1) {
				}
			;
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sqle1) {
				}
			;
		}
		return x;
	}

	public void insertMember(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		SHA256 sha = SHA256.getInsatnce();
		try {
			conn = getConnection();
			
			
			
			String orgPass = member.getPass();
            String shaPass = sha.getSha256(orgPass.getBytes());
        	String bcPass = BCrypt.hashpw(shaPass, BCrypt.gensalt());

			pstmt = conn.prepareStatement("insert into member values (?,?,?,?,?,?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, bcPass);
			pstmt.setString(3, member.getName());
			pstmt.setTimestamp(4, member.getReg_date());
			pstmt.setString(5, member.getAddress());
			pstmt.setString(6, member.getTel());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle1) {
				}
			;
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sqle1) {
				}
			;
		}
	}

	public int userCheck(String id, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;
		SHA256 sha = SHA256.getInsatnce();
		try {
			conn = getConnection();
			String orgPass = pass;
			String shaPass = sha.getSha256(orgPass.getBytes());

			pstmt = conn.prepareStatement("select pass from member where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String dbpass = rs.getString("pass");
				if (BCrypt.checkpw(shaPass, dbpass))
					x = 1; //아이디있음
				else
					x = 0; //비번오류

			} else
				x = -1; //아이디없음

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException sqle1) {
				}
			;
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle1) {
				}
			;
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sqle1) {
				}
			;
		}
		return x;
	}

	public int confirmId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select id from member where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next())
				x = 1;
			else
				x = -1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException sqle1) {
				}
			;
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle1) {
				}
			;
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sqle1) {
				}
			;
		}
		return x;
	}

	public MemberVO getMember(String id, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		SHA256 sha = SHA256.getInsatnce();
		try {
			conn = getConnection();
			String orgPass = pass;
			String shaPass = sha.getSha256(orgPass.getBytes());

			pstmt = conn.prepareStatement("select * from member where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String dbpass = rs.getString("pass");
				if (BCrypt.checkpw(shaPass, dbpass)) {
					member = new MemberVO();

					member.setId(rs.getString("id"));
					member.setName(rs.getString("name"));
					member.setReg_date(rs.getTimestamp("reg_date"));
					member.setAddress(rs.getString("Address"));
					member.setTel(rs.getString("tel"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException sqle1) {
				}
			;
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle1) {
				}
			;
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sqle1) {
				}
			;
		}
		return member;
	}

	public int deleteMember(String id, String pass) {
		Connection conn =null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		int x= -1;
		
		SHA256 sha =SHA256.getInsatnce();
		try {
			conn = getConnection();
			String orgPass= pass;
			String shaPass=sha.getSha256(orgPass.getBytes());
			
			pstmt= conn.prepareStatement("select pass from member where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbpass =rs.getString("pass");
				if(BCrypt.checkpw(shaPass, dbpass)) {
					pstmt = conn.prepareStatement("delete from member where id=?");
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					x=1;
				}else {
					x=0;
				}
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException sqle1) {
				}
			;
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle1) {
				}
			;
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sqle1) {
				}
			;
		}
		return x;
	}
}