package com.liverpool.exam.service.copomex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.liverpool.exam.dto.copomex.CopomexResponse;
import com.liverpool.exam.dto.copomex.CopomexSimplified;
import com.liverpool.exam.entity.Address;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CopomexService {

    private final WebClient webClient;

    @Value("${copomex.api.key}")
    private String apiKey;

    public CopomexService(WebClient copomexWebClient) {
        this.webClient = copomexWebClient;
    }

    public Address getAddressByCp(String codigoPostal) {

        log.info("1. Consultando COPOMEX (simplified) para CP {}", codigoPostal);

        CopomexResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/query/info_cp/{cp}")
                        .queryParam("type", "simplified")
                        .queryParam("token", apiKey)
                        .build(codigoPostal))
                .retrieve()
                .bodyToMono(CopomexResponse.class)
                .block();

        log.info("CopomexResponse: {}", response.toString());
        
        if (response == null || response.getResponse() == null) {
            throw new RuntimeException("No se encontró información para el CP " + codigoPostal);
        }

        CopomexSimplified data = response.getResponse();

        log.info("2. Construyendo Address con colonias agrupadas");

        return Address.builder()
                .codigoPostal(data.getCodigoPostal())
                .colonias(data.getColonias())
                .tipoAsentamiento(data.getTipoAsentamiento())
                .estado(data.getEstado())
                .municipio(data.getMunicipio())
                .ciudad(data.getCiudad())
                .pais(data.getPais())
                .build();
    }
}
