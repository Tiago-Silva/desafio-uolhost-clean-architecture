package br.com.uolhost.application.gateways;

import br.com.uolhost.domain.entity.Jogadores;

import java.util.List;

public interface PlayGateway {
    Jogadores createPlay(Jogadores jogadores);

    Jogadores updatePlay(Jogadores jogadores);

    void deletePlay(Jogadores jogadores);

    List<Jogadores> getPlay();

    Jogadores getPlayByCodinome(String codinome);

    List<Jogadores> getPlayersByGrupo(String grupo);
}
