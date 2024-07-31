package com.tenco.Repo.interfaces.temp;

import java.util.List;

import com.tenco.model.temp.StudentScholarDTO;

public interface StudentScholarRepository {

	List<StudentScholarDTO> selectStudentScholarAll();
	int selectStudentScholarById();
}
