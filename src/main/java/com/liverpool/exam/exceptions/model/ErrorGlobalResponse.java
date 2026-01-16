package com.liverpool.exam.exceptions.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorGlobalResponse {
	
	
	private int status;
	private String error;
	private String message;
	@JsonFormat(
		    shape = JsonFormat.Shape.STRING,
		    pattern = "dd/MM/yyyy HH:mm:ss"
		)
	private LocalDateTime localDateTime;
	

}
