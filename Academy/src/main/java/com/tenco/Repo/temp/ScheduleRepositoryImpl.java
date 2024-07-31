package com.tenco.Repo.temp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tenco.Repo.interfaces.temp.ScheduleRepository;
import com.tenco.model.temp.ScheduleDTO;
import com.tenco.util.DBUtil;

public class ScheduleRepositoryImpl implements ScheduleRepository {
	private static final String SELECT_SCHEDULE_ALL = " select * from tb_schedule order by id desc ";
	private static final String SELECT_SCHEDULE_ALL_5 = " select * from tb_schedule order by id desc limit 5 ";

	
	
	@Override
	public ScheduleDTO SelectScheduleById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScheduleDTO> SelectScheduleAll() {
		List<ScheduleDTO> scheduleList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_SCHEDULE_ALL)) {
			ResultSet rs = pstmt.executeQuery();
			System.out.println("schedule 받음");
			while (rs.next()) {
				scheduleList.add(ScheduleDTO.builder().id(rs.getInt("id")).staffId(rs.getInt("staff_id"))
						.startDay(rs.getTimestamp("start_day")).endDay(rs.getTimestamp("end_day"))
						.information(rs.getString("information")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return scheduleList;
	}

	@Override
	public List<ScheduleDTO> SelectScheduleAll5() {
		List<ScheduleDTO> scheduleList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_SCHEDULE_ALL_5)) {
			ResultSet rs = pstmt.executeQuery();
			System.out.println("schedule 받음");
			while (rs.next()) {
				scheduleList.add(ScheduleDTO.builder().id(rs.getInt("id")).staffId(rs.getInt("staff_id"))
						.startDay(rs.getTimestamp("start_day")).endDay(rs.getTimestamp("end_day"))
						.information(rs.getString("information")).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return scheduleList;
	}

}
