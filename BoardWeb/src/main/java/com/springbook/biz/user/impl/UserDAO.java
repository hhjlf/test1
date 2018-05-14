package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtill;
import com.springbook.biz.user.UserVo;

@Repository
public class UserDAO {
	private Connection conn = null;
	private PreparedStatement pstmt= null;
	private ResultSet rs = null;
	
	
	public UserVo getUser(UserVo vo) {
		UserVo user = null;
		System.out.println(vo.getId());
		System.out.println(vo.getPass());
		try {
			conn= JDBCUtill.getConnection();
			pstmt = conn.prepareStatement("select * from users where id=? and pass=?");
			pstmt.setString(1,vo.getId());
			pstmt.setString(2, vo.getPass());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new UserVo();
				user.setId(rs.getString("id"));
				user.setPass(rs.getString("pass"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtill.close(pstmt,conn,rs);
		}
		return user;
	}

}
