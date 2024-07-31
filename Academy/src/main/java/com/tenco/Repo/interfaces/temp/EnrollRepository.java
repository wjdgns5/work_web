package com.tenco.Repo.interfaces.temp;

import java.util.List;

import com.tenco.model.temp.EnrollDTO;

public interface EnrollRepository {
	
	List<EnrollDTO>  selectByStudentId(int id);
	
	
}
