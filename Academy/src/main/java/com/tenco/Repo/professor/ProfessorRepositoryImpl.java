package com.tenco.Repo.professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.professor.ProfessorRepository;
import com.tenco.model.professor.EvaluationResultDTO;
import com.tenco.model.professor.ProfessorDTO;
import com.tenco.model.professor.RestClassDTO;
import com.tenco.model.professor.StudentGradeDTO;
import com.tenco.model.student.StudentDTO;
import com.tenco.model.student.StudentIdNameDTO;
import com.tenco.model.subject.SubjectDTO;
import com.tenco.util.DBUtil;

public class ProfessorRepositoryImpl implements ProfessorRepository {

	private final static String SELECT_ALL_SUBJECT_BY_PID_YEAR_SEMESTER = " select sj.id, sj.name, sj.room_id, "
			+ "	dp.name as department_name, sj.major_type, sj.year, sj.semester, sj.grades "
			+ " from tb_subject as sj left join tb_department as dp on sj.dept_id = dp.id "
			+ " where sj.professor_id = ? and sj.year = ? and sj.semester = ? ";

	private final static String INSERT_TB_STUDENT_SUBJECT_DETAIL = " insert into tb_stu_sub_detail(student_id, subject_id, mid_exam, final_exam, converted_mark) values(?, ?, ?, ?, ?) ";

	private final static String SELECT_STUDENTS_BY_SUBJECT_ID = " select er.student_id, st.name from tb_enroll as er left join tb_student as st on er.student_id = st.id where er.subject_id = ? ";

	private final static String SELECT_RESTCLASS_BY_PROFESSOR_ID_YEAR_SEMESTER = " select * from tb_restclass where professor_id = ? and year = ? and semester = ? ";

	private final static String INSERT_TB_REST_CLASS = " insert into tb_restclass(subject_id, subject_name, professor_id, "
			+ " rest_day, room_id, year, semester, supplement) " + " values(?, ?, ?, ?, ?, ?, ?, ?) ";
	
	private final static String SELECT_EVALUATION_RESULT_BY_SUBJECTID = " select avg, improvements from tb_evaluation where subject_id = ? ";
	
	private final static String SELECT_STUDENT_GRADE_BY_SUBJECT_ID = " select ssd.student_id, st.name as student_name, ssd.subject_id, sj.name as subject_name, ssd.mid_Exam, ssd.final_exam, ssd.converted_mark from tb_stu_sub_detail as ssd left join tb_student as st on ssd.student_id = st.id left join tb_subject as sj on ssd.subject_id = sj.id where ssd.subject_id = ? ";
	
	private final static String UPDATE_GRADE_BY_STUDENT_ID = " update tb_stu_sub_detail set mid_exam = ?, final_exam = ?, converted_mark = ? where student_id = ? ";
	
	private final static String UPDATE_REST_CLASS_BY_RCID = " update tb_restclass set rest_day = ?, supplement = ? where id = ? ";
	
	private final static String DELETE_REST_CLASS_BY_RCID = " delete from tb_restclass where id = ? ";
	
