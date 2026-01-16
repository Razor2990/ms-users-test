package com.liverpool.exam.entity;

import java.util.List;

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
    private List<String> colonias;
    private String tipoAsentamiento;
    private String municipio;
    private String estado;
    private String ciudad;
    private String pais;
}
