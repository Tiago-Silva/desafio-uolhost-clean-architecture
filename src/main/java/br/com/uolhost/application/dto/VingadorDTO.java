package br.com.uolhost.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VingadorDTO {

    @JsonProperty("codinome")
    private String codinome;

    public String getCodinome() {
        return codinome;
    }

    public void setCodinome(String codinome) {
        this.codinome = codinome;
    }
}
