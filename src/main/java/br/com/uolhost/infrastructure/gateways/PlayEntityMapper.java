package br.com.uolhost.infrastructure.gateways;

import br.com.uolhost.domain.entity.Jogadores;
import br.com.uolhost.infrastructure.db.entityDB.JogadoresEntity;

public class PlayEntityMapper {

    JogadoresEntity toEntity(Jogadores playDomainObject) {
        return new JogadoresEntity(playDomainObject);
    }

    Jogadores toDomainObject(JogadoresEntity playEntity) {
        return new Jogadores(playEntity);
    }
}
