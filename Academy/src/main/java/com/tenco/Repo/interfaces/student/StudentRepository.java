package com.tenco.Repo.interfaces.student;

import java.util.List;

import com.tenco.model.student.AnswerDTO;
import com.tenco.model.student.StudentDTO;
import com.tenco.model.student.breakappDTO;
import com.tenco.model.subject.UsersSubjectDTO;
import com.tenco.model.temp.EvaluationQuestionDTO;

public interface StudentRepository {

	StudentDTO search(int id);
	List<UsersSubjectDTO> readMySubject(int studentId, int year, int semester);

    EvaluationQuestionDTO getEvaluationQuestion();
//    StudentDTO selectStudentById(int id);

    // 보류 (내 정보 수정)
//    StudentDTO studentInfoModify(int password, String email, String tel, String address, int id);

    // 학생 정보 출력
    StudentDTO studentInfo(int id);
    // 학생 정보 수정
    void studentInfoModify(String password, String email, String tel, String address, int id);
    
    // 강의 평가에 대한 설문 답변 등록
    int addEvaluationAnswer(AnswerDTO answerDto);
    
    // 학생 휴학 신청
    int addBreakapp(breakappDTO breakappDTO);
    
    // 학생 휴학 내역 조회
    breakappDTO searchBreakapp(int id);
    
}
