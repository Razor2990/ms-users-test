package com.liverpool.exam.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {
	
    private String id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private AddressResponseDto direccion;

}
