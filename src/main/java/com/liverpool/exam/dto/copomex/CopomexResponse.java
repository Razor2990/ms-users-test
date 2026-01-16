package com.liverpool.exam.dto.copomex;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CopomexResponse {

	@JsonProperty("code_error")
    private Integer codeError;

    @JsonProperty("error_message")
    private String errorMessage;

    private CopomexSimplified response;
}
