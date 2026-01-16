package com.liverpool.exam.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressResponseDto {
	
	private String codigoPostal;
	private List<String> colonias;
	private String tipoAsentamiento;
	private String municipio;
    private String estado;
    private String ciudad;
    private String pais;

}
