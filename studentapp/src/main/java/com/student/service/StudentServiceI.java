package com.student.service;

import com.student.payload.StudentDto;
import com.student.payload.StudentUpdateDto;

public interface StudentServiceI {

	StudentDto saveStudent(StudentDto dto);

	StudentDto updateStudent(StudentUpdateDto dto);

}
