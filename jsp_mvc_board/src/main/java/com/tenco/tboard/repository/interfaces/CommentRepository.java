package com.tenco.tboard.repository.interfaces;

import java.util.List;

import com.tenco.tboard.model.Comment;

public interface CommentRepository {
	
	// 댓글 기능 이라면?
	// C R U D 개념을 생각한다.
	
	// 댓글 추가
	void addComment(Comment comment);
	
	// 댓글 삭제
	void deleteComment(int id);
	
	// 댓글작성한 아이디 찾기
	Comment getCommentById(int id);
	
	// 게시글에 대한 댓글 보기
	List<Comment> getCommentsByBoardId(int boardId);
}
