package com.student.payload;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentUpdateDto {
	@NotNull
	private Long id;
	private int marks1;
	private int marks2;
	private int marks3;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMarks1() {
		return marks1;
	}

	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}

	public int getMarks2() {
		return marks2;
	}

	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}

	public int getMarks3() {
		return marks3;
	}

	public void setMarks3(int marks3) {
		this.marks3 = marks3;
	}

}
