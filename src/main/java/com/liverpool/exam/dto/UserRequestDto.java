package com.liverpool.exam.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDto {

	@NotBlank
	private String nombre;
	
	@NotBlank
    private String apellidoPaterno;

	@NotBlank
    private String apellidoMaterno;

    @Email
    @NotBlank
    private String correo;

    @NotBlank
    private String codigoPostal;
}
