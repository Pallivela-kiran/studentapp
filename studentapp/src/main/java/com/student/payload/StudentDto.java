package com.student.payload;

import java.time.LocalDate;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class StudentDto {
	Long id;
	@NotBlank(message = "FirstName should not be empty")
	@Size(min = 3, message = "FirstName is too short")
	private String firstName;
	@NotBlank(message = "LastName should not be empty")
	@Size(min = 3, message = "LastName is too short")
	private String lastName;
	@NotBlank
	private LocalDate dob;
	@NotBlank(message = "Section should not be empty")
	@Pattern(regexp = "(?i)[ABC]")
	private char section;
	@NotBlank(message = "Gender should not be empty")
	@Pattern(regexp = "(?i)[MF]")
	private char gender;
	private int marks1;
	private int marks2;
	private int marks3;
	private float total;
	private float average;
	private String result;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public char getSection() {
		return section;
	}
	public void setSection(char section) {
		this.section = section;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
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
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public StudentDto(Long id,
			@NotBlank(message = "FirstName should not be empty") @Size(min = 3, message = "FirstName is too short") String firstName,
			@NotBlank(message = "LastName should not be empty") @Size(min = 3, message = "LastName is too short") String lastName,
			@NotBlank LocalDate dob,
			@NotBlank(message = "Section should not be empty") @Pattern(regexp = "(?i)[ABC]") char section,
			@NotBlank(message = "Gender should not be empty") @Pattern(regexp = "(?i)[MF]") char gender, int marks1,
			int marks2, int marks3, float total, float average, String result) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.section = section;
		this.gender = gender;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
		this.total = total;
		this.average = average;
		this.result = result;
	}

	
}
