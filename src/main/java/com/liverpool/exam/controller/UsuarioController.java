package com.liverpool.exam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liverpool.exam.dto.UserRequestDto;
import com.liverpool.exam.dto.UserResponseDto;
import com.liverpool.exam.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@AllArgsConstructor
@RestController
@RequestMapping("/v1/api/users")
@Tag(name = "Usuarios", description = "CRUD de gestión de usuarios para examen Liverpool-Isol Ingeniería en Soluciones")
public class UsuarioController {
	
	private final UserService userService;
	
	@Operation(summary = "Lista a todos los usuarios")
	@GetMapping()
	public ResponseEntity<List<UserResponseDto>> findAll() {
		return ResponseEntity.ok(userService.findAll());
	}
	
	@Operation(summary = "Busca a un usuario por su ID")
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDto> findById(@PathVariable String id) {
		return ResponseEntity.ok(userService.findById(id));
	}
	
	@Operation(summary = "Registra a un nuevo usuario")
	@PostMapping()
	public ResponseEntity<UserResponseDto> create(@Valid @RequestBody UserRequestDto userRequestDto) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userRequestDto));
	}
	
	@Operation(summary = "Actualiza a un usuario")
	@PutMapping("/{id}")
	public ResponseEntity<UserResponseDto> update(@PathVariable String id, @Valid @RequestBody UserRequestDto userRequestDto) {
		
		return ResponseEntity.ok(userService.update(id, userRequestDto));
	}
	
	@Operation(summary = "Elimina un usuario por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<UserResponseDto> delete(@PathVariable String id) {
		
		userService.deleteById(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	

}
