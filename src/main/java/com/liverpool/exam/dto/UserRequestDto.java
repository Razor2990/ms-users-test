package com.liverpool.exam.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "^[0-9]{5}$", message = "Debe contener exactamente 5 dígitos y numérico")
    private String codigoPostal;
}
