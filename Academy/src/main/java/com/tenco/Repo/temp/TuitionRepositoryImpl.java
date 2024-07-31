package com.tenco.Repo.temp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.temp.TuitionRepository;
import com.tenco.model.temp.TuitionDTO;
import com.tenco.util.DBUtil;

public class TuitionRepositoryImpl implements TuitionRepository{
	private static final String SELECT_TUITION_ALL = " select stu.id,stu.name,tui_year,tu.semester,tui_id,sch.sch_type,col.name,co.amount,scholar.type_name,scholar.max_amount,tu.status \r\n"
																	+ "from tb_tuition as tu\r\n"
																	+ "join tb_student as stu on tu.student_id=stu.id\r\n"
																	+ "join tb_stu_sch as sch on tu.sch_type=sch.sch_type\r\n"
																	+ "join tb_coll_tuit as co on tu.tui_id=co.college_id\r\n"
																	+ "join tb_college as col on tui_id=col.id\r\n"
																	+ "join tb_scholarship as scholar on tu.sch_type=scholar.type ";
	
	
	@Override
	public List<TuitionDTO> selectTuitionAll() {
		List<TuitionDTO> tuiList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_TUITION_ALL)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				tuiList.add(TuitionDTO.builder()
						.id(rs.getInt("id"))
						.studentName(rs.getString("stu.name"))
						.tuiYear(rs.getInt("tui_year"))
						.semester(rs.getInt("semester"))
						.tuiId(rs.getInt("tui_id"))
						.schType(rs.getInt("sch_type"))
						.collName(rs.getString("col.name"))
						.amount(rs.getInt("amount"))
						.schName(rs.getString("type_name"))
						.schMount(rs.getInt("max_amount"))
						.status(rs.getInt("status"))
						.build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tuiList;
	}

}
