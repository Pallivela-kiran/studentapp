package com.student.validationUtil;

import java.time.LocalDate;
import java.time.Period;

import com.student.constatnts.ExceptionConstants;
import com.student.exception.IllegalFeildException;
import com.student.payload.StudentDto;
import com.student.payload.StudentUpdateDto;

public class StudentValidator {

	public void studentValidator(StudentDto dto) {

		Period period = Period.between(dto.getDob(), LocalDate.now());

		if (period.getYears() < 15 || period.getYears() > 20)
			throw new IllegalFeildException(ExceptionConstants.AGE_CRITERIA_NOT_MATCHED);
		if (dto.getMarks1() >= 100 || dto.getMarks1() <= 0)
			throw new IllegalFeildException(ExceptionConstants.ILLEGAL_MARKS);
	
		 if (dto.getMarks2() >= 100 || dto.getMarks2() <= 0)
			throw new IllegalFeildException(ExceptionConstants.ILLEGAL_MARKS);
	
		if(dto.getMarks3() >= 100 || dto.getMarks3() <= 0)
			throw new IllegalFeildException(ExceptionConstants.ILLEGAL_MARKS);
	}
	public void studentUpdateValidator(StudentUpdateDto dto) {

		if (dto.getMarks1() >= 100 || dto.getMarks1() <= 0)
			throw new IllegalFeildException(ExceptionConstants.ILLEGAL_MARKS);
	
		 if (dto.getMarks2() >= 100 || dto.getMarks2() <= 0)
			throw new IllegalFeildException(ExceptionConstants.ILLEGAL_MARKS);
	
		if(dto.getMarks3() >= 100 || dto.getMarks3() <= 0)
			throw new IllegalFeildException(ExceptionConstants.ILLEGAL_MARKS);
	
	}

}
