package dao;

import java.sql.*;
import java.util.ArrayList;

import vo.BoardVo;

public class BoardDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private Connection dbConn;
	private static BoardDao boardDao;
	private BoardDao() {}
	
	public static BoardDao getInstance() {
		if(boardDao == null) { boardDao = new BoardDao(); }
		return boardDao;
	}
	
	// 글 입력
	public void insertBoard(BoardVo boardVo) {
		conn = JdbcUtil.getConnection();
		String sql;
		
		try {
			int num;
			sql = "SELECT max(board_num) FROM test_board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) { num = rs.getInt(1) + 1; }
			else { num = 1; }
			
			sql = "INSERT INTO test_board VALUES(test_board_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getBoard_name());
			pstmt.setString(2, boardVo.getBoard_pass());
			pstmt.setString(3, boardVo.getBoard_title());
			pstmt.setString(4, boardVo.getBoard_content());
			pstmt.setString(5, boardVo.getBoard_file());
			pstmt.setInt(6, num);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
		finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
	}
	
	public ArrayList<BoardVo> getBoardList() {
		ArrayList<BoardVo> boardList = new ArrayList<>();
		
		try {
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM test_board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVo boardVo = new BoardVo();
				boardVo.setBoard_num(rs.getInt("board_num"));
				boardVo.setBoard_name(rs.getString("board_name"));
				boardVo.setBoard_pass(rs.getString("board_pass"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_content(rs.getString("board_content"));
				boardVo.setBoard_file(rs.getString("board_file"));
				boardVo.setBoard_re_ref(rs.getInt("board_re_ref"));
				boardVo.setBoard_re_lev(rs.getInt("board_re_lev"));
				boardVo.setBoard_re_seq(rs.getInt("board_re_seq"));
				boardVo.setBoard_readcount(rs.getInt("board_readcount"));
				boardVo.setBoard_date(rs.getTimestamp("board_date"));
				boardList.add(boardVo);
			}
		} catch (SQLException e) { e.printStackTrace(); }
		finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return boardList;
	}
	
	public void close(Connection conn) {
		try {
			if(conn != null) { conn.close(); }
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public void close(PreparedStatement pstmt) {
		try {
			if(pstmt != null) { pstmt.close(); }
		} catch (SQLException e) { e.printStackTrace(); }
	}
	
	public void close(ResultSet rs) {
		try {
			if(rs != null) { rs.close(); }
		} catch (SQLException e) { e.printStackTrace(); }
	}
}