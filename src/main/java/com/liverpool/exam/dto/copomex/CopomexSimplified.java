package com.liverpool.exam.dto.copomex;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CopomexSimplified {

    @JsonProperty("cp")
    private String codigoPostal;

    @JsonProperty("asentamiento")
    private List<String> colonias;

    @JsonProperty("tipo_asentamiento")
    private String tipoAsentamiento;

    private String municipio;
    private String estado;
    private String ciudad;
    private String pais;
}
