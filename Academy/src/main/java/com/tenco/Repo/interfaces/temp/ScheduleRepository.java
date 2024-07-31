package com.tenco.Repo.interfaces.temp;

import java.util.List;

import com.tenco.model.temp.ScheduleDTO;

public interface ScheduleRepository {

	ScheduleDTO SelectScheduleById();
	List<ScheduleDTO> SelectScheduleAll();
	List<ScheduleDTO> SelectScheduleAll5();
}
