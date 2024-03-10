package br.com.uolhost.application.gateways;

import br.com.uolhost.domain.entity.Jogadores;

public interface PlayGateway {
    Jogadores createPlay(Jogadores jogadores);
}
