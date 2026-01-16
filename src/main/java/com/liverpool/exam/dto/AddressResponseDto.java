package com.liverpool.exam.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressResponseDto {
	
	private String codigoPostal;
    private String estado;
    private String municipio;
    private String colonia;
    private String calle;

}
