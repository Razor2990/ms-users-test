package com.liverpool.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	private String codigoPostal;
	private String estado;
	private String municipio;
	private String colonia;
	private String calle;
	
}
