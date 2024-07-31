package com.tenco.Repo.interfaces.temp;

import java.util.List;

import com.tenco.model.temp.TuitionDTO;

public interface TuitionRepository {

	List< TuitionDTO> selectTuitionAll();
}
