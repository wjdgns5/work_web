package com.tenco.Repo.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tenco.Repo.interfaces.student.StudentRepository;
import com.tenco.model.student.AnswerDTO;
import com.tenco.model.student.StudentDTO;
import com.tenco.model.student.breakappDTO;
import com.tenco.model.user.UserDTO;
import com.tenco.model.subject.UsersSubjectDTO;
import com.tenco.model.temp.EvaluationQuestionDTO;
import com.tenco.util.DBUtil;

public class StudentRepositoryImpl implements StudentRepository {
	
	
	private final static String SELECT_ALL_SUBJECT_BY_SID_YEAR_SEMESTER = 
			" SELECT sj.id, sj.name, pf.name as professor_name, sj.room_id, "
			+ " dp.name as department_name, sj.major_type, sj.year, sj.semester, sj.grades "
			+ " FROM tb_subject as sj "
			+ " left join tb_professor as pf on sj.professor_id = pf.id "
			+ " left join tb_department as dp on sj.dept_id = dp.id "
			+ " left join tb_enroll as er on sj.id = er.subject_id "
			+ " where er.student_id = ? and (sj.year = ? and sj.semester = ?) ";
	
	private final static String SELECT_ALL_QUESTION_FOR_EVALUATION = " select * from tb_question where id = 1 ";
	
	public EvaluationQuestionDTO getEvaluationQuestion() {
		EvaluationQuestionDTO questions = new EvaluationQuestionDTO();
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_QUESTION_FOR_EVALUATION)) {
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				questions = EvaluationQuestionDTO.builder().id(rs.getInt("id"))
						.question1(rs.getString("question1")).question2(rs.getString("question2"))
						.question3(rs.getString("question3")).question4(rs.getString("question4"))
						.question5(rs.getString("question5")).question6(rs.getString("question6"))
						.question7(rs.getString("question7")).question8(rs.getString("question8"))
						.question9(rs.getString("question9")).question10(rs.getString("question10"))
						.sugContent(rs.getString("sug_content"))
						.build();
		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	System.out.println("@@" + questions.toString());
		return questions; 
	}
	
	@Override
	public StudentDTO studentInfo(int id) {
		
		String sql = " select s.*, d.id as d_number, d.name as d_name, d.college_id as d_id, u.id as u_number, u.password as u_password, u.permission_level as u_permission_level "
				+ " from tb_student as s "
				+ " join tb_department as d "
				+ "	on s.dept_id = d.id "
				+ " join tb_user as u "
				+ " on s.id = u.id "
				+ " where s.id = ? ";
		StudentDTO studentDTO = null;
		
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {

				studentDTO = StudentDTO.builder()
				.id(rs.getInt("id"))
				.name(rs.getString("name"))
				.birth_date(rs.getString("birth_date"))
				.gender(rs.getString("gender"))
				.address(rs.getString("address"))
				.tel(rs.getString("tel"))
				.email(rs.getString("email"))
				.dept_id(rs.getInt("dept_id"))
				.grade(rs.getInt("grade"))
				.semester(rs.getInt("semester"))
				.entrance_date(rs.getString("entrance_date"))
				.graduation_date(rs.getString("graduation_date"))
				
				.d_number(rs.getInt("d_number"))
				.d_name(rs.getString("d_name"))
				.d_id(rs.getInt("d_id"))
				
				.u_number(rs.getInt("u_number"))
				.u_password(rs.getString("u_password"))
				.u_permission_level(rs.getInt("u_permission_level"))
				.build();
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("StudentRepositoryImpl 에서 오류발생");
		}
	System.out.println("@@" + studentDTO.toString());
		return studentDTO; 
	}


// 학생 상세 정보 수정
	@Override
	public void studentInfoModify(String password, String email, String tel, String address, int id) {
			String sql = " Update tb_student as s "
					+ " join tb_user as u "
					+ " on s.id = u.id "
					+ " set u.password = ?, "
					+ "	s.email = ?, "
					+ " s.tel = ?, "
					+ " s.address = ? "
					+ " where s.id = ? ";
			
			StudentDTO dto = null;
			int rowCount = 0;
			
			try(Connection conn = DBUtil.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql)) {
					conn.setAutoCommit(false);
					pstmt.setString(1, password);
					pstmt.setString(2, email);
					pstmt.setString(3, tel);
					pstmt.setString(4, address);
					pstmt.setInt(5, id);
					pstmt.executeUpdate();
				 conn.commit();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}


	@Override
	public List<UsersSubjectDTO> readMySubject(int studentId, int year, int semester) {
		List<UsersSubjectDTO> subjectList = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_SUBJECT_BY_SID_YEAR_SEMESTER)) {

			pstmt.setInt(1, studentId);
			pstmt.setInt(2, year);
			pstmt.setInt(3, semester);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				subjectList.add(UsersSubjectDTO.builder()
						.subjectId(rs.getInt("id")).subjectName(rs.getString("name"))
						.professorName(rs.getString("professor_name")).roomId(rs.getString("room_id"))
						.departmentName(rs.getString("department_name")).majorType(rs.getString("major_type"))
						.year(rs.getString("year")).semester(rs.getString("semester"))
						.grades(rs.getString("grades")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectList;
	}

	@Override
	public StudentDTO search(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addEvaluationAnswer(AnswerDTO answerDto) {
		
		String sql = " insert into tb_evaluation (student_id, subject_id, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10, improvements, avg) "
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		int rowCount = 0;
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, answerDto.getStuId());
			pstmt.setInt(2, answerDto.getSubId());
			int[] tempanswer = answerDto.getAnswer();
			for (int i = 0; i < tempanswer.length; i++) {
				pstmt.setInt(i+3, tempanswer[i]);
			}
			pstmt.setString(13, answerDto.getContent());
			pstmt.setFloat(14,(float)answerDto.getAvg());
			rowCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}

	@Override
	public int addBreakapp(breakappDTO breakappDTO) {
		
		String sql = " insert into tb_break_app(student_id, student_grade, from_year, from_semester, to_year, to_semester, type) "
				+ " values(?, ?, ?, ?, ?, ?, ?) ";
		
		int rowCount = 0;
		try(Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, breakappDTO.getStudent_id());
			pstmt.setInt(2, breakappDTO.getStudent_grade());
			pstmt.setInt(3, breakappDTO.getFrom_year());
			pstmt.setInt(4, breakappDTO.getFrom_semester());
			pstmt.setInt(5, breakappDTO.getTo_year());
			pstmt.setInt(6, breakappDTO.getTo_semester());
			pstmt.setString(7, breakappDTO.getType());
			rowCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	@Override
	public breakappDTO searchBreakapp(int id) {
		String sql = " select * from tb_break_app where student_id = ? ";
		breakappDTO breakappDTO = null;
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				breakappDTO = breakappDTO.builder()
				.student_id(rs.getInt("student_id"))
				.student_grade(rs.getInt("student_grade"))
				.from_year(rs.getInt("from_year"))
				.from_semester(rs.getInt("from_semester"))
				.to_year(rs.getInt("to_year"))
				.to_semester(rs.getInt("to_semester"))
				.type(rs.getString("type"))
				.app_date(rs.getString("app_date"))
				.status(rs.getString("status"))
				.build();
			}				
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return breakappDTO;
	}
	
	

}
