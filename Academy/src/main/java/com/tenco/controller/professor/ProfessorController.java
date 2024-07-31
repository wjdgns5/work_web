package com.tenco.controller.professor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.professor.ProfessorRepository;
import com.tenco.Repo.professor.ProfessorRepositoryImpl;
import com.tenco.model.professor.EvaluationResultDTO;
import com.tenco.model.professor.RestClassDTO;
import com.tenco.model.professor.StudentGradeDTO;
import com.tenco.model.student.StudentIdNameDTO;
import com.tenco.model.subject.SubjectDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/professor/*")
public class ProfessorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProfessorRepository professorRepository;

	@Override
	public void init() throws ServletException {
		professorRepository = new ProfessorRepositoryImpl();
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();

		switch (action) {
		// 교수 계정 로그인 후 홈 화면에서 학생 점수 입력 탭 클릭시 -> 강의목록 조회하기 폼으로 이동 처리
		case "/goinputpage":
			request.getRequestDispatcher("/WEB-INF/views/professor/select.jsp").forward(request, response);
			break;
			
		// 강의목록 조회하기 폼에서 개설년도, 개설학기 교수 id를 받아 내 강의 목록 조회 후 내 강의 목록 폼으로 이동
		case "/mysubject":
			readMySubject(request, response);
			break;

		// 내 강의 목록 리스트에서 학생 성적을 입력할 강의를 선택 후 학생 성적 입력 폼으로 이동
		case "/selectsubject":
			moveentergrade(request, response);
			break;

			// 내 강의 목록 리스트에서 학생 성적을 수정할 강의를 선택 후 학생 성적 수정 폼으로 이동
		case "/modifysubject":
			movemodifygrade(request, response);
			break;
			
		// 학생 성적 입력 폼에서 성적 입력 후 입력받은 값을 DB에 저장하기
		case "/input-grade":
			enterStudentGrade(request, response);
			break;
			
		// 학생 성적 수정 폼에서 수정할 성적 입력 후 입력받은 값을 DB에 저장하기
		case "/update-grade":
			updateStudentGrade(request, response);
			break;
		
		// 교수 로그인 후 상단의 휴/보강 관리 메뉴 선택시 -> selectRC JSP 로 이동 처리
		case "/restclassmanagement":
			request.getRequestDispatcher("/WEB-INF/views/professor/selectRC.jsp").forward(request, response);
			break;	
		
		// selectRC.jsp 에서 개강 년도 , 학기,  정보를 받아  mysubjectRC.jsp로 이동
		case "/mysubjectRC":
			readMySubjectRC(request, response);
			break;	
			
		// 휴강 리스트 폼에서 휴강일정 추가하기 버튼 클릭시 휴강일정 입력 폼으로 이동 처리 
		case "/addRestClass":
			moveInputForm(request, response);
			break;
			
		// 휴강 일정 입력 폼에서 정보를 입력 받아 DB에 인풋 후 초기화면으로 이동	
		case "/inputRestClass":
			inputRestClass(request, response);
			break;	
		
		// 교수 로그인후 상단의 강의평가 결과 조회하기 메뉴 클릭 -> 내강의 목록 조회 폼으로 이동
		case "/clickERMenu":
			request.getRequestDispatcher("/WEB-INF/views/professor/selectER.jsp").forward(request, response);
			break;	
			
		// 내 강의 목록 조회 폼에서 개설년도 개설학기 교수id 정보를 얻은 후 해당 정보로 내 강의 리스트 폼으로 이동
		case "/readEvaluationResult":
			readMyEvaluationResult(request, response);
			break;	
		
		// 학생들의 강의 평가 결과를 익명으로 평균점수 / 건의사항 출력 | 맨 밑에 토탈 점수 출력 
		case "/resultcheck":
			resultCheck(request, response);
			break;	
			
		// 휴/보강 리스트에서 수정 버튼 클릭시 수정 폼으로 이동
		case "/updateRC":
			updateRC(request, response);
			break;	
		
		// 휴/보강 리스트에서 삭제 버튼 클릭시 삭제 처리 후 기존 페이지로 이동
		case "/deleteRC":
			deleteRC(request, response);
			break;
			
		case "/inputUpdateRC":
			inputUpdateRC(request, response);
			break;	
		
			
		default:
			break;
		}

	}

	

	private void inputUpdateRC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")); 
		String restDay = request.getParameter("restDay");
		String supplement = request.getParameter("supplement");
		professorRepository.updateRestClassByRestClassId(restDay, supplement, id);
		request.getRequestDispatcher("/WEB-INF/views/professor/selectRC.jsp").forward(request, response);
	}

	private void deleteRC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		professorRepository.deleteRestClassByRestClassId(id);
		// TODO 돌아가는 위치 수정
		request.getRequestDispatcher("/WEB-INF/views/professor/selectRC.jsp").forward(request, response);
	}

	private void updateRC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		RestClassDTO rc = professorRepository.getRestClassById(id);
		request.setAttribute("rc", rc);
		request.getRequestDispatcher("/WEB-INF/views/professor/updateRC.jsp").forward(request, response);
		
	}

	private void updateStudentGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentSize = Integer.parseInt(request.getParameter("studentSize"));
		int studentId;
		int midExam;
		int finalExam;
		float convertedMark;
		System.out.println("studentSize : " + studentSize);
		for(int i = 1; i <= studentSize; i++) {
			studentId = Integer.parseInt(request.getParameter("studentId"+i));
			midExam = Integer.parseInt(request.getParameter("midExamScore"+i));
			finalExam = Integer.parseInt(request.getParameter("finalExamScore"+i));
			convertedMark = Float.parseFloat(request.getParameter("grade"+i));
			professorRepository.updateStudentsGradeByStudentId(midExam, finalExam, convertedMark, studentId);
		}
		// TODO = 현재 학생 성적 DB에 전송 후 내 강의 선택 페이지로 가는데 기존 조회한 강의로 가도록 수정!. 
		request.getRequestDispatcher("/WEB-INF/views/professor/select.jsp").forward(request, response);
		
	}

	private void movemodifygrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectId = request.getParameter("subjectId");
		request.setAttribute("subjectId", subjectId);
		List<StudentGradeDTO> gradeList = new ArrayList<>();
		gradeList = professorRepository.selectAllStudentsGradeBySubjectId(Integer.parseInt(subjectId));
		request.setAttribute("gradeList", gradeList);
		System.out.println(gradeList.toString());
		request.getRequestDispatcher("/WEB-INF/views/professor/grademodify.jsp").forward(request, response);
		
	}

	private void resultCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectId = request.getParameter("subjectId");
		String subjectName = request.getParameter("subjectName");
		List<EvaluationResultDTO> erList = professorRepository.selectEvaluationResultBySubjectId(Integer.parseInt(subjectId));
		request.setAttribute("erList", erList);
		request.setAttribute("subjectName", subjectName);
		request.getRequestDispatcher("/WEB-INF/views/professor/checkER.jsp").forward(request, response);
	}

	private void readMyEvaluationResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("내 강의 리스트 메서드 진입 (강의평가 결과조회)");

		String year = request.getParameter("year");
		String semester = request.getParameter("semester");
		String professorId = request.getParameter("professorId");
		List<SubjectDTO> subjectList = professorRepository.selectAllSubjectByProfessorIdYearSemester(Integer.parseInt(professorId), Integer.parseInt(year), Integer.parseInt(semester));
		request.setAttribute("subjectList", subjectList);
		
		request.getRequestDispatcher("/WEB-INF/views/professor/mysubjectlistER.jsp").forward(request, response);
	
		
	}

	private void inputRestClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("휴강 일정 input 메서드 진입");
		int selectSub = Integer.parseInt(request.getParameter("selectSub"));
		
		int professorId = Integer.parseInt(request.getParameter("professorId"));
		int year = Integer.parseInt(request.getParameter("year"));
		int semester = Integer.parseInt(request.getParameter("semester"));
		List<SubjectDTO> subjectList = professorRepository.selectAllSubjectByProfessorIdYearSemester(professorId, year, semester);
		int subjectId = subjectList.get(selectSub).getId();
		String subjectName = subjectList.get(selectSub).getName();
		String roomId = subjectList.get(selectSub).getRoomId();
		String restDay = request.getParameter("restDay");
		String supplement = request.getParameter("supplement");
		professorRepository.insertRestClass(subjectId, subjectName, professorId, restDay, roomId, year, semester, supplement);
		System.out.println("휴강일정 입력 완료");
		request.getRequestDispatcher("/WEB-INF/views/professor/selectRC.jsp").forward(request, response);
		
	}
	
	private void moveInputForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String year = request.getParameter("year");
		String semester = request.getParameter("semester");
		String professorId = request.getParameter("professorId");
		
		List<SubjectDTO> subjectList = professorRepository.selectAllSubjectByProfessorIdYearSemester(Integer.parseInt(professorId), Integer.parseInt(year), Integer.parseInt(semester));
		
		request.setAttribute("subjectList", subjectList);
		request.setAttribute("year", year);
		request.setAttribute("semester", semester);
		request.setAttribute("professorId", professorId);
		request.getRequestDispatcher("/WEB-INF/views/professor/inputRestClass.jsp").forward(request, response);
		
	}

	private void readMySubjectRC(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("내 강의의 휴/보강 조회 메서드 진입");
		
		String year = request.getParameter("year");
		String semester = request.getParameter("semester");
		String professorId = request.getParameter("professorId");
		
		List<RestClassDTO> restClassList = professorRepository.selectRestClassByProfessorId(Integer.parseInt(professorId), Integer.parseInt(year), Integer.parseInt(semester));
		request.setAttribute("restClassList", restClassList);
		request.setAttribute("year", year);
		request.setAttribute("semester", semester);
		request.setAttribute("professorId", professorId);
		
		request.getRequestDispatcher("/WEB-INF/views/professor/mysubjectRC.jsp").forward(request, response);
	
	
	}

	private void moveentergrade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String subjectId = request.getParameter("subjectId");
		System.out.println("subjectId : " + subjectId);
		request.setAttribute("subjectId", subjectId);
		List<StudentIdNameDTO> studentList = new ArrayList<>();
		studentList = professorRepository.selectStudentIdNameBySubjectId(Integer.parseInt(subjectId));
		request.setAttribute("studentList", studentList);
		System.out.println(studentList.toString());
		request.getRequestDispatcher("/WEB-INF/views/professor/subjectstudents.jsp").forward(request, response);
		

	}

	private void enterStudentGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int subjectId = Integer.parseInt(request.getParameter("subjectId"));
		int studentSize = Integer.parseInt(request.getParameter("studentSize"));
		int studentId = 0;
		int midExam;
		int finalExam;
		float convertedMark;
		System.out.println("studentSize : " + studentSize);
		for(int i = 1; i <= studentSize; i++) {
			studentId = Integer.parseInt(request.getParameter("studentId"+i));
			midExam = Integer.parseInt(request.getParameter("midExamScore"+i));
			finalExam = Integer.parseInt(request.getParameter("finalExamScore"+i));
			convertedMark = Float.parseFloat(request.getParameter("grade"+i));
			professorRepository.insertStudentsGradesByStudentId(studentId, subjectId, midExam, finalExam, convertedMark);
		}
		// TODO = 현재 학생 성적 DB에 전송 후 내 강의 선택 페이지로 가는데 기존 조회한 강의로 가도록 수정!. 
		request.getRequestDispatcher("/WEB-INF/views/professor/select.jsp").forward(request, response);
	}


	private void readMySubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("내 강의 조회 메서드 진입");

		String year = request.getParameter("year");
		String semester = request.getParameter("semester");
		String professorId = request.getParameter("professorId");
		List<SubjectDTO> subjectList = professorRepository.selectAllSubjectByProfessorIdYearSemester(Integer.parseInt(professorId), Integer.parseInt(year), Integer.parseInt(semester));
		request.setAttribute("subjectList", subjectList);
		
		request.getRequestDispatcher("/WEB-INF/views/professor/mysubject.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
	}

}
