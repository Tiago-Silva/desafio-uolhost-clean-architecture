package br.com.uolhost.infrastructure.config;

import br.com.uolhost.application.gateways.PlayGateway;
import br.com.uolhost.application.usecases.CreatePlayInteractor;
import br.com.uolhost.infrastructure.controller.PlayDTOMapper;
import br.com.uolhost.infrastructure.db.repositories.JogadoresRepository;
import br.com.uolhost.infrastructure.gateways.PlayEntityMapper;
import br.com.uolhost.infrastructure.gateways.PlayRepositoryGateway;
import br.com.uolhost.infrastructure.services.PlayServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayConfiguration {

    @Bean
    CreatePlayInteractor createPlayInteractor(PlayGateway playGateway) {
        return new CreatePlayInteractor(playGateway);
    }

    @Bean
    PlayGateway playGateway(JogadoresRepository playRepository, PlayEntityMapper playEntityMapper, PlayServices playServices) {
        return new PlayRepositoryGateway(playRepository, playEntityMapper, playServices);
    }

    @Bean
    PlayEntityMapper playEntityMapper() {
        return new PlayEntityMapper();
    }

    @Bean
    PlayDTOMapper playDTOMapper() {
        return new PlayDTOMapper();
    }

    @Bean
    PlayServices playServices() {
        return new PlayServices();
    }
}
