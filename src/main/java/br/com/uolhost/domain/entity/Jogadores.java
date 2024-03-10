package br.com.uolhost.domain.entity;

import br.com.uolhost.application.dto.JogadoresRequestDTO;
import br.com.uolhost.application.dto.JogadoresResponseDTO;
import br.com.uolhost.infrastructure.db.entityDB.JogadoresEntity;
import lombok.*;

import java.io.Serial;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Jogadores {

    @Serial
    private static final long serialVersionUID = 1L;

    private String codinome;
    private String name;
    private String email;
    private String telefone;
    private String grupo;

    public Jogadores(JogadoresResponseDTO responseDTO) {
        this.codinome = responseDTO.codinome();
        this.name = responseDTO.name();
        this.email = responseDTO.email();
        this.telefone = responseDTO.telefone();
        this.grupo = responseDTO.grupo();
    }

    public Jogadores(JogadoresEntity playEntity) {
        this.codinome = playEntity.getCodinome();
        this.name = playEntity.getName();
        this.email = playEntity.getEmail();
        this.telefone = playEntity.getTelefone();
        this.grupo = playEntity.getGrupo();
    }

    public Jogadores(JogadoresRequestDTO requestDTO) {
        this.codinome = requestDTO.codinome();
        this.name = requestDTO.name();
        this.email = requestDTO.email();
        this.telefone = requestDTO.telefone();
        this.grupo = requestDTO.grupo();
    }
}
