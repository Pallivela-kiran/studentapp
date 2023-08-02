
package com.student.exception;

import lombok.Data;

@Data
public class ExceptionMessage {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
