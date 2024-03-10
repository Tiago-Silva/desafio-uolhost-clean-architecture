package br.com.uolhost.infrastructure.gateways;

import br.com.uolhost.application.gateways.PlayGateway;
import br.com.uolhost.domain.entity.Jogadores;
import br.com.uolhost.infrastructure.db.entityDB.JogadoresEntity;
import br.com.uolhost.infrastructure.db.repositories.JogadoresRepository;

public class PlayRepositoryGateway implements PlayGateway {

    private final JogadoresRepository jogadoresRepository;
    private final PlayEntityMapper playEntityMapper;
    public PlayRepositoryGateway(JogadoresRepository jogadoresRepository, PlayEntityMapper playEntityMapper) {
        this.jogadoresRepository = jogadoresRepository;
        this.playEntityMapper = playEntityMapper;
    }

    @Override
    public Jogadores createPlay(Jogadores playDomainObject) {
        JogadoresEntity playEntity = this.playEntityMapper.toEntity(playDomainObject);
        this.jogadoresRepository.save(playEntity);
        return this.playEntityMapper.toDomainObject(playEntity);
    }
}
