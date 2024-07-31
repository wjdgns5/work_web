package com.tenco.model.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class StudentDTO {
    // 학생 기본 데이터
    private int id;
    private String name;
    private String birth_date;
    private String gender;
    private String address;
    private String tel;
    private String email;
    private int dept_id;
    private int grade;
    private int semester;
    private String entrance_date;
    private String graduation_date;

    // 학과 기본 데이터
    private int d_number;
    private String d_name;
    private int d_id;

    // 유저 기본 데이터
    private int u_number;
    private String u_password;
    private int u_permission_level;



}
