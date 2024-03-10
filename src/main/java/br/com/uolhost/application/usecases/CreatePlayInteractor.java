package br.com.uolhost.application.usecases;

import br.com.uolhost.application.gateways.PlayGateway;
import br.com.uolhost.domain.entity.Jogadores;

public class CreatePlayInteractor {

    private final PlayGateway playGateway;
    public CreatePlayInteractor(PlayGateway playGateway) {
        this.playGateway = playGateway;
    }

    public Jogadores createPlay(Jogadores jogadores) {
        return this.playGateway.createPlay(jogadores);
    }
}
