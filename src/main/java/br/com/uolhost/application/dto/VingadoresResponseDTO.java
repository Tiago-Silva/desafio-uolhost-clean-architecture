package br.com.uolhost.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class VingadoresResponseDTO {
    @JsonProperty("vingadores")
    private List<VingadorDTO> vingadores;

    public List<VingadorDTO> getVingadores() {
        return vingadores;
    }

    public void setVingadores(List<VingadorDTO> vingadores) {
        this.vingadores = vingadores;
    }
}
