package br.com.uolhost.infrastructure.controller;

import br.com.uolhost.application.dto.JogadoresRequestDTO;
import br.com.uolhost.application.dto.JogadoresResponseDTO;
import br.com.uolhost.domain.entity.Jogadores;

public class PlayDTOMapper {

    public JogadoresResponseDTO toDTO(Jogadores playDomainObject) {
        return new JogadoresResponseDTO(
            playDomainObject.getCodinome(),
            playDomainObject.getName(),
            playDomainObject.getEmail(),
            playDomainObject.getTelefone(),
            playDomainObject.getGrupo()
        );
    }

    public Jogadores toDomainObject(JogadoresRequestDTO requestDTO) {
        return new Jogadores(requestDTO);
    }
    public Jogadores toDomainObject(JogadoresResponseDTO responseDTO) {
        return new Jogadores(responseDTO);
    }
}
