package com.tenco.Repo.interfaces.staff;

import com.tenco.model.professor.ProfessorDTO;
import com.tenco.model.staff.StaffDTO;
import com.tenco.model.student.StudentDTO;

import java.util.List;

import com.tenco.model.staff.DepartmentDTO;

public interface StaffRepository {

	StaffDTO selectUserIdById(int id);
	StaffDTO selectUserIdByNameEmail(StaffDTO staffDTO);
	StaffDTO selectUserIdByNameIdEmail(StaffDTO staffDTO);

	int addUser(StaffDTO staffDTO,String password );
	StaffDTO addStaff(StaffDTO staffDTO);
	
	int addUserStaff(StaffDTO staffDTO,String password );
	int addUserProfessor(ProfessorDTO professorDTO,String password );
	int addUserStudent(StudentDTO studentDTO,String password );

	StaffDTO getAllInfoById(int id);
}
