package br.com.uolhost.infrastructure.db.entityDB;

import br.com.uolhost.application.dto.JogadoresResponseDTO;
import br.com.uolhost.domain.entity.Jogadores;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serial;

@Entity
@Table(name = "jogadores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codinome")
public class JogadoresEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String codinome;
    private String name;
    private String email;
    private String telefone;
    private String grupo;

    public JogadoresEntity(JogadoresResponseDTO responseDTO) {
        this.codinome = responseDTO.codinome();
        this.name = responseDTO.name();
        this.email = responseDTO.email();
        this.telefone = responseDTO.telefone();
        this.grupo = responseDTO.grupo();
    }

    public JogadoresEntity(Jogadores playDomainObject) {
        this.codinome = playDomainObject.getCodinome();
        this.name = playDomainObject.getName();
        this.email = playDomainObject.getEmail();
        this.telefone = playDomainObject.getTelefone();
        this.grupo = playDomainObject.getGrupo();
    }
}
