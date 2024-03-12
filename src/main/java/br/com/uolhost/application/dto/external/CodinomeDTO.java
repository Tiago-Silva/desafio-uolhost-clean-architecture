package br.com.uolhost.application.dto.external;

import javax.xml.bind.annotation.XmlValue;

public class CodinomeDTO {

    @XmlValue
    private String codinome;

    public CodinomeDTO() {
    }

    public CodinomeDTO(String codinome) {
        this.codinome = codinome;
    }

    public String getCodinome() {
        return codinome;
    }

    public void setCodinome(String codinome) {
        this.codinome = codinome;
    }
}