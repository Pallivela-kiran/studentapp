package com.student.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.constatnts.ExceptionConstants;
import com.student.exception.IllegalFeildException;
import com.student.model.Student;
import com.student.payload.StudentDto;
import com.student.payload.StudentUpdateDto;
import com.student.repository.StudentRepository;
import com.student.service.StudentServiceI;
import com.student.validationUtil.StudentValidator;

@Service
public class StudentServiceImpl implements StudentServiceI {

	@Autowired
	ModelMapper mapper;

	@Autowired
	StudentRepository repository;
	@Autowired
	StudentValidator studentValidator;

	@Override
	public StudentDto saveStudent(StudentDto dto) {
		studentValidator.studentValidator(dto);

		float total = dto.getMarks1() + dto.getMarks2() + dto.getMarks3();
		float average = total / 3;
		String result = "fail";

		if (dto.getMarks1() >= 35 && dto.getMarks2() >= 35 && dto.getMarks3() >= 35)
			result = "pass";

		dto.setTotal(total);
		dto.setAverage(average);
		dto.setResult(result);
		Student student = mapper.map(dto, Student.class);
		Student savedStudent = repository.save(student);
		StudentDto savedStudentDto = mapper.map(savedStudent, StudentDto.class);

		return savedStudentDto;
	}

	@Override
	public StudentDto updateStudent(StudentUpdateDto dto) {
		if (dto.getId() == null)
			throw new IllegalFeildException(ExceptionConstants.ID_SHOULD_NOT_BE_NULL);
		studentValidator.studentUpdateValidator(dto);
		Student student = repository.findById(dto.getId())
				.orElseThrow(() -> new IllegalFeildException(ExceptionConstants.NO_STUDENT_FOUND));
		student.setMarks1(dto.getMarks1());
		student.setMarks2(dto.getMarks2());
		student.setMarks3(dto.getMarks3());
		float total = dto.getMarks1() + dto.getMarks2() + dto.getMarks3();
		float average = total / 3;
		String result = "fail";

		if (dto.getMarks1() >= 35 && dto.getMarks2() >= 35 && dto.getMarks3() >= 35)
			result = "pass";

		student.setTotal(total);
		student.setAverage(average);
		student.setResult(result);
Student updatedStudent=repository.save(student);
		StudentDto savedStudentDto = mapper.map(updatedStudent, StudentDto.class);
		return savedStudentDto;
}}
