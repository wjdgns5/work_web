package com.tenco.tboard.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tenco.tboard.model.Comment;
import com.tenco.tboard.repository.interfaces.CommentRepository;
import com.tenco.tboard.util.DBUtil;

public class CommnetRepositoryImpl implements CommentRepository {

	private static final String INSERT_COMMNET_SQL = " INSERT INTO comments (board_id, user_id, content) VALUES (?, ? , ?) ";
	private static final String DELETE_COMMNET_SQL = " DELETE FROM comments WHERE id = ? ";
	private static final String SELECT_COMMNET_BY_ID = " SELECT * FROM comments WHERE id = ?  ";
	private static final String SELECT_COMMNETS_BY_BOARD_ID = " select c.*, u.username "
			+ " From comments as c "
			+ " join users as u "
			+ " on c.user_id = u.id "
			+ " where board_id = ? "
			+ " order by created_at desc ";

	@Override
	public void addComment(Comment comment) {
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_COMMNET_SQL)) {
				pstmt.setInt(1, comment.getBoardId());
				pstmt.setInt(2, comment.getUserId());
				pstmt.setString(3, comment.getContent());
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end of addComment(Comment comment)

	@Override
	public void deleteComment(int id) {
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(DELETE_COMMNET_SQL)) {
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end of deleteComment(int id)

	@Override
	public Comment getCommentById(int id) {
		Comment comment = null;
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_COMMNET_BY_ID)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					comment = new Comment(rs.getInt("id"), rs.getInt("board_id"), rs.getInt("user_id"),
							rs.getString("content"), rs.getTimestamp("created_at"), rs.getString("username"));
					
//					comment = new Comment();
//					comment.builder()
//					.id(rs.getInt("id"))
//					.boardId(rs.getInt("board_id"))
//					.userId(rs.getInt("user_id"))
//					.content(rs.getString("content"))
//					.createdAt(rs.getTimestamp("created_at"))
//					.build();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment;
	} // end of getCommentById(int id)

	@Override
	public List<Comment> getCommentsByBoardId(int boardId) {
		List<Comment> commentList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_COMMNETS_BY_BOARD_ID)) {
			pstmt.setInt(1, boardId);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					Comment comment = new Comment(rs.getInt("id"), rs.getInt("board_id"), rs.getInt("user_id"),
							rs.getString("content"), rs.getTimestamp("created_at"), rs.getString("username"));
					commentList.add(comment);
					
//					Comment comment = new Comment();
//					comment.builder()
//					.id(rs.getInt("id"))
//					.boardId(rs.getInt("board_id"))
//					.userId(rs.getInt("user_id"))
//					.content(rs.getString("content"))
//					.createdAt(rs.getTimestamp("created_at"))
//					.build();
//					commentList.add(comment);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commentList;
	} // end of getCommentsByBoardId(int boardId)
} // end of CommnetRepositoryImpl
