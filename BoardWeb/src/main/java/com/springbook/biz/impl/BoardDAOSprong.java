package com.springbook.biz.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;


public class BoardDAOSprong  {
	private final String BOARD_INSERT ="insert into board(seq,title,writer,content)values ((select nvl(max(seq), 0)+1 from board),?,?,?)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

public void insertBoard(BoardVO vo) {
	System.out.println("inserboard처리스프링");
	jdbcTemplate.update(BOARD_INSERT,vo.getTitle(),vo.getWriter(),vo.getContent());
	
}
public void updateBoard(BoardVO vo) {
	System.out.println("업데이트스프링");
	jdbcTemplate.update("update board set title=?,content=? where seq=?",vo.getTitle(),vo.getContent(),vo.getSeq());
}
public void deleteBoard(BoardVO vo) {
	System.out.println("딜리트스프링");
	jdbcTemplate.update("delete board where seq=?",vo.getSeq());
}
public BoardVO getBoard(BoardVO vo) {
	System.out.println("get보더스프링");
	Object[]args = {vo.getSeq()};
	return jdbcTemplate.queryForObject("selete * from board where seq=?",args, new BoardRowMapper());
}
	
public List<BoardVO> getBoardList(BoardVO vo){
	System.out.println("getlist스프링");
	return jdbcTemplate.query("select * from board order by seq desc",new BoardRowMapper());
}
	
class BoardRowMapper implements RowMapper<BoardVO>{
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException{
		BoardVO vo = new BoardVO();
		vo.setSeq(rs.getInt("SEQ"));
		vo.setTitle(rs.getString("TITLE"));
		vo.setWriter(rs.getString("WRITER"));
		vo.setContent(rs.getString("CONTENT"));
		vo.setCnt(rs.getInt("CNT"));
		return vo;
	}
}
}
