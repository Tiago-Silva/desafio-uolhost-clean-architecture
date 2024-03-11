package br.com.uolhost.application.usecases;

import br.com.uolhost.application.gateways.PlayGateway;
import br.com.uolhost.domain.entity.Jogadores;

import java.util.List;

public class CreatePlayInteractor {

    private final PlayGateway playGateway;
    public CreatePlayInteractor(PlayGateway playGateway) {
        this.playGateway = playGateway;
    }

    public Jogadores createPlay(Jogadores jogadores) {
        return this.playGateway.createPlay(jogadores);
    }

    public Jogadores updatePlay(Jogadores jogadores) {
        return this.playGateway.updatePlay(jogadores);
    }

    public void deletePlay(Jogadores jogadores) {
        this.playGateway.deletePlay(jogadores);
    }

    public List<Jogadores> getPlay() {
        return this.playGateway.getPlay();
    }

    public Jogadores getPlayByCodinome(String codinome) {
        return this.playGateway.getPlayByCodinome(codinome);
    }

    public List<Jogadores> getPlayersByGrupo(String grupo) {
        return this.playGateway.getPlayersByGrupo(grupo);
    }
}
