package com.liverpool.exam.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.liverpool.exam.exceptions.model.ErrorGlobalResponse;



@RestControllerAdvice
public class GlobalExeptionsHandler {
	
	@ExceptionHandler(ResourceNotFoundExceptions.class)
	public ResponseEntity<ErrorGlobalResponse> handleNotFound(ResourceNotFoundExceptions ex) {

		ErrorGlobalResponse error = new ErrorGlobalResponse(
	            HttpStatus.NOT_FOUND.value(),
	            "Recurso no encontrado",
	            ex.getMessage(),
	            LocalDateTime.now()
	    );

	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationErrors(
	        MethodArgumentNotValidException ex) {

	    Map<String, String> errors = new HashMap<>();

	    ex.getBindingResult().getFieldErrors()
	            .forEach(error ->
	                    errors.put(error.getField(), error.getDefaultMessage()));

	    return ResponseEntity.badRequest().body(errors);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorGlobalResponse> handleInvalidJson(
	        HttpMessageNotReadableException ex) {

		ErrorGlobalResponse error = new ErrorGlobalResponse(
	            400,
	            "JSON inválido",
	            "El formato del JSON es incorrecto",
	            LocalDateTime.now()
	    );

	    return ResponseEntity.badRequest().body(error);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorGlobalResponse> handleGeneric(Exception ex) {

		ErrorGlobalResponse error = new ErrorGlobalResponse(
	            500,
	            "Error interno",
	            "Ocurrió un error inesperado",
	            LocalDateTime.now()
	    );

	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<ErrorGlobalResponse> handleNotFound(NoResourceFoundException ex) {

		ErrorGlobalResponse error = new ErrorGlobalResponse(
	            404,
	            "Not Found",
	            "No se encontró el recurso solicitado",
	            LocalDateTime.now()
	    );

	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorGlobalResponse> handleUserNotFound(NoSuchElementException ex) {

		ErrorGlobalResponse error = new ErrorGlobalResponse(
	            404,
	            "Not Found",
	            ex.getMessage(),
	            LocalDateTime.now()
	    );

	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
