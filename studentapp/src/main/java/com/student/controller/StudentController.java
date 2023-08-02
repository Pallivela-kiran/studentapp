package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.payload.StudentDto;
import com.student.payload.StudentUpdateDto;
import com.student.service.StudentServiceI;
import com.student.serviceImpl.ValidationService;

@RestController
@RequestMapping("/api")

public class StudentController {

	@Autowired
	private StudentServiceI studentServiceI;
	@Autowired
	ValidationService validationService;

	@PostMapping("/students")
	public ResponseEntity<?> createStudent(@Validated @RequestBody StudentDto dto, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return validationService.validationErrors(bindingResult);

		} else {
			StudentDto savedStudentDto = studentServiceI.saveStudent(dto);
			return new ResponseEntity<>(savedStudentDto, HttpStatus.CREATED);
		}
	}

	@PatchMapping("/students")
	public ResponseEntity<?> updateStudent(@Validated @RequestBody StudentUpdateDto dto, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return validationService.validationErrors(bindingResult);

		} else {
			StudentDto savedStudentDto = studentServiceI.updateStudent(dto);
			return new ResponseEntity<>(savedStudentDto, HttpStatus.ACCEPTED);
		}

	}

}