	private final static String SELECT_REST_CLASS_BY_ID = " select * from tb_restclass where id = ? ";
	
	
	@Override
	public List<StudentGradeDTO> selectAllStudentsGradeBySubjectId(int subjectId) {
		List<StudentGradeDTO> gradeList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_STUDENT_GRADE_BY_SUBJECT_ID)) {
			pstmt.setInt(1, subjectId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				gradeList.add(StudentGradeDTO.builder().studentId(rs.getInt("student_id")).studentName(rs.getString("student_name"))
														.subjectId(rs.getInt("subject_id")).subjectName(rs.getString("subject_name"))
														.midExam(rs.getInt("mid_Exam")).finalExam(rs.getInt("final_exam"))
														.convertedMark(rs.getFloat("converted_mark")).build());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return gradeList;
	}

	
	
	public void insertRestClass(int subjectId, String subjectName, int professorId, String restDay, String roomId, int year, int semester, String supplement) {
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_TB_REST_CLASS)) {
				pstmt.setInt(1, subjectId);
				pstmt.setString(2, subjectName);
				pstmt.setInt(3, professorId);
				pstmt.setString(4, restDay);
				pstmt.setString(5, roomId);
				pstmt.setInt(6, year);
				pstmt.setInt(7, semester);
				pstmt.setString(8, supplement);
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	};

	// 교수 id를 통해 휴강 테이블에 접근해 정보를 받아 온다.
	@Override
	public List<RestClassDTO> selectRestClassByProfessorId(int professorId, int year, int semester) {
		List<RestClassDTO> restClassList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_RESTCLASS_BY_PROFESSOR_ID_YEAR_SEMESTER)) {
			pstmt.setInt(1, professorId);
			pstmt.setInt(2, year);
			pstmt.setInt(3, semester);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				restClassList.add(RestClassDTO.builder().id(rs.getInt("id")).subjectId(rs.getInt("subject_id"))
						.subjectName(rs.getString("subject_name")).professorId(rs.getInt("professor_id"))
						.restDay(rs.getString("rest_day")).roomId(rs.getString("room_id")).year(rs.getInt("year"))
						.semester(rs.getInt("semester")).supplement(rs.getString("supplement")).build());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return restClassList;
	}

	// subjectID로 해당 강의를 수강하는 학생의 학번, 이름 받아오기
	public List<StudentIdNameDTO> selectStudentIdNameBySubjectId(int subjectId) {
		List<StudentIdNameDTO> studentList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_STUDENTS_BY_SUBJECT_ID)) {
			pstmt.setInt(1, subjectId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				studentList
						.add(StudentIdNameDTO.builder().id(rs.getInt("student_id")).name(rs.getString("name")).build());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	public void insertStudentsGradesByStudentId(int studentId, int subjectId, int midExam, int finalExam,
			float convertedMark) {
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(INSERT_TB_STUDENT_SUBJECT_DETAIL)) {
				pstmt.setInt(1, studentId);
				pstmt.setInt(2, subjectId);
				pstmt.setInt(3, midExam);
				pstmt.setInt(4, finalExam);
				pstmt.setFloat(5, convertedMark);
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 교수 id와 강의의 개설년도, 개설학기로 자신의 모든 강의를 조회 / 과목 DTO 리스트로 반환
	@Override
	public List<SubjectDTO> selectAllSubjectByProfessorIdYearSemester(int professorId, int year, int semester) {
		List<SubjectDTO> subjectList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_SUBJECT_BY_PID_YEAR_SEMESTER)) {

			pstmt.setInt(1, professorId);
			pstmt.setInt(2, year);
			pstmt.setInt(3, semester);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				subjectList.add(SubjectDTO.builder().id(rs.getInt("id")).name(rs.getString("name"))
						.roomId(rs.getString("room_id")).departmentName(rs.getString("department_name"))
						.majorType(rs.getString("major_type")).year(rs.getInt("year")).semester(rs.getInt("semester"))
						.grades(rs.getInt("grades")).build());

			}

			// System.out.println("교수Id, 개설년도, 개설학기 로 모든 강의 조회 쿼리 실행 -- 강의의 수 : " +
			// subjectList.size());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return subjectList;
	}

	@Override
	public List<EvaluationResultDTO> selectEvaluationResultBySubjectId(int subjectId) {
		List<EvaluationResultDTO> evaluationResultList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_EVALUATION_RESULT_BY_SUBJECTID)) {
			pstmt.setInt(1, subjectId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				evaluationResultList.add(EvaluationResultDTO.builder()
						.avgScore(rs.getFloat("avg")).improvements(rs.getString("improvements")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return evaluationResultList;
	}



	@Override
	public ProfessorDTO getAllInfoById(int id) {
		String query = " select * from tb_professor where id = ? ";
		ProfessorDTO professorDTO = null;
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {

				professorDTO = ProfessorDTO.builder()
				.id(rs.getInt("id")).name(rs.getString("name"))
				.birthDate(rs.getString("birth_date")).gender(rs.getString("gender"))
				.address(rs.getString("address")).tel(rs.getString("tel"))
				.email(rs.getString("email")).deptId(rs.getInt("dept_id"))
				.hireDate(rs.getDate("hire_date")).build();
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return professorDTO;
	}



	@Override
	public void updateStudentsGradeByStudentId(int midExam, int finalExam, float convertedMark, int studentId) {
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_GRADE_BY_STUDENT_ID)) {
				pstmt.setInt(1, midExam);
				pstmt.setInt(2, finalExam);
				pstmt.setFloat(3, convertedMark);
				pstmt.setInt(4, studentId);
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	@Override
	public void updateRestClassByRestClassId(String restDay, String supplement, int id) {
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_REST_CLASS_BY_RCID)) {
				pstmt.setString(1, restDay);
				pstmt.setString(2, supplement);
				pstmt.setInt(3, id);
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



	@Override
	public void deleteRestClassByRestClassId(int id) {
		try (Connection conn = DBUtil.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(DELETE_REST_CLASS_BY_RCID)) {
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
		
	}



	@Override
	public RestClassDTO getRestClassById(int id) {
		RestClassDTO rc = null;
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_REST_CLASS_BY_ID)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				rc = RestClassDTO.builder()
				.id(rs.getInt("id")).subjectId(rs.getInt("subject_id"))
				.subjectName(rs.getString("subject_name")).professorId(rs.getInt("professor_id"))
				.restDay(rs.getString("rest_day")).roomId(rs.getString("room_id"))
				.year(rs.getInt("year")).semester(rs.getInt("semester"))
				.supplement(rs.getString("supplement")).build();
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rc;
	}
}
