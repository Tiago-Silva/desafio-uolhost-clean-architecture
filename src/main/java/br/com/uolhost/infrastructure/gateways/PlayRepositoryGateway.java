package br.com.uolhost.infrastructure.gateways;

import br.com.uolhost.application.dto.VingadoresResponseDTO;
import br.com.uolhost.application.gateways.PlayGateway;
import br.com.uolhost.domain.entity.Jogadores;
import br.com.uolhost.infrastructure.db.entityDB.JogadoresEntity;
import br.com.uolhost.infrastructure.db.repositories.JogadoresRepository;
import br.com.uolhost.infrastructure.services.PlayServices;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PlayRepositoryGateway implements PlayGateway {

    private final JogadoresRepository jogadoresRepository;
    private final PlayEntityMapper playEntityMapper;
    private final PlayServices playServices;
    public PlayRepositoryGateway(JogadoresRepository jogadoresRepository, PlayEntityMapper playEntityMapper, PlayServices playServices) {
        this.jogadoresRepository = jogadoresRepository;
        this.playEntityMapper = playEntityMapper;
        this.playServices = playServices;
    }

    @Override
    public Jogadores createPlay(Jogadores playDomainObject) {

        this.playServices.codinomeIsExists(playDomainObject.getGrupo(), playDomainObject.getCodinome());

        List<Jogadores> jogadores = this.getPlayersByGrupo(playDomainObject.getGrupo());


        boolean grupoExists = jogadores.stream()
            .anyMatch(jogador -> jogador.getCodinome().equals(playDomainObject.getCodinome()));
        if (grupoExists) {
            throw new RuntimeException("codinome já existe no grupo");
        }

        JogadoresEntity playEntity = this.playEntityMapper.toEntity(playDomainObject);
        this.jogadoresRepository.save(playEntity);
        return this.playEntityMapper.toDomainObject(playEntity);
    }

    @Override
    public Jogadores updatePlay(Jogadores domainObject) {
        JogadoresEntity playEntity = this.playEntityMapper.toEntity(domainObject);
        this.jogadoresRepository.save(playEntity);
        return this.playEntityMapper.toDomainObject(playEntity);
    }

    @Override
    public void deletePlay(Jogadores domainObject) {
        JogadoresEntity playEntity = this.playEntityMapper.toEntity(domainObject);
        this.jogadoresRepository.delete(playEntity);
    }

    @Override
    public List<Jogadores> getPlay() {
        List<JogadoresEntity> playEntities = this.jogadoresRepository.findAll();
        return playEntities.stream().map(this.playEntityMapper::toDomainObject).toList();
    }

    @Override
    public Jogadores getPlayByCodinome(String codinome) {
        JogadoresEntity playEntity = this.jogadoresRepository.findByCodinome(codinome);
        return this.playEntityMapper.toDomainObject(playEntity);
    }

    @Override
    public List<Jogadores> getPlayersByGrupo(String grupo) {
        List<JogadoresEntity> playEntities = this.jogadoresRepository.findByGrupo(grupo);
        return playEntities.stream().map(this.playEntityMapper::toDomainObject).toList();
    }

}
