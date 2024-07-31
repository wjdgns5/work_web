package com.tenco.Repo.temp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.temp.StudentScholarRepository;
import com.tenco.model.temp.StudentScholarDTO;
import com.tenco.util.DBUtil;

public class StudentScholarRepositoryImpl implements StudentScholarRepository{
	private static final String SELECT_STUDENT_SCHOLAR_ALL = " select *\r\n"
																	+ "from tb_stu_sch as st\r\n"
																	+ "join tb_student as stu on st.student_id=stu.id\r\n"
																	+ "join tb_scholarship as sch on st.sch_type=sch.type ";
	
	
	@Override
	public List<StudentScholarDTO> selectStudentScholarAll() {
		List<StudentScholarDTO> studentScholarList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_STUDENT_SCHOLAR_ALL)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				studentScholarList.add(StudentScholarDTO.builder()
						.studentId(rs.getInt("student_id"))
						.schYear(rs.getInt("sch_year"))
						.semester(rs.getInt("semester"))
						.schType(rs.getInt("sch_type"))
						.studentName(rs.getString("name"))
						.amount(rs.getInt("max_amount"))
						.schTypeName(rs.getString("type_name"))
						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentScholarList;
	}

	@Override
	public int selectStudentScholarById() {
		// TODO Auto-generated method stub
		return 0;
	}

}
