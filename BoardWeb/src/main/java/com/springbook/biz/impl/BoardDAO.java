package com.springbook.biz.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtill;
import com.springbook.biz.impl.BoardDAOSprong.BoardRowMapper;

@Repository("boardDAO")
public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	 private final String board_insert = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
	   private final String board_update = "update board set title=?, content=? where seq=?";
	   private final String board_delete = "delete board where seq=?";
	   private final String board_get = "select * from board where seq=?";
	   private final String board_list = "select * from board order by seq desc";
	
	
	public void insertBoards(BoardVO vo) {
		System.out.println("insert전에한번 ㅇㅋ");
		
		try{
			conn = JDBCUtill.getConnection();
			stmt = conn.prepareStatement("insert into board(seq,title,writer,content)values((select nvl(max(seq),0)+1 from board),?,?,?)");
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtill.close(stmt,conn);
		}
	}
	
	 public void updateBoard(BoardVO vo) {
	      System.out.println("update실행");
	      try {
	         conn = JDBCUtill.getConnection();
	         stmt = conn.prepareStatement(board_update);
	         stmt.setString(1, vo.getTitle());
	         stmt.setString(2, vo.getContent());
	         stmt.setInt(3, vo.getSeq());
	         stmt.executeUpdate();
	      }catch (Exception e) {
	         e.printStackTrace();// TODO: handle exception
	      }finally {
	         JDBCUtill.close(stmt, conn);
	      }
	   }
	   
	   public void deleteBoard(BoardVO vo) {
	      System.out.println("delete실행");
	      try {
	         conn = JDBCUtill.getConnection();
	         stmt = conn.prepareStatement(board_delete);
	         stmt.setInt(1,  vo.getSeq());
	         stmt.executeUpdate();
	      }catch (Exception e) {
	         e.printStackTrace();// TODO: handle exception
	      }finally {
	         JDBCUtill.close(stmt, conn);
	      }
	   }
	   
	   public BoardVO getBoard(BoardVO vo) {
	      System.out.println("getBoard실행");
	      BoardVO board = null;
	      try {
	         conn = JDBCUtill.getConnection();
	         stmt = conn.prepareStatement(board_get);
	         stmt.setInt(1, vo.getSeq());
	         rs = stmt.executeQuery();
	         if(rs.next()) {
	            board = new BoardVO();
	            board.setSeq(rs.getInt("seq"));
	            board.setTitle(rs.getString("title"));
	            board.setWriter(rs.getString("writer"));
	            board.setContent(rs.getString("content"));
	            board.setRegDate(rs.getDate("regdate"));
	            board.setCnt(rs.getInt("cnt"));
	         }
	      }catch (Exception e) {
	         e.printStackTrace();// TODO: handle exception
	      }finally {
	         JDBCUtill.close( stmt, conn,rs);
	      }
	      return board;
	   }

	
	
	
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("getlist");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
		conn = JDBCUtill.getConnection();
		stmt = conn.prepareStatement("select * from board order by seq desc");
		rs= stmt.executeQuery();
		while(rs.next()) {
			BoardVO board= new BoardVO();
			board.setSeq(rs.getInt("seq"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setContent(rs.getString("content"));
			board.setRegDate(rs.getDate("regdate"));
			board.setCnt(rs.getInt("cnt"));
			boardList.add(board);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtill.close(stmt,conn,rs);
		}
		return boardList; 
	}
	
}
