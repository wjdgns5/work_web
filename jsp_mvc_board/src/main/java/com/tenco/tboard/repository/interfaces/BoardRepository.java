package com.tenco.tboard.repository.interfaces;

import java.util.List;

import com.tenco.tboard.model.Board;

public interface BoardRepository {
	// 게시판 웹 서비스를 개발 ()
	
	// C R U D 기본
	void addBoard(Board board);
	void updateBoard(Board board);
	void deleteBoard(int id);
	Board getBoardById(int id);
	List<Board> getAllBoards(int limit, int offset);
	int getTotalBoardCount();

} // end of BoardRepository
