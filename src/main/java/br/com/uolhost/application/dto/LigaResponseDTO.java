package br.com.uolhost.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "liga_da_justica")
public class LigaResponseDTO {

    @XmlElement(name = "codinome")
    private List<CodinomeDTO> codinomes;

    public List<CodinomeDTO> getCodinomes() {
        return codinomes;
    }

    public void setCodinomes(List<CodinomeDTO> codinomes) {
        this.codinomes = codinomes;
    }
}
