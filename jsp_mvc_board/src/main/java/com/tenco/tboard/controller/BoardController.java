package com.tenco.tboard.controller;

import java.io.IOException;
import java.util.List;

import com.tenco.tboard.model.Board;
import com.tenco.tboard.model.Comment;
import com.tenco.tboard.model.User;
import com.tenco.tboard.repository.BoardRepositoryImpl;
import com.tenco.tboard.repository.CommnetRepositoryImpl;
import com.tenco.tboard.repository.interfaces.BoardRepository;
import com.tenco.tboard.repository.interfaces.CommentRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardRepository boardRepository; // 포함관계
	private CommentRepository commentRepository; // 포함관계
       
    public BoardController() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	boardRepository = new BoardRepositoryImpl();
    	commentRepository = new CommnetRepositoryImpl();
    
    	// BoardRepository 추가 예정
    } // end of init()

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("doGet : " +request.getPathInfo());
		
		// TODO 인증처리는 추후 추가
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("principal") == null ) {
			response.sendRedirect(request.getContextPath()+"/user/signin");
			return;
		}
		
		switch (action) {
		
		case "/delete":
			// 게시글 삭제 페이지 이동 처리
			handleDeleteBoard(request, response, session);
			break;
			
		case "/update":
			// 게시글 수정 페이지 이동 처리
			showEditBoardForm(request, response, session);
			break;
		
		case "/create":
			// 게시글 생성 페이지 이동 처리
			showCreateBoardForm(request, response, session);
			break;
			
		case "/list":
			// 게시글 리스트 페이지 이동 처리
			handleListBoards(request, response, session);
			break;
			
		case "/view":
			// 게시글 생성 페이지 이동 처리
			showViewBoard(request, response, session);
			break;
			
		case "/deleteComment":
			// 게시글 생성 페이지 이동 처리
			handleDeleteComment(request, response, session);
			break;
		
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	} // end of doGet(HttpServletRequest request, HttpServletResponse response)
	
	/**
	 * 댓글 삭제 기능 (GET 방식 처리)
	 * @param request
	 * @param response
	 * @param session
	 */
	private void handleDeleteComment(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		try {
			int boardId = Integer.parseInt(request.getParameter("id"));
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// TODO Auto-generated method stub
		
	}

	/**
	 * 상세 보기 화면 이동 (GET 방식 처리)
	 * @param request
	 * @param response
	 * @param session
	 */
	private void showViewBoard(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {
			int boardId =Integer.parseInt(request.getParameter("id")); 
			Board board = boardRepository.getBoardById(boardId);
			if(board == null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			
			// 현재 로그인한 사용자의 ID
			User user = (User)session.getAttribute("principal");
			if(user != null) {
				request.setAttribute("userID", user.getId());
			}
			// TODO - 댓글 조회
			// 댓글 조회 및 권한 확인 추가 예정
			// boardId가 되어야 하는데 id ?
			List<Comment> commentsList = commentRepository.getCommentsByBoardId(boardId);
			
			request.setAttribute("board", board);
			request.setAttribute("commentList", commentsList);
			
			request.getRequestDispatcher("/WEB-INF/views/board/view.jsp").forward(request, response);
			
		} catch (Exception e) {
			// 잘못된 접근 입니다. back()
		}
	} // showViewBoard(HttpServletRequest request, HttpServletResponse response, HttpSession session)

	/**
	 * 수정 폼 화면 이동 (인증 검사 반드시 처리)
	 * @param request
	 * @param response
	 * @param session
	 */
	private void showEditBoardForm(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO 인증처리는 추후 추가
		session = request.getSession();
		
				
	}

	/**
	 * 게시글 삭제 기능 만들기
	 * @param request
	 * @param response
	 * @param session
	 */
	private void handleDeleteBoard(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 게시글 생성 화면 이동
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void showCreateBoardForm(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/board/create.jsp").forward(request, response);
		
		
	} // end of showCreateBoardForm(HttpServletRequest request, HttpServletResponse response, HttpSession session)

	/**
	 * 페이징 처리를 해야한다. (중요)
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void handleListBoards(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		
		/**
		 *  select * 
			from board
			order by created_at asc
			limit ? offset ?;
		 */
		
		// 게시글 목록 조회 기능 
		int page = 1; // 기본 페이지 번호
		int pageSize = 3; // 한 페이지 당 보여질 게시글에 수 
		
		try {
			String pageStr = request.getParameter("page");
			if(pageStr != null) {
				page = Integer.parseInt(pageStr);
			}
			
		} catch (Exception e) {
			// 유효하지 않는 번호를 마음대로 보낼 경우
			page = 1;
		}
		
		// pageSize --> 3이다. 
		// page 1, page 2, page 3 요청 동적으로 시작값을 계산하는 산수 공식 넣기
		int offset = (page - 1) * pageSize; // 시작 위치 계산 (offset 값 계산을 산수공식을 만들어야한다.)
		
		// pageSize <-- 한 페이지당 보여줄 게시글 수 (limit로 바라 볼 수 있다.)
		List<Board> boardList = boardRepository.getAllBoards(pageSize, offset);
		
		// 페이징 처리 1단계 (현재 페이지 번호가 필요, 페이지 사이즈가 필요(pageSize), offset)
		////////////////////////////////////////////////////////////////////////////////////////
		
		// 전체 게시글 수 조회가 필요하다.
		int totoalBoards = boardRepository.getTotalBoardCount();
		
		// 총 페이지 수 계산 ---> [1][2][3][...]
		int totalPages = (int)Math.ceil((double)totoalBoards / pageSize);
		
		request.setAttribute("boardList", boardList); // 게시판리스트
		request.setAttribute("totalPages", totalPages); // 총 몇 페이지
		request.setAttribute("currentPage", page); // 현재 페이지 번호
		
		// 현재 로그인 한 사용자 ID 설정
		if(session != null) {
			User user = (User)session.getAttribute("principal");
			if(user != null) {
				request.setAttribute("userId", user.getId());
			}
		}
	
		System.out.println(" 총 페이지 블록 수 : " + totalPages);
		System.out.println("page : " + page);
		System.out.println("offset : " + offset);
		
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
	} // end of handleListBoards(HttpServletRequest request, HttpServletResponse response)

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getPathInfo();
		System.out.println("doPost : " +request.getPathInfo());
		
		// TODO 인증처리는 추후 추가
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("principal") == null ) {
			response.sendRedirect(request.getContextPath()+"/user/signin");
			return;
		}
		
		switch (action) {
		case "/create":
				handleCreateBoard(request, response, session);
			break;
			
		case "/edit":
		
			break;
			
		case "/addCommnet":
			
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	} // end of doPost(HttpServletRequest request, HttpServletResponse response)

	/**
	 * 게시글 생성 처리
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException 
	 */
	private void handleCreateBoard(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		User user = (User)session.getAttribute("principal");
		
		Board board = Board.builder()
		.userId(user.getId())
		.title(title)
		.content(content)
		.build();
		
		boardRepository.addBoard(board);
		response.sendRedirect(request.getContextPath() + "/board/list?page=1");
	} // end of handleCreateBoard(HttpServletRequest request, HttpServletResponse response, HttpSession session)

} // end of BoardController
